package synchronization;

import xpath.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaits extends BaseClass
{

	public static void main(String[] args)
	{
		/*This is 2nd type of explicit wait mechanism in this waiting mechanism webdriver until specified time
		 * with frequent polling for webelement for every specified time in polling time method.*/

		browserInstantiation("chrome");
		driver.get("https://google.com");
		/*Created a reference variable of type Wait (interface) and assigning object of FluentWait (class)
		 * which takes webdriver instance as constructor argument.
		 *
		 * And calling withTimeOut method which takes maximum waiting time for webelement as argument.
		 * And calling pollingEvery method which takes polling time as argument.
		 * */
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) wait).withTimeout(Duration.ofSeconds(20));
		((FluentWait<WebDriver>) wait).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);


		/*This is lambda expression of apply method in Function interface which returns webelement.*/
		Function<WebDriver , WebElement> function = (driver)->{ return driver.findElement(By.name("q"));};
//
		/*We have to pass function as argument to the until method, where it returns webelement by processing.*/
		WebElement element = wait.until(function);
		element.sendKeys("Billionaire");
		element.submit();

//		Function<Integer,Integer> function1 = (number)->number+number;
//		System.out.println(function1.apply(3));

	}

}
