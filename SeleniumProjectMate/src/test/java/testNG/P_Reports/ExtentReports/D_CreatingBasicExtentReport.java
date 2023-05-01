package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class D_CreatingBasicExtentReport
{
    @Test
    public void basicExtentReport() throws IOException {
            // create object of ExtentReports class.
            // This is report engine for creating extent reports for us.
            ExtentReports engine = new ExtentReports();
            /*Now create object of type of report we are creating in Extent reports, basically we have 4 types of
            * reports in Extent reports 1.ExtentSparkReporter 2.ExtentAvenReporter 3.ExtentEmailReporter 4.ExtentKlovReporter
            *Where emailReporter and AvenReporter are pro version reporters, and remaining reports are free.
            *
            * In between ExtentKlov and ExtentSpark klov is dynamic reporter which we have to learn separately which is not
            * using in this series, so we are going to create ExtentSparkReporter object.
            **/
            // pass the path directly of in form of file to where we have to create extent reports.
            File extentReportPath = new File("./ReportFiles/ExtentReports");
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
            // Now we have to attach sparkReports to ExtentReports object(engine).
            engine.attachReporter(sparkReporter);
            // Now we have to flush the reports to generate the report.
            engine.flush();
            // This creates the plan extent reports with no reports because we didn't add any test cases yet.

            // when ever the extent reports are generated we have a automated way to open this file directly as shown below.

            Desktop.getDesktop().browse(new File("C:\\Users\\dilee\\IdeaProjects\\SeleniumProjectMate\\ReportFiles\\ExtentReports.html").toURI());
            /*In above statement the Desktop is a Java class,*/
        }

        @Test
    public void createReportWithTests()
        {
            ExtentReports engine = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter
                    (new File("ReportFiles/TestReports/reportWithTests.html"));
            engine.attachReporter(sparkReporter);
            /*Now we will add tests, we have to add them under the extent reports, by using createTest() method which is
            * overloaded method we have other versions of it which takes parameters like, String, GherkinKeyword and string
            * testName,String description.
            *
            * These extent reports can be used with J-unit, Cucumber, so we have those overloaded methods for 'createTest'
            * method.
            *
            * */
            ExtentTest test1 = engine.createTest("Test 1");// this returns ExtentTest class.
            /*By default, when we crate test it will be passed.
            * We can add status for this method by using logs. */
            test1.pass("This is pass test.");

            ExtentTest test2 = engine.createTest("Test2");
            test2.log(Status.FAIL,"This is failed test");

            engine.createTest("Test3").log(Status.SKIP,"This is skipped test");

            engine.flush();
        }
}
