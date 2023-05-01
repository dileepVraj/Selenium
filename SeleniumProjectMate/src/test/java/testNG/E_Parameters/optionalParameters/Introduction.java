package testNG.E_Parameters.optionalParameters;

public class Introduction
{
    /**
     * let's assume we have a test class which has two test methods where one validates the login verification of OrangeHRM
     * and other method validates the myInfo functionality of the same application.
     *
     * we have method with @BeforeTest which initializes browser by using TestNG Parameters, where we have a switch
     * statement in that method based on the parameter value appropriate browser will be invoked.
     *
     * How?
     * For every test in xml configuration file we will have specified parameter like as below
     * <parameters name = "browserName" value = "chrome"/>
     *
     * based on the value of the browserName the specified browser will be invoked before every test in the xml
     * configuration file.
     *
     * here is a point to catch we have a method in test class which invokes before every test in the xml configuration
     * file if we specified valid parameter then the parameter is passed to the test method and that particular test
     * is run on that specific browser, if we don't specify any browser or don't provide valid value which is part of
     * switch block in the method that invokes before every method then the test will fail, so to avoid this
     * we have to use @Optional() annotation inside the @BeforeTest method parenthesis by passing default value as argument
     * to the @Optional("optional value") as argument where if we didn't pass any valid or don't specify parameters to
     * the test in xml configuration file the test will be executed in the optional browser we specified inside the
     * parenthesis of the @BeforeTest method.
     *
     * Syntax:
     *
     * @Parameters("browserName)
     * @BeforeTest
     * public void initializeBrowser(@Optional("chrome") String browserName)
     * {
     *     switch(browserName.toLowerCase())
     *     {
     *         case "chrome":
     *         WebDriverManager.chromeDriver().setUP();
     *         driver = new ChromeDriver();
     *         break;
     *
     *      case "edge":
     *      WebDriverManager.edgeDriver().setUP();
     *      driver = new EdgeDriver();
     *      break;
     *
     *      case "firefox":
     *      WebDriverManager.firefoxDriver().setUP();
     *      driver = new FirefoxDriver();
     *      break;
     *
     *     }
     * }
     *
     * Note: if we are specifying any parameter or valid parameter value to the test then TestNG will consider that
     * value instead of the optional value passed at the test method in the class.
     */
}
