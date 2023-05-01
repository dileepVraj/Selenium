package switchWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyrHandlingSingleWindow
{
	static WebDriver driver;
	public static String getWindowHandles() 
	{
		String childWindow = null;
		Set<String> windowSet = driver.getWindowHandles();
		
		Iterator<String> iterator = windowSet.iterator();
		
		while(iterator.hasNext()) 
		{
			childWindow = iterator.next();
			
		}
		return childWindow;
	}

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> iterator = handles.iterator();
		
		while(iterator.hasNext()) 
		{
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) 
			{
				driver.switchTo().window(childWindow);
				
				driver.findElement(By.id("firstName")).sendKeys("Dileep");
				Thread.sleep(3000);
				
				driver.close();
				driver.switchTo().window(mainWindow);
				driver.findElement(By.id("name")).sendKeys("Raju");
				Thread.sleep(3000);
				driver.close();
			}
		}

	}

}
