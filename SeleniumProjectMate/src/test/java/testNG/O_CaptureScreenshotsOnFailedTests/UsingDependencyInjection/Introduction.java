package testNG.O_CaptureScreenshotsOnFailedTests.UsingDependencyInjection;

public class Introduction
{
    /**
     * To capture screenshots on failure tests using TestNG dependency injection concept we have to add
     * @AfterMethod in test class.
     * public void captureScreenshot(ITestListener result)
     *
     * {
     *     if(result.getStatus()==ITestResult.FAILURE)
     *     {
     *         // code to capture screenshot and saving in a folder in project with test name and method name combination.
     *     }
     * }
     *
     * that's it we all have to do this, this captureScreenshot method will be look into every method status after
     * it's execution and captures screenshot if failure.
     */
}
