package testNG.C_Assertions.HardAsserts;

import org.openqa.selenium.Keys;
import xpath.BaseClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestsWithHardAssertions extends BaseClass
{

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
        // Url assertion
        String expectedUrl = "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjc5NTc1Mzc0LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D";
        assertNotEquals(driver.getCurrentUrl(),expectedUrl,"Url shouldn't match but matched");
        System.out.println("Text matched successful");


        driver.quit();
    }

    /**
     * As we are using hard assertions to validate the test steps the execution will be halted if any assertion is failed
     * in the test.
     */
}
