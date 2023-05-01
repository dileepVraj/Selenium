package testNG.E_Parameters;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import xpath.BaseClass;

public class OrangeHrm extends BaseClass
{
    @Parameters("url")
    @BeforeTest
    public void launchApplication(String url)
    {
        browserInstantiation("chrome");
        driver.get(url);
    }

    @Parameters({"userName","password"})
    @Test
    public void verifyLogin(String userName, String password)
    {
        findElementByName("username").sendKeys(userName);
        findElementByName("password").sendKeys(password, Keys.ENTER);
        boolean isDashboardDisplayed=findElementByXpath("//h6[contains(@class,'oxd-text oxd-text--h6')]").isDisplayed();
        SoftAssert sf = new SoftAssert();
        sf.assertTrue(isDashboardDisplayed);

        sf.assertAll();
    }

    @AfterTest
    public void terminate()
    {
        quit();
    }

}
