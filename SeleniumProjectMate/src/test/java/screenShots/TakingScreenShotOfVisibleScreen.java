package screenShots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import xpath.BaseClass;

import java.io.File;
import java.io.IOException;

public class TakingScreenShotOfVisibleScreen extends BaseClass
{
    /*To capture screenshot using selenium webdriver , we can use 'getScreenshotAs();' method of webdriver interface.
    *
    * Here is an example code snippet that demonstrates that how to capture screenShot:
    *
    * */



    public static void screenShotAsFile()
    {

        // navigating to google home page.
        driver.get("https://google.com");
        /*saving screenshot in File format because we are taking screenshot in file format using 'getScreenShotAs()'
         method which called on driver which casted with TakesScreenShot interface.*/
        File googleSc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try
        {
            /*Copying the captured screenshot using 'copyFile();' method on FileUtils class which takes source(screenshot)
            * and destination of screenshot to be saved in file format.
            *
            * wrapping this command in a try catch block because it throws checked exception 'IOException'*/
            FileUtils.copyFile(googleSc,new File("./ScreenShots/GoogleHomePage.png"));

            /*We can also save captured screenshot in particular destination folder by using 'FileHandler' class in
            * selenium.io package where we have to manually create folder we specified as argument to File constructor.
            * otherwise which will throw FileNotFoundException.*/

            //FileHandler.copy(sourceOfScreenshot,new File("./ScreenShots/GoogleHomePage.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        /**
         * FileUtils and FileHandler are two different classes in Selenium WebDriver that are used for different purposes.
         *
         * FileUtils is a class from the Apache Commons IO library, which provides various utility methods for working with files and directories.
         * It includes methods for copying, deleting, and moving files, as well as reading and writing to files.
         *
         * FileHandler is a class from the Selenium WebDriver library that is used to capture screenshots of a web page.
         * It provides a method called copy() that takes a screenshot and saves it to a file.
         *
         * The reason why FileUtils has been replaced by FileHandler in taking screenshots in Selenium WebDriver is that FileUtils is a generic utility
         * class that provides many methods that are not related to taking screenshots. This can make it confusing to use, especially for beginners.
         * FileHandler, on the other hand, is a specialized class that is specifically designed for taking screenshots in Selenium WebDriver.
         * It provides a simple and straightforward way to capture screenshots and save them to a file.
         *
         * In summary, FileUtils is a general-purpose utility class for working with files and directories,
         * while FileHandler is a specialized class for taking screenshots in Selenium WebDriver.
         * FileHandler provides a simpler and more focused API for capturing screenshots, which is why it has replaced FileUtils in this context.
         */
    }

    public static void main(String[] args)
    {


        browserInstantiation("chrome");

        screenShotAsFile();

    }
}
