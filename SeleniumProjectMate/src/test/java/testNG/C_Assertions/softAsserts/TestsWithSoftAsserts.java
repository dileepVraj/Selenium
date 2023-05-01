package testNG.C_Assertions.softAsserts;

import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import xpath.BaseClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestsWithSoftAsserts extends BaseClass
{
    /**
     * Point to be noted:
     * We don't have any static methods on softAssert class like Assert class.
     * We have to create the instance of the softAssert.
     * These assert methods on this class don't throw any exceptions where it records the failures.
     *
     */
    @org.testng.annotations.Test
    public static void googlePage()
    {
        SoftAssert softAssert = new SoftAssert();
        browserInstantiation("chrome");
        driver.get("https://google.com");
        String expectedTitle = "Googlee";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Titles didn't match");

        driver.quit();
        // throws all exceptions if we have failed assertion in the test.
        softAssert.assertAll();
    }

    @org.testng.annotations.Test
    public void faceBookPage()
    {
        SoftAssert softAssert = new SoftAssert();
        browserInstantiation("chrome");
        driver.get("https://facebook.com");
        findElementById("email").sendKeys("noo", Keys.ENTER);
        String errorText = findElementByXpath("//div[@class='_9ay7']").getText();
        String expectedText = "The email address or mobile number you entered isn't connected to an account. Find your account and log in?.";
        softAssert. assertEquals(errorText,expectedText,"Error message text didn't matched");
        // Url assertion
        String expectedUrl = "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjc5NTc1Mzc0LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D";
        softAssert.assertNotEquals(driver.getCurrentUrl(),expectedUrl,"Url shouldn't match but matched");
        driver.quit();
        // throws all exceptions if any assertion failed in the test.
        softAssert.assertAll();
    }
}
