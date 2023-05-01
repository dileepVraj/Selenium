package xpath;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class  BaseClass
{

	public static WebDriver driver;
	public static String screenshotFolderName;


	public static WebDriver browserInstantiation(String browser)
	{
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		switch(browser.toLowerCase())
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




	
	public static void quit() 
	{
		driver.close();
	}


}
