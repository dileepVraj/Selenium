package testNG.O_CaptureScreenshotsOnFailedTests;

public class Introduction
{
    /**
     * How to capture screenshots for only failed test cases in TestNG?
     *
     * In how many ways we can achieve this and what are they?
     *
     * How to capture screenshots for failed tests in testNG using listeners?
     *
     * How to capture screenshots for only failed tests in testng using dependency injection?
     *
     * How to avoid screenshots overriding?
     */

    /**
     * When ever we are working with test automation we have to capture screenshots and logs because these are going to
     * help us in many ways.
     *
     * One of the situation is : If we need to analyze and test failure we need logs and screenshots.
     * Log file will give us technical information, like because of which exception test case is failed and what exactly is the
     * exception, and screenshots will provide us the visual information, sometimes even though the log file is not providing
     * the clear information by looking at screenshot we will understand why particular test is failed.
     *
     * Screenshots and log files are very important to analyze the test failure, but in some conditions the screenshots
     * will help us more precisely than log files.
     *
     * Not only in this situation, if we encountered a bug in the application then to log the bug we have to attach
     * the screenshots for proof or analyzing purpose.
     *
     *
     */

    /**
     * Actually when ever we want to capture screenshots we will code some lines of code, but the point is we want to
     * capture the screenshot only when the test is failed.
     * How to identify whether test failed or not, and how to capture the screenshot only when test is failed.
     *
     * We can do it in 2 ways 1. normal way 2. professional way.
     *
     * @Test
     * public void normalWayToCaptureScreenshot()
     * {
     *     encompass the entire code inside the try catch block, when ever the exception occurs catch the exception and
     *     add code to capture the screenshot code inside the try block, this will do the job.
     *
     *     By following this approach we will face some problems:
     *
     *     1. code repetition we have to encompass our code in every test method in try catch blocks with screenshot capturing
     *     code, for every test method we are wasting 6,7 lines of code.
     *     We are violating the automation coding principles.
     *
     *     This is not the professional way to follow to capture screenshots in testng.
     * }
     *
     *We can capture the screenshots when the test method is failed, 1. using TestNG listeners 2. dependency injection.
     *
     *
     */
}
