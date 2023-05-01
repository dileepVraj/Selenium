package testNG.H_Groups;

import org.testng.annotations.Test;

public class GroupingSample1
{
    @Test(groups = {"regression","smoke"})
    public void method3()
    {
        System.out.println("method 3 in "+this.getClass().getName()+"\n"+
                "this method is part of smoke and regression groups");
    }

    @Test(groups = {"sanity","smoke"})
    public void method4()
    {
        System.out.println("method 4 in "+this.getClass().getName()+"\n"+
                "this method is part of smoke and sanity groups");
    }

    @Test(groups = {"sanity"})
    public void method5()
    {
        System.out.println("method 5 in "+this.getClass().getName()+"\n this method is part of" +
                "only sanity group");
    }
}
