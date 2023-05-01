package xpath.XpathOperators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class XpathOperators extends BaseClass
{
	// here we are using https://www.hyrtutorials.com/p/add-padding-to-containers.html to find 
	// elements.

	/**
	 * What are xpath operators:
	 *
	 * Xpath operators are used to create expressions that can be used to locate specific elements or attributes within
	 * an XML or HTML document.
	 *
	 * Here are some most commonly used xpath operators:
	 *
	 * 1.path Expressions(/ and //):
	 * The forward slash is used to locate and element in the current node, while the double forward slash is used to
	 * locate an element anywhere in the document.
	 *
	 * 2.Predicates([]): predicates are used to select nodes based on a condition.
	 * They are enclosed in square brackets and can contain comparison operators such as equals(=), not equals(!=),
	 * less than(<), greater than(<) etc...
	 *
	 * 3.Attribute selectors(@): is used to select attributes of an element.
	 * For example, the expression //book@isbn selects the ISBN attribute of all book elements.
	 *
	 * 4.Boolean operators(and ,or, not): Boolean operators are used to combine two or more conditions in an xpath expression.
	 * The and operator is used to select nodes that satisfies both conditions, while the or operator is used to select nodes
	 * that satisfy either condition.
	 * The not operator is used to select nodes that do not satisfy a condition.
	 *
	 * 5.Numeric operators(+,-,div,mod):
	 * Numeric operators are used to perform arithmetic operations on numeric values in xpath expressions.
	 * The plus(+) and minus(-) operators are used to add or subtract values, the asterisk(*) operator multiply values
	 * div operator is used to divide values,and the mod operator is used to calculate the reminder of a division operation.
	 *
	 * Overall xpath operations are essential for navigating and querying XML and HTML documents, and understanding how they work
	 * is key to effectively work with XML data.
	 *
	 */

	/*Among =,!=,<,<=,> and >=
	*
	* = and != can be used on any type of attribute values like text format and numeric format etc...
	* where <,<=,> and > can only used with numeric attribute values.
	*
	* For example in hyr tutorials web application in xpath practice page we have first and last name text box elements
	* or fields where these elements have attributes like max-length which has numeric values like 15,10 etc...
	*
	* If we know or feel that any attribute value is numeric then we don't have to use single quotes('') or double quotes
	* ("") in xpath expression.
	*
	* */



	public static void main(String[] args) 
	{
		//equalsOperator();
		//notEqualsToOperator();
		//greaterThan10();
		//greaterThanOrEqual10();

	}

	public static void equalsOperator() 
	{
		/*In this method we are using equals(=) operator in xpath expression to identify a webelement.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement elements = driver.findElement(By.xpath("//input[@maxlength = '10']"));
		highlight(elements);
	}

	public static void notEqualsToOperator() 
	{
		/*In this method we are using not-equals(!=) operator in xpath expression to identify a webelement.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement elements = driver.findElement(By.xpath("//input[@maxlength != '10']"));
		highlight(elements);
	}

	public static void greaterThan10() 
	{
		/*In this method we are using greater than(>) operator in xpath expression to identify a webelement.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement elements = driver.findElement(By.xpath("//input[@maxlength > '10']"));
		highlight(elements);
	}

	public static void greaterThanOrEqual10() 
	{
		/*In this method we are using greater than or equal(>=) operator in xpath expression to identify a webelement,
		where this expression returns a List of webelements because our xpath expression have identified more than one
		webelement in the html document.*/

		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength >= '10']"));

		for(WebElement element : elements) 
		{
			highlight(element);
		}
	}

	public static void lessThan10() 
	{
		/*In this method we are using less than(<) operator in xpath expression to identify a webelement.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement elements = driver.findElement(By.xpath("//input[@maxlength < '10']"));

		highlight(elements);
	}

	public static void lessThanOrEqual10() 
	{
		/*In this method we are using less than(<=) operator in xpath expression to identify a webelement.
		* where this expression returns a List of webelements because our xpath expression have identified more than one
		webelement in the html document.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength <= '10']"));

		for(WebElement element : elements) 
		{
			highlight(element);
		}
	}




}
