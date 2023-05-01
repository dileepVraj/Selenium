package javaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightingElementsUsingJavaScript 
{
	
	
		static WebDriver driver;
		
		
		
		/*here we are writing absolute x-path of exercises element in 'https://www.w3schools.com/'
		 * web application. 
		 * 
		 * absolute x-path:- /html/body/div[3]/a[4]
		 * 
		 * 
		 * */

		public static void main(String[] args) 
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.get("https://www.w3schools.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement exercises = driver.findElement(By.xpath("/html/body/div[3]/a[4]"));
			//WebElement exercises = driver.findElement(By.id("navbtn_exercises"));
			WebElement references = driver.findElement(By.id("navbtn_references"));

			highlight(exercises);
		}
		
		public static void highlight(WebElement element) 
		{
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			// syntax for finding and highlighting element using java script.
			//jsExecutor.executeScript("document.getElementById('navbtn_exercises').setAttribute('style','border:2px solid red;')");
			
			// syntax for finding element using webdriver and highlighting using javaScriptExecutor.
			
			jsExecutor.executeScript("arguments[0].setAttribute('style','border:2px solid red; background: yellow;')",element);
		}
}
