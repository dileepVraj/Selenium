package alertsAndNotifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import xpath.BaseClass;

import java.time.Duration;
import java.util.function.Function;

public class BootStrapModalDialogs extends BaseClass
{

    /*BootStrapModal dialogs are look like javaScript alerts, but they are not, we can inspect modal dialog boxes
    * where we cannot inspect alerts.
    *
    * in this section we are going to automate forum type dialog box where itself contains some fields like text boxes
    * etc...
    *
    * we also have some normal dialog boxes which displays some messages.
    *
    * Source:https://automatenow.io/sandbox-automation-testing-practice-website/modals/ */
    public static void main(String[] args) {

        browserInstantiation("chrome");
        driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/modals/");
        findElementById("formModal").click();
        findElementById("g1051-name").sendKeys("Tom");
        findElementById("g1051-email").sendKeys("Hanks@gmail.com");
        findElementById("contact-form-comment-g1051-message").sendKeys("Thank you for the opportunity");
        findElementByXpath("//p//button[text()='Submit']").click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15l,500l));
        Function<WebDriver, WebElement> function = (driver)->{return driver.findElement(By.xpath("//div/h1[text()='Modals']"));};
        wait.until(function);
        System.out.println("successful");
        driver.close();


    }
}
