package testNG.J_DataProviders.InegrationOfExcelFileWithDataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import xpath.BaseClass;


public class OrangeHrmLogin extends BaseClass
{

    @BeforeMethod
    public void setUp()
    {
        browserInstantiation("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void login(String userName, String password) {

        findElementByName("username").sendKeys(userName);
        findElementByName("password").sendKeys(password, Keys.ENTER);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(findElementByXpath("//p[text()='Time at Work']").isDisplayed());
        softAssert.assertAll("Test failed because 'Time at Work' not displayed");

    }


    @AfterMethod
    public void terminate()
    {
            driver.quit();
    }



}