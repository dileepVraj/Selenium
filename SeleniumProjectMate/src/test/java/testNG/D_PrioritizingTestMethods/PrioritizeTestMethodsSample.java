package testNG.D_PrioritizingTestMethods;

import org.testng.annotations.Test;

public class PrioritizeTestMethodsSample
{
    /**
     * In this test class we are performing the flight ticket booking in a booking web application.
     */

    /**
     * Point to be noted:
     * if we are not specifying priority for methods using TestNG then the test methods will execute in alphabetical
     * order.
     */
    @Test(priority = 0)
    public void signUp()
    {
        System.out.println("signUp");
    }
    @Test(priority = 1)
    public void login()
    {
        System.out.println("login");
    }

    @Test(priority = 2)
    public void searchForFlight()
    {
        System.out.println("search for flight");
    }

    @Test(priority = 3)
    public void bookFlight()
    {
        System.out.println("book the flight");
    }

    @Test(priority = 4)
    public void logout()
    {
        System.out.println("logOut");
    }
}
