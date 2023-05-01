package testNG.L_ParallelTestsExecution;

import org.testng.annotations.Test;

public class Sample1
{
    @Test
    public void test1()
    {
        System.out.println("Test1 in Sample1 Executed By "+Thread.currentThread().getId());
    }

    @Test
    public void test2()
    {
        System.out.println("Test2 in Sample1 Executed By "+Thread.currentThread().getId());
    }

    @Test
    public void test3()
    {
        System.out.println("Test3 in Sample1 Executed By "+Thread.currentThread().getId());
    }
}
