package testNG.Z_BasicTestScripts;


import org.openqa.selenium.Keys;
import xpath.BaseClass;

import static org.testng.Assert.*;

public class Test extends BaseClass
{
//testNG.Test
    @org.testng.annotations.Test
    public static void googlePage()
    {
        browserInstantiation("chrome");
        driver.get("https://google.com");
        String expectedTitle = "Googlee";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,expectedTitle,"Titles didn't match");
        System.out.println("successfully navigated to google home page");
        driver.quit();
    }

    @org.testng.annotations.Test
    public void faceBookPage()
    {
        browserInstantiation("chrome");
        driver.get("https://facebook.com");
        findElementById("email").sendKeys("no", Keys.ENTER);
        String errorText = findElementByXpath("//div[@class='_9ay7']").getText();
        String expectedText = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
        assertEquals(errorText,expectedText,"Text didn't matched");
        System.out.println("Text matched successful");


        driver.quit();
    }

}
