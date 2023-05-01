package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class I_ConfigurationUsingJavaJsonXml
{
    /**
     * In this class we are going to learn how to configure extent reports using Java-programming, Json, Xml files.
     *
     * Let's discuss a real time example to understand what are extent report configurations, do you remember that
     * when we bought a new mobile from store it will be configured to some default manufacturer settings, like
     * Theme, wallpaper, fonts, etc... where we can change them if we want to.
     *
     * As like that we can make configuration changes to extent-reports also by using Java programming language, Json
     * and Xml files.
     *
     * The changes we are going to perform on extent reports:
     *
     * 1. Change the theme.
     * 2. Change the report name.
     * 3. Change the document title.
     * 4. Change the date and time stamp format.
     * 5. Apply the CSS.
     * 6. Run the Javascript.
     *
     */

    @Test
    public void duplicateAddingAdditionalInfo()
    {
        ExtentReports engine = new ExtentReports();
        File file = new File("./ReportFiles/additionalInfoToTests");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);


        /**
         * If we want to make the configuration changes to the report we have to make them on the 'sparkReport' instance
         * because that is what helps us to create the report file.
         *
         * let's understand this we already come to know that ExtentReports class or instance of ExtentReports is main
         * engine to generate the different types of reports like ExtentSparkReports, ExtentAvenReports, ExtentEmailable-
         * Reports etc...
         *
         * So we can create different kinds of extent reports and configure them differently, if we set configuration
         * settings to ExtentReports engine then those settings will be applicable to all kinds of reports.
         *
         */
        //Applying different theme on ExtentSparkReporter instance.
        //We have to call 'config()' method on spark-reporter instance where it returns 'ExtentSparkReporterConfig'
        //... and we have to call the 'setTheme(Theme t)' method which takes a ENUM as argument.
        sparkReporter.config().setTheme(Theme.DARK);

        //Setting/changing report name.
        sparkReporter.config().setReportName("Sample report name");

        //Setting document(report)title.
        sparkReporter.config().setDocumentTitle("SampleDocTitle");



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

        /**
         * In this method we have seen how to configure extent reports using Java programming language, where it is
         * quite tedious to make further changes to the extent reports file because we have to visit the code block/
         * source code.
         *
         * So in next methods we are going to learn how to set configuration settings to extent-reports using Json and
         * Xml files.
         */


    }


    @Test
    public void configurationThroughJsonFile()
    {
        /**
         * To configure extent reports using Json configuration file we need some predefined template right!
         * where we will find that, we can find that in 'extent-reports.com' under docs->version5->java->Github,
         * click on the Git-hub button where it navigates us to source code of template.
         *
         * Click on extent-reports Java->config where we will find configuration files in format of Json and Xml.
         * I have created a module src/test/resources in project and created a file with extension '.json' where
         * we have to paste Json code in that file copied from Json configuration file in Git-hub.
         *
         * If we want to make changes to extent-reports we have to change the properties values in the Json file which
         * we created in resources folder.
         *
         *
         */

        ExtentReports engine = new ExtentReports();
        File file = new File("./ReportFiles/additionalInfoToTests");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        //Now we have to load the Json configuration file to make configuration changes to the report file, we have to
        //... call 'loadJsonConfig()' method which is overloaded method of two types, \
        //... 1.'loadJsonConfig(File JsonFile)'
        //... 2. 'loadJsonConfig(String jsonString)'
        try
        {
            sparkReporter.loadJSONConfig(new File("src/test/resources/extent-reports-config.json"));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

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

    @Test
    public void configurationThroughXmlFile()
    {
        ExtentReports engine = new ExtentReports();
        File file = new File("./ReportFiles/additionalInfoToTests");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        //Now we have to load the Json configuration file to make configuration changes to the report file, we have to
        //... call 'loadJsonConfig()' method which is overloaded method of two types, \
        //... 1.'loadJsonConfig(File JsonFile)'
        //... 2. 'loadJsonConfig(String jsonString)'
        try
        {
            sparkReporter.loadXMLConfig(new File("src/test/resources/extent-configuration-file.xml"));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

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
