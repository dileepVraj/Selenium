package javaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptexecuteAsyncScriptMethod 
{

	/*This method executes the asynchronous piece of JavaScript on the current window or frame. 
	 * An asynchronous script will be executed while the rest of the page continues parsing,
	 *  which enhances responsiveness and application performance.*/
	
	@Test
	public void login() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.manage().window().maximize();
	driver.get("https://www.browserstack.com");
	js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
	} 
	}

