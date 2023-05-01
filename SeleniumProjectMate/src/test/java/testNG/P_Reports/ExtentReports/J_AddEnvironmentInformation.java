package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import xpath.BaseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class J_AddEnvironmentInformation extends BaseClass
{
    /**
     * In this class we will learn how to add environment or system information to extent-reports.
     *
     * Let's understand what is environment information?
     *
     * When we are working with test automation we need to add extra details to reports like
     *
     * 1. operating system name.
     * 2. operating system version.
     * 3. Browser name.
     * 4. Browser version.
     * 5. Application under test URL, username, password.
     *
     * After executing our test cases we will submit our test report to our manager , stakeholder, team-leader etc...
     * They will not know on which environment you have executed all those test cases.
     *
     * With help of these details they will come to know the environment of a test case which is failed.
     *
     *
     */

    @Test
    public void getBrowserInformation()
    {
        /**
         * If we want to get browser related information we will only get it when the browser instance is invoked or
         * opened.
         */
        // If we want to get browser details or information we can only get that by using 'RemoteWebdriver' instance,
        //... all we need to do is that we have to type cast the driver instance to 'RemoteWebdriver' instance.

       WebDriver driver1=  browserInstantiation("chrome");
       //casting driver to 'RemoteWebdriver' instance and calling 'getCapabilities()'method which returns capabilities(I)
        //... which returns capabilities for 'remote-webdriver' instance
        Capabilities capabilities = ((RemoteWebDriver)driver1).getCapabilities();
        // In this capabilities instance we have all information related to 'RemoteWebdriver'.

        //printing browser version and name to console.

        System.out.println(capabilities.getBrowserName()+","+capabilities.getBrowserVersion());
        driver1.quit();


    }

    @Test
    public void getSystemProperties()
    {
        /**
         * Under system properties we have Java version , and operating system version and details.
         *
         * In Java to get or set ant system property we have a class called 'System', to get system properties
         * we have three methods as follows.
         *
         * 1.getProperties(); this method gives all system properties along with their values.
         * 2.getProperty(String key); if we provide any key of system then we will get value of that key, this returns
         * null if specified key is not available.
         * 3.getProperty(String key, String def); this method also returns value to specified property key as parameter
         * where it returns default value which also specified as parameter if key is not available in system properties.
         */

        /** to print all system properties.*/
        // System.getProperties().list(System.out);

        // to get and print operating system name.
        System.out.println(System.getProperty("os.name"));

        // to get Java version.
        System.out.println(System.getProperty("java.version"));

        //along with these if we want to get application URL ,username, password then we need to fetch them from
        //... properties file or Json file.

    }

    @Test
    public void loggingSystemInformation()
    {
        /**
         * These system information is common to all reports, so we need to set them to the 'ExtentReports'(engine).
         */

        WebDriver driver1 = browserInstantiation("chrome");
        Capabilities capabilities = ((RemoteWebDriver)driver1).getCapabilities();

        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File("./ReportFiles/loggingSystemInfo.html"));
        engine.attachReporter(sparkReporter);

        // To set system info we need to call the 'setSystemInfo(String key,String value)' method on 'ExtentReports' instance.
        engine.setSystemInfo("OS",System.getProperty("os.name"));
        engine.setSystemInfo("Java-version",System.getProperty("java.version"));
        engine.setSystemInfo("BrowserName",capabilities.getBrowserName());
        engine.setSystemInfo("BrowserVersion",capabilities.getBrowserVersion());
        engine.setSystemInfo("Application URL","https://hyrtutorials.com");
        engine.setSystemInfo("userName","Admin");
        engine.setSystemInfo("password","admin123");

        engine.flush();
        driver1.quit();

        try
        {
            Desktop.getDesktop().browse(new File("ReportFiles/loggingSystemInfo.html").toURI());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
