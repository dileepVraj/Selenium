package xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pratice {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		Thread.sleep(3000);
		driver.get("https://instagram.com");
		driver.getPageSource();
		
	}
	
	

}

interface animal
{
	public void print(); 

}

class dog implements animal
{
	
	public void print() 
	{
		System.out.println("iam dog");
	}
}
