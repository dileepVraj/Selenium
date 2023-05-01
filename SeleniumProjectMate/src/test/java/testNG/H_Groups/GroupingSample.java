package testNG.H_Groups;

import org.testng.annotations.Test;

@Test(groups = {"all"})
public class GroupingSample
{
    @Test(groups = {"smoke"})
    public void method0()
    {
        System.out.println("method 0 in "+this.getClass().getName());
        System.out.println(" this method in part of only smoke group");
    }

    @Test(groups = {"smoke","regression"})
    public void method1()
    {
        System.out.println("method 1 in "+this.getClass().getName());
        System.out.println(" this method is part of smoke and regression group");
    }

    @Test(groups = {"functional","regression"})
    public void method2()
    {
        System.out.println("method 2 in "+this.getClass().getName()+"\n"+
                "this method is part of functional and regression groups");
    }
}
