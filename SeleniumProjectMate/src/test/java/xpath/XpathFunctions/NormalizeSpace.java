package xpath.XpathFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class NormalizeSpace extends BaseClass
{
    /**
     * If we have white extra spaces in starting or ending of a attribute value then our task is to remove those
     * extra white spaces and identify webelement in this type of scenario we will use normalizeSpace function.
     *
     * Syntax: //tagName[normalize-space(text()='text of element or value of an attribute by removing white spaces')]
     */

    public static void normalizeSpaceFunction()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        WebElement firstNameLabel = driver.findElement(By.xpath("//label[normalize-space(text()='First Name']"));

        highlight(firstNameLabel, "border: 3px solid green");
    }

    public static void main(String[] args) {
        normalizeSpaceFunction();
    }
}
