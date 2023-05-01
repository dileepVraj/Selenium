package testNG.J_DataProviders.ParallelExecution;

public class Introduction
{
    /**
     * How to execute tests parallel with data provider?
     *
     * Till now when we are executing our test methods with data provider they are executing sequentially one by one
     * not parallel, with this approach it consumes more time, out computer machines has ability to run multiple programs
     * in parallel to save time we have to use it by multi threading process.
     *
     * To execute our tests in parallel we have to pass attribute 'parallel' to @DataProvider(parallel = true) and have
     * to set the value as true.
     *
     */

    /**
     * How to control the thread count when using data provider?
     *
     * Assume we have 100 of test data which we are reading from Excel file and integrated with data provider then if
     * we perform parallel testing with data provider 100 browser instances will be invoked which leads to failure
     * if our machine is not capable of handling those browser instances at a time.
     * So we have another process to control how many browser instances need to be invoked at a time using data provider
     * thread count.
     * We cannot specify that attribute inside the test class we have to specify at the testNG.xml configuration file.
     *
     * We have to add 'data-provider-thread-count' to the suite tag and set value to 2 so in every parallel execution
     * it will provide 2 sets of data and where only 2 instances of browser will be invoked each time.
     */
}
