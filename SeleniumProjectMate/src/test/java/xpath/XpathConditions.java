package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XpathConditions extends BaseClass
{


	/**
	 *
	 * Xpath conditions:(and ,or, not):operators are used to combine two or more conditions in a xpath expression.
	 * 	 * The and operator is used to select nodes that satisfies both conditions, while the or operator is used to select nodes
	 * 	 * that satisfy either condition.
	 * 	 * The not operator is used to select nodes that do not satisfy a condition.
	 */
	public static void main(String[]args) 
	{
		andCondition();
		orCondition();
	}
	
	public static void andCondition() 
	{
		 /*This method is used ot find element by using conditional operator 'and' in xpath expression in combination of
		 * two attributes.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength=10 and @maxlength=15]"));
		
		System.out.println("Number of elements finded by using and condition are "+elements.size());

		for(WebElement e:elements)
		{
			highlight(e);
		}
		
		quit();
	}
	
	public static void orCondition() 
	{
		/*This method is used ot find element by using conditional operator 'or' in xpath expression in combination of
		 * two or more attributes.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength=10 or @maxlength=15 or @name='name1']"));
		
		System.out.println("Number of elements finded by using or condition are "+elements.size());

		for(WebElement e:elements)
		{
			highlight(e);
		}
		
		quit(); 
	}

	public static void notCondition()
	{
		/*This method is used ot find element by using conditional operator 'not' in xpath expression in combination of
		 * two or more attributes.
		 *
		 * By using not conditional operator in xpath expression we will get all elements in webpage which don't have
		 * attribute that provided inside the parenthesis after not operator.
		 *
		 * To get webelement that should have the specified attribute name but should not match specified attribute value
		 * then we should use '!=' .*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		List<WebElement> elements = driver.findElements(By.xpath("//input[not(@maxlength=10)]"));

		System.out.println("Number of elements finded by using or condition are "+elements.size());

		for(WebElement e:elements)
		{
			highlight(e);
		}

		quit();
	}
}
