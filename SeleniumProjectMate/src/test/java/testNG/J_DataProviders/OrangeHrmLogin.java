package testNG.J_DataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import xpath.BaseClass;

public class OrangeHrmLogin extends BaseClass
{
    static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


//    @BeforeTest
//    public void browserSetUp()
//    {
//
//
//
//    }

    @Test(dataProvider = "loginData1",dataProviderClass = DataProviderContainer.class)
    public void login(String userName, String password)
    {
        browserInstantiation("chrome");
        driver.get(url);
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password, Keys.ENTER);
        String actualText = findElementByXpath("//h6[text()='Dashboard']").getText();
        String expectedText = "Dashboard";
        Assert.assertEquals(actualText,expectedText,"Text didn't matched");
    }





    @AfterMethod
    public void tearDown()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }


}
