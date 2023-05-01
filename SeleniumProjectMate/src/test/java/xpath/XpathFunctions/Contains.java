package xpath.XpathFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class Contains extends BaseClass
{
    /**
     * contains function is used to identify webelement using partial text on webelement.
     * For example if we have a webelement with tag 'a and text as sign in into account'.
     *
     * Now to identify webelement using contains function we have to write xpath expression as below.
     * //a[contains(text(),"text on webelement")]
     *
     * explanation: in predicates we have to call contains function by passing text() function and text on webelement
     * as arguments to the contains function.
     */

    /**
     * we can also find webelement by using partial attribute value using contains method.
     *
     * Syntax: //tagName[contains(@attributeName,"partial attribute value")]
     */
    public static void containsFunction()
    {
        // we can use contain method to find element using partial text and partial attribute value as well.

        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        // locating element using partial text.
        WebElement signIntoAccount = driver.findElement(By.xpath("//a[contains(text(),'Sign in into')]"));
        highlight(signIntoAccount,"border: 2px solid orange");

        // locating element using partial value of attribute.

        WebElement praticeXpath = driver.findElement(By.xpath("//h1[contains(@class,'post-title ' )]"));
        highlight(praticeXpath, "border: 3px solid pink");

    }
}
