package webDriverMethods;

import org.openqa.selenium.*;

import java.util.List;

public class WebDriverMethods extends BaseClass
{
    public static void get()
    {
        /*This method is on webdriver interface, and it loads a new webpage in current browser window.
         *
         * This is done using an HTTP post operation, and this method is blocked until the load is complete.
         *
         * This will follow redirects issued by either server or meta redirect from within the returned HTML.
         *
         * As we know that meta redirect redirects us to specified webpage after waiting specific amount of time, the
         * actions we write in script are performed on page we redirected to.*/
        driver.get("https://google.com");
    }

    public static String getCurrentUrl()
    {
        /*Get a String representing current URL that the browser is looking at.
        *
        * Returns: the URl of the page currently loaded on the browser.*/
       return driver.getCurrentUrl();
    }

    public static String getTitle()
    {
        /*Gets the Title of current page loaded on the current window.
        * Returns: returns Title of page with stripping leading and trailing spaces if exist returns null if Title
        * not yet set. */

        return driver.getTitle();
    }

    public static List<WebElement> findElements(By by)
    {
        /*Find all webelements in the current page using given mechanism.
        * This method is effected by implicit wait times in force at time of execution.
        * When implicitly waiting, this method will return as soon as there are more than 0 items in the found collection,
        * or will return an empty list if the timeout is reached.
        *
        * Parameters: by the locating mechanism to use.
        * Returns: a list of all webelements or an empty list if nothing matches.
        *  */

        /*Here iam writing a script to return all webelements with anchor tag 'a'*/
        return driver.findElements(by);
    }
    public static void main(String[] args)
    {
        browserInstantiation();
        get();
        System.out.println(getCurrentUrl());
        System.out.println(getTitle());
        System.out.println("number of anchor tags in "+getTitle()+" are "+findElements(By.tagName("a")).size());
        String value = driver.findElement(By.name("btnK")).getAttribute("value");
//        driver.findElement(By.name("q")).sendKeys("Dileep the billionaire");
//        driver.findElement(By.name("q")).submit();
        System.out.println(driver.findElement(By.xpath("//a[text()='Gmail']")).getTagName());
        System.out.println(driver.findElement(By.xpath("//a[text()='Gmail']")).getCssValue("color"));
        /*To know what css properties do a webelement have go through this link:
        https://www.dofactory.com/css/properties#:~:text=A%20CSS%20property%20assign%20a,font%2Dstyle%2C%20and%20transform.*/
        System.out.println(value);
        Point p = driver.findElement(By.xpath("//a[text()='Gmail']")).getLocation();
        System.out.println("x location is "+p.x+" "+p.getX());
        System.out.println("y location is "+p.y+" "+p.getY());
        Dimension d = driver.findElement(By.xpath("//a[text()='Gmail']")).getSize();
        System.out.println("height is "+d.height);
        System.out.println("width is "+d.width);
        Rectangle rectangle = driver.findElement(By.xpath("//a[text()='Gmail']")).getRect();
        System.out.println("height is "+rectangle.height);
        System.out.println("width is "+rectangle.width);
        System.out.println("x is "+rectangle.getX());
        System.out.println("y is "+rectangle.getY());

        driver.quit();
    }
}
