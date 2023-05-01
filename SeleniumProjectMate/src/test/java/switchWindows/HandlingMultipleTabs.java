package switchWindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleTabs 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.id("newTabsBtn")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		List<String> lHandles = new ArrayList<String>(handles);
		
		if(switchToHandle("Basic Controls", lHandles)) 
		{
			driver.findElement(By.id("email")).sendKeys("ananthvraju44@gmail.com");
			driver.switchTo().window(mainWindow);
		}
		closeTabs(mainWindow, lHandles);

	}
	/*
	 * this method is to switch required windowHandle by using partial page title, it returns
	 * true if required window found and driver has switched to particular window or else it returns
	 * false*/
	public static boolean switchToHandle(String title, List<String> list) 
	{
		for(String e:list) 
		{
			driver.switchTo().window(e);
			String pageTitle = driver.getTitle();
			
			if(pageTitle.contains(title)) 
			{
				driver.switchTo().window(e);
				return true;
			}
		}
		
		return false;
	}
	/*this method is used to close all windows or tabs except main window/tab */
	public static void closeTabs(String mainWindow, List<String> list)
	{
		for(String e: list) 
		{
			if(!e.equalsIgnoreCase(mainWindow))
			{
				driver.switchTo().window(e);
				driver.close();
			}
		}
	}

}
