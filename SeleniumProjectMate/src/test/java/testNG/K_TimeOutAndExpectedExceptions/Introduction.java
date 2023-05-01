package testNG.K_TimeOutAndExpectedExceptions;

public class Introduction
{
    /**
     * TimeOuts and Expected Exceptions are attributes inside @Test annotation.
     *  Generally we use attributes to alter the functionality of the test methods where they pass some data to the method.
     */

    /**
     * What is timeout?
     *
     * Suppose we have a home page loading test case where it is taking 6 seconds to load, but in our business requirement
     * specifications it is specified that it should load in 4 seconds now how to test this functionality?
     *
     * Another analogy, suppose we are placing an order in amazon application where the order summary page should load
     * with in 3 seconds after payment done, how to test this scenario.
     *
     * Here comes the TestNG TimeOut attribute which resides inside the @Test() annotation which fails the test if
     * it is not completed with in specified time, and it throws the exception also.
     *
     */

    /**
     * How to use timeOut?
     *
     * We have to pass this 'timeOut' attribute to @Test tag with value as in form of milli seconds.
     *
     * Syntax: @Test(timeOut=6000) // 6000 milli seconds = 6 seconds.
     */

    /**
     * What is expectedExceptions?
     *
     * The 'expectedExceptions' attribute in @Test() annotation is used to specify the expected exception that a test
     * method may throw.
     * If the expected exception is thrown by the test method then it is marked as pass,
     * if the method throws different exception or doesn't throw any exception at all then it is marked as fail.
     */

    /**
     * How to use expected conditions?
     *
     * It can expect multiple exceptions that a method may throw if all expected exceptions are thrown by test method
     * then the test method is marked as pass.
     *
     * Syntax:
     *
     * @Test(expectedExceptions = {ArithmeticException.class,IOEException.class})
     * public void testTheFile()
     * {
     *     //code.
     * }
     */
}
