package testNG.A_IntroductionTopics;

public class IntroToTestNgXmlFIle
{
    /**
     * What is testNG xml file?
     *
     * TestNG xml file is a configuration file which contains the test execution details, test execution details is
     * nothing but test execution flow like what are test cases needed to be executed, how we want to execute our tests
     * like that.
     * All this information is saved under one configuration file which is nothing but testNG xml file.
     *
     */

    /**
     * What is need of testNG xml?
     *
     * Suppose in our project we have three test classes which each have 3 test methods in them, now my scenario is
     * to run 2nd method in the 3rd test class, 1st method in 2nd test class and 3rd method in first test class.
     *
     * Now we cannot run them in one by one in traditional way(by getting into the classes and running required individual
     * method) so we are going to use the testNG xml configuration file where we can configure all our test methods to
     * execute in particular order and how many times to execute a particular method so on.
     */

    /**
     * How to create testNG xml?
     *
     * we can have any file name to the testNg xml configuration file with extension '.xml' and we can have any number
     * of xml files in the project.
     *
     * We can create testNG xml file in intellij in two different ways.
     * 1. left click on project and select file and give file any name with extension of 'xml'.
     * we have to explicitly write all the tags inside the file, in this approach.
     * 2. We need to install testNG plugin: press 'control' plus 'alt' plus 's' and visit
     * plugins section choose marketplace and search for testng in search results install
     * ' create testng xml ' plugin click on install.
     * After installing 'create testng xml ' plugin to create testng xml we have to left-click
     * on project where we can see create testng xml file option and wait for few seconds
     * the testng xml file will be created under the project.
     *
     * After opening the testNG xml file we will see that code in the file is not aligned
     * properly to do click on code and select reformat code.
     *
     * Inside the xml file we have different types of tags like 'test suite' and inside testSUite we will have the
     * test cases 'tests' inside the tests we will have the 'test steps'.
     *
     * basically we will have test suite and in test suite we will have tests and inside tests we will have test steps
     * (methods in the test class). so to access the test methods we have to access the test classes.
     *
     * Syntax:
     *
     * <suite>
     *     <test>
     *         <classes>
     *             <class>
     *                 <methods>
     *
     *                 </methods>
     *             </class>
     *         </classes>
     *     </test>
     *
     * </suite>
     *
     * if we don't want to include any methods from class and want to run all the methods in side the class then we can
     * simply remove the methods tag.
     */

    /**
     *How to add tests to the testNG xml?
     *
     * Before knowing how to add testes in xml file we have to know about the structure of the testng xml file.
     * In xml file we will have a parent tag called suite with attribute called name we can give appropriate name to it.
     * inside the suite we will have test with different attributes but as of now just know about the name attribute
     * which is name of the test.
     * The test will contain the classes tag and classes tag will contain class tag which has name attribute as of now
     * we have to specify the class name along with the package name like 'package.className'.
     * Note: if we want to run all the methods in the specified class then we can leave the class tag like that and can
     * run the xml file where it executes all the test methods in that class.
     * If we want to specify particular methods to run then we have to use methods tag and it contains the < include
     * tag with attribute name ' method name'.
     * Note: here methods will be executed in this test in the order of methods are specified under the methods tag.
     * suppose we have method1 and method2 in the Test class and i included first method2 and followed by method1 then
     * method2 will be executed first and method1 will be next.
     *
     * Note: we can include multiple methods under methods tag.
     * Note: we can have multiple test's under the suite.
     */

    /**
     * How to execute the tests using the testNG xml?
     *
     * To execute the tests from the testng xml file right-click on the file anc click on the run.
     */
}
