package testNG.O_CaptureScreenshotsOnFailedTests.byListeners;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
import static xpath.BaseClass.*;

public class TestOrangeHrm
{
    @BeforeTest
    public void initializeBrowser()
    {
        browserInstantiation("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }



    @Test
    public void login()
    {
        WebElement userName = findElementByName("username");
        userName.sendKeys("Admin");
        WebElement password = findElementByName("password");
        password.sendKeys("admin123", Keys.ENTER);
        Boolean isDashBoardDispayed = findElementByXpath("//h6[text()='Dashboard']").isEnabled();
        assertTrue(isDashBoardDispayed);
        System.out.println("login successful");
    }

    @Test()
    public void validateSsnNumber()
    {
        findElementByXpath("//a[.='My Info']").click();
        boolean isPersonalDetailsDisplayed =   findElementByXpath("//h6[text()='Personal Details1']").isDisplayed();
        assertTrue(isPersonalDetailsDisplayed);
        System.out.println("personal details are displayed successful");
    }

    @AfterTest
    public void terminate()
    {
        quit();
    }


}
