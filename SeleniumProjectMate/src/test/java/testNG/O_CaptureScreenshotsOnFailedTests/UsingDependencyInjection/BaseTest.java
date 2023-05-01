package testNG.O_CaptureScreenshotsOnFailedTests.UsingDependencyInjection;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest
{

    //creating extent reports object at class level because we want to use this object in multiple methods.
    public static ExtentReports engine;
    public static ExtentTest test;


    public static WebDriver driver;
    public static String screenshotFolderName;

    @Parameters("browserName")
    @BeforeTest
    public static WebDriver browserInstantiation(ITestContext context, @Optional("chrome")String browserName)
    {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        switch(browserName.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
        }

        test =   engine.createTest(context.getName());
        Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
        String device = capabilities.getBrowserVersion()+"_"+ capabilities.getBrowserName();
        test.assignDevice(device);
        test.assignAuthor(context.getCurrentXmlTest().getParameter("author"));
        return driver;
    }

    public static void highlight(WebElement element)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style','border: 2px solid green');", element);

        //border: 2px solid blue
    }

    public static void highlight(WebElement element, String colour)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

        jsExecutor.executeScript("arguments[0].setAttribute('style','"+colour+"');", element);
    }

    public static WebElement findElementByName(String locatorValue)
    {
        WebElement element  = driver.findElement(By.name(locatorValue));
        return element;
    }

    public static WebElement findElementById(String locatorValue)
    {
        WebElement element  = driver.findElement(By.id(locatorValue));
        return element;
    }

    public static WebElement findElementByXpath(String locatorValue)
    {
        WebElement element  = driver.findElement(By.xpath(locatorValue));
        return element;
    }

    public static WebElement findElementByVisibleText(String locatorValue)
    {
        WebElement element  = driver.findElement(By.linkText(locatorValue));
        return element;
    }

    public static String capScreenshot(String fileName)
    {
        /**
         * To get rid of overriding the screenshots when we run the same failed test's multiple times by using
         * date and time stamp,
         *
         */

        if(screenshotFolderName==null)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
//			System.out.println("before formatting: "+localDateTime);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            screenshotFolderName = localDateTime.format(dateTimeFormatter);
        }

        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+screenshotFolderName+"/"+fileName);
        try
        {
            FileUtils.copyFile(srcFile,destFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return destFile.getAbsolutePath();

    }

    @BeforeSuite
    public void initializeExtentReports()
    {
        engine = new ExtentReports();
        ExtentSparkReporter all_Tests = new
                ExtentSparkReporter(new File("./ReportFiles/integrationWithTestNG/allTests.html"));
        engine.attachReporter(all_Tests);

        // this method will execute before suite execution so we need to attach system information to reports in this
        //... method it self.

        engine.setSystemInfo("OperatingSystem",System.getProperty("os.name"));
        engine.setSystemInfo("Java-version",System.getProperty("java.version"));

    }

    @AfterSuite
    public void generateExtentReports()
    {
        engine.flush();
    }

    @AfterMethod
    public void checkStatus(Method m, ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String screenshotPath =
            capScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
            test.addScreenCaptureFromPath(screenshotPath);
            test.fail(result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            test.pass(m.getName()+" is passed");
        }

        test.assignCategory(m.getAnnotation(Test.class).groups());
    }





    public static void quit()
    {
        driver.close();
    }
}
