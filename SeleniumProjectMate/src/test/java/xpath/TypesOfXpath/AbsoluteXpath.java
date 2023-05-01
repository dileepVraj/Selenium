package xpath.TypesOfXpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbsoluteXpath 
{
	static WebDriver driver;
	
	
	
	/*Here we are writing absolute x-path of exercises element in 'https://www.w3schools.com/'
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

	// this method is to highlight the webelement that passed as argument to it.
	public static void highlight(WebElement element) 
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:2px solid red; background: yellow;')",element);
	}

	/**
	 * The demerits of absolute xpath is we have to address all tags in between from root tag to required element using
	 * indexes if in future any webelement is injected in between then we will cannot locate previous element using this
	 * xpath it will locate another webelement present in that particular index.
	 *
	 * So absolute xpath is not recommended to use in automation.
	 */

}
