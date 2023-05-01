package xpath.XpathFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class Text extends BaseClass
{
    /**
     * we use text function to identify elements that contains text with in them.
     * text function helps us to identify webelements by using text on them or in them.
     *
     * Syntax: //tagName[text()='text of webelement']
     */

    public static void textFunction()
    {
        /*This function identifies sign in anchor tag on hyr tutorials webpage using text on that element.*/
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        WebElement signButton = driver.findElement(By.xpath("//a[text()='Sign in']"));

        highlight(signButton,"border: 2px solid blue");

    }

    public static void main(String[] args)
    {
        textFunction();
    }
}
