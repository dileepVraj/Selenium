package testNG.O_CaptureScreenshotsOnFailedTests.byListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import xpath.BaseClass;

import java.io.File;

public class ITestListenerClass extends BaseClass implements ITestListener
{


    @Override
    public void onTestFailure(ITestResult result)
    {
        // gives the test name in xml configuration file.
        String testName = result.getTestContext().getName();
        String name = result.getMethod().getMethodName();

        String testNamePlusMethodName = testName+"_"+name;



       capScreenshot(testNamePlusMethodName+".png");
//
    }
}
