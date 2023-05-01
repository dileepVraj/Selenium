package testNG.D_PrioritizingTestMethods;

public class Introduction
{
    /**
     * What is priority and why we need to use priority?
     *
     * Priority is importance we are giving to someone or something other others.
     * We need priority in testNG to prioritize the test methods in the class so that they will follow the priority
     * defined, if we don't specify priority to the methods then the execution is held by following the ASCII order of
     * method names.
     * So to avoid this conflict we use priority concept in TestNG.
     */

    /**
     * How to define the priority?
     *
     * We have a property in TestNG called 'priority' we have to pass that property to @Test() annotation by giving the
     * values in integer.
     *
     * Ex:
     * @Test(priority = 1)
     * public void login()
     * {
     *     //code
     * }
     *
     * The method which have the least value to priority property will execute first among other methods.
     */

    /**
     * What is default value of the priority?
     *
     * The default priority value is 0.
     * If all methods except one or few methods in the class having priority set then those methods with no priority
     * has default priority with value 0, so those methods having same priority value they will be again executed/scheduled
     * based on ASCII value of method names.
     */

    /**
     * Can we pass negative values to the priority?
     *
     * Yes we can pass negative values to the priorities, and those methods with the least priority value (even negative numbers)
     * will execute first.
     */

    /**
     * What happens if same priority is passed to multiple test methods?
     *
     *  Those methods having same priority value they will be again executed/scheduled based on ASCII value of method names.
     */


    /**
     * Beautiful point to be noted is that :
     *
     * If we are learning anything, including general things we have to ask the three thing to our self they are:
     *
     * 1. What?
     * 2. Why?
     * 3. How?
     */
}
