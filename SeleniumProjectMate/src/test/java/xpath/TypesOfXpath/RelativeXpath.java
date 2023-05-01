package xpath.TypesOfXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;


public class RelativeXpath extends BaseClass {

	/**
	 *
	 * here we are writing relative xpath for same webelement of 'exercises' in w3c application.
	 *
	 * relative xpath : "//a[@id='navbtn_references']".
	 */
	

	public static void main(String[] args) throws InterruptedException 
	{
		
		browserInstantiation("chrome");
		driver.get("https://www.w3schools.com/");
		WebElement references =findElementByXpath("//a[@id='navbtn_references']");
		//quit();
		highlight(references);
		

	}

	/**
	 * we can see that it successfully identified 'exercises' webelement it won't fail in near feature because
	 * we targeted the tag which the webelement is resides on, we won't follow any structure here.
	 */

}
