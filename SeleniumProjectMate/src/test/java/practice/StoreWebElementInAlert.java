package practice;

import xpath.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;

public class StoreWebElementInAlert extends BaseClass
{
    /*No we cannot store a webelement in an alert.
    * this script is created to find can we store a webelement in alert, at last I come to know that we cannot do that.*/
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        browserInstantiation("chrome");
        driver.get("https://the-internet.herokuapp.com/");
        findElementByXpath("//a[text()='JavaScript Alerts']").click();
        findElementByXpath("//button[text()='Click for JS Alert']").click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }
}
