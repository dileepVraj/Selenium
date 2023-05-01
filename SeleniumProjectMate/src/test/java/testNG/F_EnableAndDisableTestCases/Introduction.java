package testNG.F_EnableAndDisableTestCases;

public class Introduction
{
    /**
     * In testNG project we will have multiple TestNG.xml files and inside those files we will have multiple tests.
     *
     * Now our scenario is to not execute all the test cases in those xml files we have to execute the selective test
     * cases from those xml files.
     *
     * Let's discuss a scenario where we have to test selected test cases.
     *
     * As part of our project testing we will have multiple releases like, release1, release2 , release3 etc...
     *
     * Under each release we will have multiple sprints if we are following agile project development process in our
     * organisation.
     *
     * Based on test coverage analysis i wanted to execute only few test cases from multiple xml files here comes the
     * testNG enable and disable functionality into the picture.
     *
     * we already know that in xml file we have suite tag and suite will have multiple tests inside it, to disable the
     * test case in suite we have to set value of enabled property of test to false, then when we run the suite this
     * test case won't be executed.
     *
     * Example:
     *
     * <suite name = "sampleSUite>
     *     <test name = "validate user login">
     *         <classes>
     *             <class name = "package.className">
     *                 <methods>
     *                     <include name = "launch the application"/>
     *                     <include name  = "login to application"/>
     *                     <include name = "validate login "/>
     *                 </methods>
     *                 </class>
     *         </classes>
     *         </test>
     *
     *         <test name = "validate user info" enabled = "false">
     *      *         <classes>
     *      *             <class name = "package.className">
     *      *                 <methods>
     *      *                     <include name = "launch the application"/>
     *      *                     <include name  = "login to application"/>
     *      *                     <include name = "validate validate user info "/>
     *      *                 </methods>
     *      *                 </class>
     *      *         </classes>
     *      *         </test>
     *     </suite>
     *
     *
     * In above suite we can see that we set property value of enabled to false in the 'validate user info' test case
     * that means when we run this test suite except this test case all test cases will run, means that we are explicitly
     * skipping this test case.
     */
}
