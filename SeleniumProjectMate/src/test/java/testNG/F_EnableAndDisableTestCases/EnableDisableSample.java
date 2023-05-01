package testNG.F_EnableAndDisableTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EnableDisableSample
{
    @BeforeTest
    public void sayHello()
    {
        System.out.println("hello this is before test case method.");
    }

    @Parameters("loginStatus")
    @Test
    public void login(boolean loginStatus)
    {
        if(loginStatus==true)
        {
            System.out.println("login performed and successful");
        }
        else
        {
            System.out.println("login performed and un-successful");
        }
    }

    @Parameters("myInfo")
    @Test
    public void verifyMyInfo(boolean myInfo)
    {
        if(myInfo==true)
        {
            System.out.println("my info verification performed and successful");
        }
        else
        {
            System.out.println("my info verification performed and un-successful");
        }
    }

    @AfterTest
    public void terminate()
    {
        System.out.println("This is terminate method which executes after each and every test");
    }
}
