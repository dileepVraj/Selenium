package testNG.N_Listeners;

public class Introduction
{
    /**
     * What is listener in testNG?
     *
     * In TestNG, listeners are components that allow you to customize the behavior of your tests.
     * Listeners are Java classes that implement TestNG listener interfaces and are used to perform actions at
     * various stages of a test's lifecycle, such as before or after a test method or suite.
     *
     * There are several built-in listeners available in TestNG that you can use to perform various actions.
     * For example, the IInvokedMethodListener interface allows you to perform actions before and after a test
     * method is invoked, while the ISuiteListener interface allows you to perform actions before and after a
     * test suite is run.
     *
     * TestNG also allows you to create your own custom listeners by implementing the various listener interfaces.
     * This can be useful if you want to perform specific actions that are not covered by the built-in listeners.
     *
     * Overall, TestNG listeners are a powerful feature that allow you to customize the behavior of your tests and
     * perform various actions at different stages of the test lifecycle.
     */

    /**
     * Why do we need listener in testNG?
     *
     *TestNG listeners allow us to perform custom actions before or after different stages of our test life cycle.
     * Suppose we can use listener to log information before or after each test method or to initialize or clean up
     * resources before or after test suite run.
     *
     * With TestNG listeners we can customize the behaviour of our tests without changing the test code.
     * This can be particularly useful to perform actions that are not related to test code, such as logging, reporting
     * or environment setup.
     *
     * TestNG listeners help us to better to manage your tests by providing hooks for specific events, allowing you to
     * take actions based on the outcome of the test.
     * For example, we can use listener to retry if a particular test failed and to skip a test based on certain conditions.
     *
     * TestNG listeners can be extended and customized according to our testing needs.
     * By implementing our own testing listeners we can perform actions that specific to your application or testing environment.
     *
     * Overall TestNG listeners are powerful tool that allow us to customize the behaviour of your tests and perform wide
     * range of actions at different stages of test life cycle.
     */

    /**
     * List out some listeners available in TestNG?
     *
     * 1. IAnnotationTransformer: This listener allows you to modify test class annotations at runtime.
     *
     * 2. AnnotationTransformer2: This listener allows you to modify test method annotations at runtime.
     *
     * 3.IConfigurable: This listener allows you to configure the test suite.
     *
     * 4. IConfigurationListener: This listener allows you to perform custom actions before or after the configuration
     * of the test suite.
     *
     * 5. IExecutionListener: This listener allows you to perform custom actions before or after the entire test suite is executed.
     *
     * 6. IInvokedMethodListener: This listener allows you to perform custom actions before or after each test method is executed.
     *
     * 7. IMethodInterceptor: This listener allows you to reorder the test methods.
     *
     * 8. IReporter: This listener allows you to generate custom HTML or XML reports.
     *
     * 9. ISuiteListener: This listener allows you to perform custom actions before or after the entire suite is run.
     *
     * 10. ITestListener: This listener allows you to perform custom actions before or after each test method is executed.
     *
     * 11. IDataProviderListener: This listener allows you to perform custom actions before or after each data provider method is executed.
     *
     * 12. IParametersListener: This listener allows you to perform custom actions before or after the parameters of
     * a test method are set.
     *
     * 13. ITestClassListener: This listener allows you to perform custom actions before or after each test class is executed.
     *
     * 14. IMethodInterceptor: This listener allows you to reorder the test methods based on the groups they belong to.
     *
     * Among these we have some frequently used listeners:
     *
     * 1. IAnnotationTransformer
     * 2. IAnnotationTransformer2.
     * 3. IHookable.
     * 4. IInvokedMethodListener.
     * 5. IMethodInterceptor.
     * 6. IReporter.
     * 7. ISuiteListener.
     * 8. ITestListener.
     */

    /**
     * how to use listeners at class level ?
     *
     * If we want to use listeners at class level we have to declare '@listeners' annotation at class level and need to
     * specify implementation's of Listener Interface.
     *
     *  This '@Listeners' annotation accepts an array of classes that implements the ITestListener or other
     *  Listener in TestNG.
     *
     *  To user listener methods at class level we have to implement all methods in ITestListener interface and
     *  pass implemented class to @Listeners annotation.
     *
     *  What ever code is written in implemented methods of ITestListener that code will be executed at start of test
     *  end of test, on test failure, on test success, etc...
     *
     *
     */

    /**
     * How to use listeners at suite level?
     *
     * To use TestNG listeners at suite level we have to define <listeners></listeners> tag inside the <suite/> tag and
     * have to include class that implement the Listener interface.
     *
     * Example:-
     *
     * <listeners>
     *     <listener name = "package.class name that implement listener interface/>
     * </listeners>
     *
     * If we want to include multiple classes that implement listener interface then we can include them no problem.
     *
     * Advantage of using listeners at suite level is that these listeners behaviours can be used at every test inside the
     * suite.
     *
     */

    /**
     * What is difference between listeners and annotations?
     *
     * Annotations and listeners are all different kind, annotations are 4 types before and after suite, test, method, class.
     * But we have different types of listeners which has unique implementation and purpose, these listeners listen to
     * test and suite and class events and execute appropriate code to the situation, for example if a test fail the OnTestFailure
     * method ni ITestListener implemented class will be executed so on.
     *
     * We have different types of Listeners interfaces.
     * 1.IAnnotationTransformer which uses to modify annotations of test class at run time.
     * 2.IAnnotationTransformer which uses to modify test method annotation at run time.
     * 3.IHookable: which is used to execute particular code before or after method execution. so on...
     *
     * We don't need to implement all different type of interfaces to use all methods in different listener interfaces
     * we can extend 'TestListenerAdapter' class which implements all methods of all listener interfaces just we have to
     * override those methods with our required code.
     */
}
