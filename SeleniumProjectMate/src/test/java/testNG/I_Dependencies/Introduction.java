package testNG.I_Dependencies;

public class Introduction
{
    /**
     * What are test dependencies?
     *  In test-NG test dependencies refer to relationship between test methods in a test suite where execution of one
     *  test method depends on the successful execution of another test method.
     *  In other words test dependencies are used to ensure that a test method runs only a specific test method has
     *  completed successfully.
     *
     *  Test-NG allows you to define the dependencies between test methods by using the 'dependsOnMethods' attribute
     *  in @Test annotation.
     *  For example, if we have 2 test methods 'testMethod1' and 'testMethod2' and you want to execute testMethod2 only
     *  after testMethod1 passed, you can use 'dependsOnMethods' attribute as follows.
     *
     *  Code snippet:
     *
     * @Test
     * public void testMethod1()
     * {
     *     // code
     * }
     *
     * @Test(dependsOnMethods = {"testMethod1"})
     * public void testMethod2()
     * {
     *     //code
     * }
     *
     * in above example the testMethod2 will be executed only if testMethod1 is passed successfully, if testMethod1 fails
     * testMethod2 will be skipped.
     *
     * Using test dependencies help us to create more complex scenarios where you need to ensure that certain actions
     * have been performed before proceeding to the next step.
     * This is particularly useful when testing web applications where you may need to log in to a site before accessing
     * certain pages and performing certain actions.
     */

    /**
     * Point to be noted:
     *
     * We can create test dependencies on test methods and test groups also.
     */



    /**
     * What happens when priority is set to the test methods?
     *
     * If we have two methods createShipment which create shipment and generate the tracking number , and another
     * method which is tracking the shipment using the tracking number in this case the trackShipment method is
     * dependent on the createShipment if it fails the trackShipment won't execute.
     *
     * If I have given the lowest priority to the trackShipment over createShipment method then it won't work the
     * dependent method(createShipment) method only will be executed first and later trackShipment irrespective of
     * priority value.
     * This means dependency overrides the priority.
     */

    /**
     * What happens when dependent test is failed?
     *
     * If dependent test fails then test methods depends on dependent method will be skipped.
     *
     * Point to be noted:
     *
     * Even though the dependent test is failed I want to run test methods those depend on dependent method then we have
     * to add another attribute to the @Test() annotation 'alwaysRun' and set its value to true.
     */

    /**
     * What happens when dependent test is ignored or skipped or deleted?
     *
     * Scenario Ignored:
     * If dependent method createShipment method is ignored then no methods will be executed that's it.
     *
     * Scenario Deleted:
     * If dependent method is deleted then those methods depends on that method won't execute.
     *
     * Even though if dependent method is deleted or Ignored if we still want to run depend on methods then we have
     * to pass attribute 'ignoreMissingDependencies' to @Test annotation and set its value to true.
     *
     */
}
