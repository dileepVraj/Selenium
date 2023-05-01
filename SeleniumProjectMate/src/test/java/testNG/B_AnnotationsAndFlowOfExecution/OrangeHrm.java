package testNG.B_AnnotationsAndFlowOfExecution;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xpath.BaseClass;

import static org.testng.Assert.*;

public class OrangeHrm extends BaseClass
{
    @BeforeTest
    public void initializeBrowser()
    {
        browserInstantiation("chrome");
    }

    @Test
    public void launchOrangeHrm()
    {
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

    @Test
    public void validateSsnNumber()
    {
        findElementByXpath("//a[.='My Info']").click();
        boolean isPersonalDetailsDisplayed =   findElementByXpath("//h6[text()='Personal Details']").isDisplayed();
        assertTrue(isPersonalDetailsDisplayed);
        System.out.println("personal details are displayed successful");
    }

    @AfterTest
    public void terminate()
    {
        quit();
    }

}
