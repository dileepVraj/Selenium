package testNG.O_CaptureScreenshotsOnFailedTests.A_HowToCaptureScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xpath.BaseClass;

import java.io.*;
import java.util.Base64;

public class ScreenShotTest extends BaseClass
{

    @BeforeMethod
    public void setUp()
    {
        // browser initialization.
        browserInstantiation("chrome");
        // navigating to required web page.
        driver.get("https://www.w3schools.com/");

    }

    @AfterMethod
    public void terminate()
    {
        driver.quit();
    }
    @Test
    public void captureScreenShotInFileFormat() throws IOException {

        // clicking on exercises webelement.
        findElementById("navbtn_exercises").click();
        // To capture screenshot selenium tool consists of an Interface 'TakeScreenshot'.
        // Point to catch: we all know that we cannot create instance of interface in java, so we have to understand
        // one thing here, we are actually capturing the page or screen that is loaded on the browser, the browser
        // instance is on 'driver' so we have to take the help of the driver and TakeScreenshot interface combine.
        // Now we have to cast this driver To the TakeScreenshot interface

        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        /*Now we have to call 'getScreenshotAs()' method on this TakeScreenshot instance where 'getScreenshotAs()'
         * method takes argument type of 'OutputType' Where OutputType is an interface.
         *
         * To capture screenshot in different types of format we have to use this OutputType as argument to getScreenshotAs()
         * method, OutputType's we have there is BASE64,BYTES,FILE.
         * Where BASE64 will return us the output in string format.
         * BYTES will return us output in byte[] format.
         * FILE will return us the FILE format.
         *
         * */

        //first let us capture screenshot in FILE format.
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // Now we have to store this File into our local machine by using 'FileUtils' class.
        // This FileUtils class is from apache.commons.io It is a java library, we can get this from maven repository.
        /*We have to call 'copyFile(srcFile,destFile)' method which takes 2 arguments one source file which is our
         * screenshot we captured in file format, another one is destination file i.e where we want to store the
         * source file in our local machine.
         * */

        //Creating a new file instance and passing destination path to where captured screenshot to be stored, as
        //argument to the File class constructor.
        //Note: don't forget to add extension type in which format we want to store the screenshot like '.png,.jpg etc...'.
        File destinationFile = new File
                ("src/test/java/testNG/CaptureScreenshotsOnFailedTests/HowToCaptureScreenshot/ExercisesMenu.png");

        // Copying source file (screenshot) to the local machine by passing source and destination fil to the 'copyFile()'
        // method.
        FileUtils.copyFile(file,destinationFile);
        //quitting driver.



    }

    @Test(priority = 1)
    public void captureScreenshotInBase64Format() throws IOException, InterruptedException {
        // clicking on exercises webelement.
        findElementById("navbtn_exercises").click();
        Thread.sleep(3000);
        //create the TakeScreenshot interface instance by casting it to the browser instance.
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        //capturing sc in base64 format which returns string.

        String screenshot = takesScreenshot.getScreenshotAs(OutputType.BASE64);

        // Now create the instance of FileOutputStream class and pass destination path  as argument.
        File destinationFile = new File
                ("src/test/java/testNG/CaptureScreenshotsOnFailedTests/HowToCaptureScreenshot/ExercisesMenu1.jpeg");
        FileOutputStream fos = new FileOutputStream(destinationFile);
        //Now we have to store the screenshot we captured to destination location by using 'write(byte[])' method.
        // but we have screenshot in string format so we need to convert it into byte[] format.

        //converting string into byte[]
        /*Actually what we are doing is we got the screenshot in encoded format when we are capturing it in BASE64 format
        * we have to decode it by calling 'gerDecoder()' method on Base64 class in java, and we have to call
        * 'decode()' method on 'getDecoder()' and pass captured screenshot in BASE64 format.*/
        byte[] screenShotInBytes = Base64.getDecoder().decode(screenshot);
        fos.write(screenShotInBytes);
        //flushing the data in FileOutPutStream
        fos.flush();
        // closing the FileOutputStream instance.
        fos.close();


    }

    @Test(priority = 2)
    public void captureScreenshotInByteFormat() throws IOException {
        // clicking on exercises webelement.
        findElementById("navbtn_exercises").click();
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File destinationFile = new File
                ("src/test/java/testNG/CaptureScreenshotsOnFailedTests/HowToCaptureScreenshot/ExercisesMenu2.jpeg");
        FileOutputStream fos = new FileOutputStream(destinationFile);
        fos.write(screenshot);
        fos.flush();
        fos.close();
    }
}
