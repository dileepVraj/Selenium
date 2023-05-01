package testNG.C_Assertions.Explanations;

public class HardAssertionsVsSoftAssertions
{
    /**
     * What is a hard assertion?
     *
     * Hard assertion is an assertion that stops the execution immediately when it fails.
     * In other words if the hard assertion fails the remaining assertions in the test case will not execute and test
     * will be remarked as failure.
     * Hard assertions are implemented using TestNG Assert class.
     *
     * Hard assertions are useful for catching errors early in the test execution process for improving the efficiency
     * of tests runs by stopping the execution of the test as soon as an error is detected.
     * However, they, should use judiciously because they can also cause false positives if they are too strict or not
     * well-thought-out.
     */

    /**
     * What is soft assertion?
     *
     * In TestNg soft assertion is an assertion that does not stop the test execution immediately when it fails.
     * Instead, the test execution continues and all failures are collected until the end of the test method.
     * Only then test is marked as failure.
     * Soft assertions are implemented using TestNG 'SoftAssert' class.
     *
     * Sample code:
     *
     * @Test
     * public void testDivision() {
     *     int a = 10;
     *     int b = 5;
     *     SoftAssert softAssert = new SoftAssert();
     *     softAssert.assertEquals(a / b, 2);
     *     softAssert.assertEquals(b / a, 0);
     *     softAssert.assertAll();
     * }
     *
     * In this example, the SoftAssert class is used to perform soft assertions.
     * The assertEquals method is called twice, and the test continues executing even if the first assertion fails.
     * The assertAll method is then called at the end of the test method to mark the test as failed if any of the
     * soft assertions failed.
     *
     * Soft assertions are useful when we want to perform multiple validations in single test method and want to collect
     * all the failures before marking the test as failure.
     * They are also helpful when we want to perform some clean up actions before marking the test as failure, examples
     * like closing a browser and logging out of the application.
     *
     * We can throw all collected exceptions at the end of the test or at specified step in the test.
     *
     *
     *
     */



    /**
     * How to use soft assertions?
     */
}
