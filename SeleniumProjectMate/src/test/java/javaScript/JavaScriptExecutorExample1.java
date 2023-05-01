package javaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorExample1 
{
	
	/*
	 * 	To explain the concept of JavascriptExecutor, let’s look at two simple use cases:

	Example 1:-
	
			Problem Statement: Generate an alert window using JavascriptExecutor.

			Objective: Create a login automation script using Selenium that generates an alert window using JavascriptExecutor methods.
			Code:*/
	
	/*To know more about javaScriptExecutor interface and methods in JavaScriptInterface
	 * refer this link - https://www.browserstack.com/guide/javascriptexecutor-in-selenium#:~:text=executeScript%20method%20%E2%80%93%20This%20method%20executes,the%20method%20returns%20a%20WebElement.*/
	
			@Test

			public void login() {	
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			driver.manage().window().maximize();
			driver.get("https://www.browserstack.com/users/sign_in");
			js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
			//js.executeScript("driver.findElement(By.Id('user_email_login').sendKeys('rbc@xyz.com')");
			js.executeScript("document.getElementById('user_password').value='password';");
			js.executeScript("document.getElementById('user_submit').click();");
			js.executeScript("alert('please enter correct login credentials to continue');");
			sleep(2000);
			}

			public static void sleep(int ms)
			{
			try

			{
			Thread.sleep(ms); 
			}
			catch(InterruptedException e)

			{
			e.printStackTrace();
			}

			
			}
				
}
