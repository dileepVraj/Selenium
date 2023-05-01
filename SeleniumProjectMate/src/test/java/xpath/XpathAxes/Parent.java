package xpath.XpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class Parent extends BaseClass
{
    public static void parentFunction()
    {
        browserInstantiation("chrome");
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        WebElement row = driver.findElement(By.xpath("//td[text()='UK']/parent::tr"));

        highlight(row, "border: 2px solid pink");

    }

    public static void main(String[] args) {
        parentFunction();
    }
}
