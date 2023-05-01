package testNG.P_Reports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class E_LogLevels
{
    /**
     * In this class we will learn about different log levels in Extent reports and what is the priority of these log
     * levels.
     *
     * We have 5 different types of log's in Extent reports.
     *
     * 1.Fail.
     * 2.Skip.
     * 3.Warning.
     * 4.Pass.
     * 5.Info.
     */

    @Test
    public void logging()
    {
        ExtentReports engine = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(new File("ReportFiles/logging.html"));
        engine.attachReporter(spark);

        engine.createTest("Test1")
                .log(Status.INFO,"Info 1")
                .log(Status.INFO,"Info 2")
                .log(Status.PASS,"Pass 1")
//                .log(Status.FAIL,"Fail 1")
                .log(Status.WARNING,"Warning 1");
//                .log(Status.SKIP,"Skip 1");

        /*
          By adding these logs our test status in Extent reports is considered as fail because, Extent reports logging
        * order is like Fail, Skip, Warning, Pass, Info if a single test has all these logs or some, then Fail will be
        * given the highest precedence over other logs as test status, if fail is not in the logs then skip will be given the highest
        * precedence, after warning and after pass and info.
        *
        * So we have to use log events appropriately because if we use all log events, based on logs precedence the status
        * of test will be given. */

        engine.flush();

        try
        {
            // This below step is to open the report automatically after execution of test method completes.
            Desktop.getDesktop().browse(new File("ReportFiles/logging.html").toURI());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
