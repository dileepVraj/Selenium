package xpath.XpathFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class StartsWith extends BaseClass
{
    /**
     * we have to use startsWith function to identify a webelement using starting text of value.
     * For example if we have a webelement with tagName a and text sign in into account then we have to write xpath
     * to identify webelement using starts-with function as below.
     *
     * //a[starts-with(text(),'text on webelement')]
     */

    public static void startsWithFunction()
    {
        browserInstantiation("chrome");

        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        // starts-with function to identify element using text().

        WebElement twitter = driver.findElement(By.xpath("//h2[starts-with(text(),'Twitte')]"));
        highlight(twitter,"border: 2px solid red");

        // starts-with function to identify element using starting attribute value.

        WebElement secondName = driver.findElement(By.xpath("//input[starts-with(@name,'name') and starts-with(@maxlength,15)]"));

        highlight(secondName, "border: 2px solid blue; background: yellow");
    }

    public static void main(String[] args)
    {
        startsWithFunction();
    }
}
