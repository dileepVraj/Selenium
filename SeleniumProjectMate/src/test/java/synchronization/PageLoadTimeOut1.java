package synchronization;

import webDriverMethods.BaseClass;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class PageLoadTimeOut1 extends BaseClass
{
    /*PageLoadTimeOut is a method in Timeouts Interface and implemented in RemoteWebDriver class.
    *
    * Basically all web pages have different time to fully load, it differs from application to application and page
    * to page.
    *
    * The load time mainly depends on internet speed, images, videos and css styles in the page.
    *
    * But according to customer need we have to modify the worst loading time in bad internet speed i.e. what
    * may be the factor, internet speed or images,videos we have to set some standard pageLoadTimeOut to every
    * page according to customer need.
    *
    * default pageLoadTimeOut for selenium is 300,000 milliseconds = 5 minutes, we can set our customized timeOut
    * to our application if needed, if page doesn't loaded in that specified time then our test script will throw
    * TimeOutException. */

    /*In Java, we have a package named java.Time and we have a class in that package called Instant, and we have
    * a method in that class called now(); which returns the current time and date.
    *
    * To find the difference between two time instances we have Duration class in Time package and we have to use
    * between(inclusive time, exclusive time); method, which takes two Instant instances, and returns the time difference
    * between those Instant instances, to get difference in time in seconds and milliSeconds and Minutes we have respective
    * methods in that class.*/

    public static void main(String[] args) throws InterruptedException
    {
//        Instant instantTime = Instant.now();
//        System.out.println(instantTime.toString());
//
//        Instant instantTime1 = Instant.now();
//        System.out.println(instantTime1.toString());
//        Duration duration = Duration.between(instantTime,instantTime1);
//        System.out.println(duration.toSeconds());

        browserInstantiation();// browser instantiation.
        driver.manage().timeouts().pageLoadTimeout(7000, TimeUnit.MILLISECONDS);
        Instant startTime = Instant.now();
        driver.get("https://www.hyrtutorials.com/");
        /*Usually on average this website takes 4-5 seconds to load on decent internet speed.*/
        Instant endTime = Instant.now();
        Duration difference = Duration.between(startTime,endTime);
        System.out.println(difference.toSeconds());
        driver.quit();


    }
}
