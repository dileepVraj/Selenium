package testNG.C_Assertions.Explanations;

public class AssertionsIntro
{
    /**
     * What are Assertions?
     *
     * Let's take any testing manual / automation while testing the functionality of the application we will perform
     * some steps/actions and validate 'actual outcome' with the 'expected outcome'.
     * Based on the outcome we are going to say that is test passed or failed.
     *
     * Here comes the use of Assertions in automation testing.
     *
     * Basically Assertion is an expression which will verify the actual test outcome with the expected test outcome.
     *
     *
     */

    /**
     * Are Assertions mandatory in the tests?
     *
     * Yes if we don't use assertions in place we don't know whether the test case is passed or failed.
     * Assertions can tell you whether the test actually passed or failed.
     * To get the status of the tests we definitely need the Assertions in the test case.
     */

    /**
     * How to perform Assertions?
     *
     * Assume we are clicking a link which navigates to shopping page located on home page, now we have to validate
     * is that link navigated us to shopping page or not if yes test is passed if not test is failed, so in this scenario
     * we will use Assertion in this way.
     *
     * We can validate are we navigated to required webpage or not by comparing Expected title of page, with the
     * actual title of the page.
     *
     * String expectedTitle = "expected title";
     * String actualTitle = driver.getTitle(); // which returns the current page title.
     *
     * To compare the above page titles using Assertions we have to use methods that are present on the static class
     * 'Assert'
     *
     * I don't know how many methods are present on 'Assert' class but some of them are listed below.
     *
     * 1. assertEquals();// we use it to compare any two values, irrespective of data type.
     * 2. assertNotEquals(); // if we want to verify actual value is not equal to expected value then we have to use it.
     * 3. assertTrue(); // when a action is returning a boolean value in the test case we can use these two methods
     * 3,4 to compare them , for positive validation we use 'assertTrue()' for negative validation we use ' assertFalse'.
     * 4. assertFalse();
     * 5. assertNull(); // while reading data from the object we use these two methods 5,6 to validate whether the
     * object is null or not null.
     * 6. assertNotNull();
     *
     *
     */

    /**
     * While using static methods on a class we have to call them by using class name, everytime to avoid that
     * we can use static import using wild card '*'.
     *
     */
}
