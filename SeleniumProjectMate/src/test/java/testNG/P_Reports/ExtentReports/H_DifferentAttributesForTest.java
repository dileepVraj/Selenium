package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class H_DifferentAttributesForTest
{
    /**
     * Here attributes are noting but additional information that we can provide to a test, in extent reports.
     *
     * While creating tests in extent reports we are passing some information like screenshots, details in string format
     * and titles etc... along with these information if we want to pass any other additional information how we are
     * going to do that and what exactly this additional information is?
     *
     *
     * The basic information we pass while creating tests in extent reports is test-name, test description(optional).
     *
     * The additional information we are going to pass is as follows:
     *
     * 1. Author.
     * 2. Category.
     * 3. Device.
     *
     * Author is nothing but a test case developer the guy/girl who developed the test case, this attribute is very
     * useful because all test engineers in team will keep adding testcases into project test suite and with the help
     * of this 'Author' test case we will come to know who developed particular test case etc...
     *
     * Category: This category is called as Groups in TestNG and Tags in Cucumber, we have different names for different
     * test framework libraries where combine in ExtentReports they gave a generic name called 'Category'.
     *
     * This attribute is useful when we want to track which test cases are failing and to which group they are belong to
     * and we can filter test cases and execution details by using 'Category', if we want all these things we have to
     * log this 'Category' information to the tests while creating.
     *
     * Device: Devices can be different types of browsers and different versions also, including pc, mobile etc...
     * By logging device information into the tests we can know that in which devices do the test cases failing and
     * finding defects.
     */

    @Test
    public void addAdditionalInformationToTests()
    {
        ExtentReports engine = new ExtentReports();
        File file = new File("./ReportFiles/additionalInfoToTests");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        engine.attachReporter(sparkReporter);

        //While creating test it return ExtentTest instance where we can call the assignDevice(String device);, assignAuthor(String device);
        //... and assignCategory(String category);
        engine.createTest("addAdditionalInformation")
                .assignAuthor("DileepRaju")
                .assignCategory("Smoke")
                //For cross browser testing device will be version of browser.
                .assignDevice("chrome 101")
                .pass("Passes test");

        engine.createTest("addAdditionalInformation2")
                .assignAuthor("Brook")
                .assignCategory("Regression")
                //For cross browser testing device will be version of browser.
                .assignDevice("chrome 101")
                .fail("failed test");

        engine.createTest("addAdditionalInformation3")
                // assume this test is developed by more than one test engineer and part of two test groups.
                .assignAuthor("Brook","MarkRam")
                .assignCategory("Regression","Sanity")
                //For cross browser testing device will be version of browser.
                .assignDevice("chrome 101")
                .pass("failed test");

        engine.flush();
        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/additionalInfoToTests.html").toURI());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
