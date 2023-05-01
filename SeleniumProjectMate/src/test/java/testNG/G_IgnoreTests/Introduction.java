package testNG.G_IgnoreTests;

public class Introduction
{

    /**
     * We use the Ignore concept to specifically Ignore the test methods in the class or a package.
     */

    /**
     * Point:
     * we can also use enabled attribute in the testNG class with methods as below.
     *
     * @Test(enabled="false")
     * public void signUp()
     * {
     *      // code
     * }
     */
    /**
     * How to ignore the specific selected test methods?
     *
     * If we want to ignore any test method specifically then we need to add ignore annotation at the method level.
     *
     * Example:
     *
     * @Ignore
     * @Test
     * public void login()
     * {
     *      // code
     * }
     *
     * if we have a method with test parameter enabled = "true" and @Ignore tag then this method will not be executed
     * because the @Ignore will have the highest precedence.
     */

    /**
     * How to ignore all the test methods in the testNG class?
     *
     *If we want to ignore all the methods in a test class then we have to pass @Ignore annotation to the test class.
     *
     * Ex:
     *
     * @Ignore
     * public loginFunctionality
     * {
     * @Test
     * public void method(){}
     *
     * @Test
     * public void method1(){}
     *
     * @Test
     * public void method2(){}
     *
     * @Test
     * public void method3(){}
     * }
     *
     * If we include this class in configuration file and run through it even then the methods inside this class won't
     * run.
     *
     * We can have multiple classes with @Ignore tag.
     */

    /**
     * How to ignore all the test methods inside a package?
     *
     * We know that a package contains multiple classes and those classes contains multiple methods and properties/
     * variables with in them.
     *
     * To ignore all the methods in a package we have to use the @Ignore tag at the package level but how?
     *
     * To do that we have to create another java file called ' package-info.java', we need to create this package-info.java
     * inside package where we want to ignore all methods in that package classes.
     *
     *To do that in intellij ide we have to right-click on the package where we want to create that 'package-info.java'
     * file and select 'package-info.java' it creates the file with the entry of current package.
     *
     * On top of that we have to add @Ignore annotation to disable or ignore all test methods in a specific package.
     *
     */
}
