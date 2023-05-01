package testNG.E_Parameters;

public class Introduction
{
    /**
     * What are parameters in testNG:
     *
     * In testNG parameters allow us to pass data to our test methods dynamically.
     * You can use the parameters to run the same test method with different sets of data.
     * Parameters are defined in testNG.xml file or in a data provider method, and then passed to the test method as
     * arguments.
     */

    /**
     * Here is an example code how to pass parameters to the testNG xml file:
     *
     * <suite name = "sample-suite>
     *     <test name = "sample-test>
     *         <parameter name = "browser" value = "chrome"/>
     *         <parameter name = "env" value = "prod"/>
     *         <classes>
     *             <class name = "samplePackage.sampleClass">
     *                 <methods>
     *                     <include name = "sampleMethod/>
     *                 </methods>
     *                 </class>
     *         </classes>
     *         </test>
     *     </suite>
     *
     *     In this example the parameters "browser","env" are defined with the values "chrome" and "prod", respectively.
     *     These parameters can then, passed on to test methods as arguments.
     *
     * @Test
     * public void sampleMethod(@optional("firefox")String browser,@Optional("dev")String env)
     * {
     *     In this example the sampleMethod takes 2 parameters: 'browser' and 'env'.
     *     The @Optional annotation is used to provide default values for the parameters in case if they are not defined
     *     in the testNG.xml, these values will be passed to the test method when it is executed.
     *
     *     You can also use a data provider method to define the parameters dynamically at runtime.
     *     In this case the data provider method must return a two-dimensional array of objects , where each row
     *     represents the set of parameters for a single invocation of the test method.
     *
     *     Code snippet:
     *
     * @DataProvider(name = "myDataProvider")
     *     public Object[][] provideData()
     *     {
     *         return new Object[][]{{"chrome","prod"},{"firefox","dev"}}
     *     }
     *
     * }
     *
     * // Test method.
     *
     * @Test(DataProvider="myDataProvider")
     * public void testMethod(String browser,String env)
     * {
     *     //test code.
     * }
     *
     * In this example the DataProvider annotation is used to provide the name to the dataProvider method.
     * The test method takes two parameters browser and env.
     * The data provider method returns a two-dimensional array with two rows, representing two sets of parameters values
     * The @Test annotation is used to specify the data provider method to use.
     * Once the test method is executed, it will invoke twice once for each set of parameters values.
     */

    /**
     * These parameters can be passed at suite and test level.
     *
     * If any parameters are supposed to pass across all tests cases then we can pass those parameters at suite level.
     * If we want to pass parameters that are only specific to the test then we should go for the test level parameters.
     *
     */

    /**
     * If we have parameters at suite level and also test level with same name and different values then testNG
     * will prioritize the test level parameter in the test method.
     */

    /**
     * We can read string value in the parameters in xml file in any data type in the test method.
     *
     * sample code:
     * <Parameters name = "sleepTime" value = "3000"/>
     *
     * @AfterTest
     * public void terminate(Long sleepTime)
     * {
     *     Thread.sleep(sleepTIme);
     *     driver.quit();
     * }
     *
     * we can notice that we passed value of sleepTime in xml as string but, we are reading it as Long which is
     * argument type of sleep() method.
     */
}
