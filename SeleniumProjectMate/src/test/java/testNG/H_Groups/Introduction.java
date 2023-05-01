package testNG.H_Groups;

public class Introduction
{
    /**
     * What is grouping and why we need grouping?
     *
     * Grouping is categorization of test methods as one set.
     *
     * for example, we have 100 tests we want to categorize these 100 tests as some as smoke test and some as regression
     * and some as functional tests and daily build.
     *
     * As part of smoke tests we are going to put high level or main components of functionality of applications tests
     * in that group.
     * This smoke test will ensure is our build stable or not before we are going to further testing like integration
     * and functional testing etc...
     *
     * we may also have some tests for windows based and for mackintosh based systems.
     *
     * those 100 test cases are belong to different types of groups like stated above.
     *
     * suppose in 100 tests we have 10 tests for smoke group, 90 for functional group, 95 for regression group,
     * 50 for daily build, 100 for weekly build group and 50 for operating system group.
     *
     * we can run these groups individually by creating separate xml configuration files and include these groups tests
     * in them, this approach consumes lot time and effort.
     *
     * Instead, creating multiple testng.xml files for each group of tests we can use grouping concept in testNG, in this
     * approach we will group multiple tests into multiple groups like, smoke group, regression groups etc...
     */

    /**
     * Note: we cannot run tests in groups using ide we can run those groups(tests in groups) using testNG.xml file only.
     *
     */

    /**
     * How to define grouping?
     *
     * We define grouping of test methods by passing an parameter called 'groups' to the @Test annotation, and we have
     * to pass values to the groups parameter using an array because a single test method can be part of multiple groups.
     *
     *
     */

    /**
     * Types of groups and how to use them?
     *
     * Basically We can specify these groups at suite and test level in xml configuration file.
     *
     * To specify groups at test level we have to add <groups></groups> tag under the test and we have to add
     * <run></run> tag under <groups></groups> tag, we have to include what groups we want to run as part of classes
     * included in this test using <include></include> tag.
     *
     * Syntax:
     *
     * <test name = "sampleGroupingTest>
     *     <groups>
     *         <run>
     *             <include name = "smoke"/>
     *             <include name = "regression"/>
     *         </run>
     *     </groups>
     *     <classes>
     *         <class name = "package.className"/>
     *         <class name = "package1.className1"/>
     *     </classes>
     *     </test>
     */

    /**
     * Types of groups.
     *
     * basically we have 4 types of groups.
     * 1.Test groups( groups they are defined under the test of testNG.xml file ).
     * The test groups can have meta groups, partial groups, exclusive groups etc...
     * The scope of test groups is only for test in which they are defined.
     *
     *
     * 2.Exclusion groups(If we want to exclude any groups particularly that is called exclusion groups).
     *
     * For example, we have test methods in a class which is only part of sanity group and also part of sanity and
     * regression groups, then if we exclude regression using exclude groups then those test methods which are part
     * of sanity and regression groups will be excluded and only test methods part of sanity group will be included in run.
     *
     * Code snippet:
     * <groups>
     *     <run>
     *         <include name = "sanity"/>
     *         <exclude name = "regression"/>
     *     </run>
     * </groups>
     *
     * 3.Meta groups(groups of groups).
     *
     * If we want to create meta groups(groups of groups) we need to use testNG.xml file.
     * To define meta groups we need to use <define></define> tag and pass parameter name and value is name of this
     * meta groups and, we should include the groups using <include> </include> tag in it.
     *
     * code snippet:
     * <groups>
     *     <define name = "dailyBuild">
     *         <include name = "smoke"/>
     *         <include name = "regression"/>
     *     </define>
     *
     *     <define name = "weeklyGroups">
     *         <include name = "smoke"/>
     *         <include name = "regression"/>
     *         <include name = "sanity"/>
     *         <include name = "functionality"/>
     *         </define>
     *
     *         <run>
     *             <include name = "dailyBuild"/>
     *             <include name = "weeklyBuild"/>
     *         </run>
     * </groups>
     *
     * Now to run these meta groups(dailyBuild,weeklyBuild) we have to include these groups inside the <run></run>
     * tag of <groups></groups> tag.
     *
     * 4.partial groups:
     * If we define any group tag at the class level then we will call that as a partial group.
     *
     * Code snippet:
     *
     * @Test(groups= {"all"})
     * public class groupsSample
     * {
     * // multiple methods in the class, which are part of different groups.
     *
     * }
     *
     */

    /**
     * How to execute the groups at suite level?
     *
     *We have to define the groups at suite level to execute those groups.
     *
     * Code snippet:
     *
     * <suite name = "groupsSuite>
     *     <groups>
     *         <run>
     *             <include name = "sanity"/>
     *         </run>
     *     </groups>
     *     <test name = "test1>
     *         <groups>
     *             <run>
     *                 <include name = "smoke"/>
     *                 <exclude name = "regression"/>
     *             </run>
     *         </groups>
     *         <classes>
     *             <class name = "sampleClass"/>
     *         </classes>
     *         </test>
     *     </suite>
     *
     *     Point to be noted:
     *     the groups defined at suite level will be applicable to all the tests in the suite.
     *     means if we have two tests which has each class in them and those classes has different methods belongs to
     *     different groups.
     *     if I defined a group at suite level which includes all the methods part of sanity group then along with the
     *     groups inside the tests this sanity methods will also execute sanity methods in those classes of both tests.
     *
     *     Point to be noted:
     *
     *     If we excluded a group at suite level and, included same suite at test level then methods part of those
     *     group excluded at suite level will not be executed even because suite level groups has more precedence than
     *     test level groups.
     */

    /**
     * How to execute the groups at suite + test level?
     *
     * If we want to execute methods of a particular groups to all tests then we have to specify them at suite level,
     * if we want to run groups they are specific to tests then we have to define them at test level.
     *
     */

    /**
     * How to use regular expressions?
     *
     * If we want to execute methods which are part of some groups which have some common prefix name like
     * windows.regression, windows.sanity, windows.smoke, windows.functionality etc..
     *
     * If we want to execute all these methods part of those groups we can use regular expression '*' instead of suffix
     * name that has been changing.
     *
     * cod snippet:
     *
     * <groups>
     *     <run>
     *         <include name = "windows.*"/> // this will run all the test methods part of windows suffix groups.
     *     </run>
     * </groups>
     */
}
