package testNG.J_DataProviders.ParallelExecution;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNG.J_DataProviders.InegrationOfExcelFileWithDataProvider.DataProviders;
import xpath.BaseClass;

import java.time.Duration;

public class ParallelExecution extends BaseClass
{





    @Test(dataProvider = "loginData",dataProviderClass = DataProviders.class)
    public void launchFacebook(String userName,String password) throws InterruptedException
    {
        browserInstantiation("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement name =  findElementByName("username");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(userName);
        WebElement passwrd = findElementByName("password");
        wait.until(ExpectedConditions.visibilityOf(passwrd));
        passwrd.sendKeys(password,Keys.ENTER);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(findElementByXpath("//button[@fdprocessedid='70amdo']//i[1]").isDisplayed());
        softAssert.assertAll("Test failed because 'Time at Work' not displayed");
        driver.quit();

    }

//    @AfterTest
//    public void terminate()
//    {
//        driver.quit();
//    }
}
