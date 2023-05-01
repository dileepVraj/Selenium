package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import xpath.BaseClass;

public class ExplicitWaits extends BaseClass
{
	/*Explicit wait can be used in two ways by using Explicit wait mechanism and WebDriver wait.
	 * 
	 * It generally used with single elements.
	 *
	 * Explicitly waits are two types fluent wait and WebDriver wait*/
	
	public static void main(String[] args)
	{
		browserInstantiation("chrome");
		driver.get("https://google.com");


		/*This is webdriver wait where webdriver wait constructor takes two parameters, 1.driver instance,2.number
		* of seconds to be waited for webelement before throwing an exception.
		*
		* after we have to call until method on webdriver instance where it takes static method as parameter from
		* ExpectedConditions class where we have to give locator of webelement we are looking for that method of
		* ExpectedConditions class.
		*
		* This until method returns a value apart from null and false before given time expires, if given time
		* expires it throws un-ignored exception.
		*
		* In below case it returning a webelement we are storing it and using for further operations.
		*
		* By default, polling time for webdriver wait and implicit wait is 500 ms.*/

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

		WebElement googleSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		googleSearch.sendKeys("billionaire");
		googleSearch.submit();
				
		
	}
	
	
}
