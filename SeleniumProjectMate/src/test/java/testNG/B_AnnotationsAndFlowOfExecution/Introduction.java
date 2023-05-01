package testNG.B_AnnotationsAndFlowOfExecution;

public class Introduction
{
    /**
     * What is an annotation?
     * An annotation is type of metadata in programming languages that provides information about a piece of code
     * such as classes, methods, or variables.
     * Annotations are used to provide information to the compiler, runtime environment or other tools that process the
     * code.
     *
     * TestNG is popular testing framework for java applications that provides a rich set of annotations to define and
     * control the test execution flow.
     * TestNG annotations are used to define the order of execution of test methods, specify the dependencies between
     * the test methods, and configure the test environment.
     * TestNG annotations are also used to group the test methods , specify the data provider for test methods, and con
     * figure the test output.
     * Annotations in testNG are:
     * 1.@Test.
     * 2.@BeforeSuite
     * 3.@AfterSuite
     * 4.@BeforeTest
     * 5.@AfterTest
     * 6.@BeforeClass
     * 7.@AfterClass
     * 8.@BeforeMethod
     * 9.@AfterMethod.
     * 10.@BeforeGroup
     * 11.@AfterGroup
     * 12.@DataProvider
     * 13.@Ignore
     * 14.@Parameters
     * 15.@Listeners
     * 16.@Factory
     *
     * If we want to execute any piece of code before the suite then we should use @BeforeSuite annotation on the
     * method.
     * If we want to execute a piece of code before test in xml configuration file then we should use @BeforeTest annotation
     * on that method.
     * If we want to execute any code before the class then we should use @BeforeClass annotation on that method.
     * In a class we will have multiple methods so if we want to execute any code before every method then we should
     * use @BeforeMethod annotation on that method.
     * Similar way for after things(annotations).
     *
     * These annotations are created based on the xml configuration file structure.
     *
     */
}
