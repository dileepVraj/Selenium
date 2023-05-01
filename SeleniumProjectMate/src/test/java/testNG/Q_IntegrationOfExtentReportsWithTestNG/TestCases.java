package testNG.Q_IntegrationOfExtentReportsWithTestNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNG.O_CaptureScreenshotsOnFailedTests.UsingDependencyInjection.BaseTest;
import xpath.BaseClass;

public class TestCases extends BaseTest
{



    @Test(groups = {"regression","smoke"})
    public void orangeHrmLogin()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test.info("navigated to URL");
        findElementByName("username").sendKeys("Admin");
        test.info("entered userName");
        findElementByName("password").sendKeys("admin123", Keys.ENTER);
        test.info("entered password");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(findElementByXpath("(//p[@class='oxd-text oxd-text--p'])[1]").isDisplayed());
        test.pass("passed");
        softAssert.assertAll("Time at work element is not visible");
    }

    @Test(groups = {"regression","sanity"})
    public void deliberatelyFailing()
    {
        driver.get("https://google.com");
        test.info("navigated to URL");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(findElementById("ms").isDisplayed());
        softAssert.assertAll("Specified element is not displayed");
    }




    @AfterTest
    @Test
    public void terminate()
    {
        driver.quit();
    }

//    @AfterMethod
//    public void captureScreenshot(ITestResult result)
//    {
//        if(result.getStatus()==ITestResult.FAILURE)
//        {
//            // gets the test name from xml configuration file.
//            String testName = result.getTestContext().getName();
//            // gets the test-method name in tst class.
//            String name = result.getMethod().getMethodName();
//
//            String testNamePlusMethodName = testName+"_"+name;
//
//            capScreenshot(testNamePlusMethodName+".png");
//        }
//    }
}
