package testNG.K_TimeOutAndExpectedExceptions;

import org.testng.annotations.Test;
import xpath.BaseClass;

import java.util.NoSuchElementException;

public class SampleCase extends BaseClass
{
    @Test(timeOut = 21000)
    public void launchHyrTutorials()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/");
        driver.quit();

    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void expectedConditionsMethod()
    {
        System.out.println("hello how are you.");
    }
}
