package testNG.M_InvocationTimeOut;

public class Introduction
{
    /**
     * In this class we are going to learn about following topics.
     *
     * 1. What is invocation count?
     * 2. Why do we need invocation count?
     * 3. How to use invocation count?
     * 4. What is invocation timeout?
     * 5. How do we use invocation timeout?
     * 6. What is thread-pool size?
     * 7. Why do we need thread-pool size?
     * 8. How to use thread-pool size?
     */

    /**
     * Before knowing invocation timeOut and invocation count we have to understand some scenario.
     *
     * Let's assume our test needs some random users to test the functionality of the application then we can visit
     * 'randomuser.me' application which generates a random user when ever we hit this application.
     *
     * Now I need to hit this application 5 times to generate 5 random users and print those user details to the console
     * we can encompass that code in for loop and make loop to run 5 times but in case with any reason if encompassed code
     * throws exception and failed then the entire method will fail and it don't execute next run to generate random user.
     *And we cannot track the information on and remaining iterations will not be executed, so here comes invocation concept
     * with this concept we can execute same piece of code multiple times and we can track each and every iteration and if
     * one iteration failed it will not halt it will continue with other iterations.
     *
     */

    /**
     * What is invocation count?
     *
     * Invocation count is parameter inside @Test() annotation, where it tells how many number of times a test method needs
     * to be executed based on value we passed to this 'invocation count' parameter.
     *
     */

    /**
     * Why do we need invocation count?
     *
     * While using for loop or other loops we will have some issues where if one iteration fails because of any exception
     * then remaining iterations will not be executed.
     * To avoid these issues we need the invocation count.
     */

    /**
     * How to use invocation count?
     *
     * @Test(invocationCount = 5)
     *
     * this test will run for 5 times even if any iteration fails.
     */

    /**
     * What is Invocation timeout?
     *
     * We can restrict invocation time for all invocations by using invocationTimeout attribute inside @Test annotation.
     *
     * suppose we have a test method with invocation count = 5, and it should complete it's all invocations with in 10
     * seconds then we should use invocationTimeout attribute with value = 10000(milli seconds).
     *
     */

    /**
     * Point to be noted: if we don't mention invocation count and mentioned invocation timeout then it is useless
     * parameter.
     *
     */

    /**
     * What is thread-pool size?
     * It is same concept as thread-count in parallel execution of tests, the invocations we are adding to test method
     * need to run in parallel mode then we should distribute our invocations to threads using thread-pool size
     */
}
