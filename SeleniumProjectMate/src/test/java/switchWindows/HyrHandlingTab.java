package switchWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HyrHandlingTab 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.id("newTabBtn")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> iterator = handles.iterator();
		
		while(iterator.hasNext()) 
		{
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) 
			{
				driver.switchTo().window(childWindow);
				
				driver.findElement(By.xpath("//button[@id='alertBox']")).click();
				driver.switchTo().alert().accept();
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
