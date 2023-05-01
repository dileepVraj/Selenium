package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import xpath.BaseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class K_ReportForFailedSkippedPassedTests extends BaseClass
{
    /**
     * In this class we will learn how to generate multiple reports in extent reports and how to generate reports for
     * only failed,all tests, skipped, warning, passed test cases.
     *
     * The purpose of creating multiple reports is to submit or showcase our manager/team lead all test cases belong to
     * particular status like failed, passed etc...
     *
     *
     */

    public String getDeviceInfo(String input)
    {
     WebDriver driver1 =  browserInstantiation("chrome");

        Capabilities capabilities = ((RemoteWebDriver)driver1).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        driver1.quit();

        if(input.toLowerCase() == "name")
        {
            return browserName;
        }
        else if (input.toLowerCase() == "version")
        {
            return browserVersion;
        }

        return null;

    }



    @Test
    public void generateMultipleReports()
    {
        ExtentReports engine = new ExtentReports();



        // We have to create multiple reporter instances when we are creating multiple reports.
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File("./ReportFiles/multipleReports/allTests.html"));
        ExtentSparkReporter failedSparkReport = new ExtentSparkReporter(new File("./ReportFiles/multipleReports/failed.html"));
        ExtentSparkReporter skippedWarningReport = new ExtentSparkReporter(new File("./ReportFiles/multipleReports/skipped_Warning.html"));

        // filtering failed and skipped_warning test cases by applying filters on appropriate reporter instances.
        failedSparkReport.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
        skippedWarningReport.filter().statusFilter().as(new Status[] {Status.SKIP,Status.WARNING}).apply();
        engine.attachReporter(sparkReporter,failedSparkReport,skippedWarningReport);


       ExtentTest test1 =  engine.createTest("passedTest");
        test1.pass("PassedTest");
        test1.assignCategory("smoke","regression")
                .assignAuthor("Dileep");


        ExtentTest failedTest = engine.createTest("failedTest");
        failedTest.fail("failedByUnknownReasons");
        failedTest.assignAuthor("Dileep")
                        .assignCategory("Regression");

        ExtentTest skippedTest = engine.createTest("skippedTest");
        failedTest.skip("skippedByUnknownReasons");
        failedTest.assignAuthor("John")
                .assignCategory("Sanity");

        ExtentTest warningTest = engine.createTest("warningTest");
        failedTest.warning("WarningMessage....");
        failedTest.assignAuthor("John")
                .assignCategory("Sanity");

        engine.setSystemInfo("BrowserName",getDeviceInfo("name"));
        engine.setSystemInfo("BrowserVersion",getDeviceInfo("version"));
        engine.setSystemInfo("JavaVersion",System.getProperty("java.version"));
        engine.setSystemInfo("OperatingSystem",System.getProperty("os.name"));


        engine.flush();
        driver.quit();
        try {
            Desktop.getDesktop().browse(new File("ReportFiles/multipleReports/allTests.html").toURI());
            Desktop.getDesktop().browse(new File("ReportFiles/multipleReports/failed.html").toURI());
            Desktop.getDesktop().browse(new File("ReportFiles/multipleReports/skipped_Warning.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
