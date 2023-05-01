package screenShots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CapturingScreenShotOfEntireWebPage
{
    /*In selenium 4 we have introduced to capture screenshot of entire web page.
    *
    * We can perform this operation only on firefox browser.*/

    public static void main(String[] args)
    {
        //browser setup.
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        //taking screenshot of entire webpage.

        File fullPageScreenShot = driver.getFullPageScreenshotAs(OutputType.FILE);

        try
        {
            FileHandler.copy(fullPageScreenShot, new File("./ScreenShots/FullPageSc.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }




    }
}
