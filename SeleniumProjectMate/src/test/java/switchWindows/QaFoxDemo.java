package switchWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QaFoxDemo 
{

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		
		WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
		
		newWindow.sendKeys(Keys.ENTER);
		
		WebElement messageWindow = driver.findElement(By.id("messageWindowButton"));
		
		
		
		String mainWindow = driver.getWindowHandle();
		
		Set<String> handleSet = driver.getWindowHandles();
		
		
		
		Iterator<String> handles = handleSet.iterator();
		
		while(handles.hasNext()) 
		{
			String childWindow = handles.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) 
			{
				
				driver.switchTo().window(childWindow);
				
				WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
				String sampleHedingText = sampleHeading.getText();
				
				System.out.println(sampleHedingText);
				
				driver.close();
				driver.switchTo().window(mainWindow);
			}
			
			
		}
		
		//driver.switchTo().window(mainWindow);
		messageWindow.sendKeys(Keys.ENTER);	
		Set<String> handleSet2 = driver.getWindowHandles();
		Iterator<String> handles2 = handleSet2.iterator();
			
			while(handles2.hasNext()) 
			{
				
				String messageWindowText = handles2.next();
				
				if(!mainWindow.equalsIgnoreCase(messageWindowText)) 
				{
					driver.switchTo().window(messageWindowText);
					
					String messageWindowMessage = driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")).getText();
					
					System.out.println(messageWindowMessage);
					driver.close();
				}
			}
			
			driver.switchTo().window(mainWindow);
			driver.close();
			
			
	}

}
