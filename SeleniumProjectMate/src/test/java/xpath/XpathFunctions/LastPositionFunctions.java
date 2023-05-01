package xpath.XpathFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

import java.util.List;

public class LastPositionFunctions extends BaseClass
{
    /**
     * Even after using all methods like text(), contains(), starts-with(), normalize-space(), if we are not finding
     * unique webelements then we have to use last() and position() functions to find unique webelements in webpage.
     *
     * For example, we have to find last row in web-table, here we have a problem we have don't know what is last index
     * of a row in web-table so to avoid such tricky ness we have to use last() function here.
     *
     * Syntax: (//table[@id='contactList']/tbody/tr)[last()]
     */
    public static void lastFunction()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        WebElement lastElementOfRows = driver.findElement(By.xpath("(//table[@id='contactList']//tbody//tr)[last()]"));
        highlight(lastElementOfRows, "border: 2px solid green");

    }

    /**
     * we can use position() function to find row in a web-table using index, and we can also find row by using <, >,
     * <=, >= operators.
     *
     * syntax: (//table[@id='contactList']/tbody/tr)[position()=2]
     * syntax: (//table[@id='contactList']/tbody/tr)[position()<2]
     * syntax: (//table[@id='contactList']/tbody/tr)[position()<=2]
     * syntax: (//table[@id='contactList']/tbody/tr)[position()>2]
     * syntax: (//table[@id='contactList']/tbody/tr)[position()>=2]
     */

    public static void positionFunction()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement> rows = driver.findElements(By.xpath("(//table[@id='contactList']//tbody//tr)[position()!=2]"));

        for(WebElement eachRow:rows)
        {
            highlight(eachRow, "border:2px solid red");
        }

    }

    public static void main(String[] args)
    {
        lastFunction();
        positionFunction();
    }
}
