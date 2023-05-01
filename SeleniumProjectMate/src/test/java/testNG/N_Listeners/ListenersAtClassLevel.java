package testNG.N_Listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * If we want to use listeners at class level we have to declare '@listeners' annotation at class level and need to
 * specify implementation's of ITestListener Interface.
 *
 * This '@Listeners' annotation accepts an array of classes that implements the ITestListener or other Listener in TestNG.
 */

@Listeners({ITest.class})
public class ListenersAtClassLevel
{

    @Test(priority = 0)
    public void test1()
    {
        System.out.println("test1");
    }

    @Test(priority = 1)
    public void test2()
    {
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void test2(String name)
    {
        System.out.println("test2");
        System.out.println(5/0);
    }

    @Test(timeOut = 1000,priority = 3)
    public void test3() throws InterruptedException
    {
        Thread.sleep(2000);
        System.out.println("test2");
    }

    @Test(dependsOnMethods = "test3",priority = 4)
    public void test4()
    {
        System.out.println("test4");
    }
}
