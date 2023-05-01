package testNG.B_AnnotationsAndFlowOfExecution;

import org.testng.annotations.*;

public class SampleExecutionOfAnnotations
{
    @Test
    public void normalTestMethod()
    {
        System.out.println("Test method executed");
    }

    @Test
    public void normalTestMethod1()
    {
        System.out.println("Test method1 executed");
    }

    @BeforeTest
    public void beforeTestMethod()
    {
        System.out.println("Before test method");
    }

    @AfterTest
    public void afterTestMethod()
    {
        System.out.println("After test method");
    }

    @BeforeSuite
    public void beforeSuiteMethod()
    {
        System.out.println("Before suite method");
    }

    @AfterSuite
    public void afterSuiteMethod()
    {
        System.out.println("after suite method");
    }

    @BeforeClass
    public void beforeClassMethod()
    {
        System.out.println("before class method");
    }

    @AfterClass
    public void afterClassMethod()
    {
        System.out.println("after class method");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("after method");
    }
}
