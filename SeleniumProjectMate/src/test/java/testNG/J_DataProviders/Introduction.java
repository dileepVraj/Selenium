package testNG.J_DataProviders;

public class Introduction
{
    /**
     * What is data provider?
     *
     * In Test-NG dataProvider is a method that provides data to the test method. It allows us to run same test method
     * multiple times with different sets of data.
     *
     * By using dataProvider we can separate test data from test logic(test method), which makes the test code more
     * modular and easy to maintain. Test-NG provides several ways to specify dataProvider, including:
     *
     * 1. Method level dataProvider:
     * We can specify a dataProvider method for a specific test method using @DataProvider annotation.
     * The DataProvider should return two-dimensional Object array, Where each row represents a set of test data.
     *
     * 2. Class level dataProvider:
     * We can specify DataProvider method to all test methods in a test class using @DataProvider annotation at the
     * class level.
     * The DataProvider method should also return two-dimensional Object array.
     *
     * 3. External data source:
     * Test-NG also supports to read data from external sources like CSV, Excel and XML files.
     * We can specify the location of the external file as parameter to DataProvider method.
     *
     * Here is an example of using a data provider method in test-NG.
     *
     * @DataProvider(name = "loginDataProvider")
     * public Object[][] testData()
     * {
     *      return new Object[][]
     *      {
     *          {"userName", "password"}
     *          {"userName1", "password1"}
     *          {"userName2", "password2"}
     *      }
     * }
     *
     * @Test(dataProvider="loginDataProvider")
     * public void testLogin(String userName, String password)
     * {
     *      // test login using given userName and password.
     * }
     *
     * In this example testData() method returns two-dimensional Object array with three sets of data.
     * The 'testLogin' method is annotated with @Test() and specifies 'testData' method as DataProvider.
     * The 'testLogin' method takes two string type parameters 'userName' and 'password' which are supplied by the data
     * provider method for each iteration of the test.
     */

    /**
     * What happens if we don't provide a name to the data provider.
     *
     * If we don't provide name to the dataProvider method then we will get runtime exception 'testNGException'
     * which says the login method needs a data provider with name which we specified in @Test() annotation.
     *
     * It is best practice to set data provider name to which we gave to dataProvider method, if we didn't specify any
     * name to dataProvider(not even the method name) then we should pass dataProvider method name as value to
     * dataProvider attribute in @Test() annotation of login method.
     */

    /**
     * Is it mandatory to return Object[][] from the data provider method?
     *
     * No it is not mandatory to return only two-dimensional Object array from data provider method,we can return other
     * return types from a data provider method.
     */

    /**
     * What are return types of data provider?
     *
     * 1. Object[] (Object single dimension array).
     * 2. Object[][] (Object two-dimensional array).
     * 3. Iterator<Object>
     * 4. Iterator<Object[]>
     */

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * How to use data provider partially in TestNG
     * Here partially means using some part(partial) of data not all the data in data provider.
     *
     * For example:
     *
     * we have two basic methods where 1 is data provider and one is test-method which use data from data provider.
     *
     * if we run that test method which consumes data from specified data provider then that method will run multiple
     * times depends on different or number of sets of data in data provider.
     *
     * So if we want to pass the partial data (some part of data) to the test method from data provider then we have to
     * use 'indices'
     *
     * What are indices?
     *
     * indices are nothing but indexes of which part of data we want to pass to test method from data provider.
     *
     * Suppose:
     *
     * I have single dimensional array in my data provider as Object[] data = {"hai",123,"how","what", 23.5}
     * Now I only want to supply ' how, hai, 23.5' to test method.
     * While passing data to test method from data provider using indices we have to use the index concept indices are
     * 0 based indexes where index of hai=0, 123=1, how=2,what=3,23.5=4.
     * These indexes are called as indices.
     *
     * How to use Indices?
     *
     * indices is a parameter to the @DataProvider() annotation which accepts int[] as value.
     * If we don't provide any indices parameter in dataProvider annotation by default it is set to all(that's why all
     * test data will be supplied to test method if we don't use indices parameter).
     *
     * Why we use indices?
     *
     * Assume suppose we have 10 sets of data in our data provider and where test method is failing while using
     * 3 sets of data out of 10 where it should pass with those data sets, now we have to run test method with
     * those 3 sets of data while de-bugging so we cannot run remaining 7 sets of data where they are fine so to achieve
     * this scenario we have to use indices parameter inside @DataProvider() annotation and specify which sets of data
     * need to be passed to the test method while execution.
     */
    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * How to create data provider method in separate class?
     *
     * Until, now we have created data provider method in same class where test method resides on.
     * But with some process we can separate data provider into another class from test classes.
     *
     * To do that we have to use a parameter called 'dataProviderClass' inside a @Test annotation, by using this
     * parameter we can specify to test method where the specified data provider is residing at.
     *
     * This 'dataProviderClass' parameter takes the instance of class as value.
     *
     * Example:
     *
     * @Test(dataProvider = "loginData",dataProviderClass = className.Class);
     *
     *
     * Can we specify of can we have more than one data provider in single class?
     *
     *Yes we acn have multiple data providers in single class because we will have different names to those methods
     * we will not fall into ambiguity problem.
     *
     * Can we have multiple data provider classes in a project?
     *
     * Yes we can have multiple data provider classes in single project there is no problem.
     *
     */

    /**
     * Point to be noted:
     *
     * In real time projects data providers will be created in separate classes and use them with 'dataProviderClass'
     * attribute in the test classes with test methods.
     */

    /*---------------------------------------------------------------------------------------------------------------*/


}
