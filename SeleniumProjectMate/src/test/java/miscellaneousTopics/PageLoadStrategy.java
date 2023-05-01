package miscellaneousTopics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PageLoadStrategy
{
    public static WebDriver driver;

    /*PageLoadStrategy is a strategy used to set particular load time to load the webpage.
    * To set pageLoadStrategy we have to create instance of BrowserSpecific options here iam using chrome browser so
    * im creating ChromeOptions class object and have to call setPageLoadStrategy() method and pass NORMAL/EAGER/NONE
    * enum constants of type PageLoadStrategy.
    *
    * NORMAL:- this type waits until loading of all files images and videos on webpage, by default if we didn't specify
    * any PageLoadStrategy by default strategy is NORMAL only.
    *
    * EAGER: this strategy only waits until loading of DOM and performs operations after Loading of DOM.
    *
    * NONE: this is equivalent to not applying any pageLoadStrategy then default strategy NORMAL will be applied.*/
    public static void browserInstantiation()
    {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NORMAL);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
//        Dimension d = new Dimension(300,1080);
//        driver.manage().window().setSize(d);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
