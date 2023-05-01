package testNG.N_Listeners;

import org.testng.annotations.Test;

public class ListenersAtSuiteLevel
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
