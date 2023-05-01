package testNG.L_ParallelTestsExecution;

public class Introduction
{

    /**
     * Point to be noted:
     *
     * This is very important topic because we extensively use this concept in real time project.
     */
    /**
     * What is parallel execution?
     *
     *parallel testing is feature of TestNG which executes test cases concurrently, which can significantly reduce the
     * amount of time which it takes to run a suite of tests.
     *
     */




    /**
     * How to perform parallel execution?
     *
     *Parallel testing can be achieved in several ways. One approach is to use TestNG built in support for running
     * tests in parallel.
     * This can be done by setting 'parallel' attribute in the TestNG xml file to one of the following values.
     *
     * 1. "methods" - runs all test methods in parallel
     * 2. "classes" - runs all test classes in parallel
     * 3. "tests" - runs all test cases in parallel
     * 4. "instances" - runs all instances of a test class in parallel
     * 5. "none" executes test cases in sequential execution order.
     * 6. "false" executes test cases in sequential execution order.
     *
     * Another way to achieve parallel testing in TestNG is by using thread pool feature.
     * This allows us to specify that number of threads to use for running tests in parallel, which can be helpful for
     * controlling the level of parallelism and avoiding overloading the system.
     *
     * To use Thread pool feature in TestNG we have to set the 'thread-count' attribute in the TestNG xml configuration
     * file to the number of threads to use.
     *
     * Syntax:-
     * <suite name="MyTestSuite" parallel="tests" thread-count="3">
     *    <!-- Test cases go here -->
     * </suite>
     *
     * This configuration runs all the tests cases in parallel across the three threads.
     *
     * Parallel tests execution in TestNG helps us for faster tests execution in times, which can be specially useful
     * for large test suits.
     * How-ever it is important to keep in mind that parallel testing can also introduce additional complexity, such as
     * race conditions and resource contention, so it is important to design your tests carefully to avoid these issues.
     *
     */

    /**
     * Points to be noted:
     *
     * 1. If we provide negative value to the thread-count attribute then it will throw java.lang.IllegalArgumentException.
     * 2. We cannot use parallel = "tests" at test level because there will be no tests available at test level.
     * 3. Mostly we use parallel = "methods" and parallel = "classes" at test level because we will have more control while
     * using them at test level, but if we want to execute tests in parallel we have to mention parallel = "tests" at suite
     * level only.
     */
}
