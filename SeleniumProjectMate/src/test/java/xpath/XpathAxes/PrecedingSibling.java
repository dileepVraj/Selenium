package xpath.XpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class PrecedingSibling extends BaseClass
{
    public static void precedingSiblingFunction()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        WebElement checkbox = driver.findElement(By.xpath
                ("(//td[text()='5000'])[1]/preceding-sibling::td/child::input[@type='checkbox']"));

        highlight(checkbox, "border: 2px solid pink");

        checkbox.click();
    }

    public static void main(String[] args) {
        precedingSiblingFunction();
    }
}
