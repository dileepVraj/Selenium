package xpath.XpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class FollowingSibling extends BaseClass
{
    /**
     * To use any xpath axis to find target element we have to use forward slash(/) after reference element.
     *
     * Syntax: //tagName[condition]/following-sibling::tagName[condition]
     */

    public static void followingSiblingFunction()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        WebElement emailTextBox = driver.findElement(By.xpath
                ("//label[text()='Email']/following-sibling::input[@type='text']"));

        highlight(emailTextBox, "border: 2px solid red");
    }
}
