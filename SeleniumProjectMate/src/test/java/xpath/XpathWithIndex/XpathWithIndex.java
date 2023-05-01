package xpath.XpathWithIndex;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xpath.BaseClass;

public class XpathWithIndex extends BaseClass
{

	/**
	 * we prefer index with xpath expression to find webelement is because in some situations we may can't find
	 * webelement uniquely only with attributes.
	 *
	 * Basically we use index with xpath expression only after not finding elements with all combinations of xpath expressions.
	 *
	 */

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//xpathToFindcellInParticularRow();
		
		//highlightAllCellsInTable();
		
		highlightParticularCell();
	}
	/*This ' xpathToFindCellInParticularRow ' method is to locate particular cell in particular
	 * row.
	 * */
	public static void xpathToFindCellInParticularRow()
	{
		/*This method is to highlight particular cell in particular row in html web table.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		/*Iam writing xpath to find element in 1st row 2nd column*/
		WebElement element = driver.findElement(By.xpath("//table[@id='contactList']//tbody//tr[2]//td[3]"));
		highlight(element);
	}
	

	public static void highlightAllCellsInTable() 
	{
		/*This method is to locate all cells in table one by one and highlight them.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='contactList']//tbody//tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='contactList']//tbody//tr[2]//td"));
		
		int numberOfRows = rows.size();
		int numberOfColumns = columns.size();
		for(int i = 2; i<= numberOfRows; i++) 
		{
			for(int j = 1; j<=numberOfColumns; j++) 
			{
				highlight(driver.findElement(By.xpath("//table[@id='contactList']//tbody//tr["+i+"]//td["+j+"]")));
			}
		}
	}
	
	
	/*This method is to find all cells in table and locate particular required cell in them*/
	public static void highlightParticularCell() 
	{
		/*This method will take index of cell from user and highlights particular cell in web table.*/
		browserInstantiation("chrome");
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		List<WebElement> allElements = driver.findElements(By.xpath("//table[@id='contactList']//tbody//tr//td"));
		System.out.println("Number Of Cells In Table Are "+allElements.size());
		System.out.println("Enter any number greater than 0 and less than or equal "+allElements.size());
		int cellNumber = scanner.nextInt();
		WebElement element = driver.findElement(By.xpath("(//table[@id='contactList']//tbody//tr//td)["+cellNumber+"]"));
		highlight(element);
	}

}
