package xpath.XpathWithAttributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class XpathUsingAttributes extends BaseClass
{

	public static void main(String[] args) 
	{
		browserInstantiation("chrome");
		driver.get("https://www.w3schools.com/");
		
		WebElement loginbutton = driver.findElement(By.xpath("//a[@id='w3loginbtn']"));
		WebElement searchButton = driver.findElement(By.xpath("//a[@title = 'Search W3Schools']"));
		highlight(loginbutton);
		
		highlight(searchButton);

	}

	/**
	 * If we want to identify all webelements present in html document with specific attribute name then we should write
	 * xpath as follows:
	 *
	 * //tagName[@attributeName]. that's it will fetch all webelements with specified tag and specified attribute name.
	 */

	/**
	 * If we want to identify all anchor tags in body we have to write xpath as follows.
	 * Syntax: //body//a
	 */

}
