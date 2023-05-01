package switchWindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HyrHandlingMultipleWindows 
{
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		List<String> lHandles = new ArrayList<String>(handles);
		
		/*
		 * if(switchToTargetWindow("  ", lHandles)) {
		 * driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("Dileep");
		 * Thread.sleep(2000); driver.close(); driver.switchTo().window(mainWindow); }
		 */
		
		if(switchToTargetWindow("Basic Controls", lHandles)) 
		{
			driver.findElement(By.id("femalerb")).click();
			Thread.sleep(2000);
			
		}
		
		closeChildWindows(mainWindow, lHandles);
		
	}
	
	
	
	public static boolean switchToTargetWindow(String title, List<String> list) 
	{
		for(String e:list) 
		{
			String pageTitle = driver.switchTo().window(e).getTitle();
			
			if(pageTitle.contains(title)) 
			{
				driver.switchTo().window(e);
				System.out.println("Success");
				return true;
			}
			
			
		}
		return false;
	}
	
	public static void closeChildWindows(String mainWindow, List<String> list) 
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
