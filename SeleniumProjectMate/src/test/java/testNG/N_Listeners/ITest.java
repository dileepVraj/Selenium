package testNG.N_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ITest extends TestListenerAdapter
{
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("on test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("On test failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("on test failed but with success percentage");
    }



    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("On test failed with timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On finish");
    }
}
