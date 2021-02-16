package pageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.commonMethods;

public class Do_GRN_Return {
	commonMethods com=new commonMethods();
	
	By GRN_return_icon=By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-GRNReturn']//following::img[1]");
	By GRN_No_search=By.id("poNoCombo");
	By PO_No_dropdownselect=By.xpath("//div[@class='x-combo-list-item']");
	By available_stock=By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-AvailableStock']");
	By double_click_returntext=By.xpath("x-grid3-cell-inner x-grid3-col-ReturnQuantity");
	By return_quantity=By.cssSelector("div[class='x-layer x-editor x-small-editor x-grid-editor'] input");
	By reason_text=By.id("GOODS_RETURN_GRIDReasonTrigger");
	By reason_list=By.xpath("//div[@id='GOODS_RETURN_GRIDReasonListItem'][1]");
	By click_return=By.xpath("//span[contains(text(),'Return')]");
	
	
	public WebDriver Click_GRNReturn_From_GRN_Console(WebDriver driver,String PONo) throws InterruptedException {
		
		Thread.sleep(2000);

		com.Select_departmentname_dropdown(driver,"deptId","Pharmacy");
		WebElement No= driver.findElement(GRN_No_search);
		No.sendKeys(PONo);
		//String a= Po_NUMBER;
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'"+PONo+"')]")).click();
		//driver.findElement(PO_No_dropdownselect).click();
		Thread.sleep(5000);
	
		//com.Select_Dynamic_dropdown(driver,"poNoCombo");
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(GRN_return_icon));
		driver.findElement(GRN_return_icon).click();
		return driver;	
	}

	public WebDriver Return_grn_quantity(WebDriver driver) throws InterruptedException {
		
		
		List<WebElement> rows=driver.findElements(available_stock);
		
		for(int i=0;i<rows.size();i++) {
			
		int increment=i+1;
		String Available_quan=driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increment+"]//div[@class='x-grid3-cell-inner x-grid3-col-AvailableStock']")).getText();
		System.out.println(Available_quan);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increment+"]//div[@class='x-grid3-cell-inner x-grid3-col-ReturnQuantity']"))).perform();
		WebElement quantity=driver.findElement(return_quantity);
		quantity.sendKeys(Available_quan,Keys.TAB);
		driver.findElement(reason_text).sendKeys("a");
		driver.findElement(reason_list).click();
		}
		
		driver.findElement(click_return).click();
		return driver;
		
		
		
	}
	
	
	

}
