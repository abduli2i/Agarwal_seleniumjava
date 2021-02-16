package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.commonMethods;

public class Do_Sales_Return {
	
	commonMethods com=new commonMethods();
	
	By sales_No_dropdownselect=By.xpath("//div[@class='x-combo-list-item']"); //sales search filter list
	By salesNo_click=By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-SalesNo']"); //Salesno link select
	By salesno=By.id("salesNoCombo");  //salesNo search filter
	By returniconclick=By.xpath("//img[contains(@src,'/images/Prescribe.png')]");
	By available_quantity=(By.className("x-grid3-cell-inner x-grid3-col-Quantity"));
	By return_quantity=(By.cssSelector("input[id*='ext-comp-']"));
	By click_return=By.xpath("//span[contains(text(),'Return')]");
	
	
	public WebDriver Click_SalesReturn_From_sales_Console(WebDriver driver,String saleNo) throws InterruptedException {
		
		
		WebElement No= driver.findElement(salesno);
		No.sendKeys(saleNo);
		Thread.sleep(3000);
		driver.findElement(sales_No_dropdownselect).click();
		Thread.sleep(5000);
		
		  driver.findElement(returniconclick).click(); 
		  Thread.sleep(2000); 
		  
		  Actions action = new Actions(driver);
		  action.doubleClick(driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-ReturnQuantity']"))).perform();
		  
		  List<WebElement> rows=driver.findElements(available_quantity);
			
			for(int i=0;i<rows.size();i++) {
				
				int increment=i+1;
				String Available_quan=driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increment+"]//div[@class='x-grid3-cell-inner x-grid3-col-ReturnQuantity']")).getText();
				System.out.println(Available_quan);
			
				WebElement quantity=driver.findElement(return_quantity);
				quantity.sendKeys(Available_quan,Keys.ENTER);
			}
		driver.findElement(click_return).click();
		return driver;

	}
}
