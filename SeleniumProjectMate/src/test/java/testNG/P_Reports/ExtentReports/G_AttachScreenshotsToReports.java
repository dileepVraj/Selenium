package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;
import xpath.BaseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class G_AttachScreenshotsToReports extends BaseClass
{
    /**
     * In this class we are going to learn about how to capture the screenshot, sometimes we need to capture the screenshots when
     * there is a test failure occurs.
     *
     * We also have scenario to capture the screenshot for every test step execution in the test method.
     *
     * Irrespective of test status we have a scenario to capture the screenshot on every testing ending/after every test method
     * execution.
     *
     * We can attach screenshots in extent reports at test level and log level.
     *
     *
     */

    @Test
    public void attachScreenshotAtTestLevel()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File("./ReportFiles/AttachScreenshots/atTestLevel.html"));
        engine.attachReporter(sparkReporter);

        browserInstantiation("chrome");
        driver.get("https://google.com");

        // Adding description along with the test name.
        engine.createTest("atTestLevel","this test is about attach screenshot at test level")
                .log(Status.INFO,"This is atTestLevelSc info message")

                /**
                 * Point to be noted if we are attaching screenshot at test level then, screenshot will appear at below the test description
                 * if description is present if not it will be attached under the time stamps.
                 *
                 * We have 2 methods(overloaded) present in the Extent reports to attach screenshots at test level,
                 * those method names are
                 *
                 * 1. addScreenCaptureFromBase64String(String base64);
                 * 2. addScreenCaptureFromPath(String path);
                 */
                        .addScreenCaptureFromPath(capScreenshot("GoogleHomepage.jpg"));
        //Apart from simply attaching screenshot to the test in reports we can also give a title to the screenshot
        //... by using overloaded methods of addScreenCaptureFromBase64(String base64,String title);
        //... by using overloaded methods of addScreenCaptureFromPath(String path,String title);


        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/AttachScreenshots/atTestLevel.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        driver.quit();


    }

    @Test
    public void addScreenCaptureWithOverloadedMethodOfFromPath()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File("./ReportFiles/AttachScreenshots/atTestLevelWithTitle.html"));
        engine.attachReporter(sparkReporter);

        browserInstantiation("chrome");
        driver.get("https://google.com");

        // Adding description along with the test name.
        engine.createTest("atTestLevelWithTitle","this test is about attach screenshot at test level")
                .log(Status.INFO,"This is atTestLevelSc info message")
                .addScreenCaptureFromPath(capScreenshot("GoogleHomepage1.jpg"),"TitleOfScreenShot");

        engine.flush();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/AttachScreenshots/atTestLevelWithTitle.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void addScreenshotAtLogLevel()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File("./ReportFiles/AttachScreenshots/atLogLevelWithTitle.html"));
        engine.attachReporter(sparkReporter);
        //We can attach screenshot for every log event for fail, skip, warning, pass, info.

        browserInstantiation("chrome");
        driver.get("https://google.com");

        engine.createTest("TestWithScreenshotsAtLogLevel")
                //To attach screenshot for every log we have 6 overloaded methods, for example let's take fail log so we
                //... can assume that because of test method is failed we are attaching the screenshot.
                //... in this scenario to attach screenshot to this log we have following overloaded methods.
                /**
                 * 1.fail(Markup m);
                 * 2.fail(Media media);
                 * 3.fail(String details);
                 * 4.fail(Throwable t);
                 * 5.fail(String details,Media media);
                 * 6.fail(throwable t, Media m);
                 *
                 * in this test method we are going to use fail(Media m);, fail(String details, Media m);, fail(Throwable t, Media m);.
                 */
                //If we're directly passing Media class as argument to fail or any log method we cannot get these above methods we have to pass
                //... 'MediaEntityBuilder' class as argument where we can access methods like
                /**
                 * 1. createScreenCaptureFromBase64(String Base64);
                 * 2. createScreenCaptureFromBase64(String Base64,String title);
                 * 3. createScreenCaptureFromPath(String path);
                 * 4. createScreenCaptureFromPath(String path,String title);
                 */
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("GoogleHomePage3.jpg"),"title").build())
                .info(MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("Google.jpg")).build())
                .warning(MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("Google1.jpg")).build());



                //Media(Screenshot with details)
                engine.createTest("MediaWithText")
                        //The details we are entre will be displayed on the top of the screenshot we captured.
                        .fail("Details1",MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("GoogleHomePage4.jpg"),"title").build())
                        .info("Details2",MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("Google2.jpg")).build())
                        .warning("Details3",MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("Google3.jpg")).build());


                //Media(Screenshot with exception)
                Throwable throwable = new Throwable("This is a throwable exception");
                engine.createTest("MediaWithException")
                .fail(throwable,MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("GoogleHomePage4.jpg"),"title").build())
                .info(throwable,MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("Google2.jpg")).build())
                .warning(throwable,MediaEntityBuilder.createScreenCaptureFromPath(capScreenshot("Google3.jpg")).build());

                engine.flush();
                driver.quit();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/AttachScreenshots/atLogLevelWithTitle.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        //Point to be noted: we cannot log exceptions at test level along with screenshots, where we can at log level
        //... and we can log details at both test and log levels.


    }
}
