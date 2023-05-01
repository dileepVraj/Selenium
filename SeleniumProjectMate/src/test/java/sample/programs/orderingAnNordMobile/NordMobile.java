package sample.programs.orderingAnNordMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NordMobile extends BaseClass
{
    public static void main(String[] args)
    {
        browserInstantiation("chrome");
        driver.navigate().to("https://www.amazon.in/ref=nav_logo");
        WebElement searchTab = findElementById("twotabsearchtextbox");
        searchTab.sendKeys("one plus nord", Keys.ENTER);
        WebElement nordGrey = findElementByXpath("(//span[text()='OnePlus Nord 2T 5G (Gray Shadow, 8GB RAM, 128GB Storage)'])[1]");
        nordGrey.click();
//        driver.manage().timeouts().pageLoadTimeout(7000, TimeUnit.MILLISECONDS);
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for(String e: handles)
        {
            if(!(e.equals(parentWindow)))
            {
               driver.switchTo().window(e);
            }

        }

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath("(//span[text()=' Cart ']/following::input)[1]")).click();

        if(driver.findElement(By.id("continue")).isDisplayed())
        {
            System.out.println("successful");
            driver.quit();
        }



    }
}
