package pageObjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.commonMethods;

public class Sales_CreationPage {
	
	commonMethods com=new commonMethods();
	
	By cusname=By.id("cusName");        //Customer Name
	By address=By.id("address");        //Address text box
	By quantity=By.cssSelector("input[id*=ext-comp-]");     //Quantity text_box
	By batchpopup=By.xpath("//table[@id='BatchNoList']/tbody");  //Batch popup
	By batchselect=By.xpath("//table[@id='BatchNoList']/tbody/tr[2]");  //Batch popup list
	By salesno=By.id("salesNoCombo");  //salesNo search filter
	By workorderclick=By.xpath("//img[contains(@src,'/newui/images/icons/workorder.jpg')]");   //workorder icon
	By sender=By.cssSelector("select[name='sendTo']");  //Sendername
	By overview=By.xpath("//div[@id='overview']//td[2]//span[1]/img"); //date picker
	By date=By.linkText("30"); // link text
	By ordercreate=By.id("create"); //workorder create button
	By close_menu=By.xpath("//img[contains(@src,'/newui/images/default/layout/expand.gif')]"); //workorder menu close icon
	By rowchecker=By.xpath("//div[@class='x-grid3-row-checker']"); //Row checker 
	By workordersent=By.xpath("//button[contains(text(),'Work Order Sent')]");  //WorkorderSent button
	By finishgoods=By.xpath("//button[contains(text(),'Finished Goods Received')]"); //finished goods button
	By DCNO=By.id("dcNumber");  //Dc textbox
	By updatebutton=By.xpath("//span[contains(text(),'Update')]"); //update button
	By readytodeliver=By.xpath("//button[contains(text(),'Ready To Deliver')]");  //Ready to deliver
	By salesNo_click=By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-SalesNo']"); //Salesno link select
	By Deliver_button=By.xpath("//button[contains(text(),'Deliver')]");  //Deliver button
	// sales_No_dropdownselect=By.xpath("//div[contains(text(),'PRR/OPT/')]");
	By sales_No_dropdownselect=By.xpath("//div[@class='x-combo-list-item']"); //sales search filter list
	By batch_headername=By.xpath("//*[contains(text(),'Current Stock')]");  //Batch no popup header
	
	
	

//Direct Sales header  
	public WebDriver Create_Direct_salesheader(WebDriver driver) throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(cusname));
		driver.findElement(cusname).sendKeys("abdul");
		com.Select_Dynamic_dropdown(driver, "consultants");
		Thread.sleep(2000);
		WebElement address1=driver.findElement(address);
		address1.sendKeys("Testaddress");
		return driver;	
	}
	

//Create pharmacy sales
	
	public WebDriver create_pharmacy_sales(WebDriver driver) throws InterruptedException {
		
		
		ArrayList<String> itemlist = new ArrayList<String>();
		itemlist.add("TABLET CRASHER");
		itemlist.add("TAMFLO 0.4MG CAPS");
		//itemlist.add("TAB ACE TH4");
		itemlist.add("TAB ACEPRINE 8T");
		System.out.println(itemlist);
		int itemlength=itemlist.size();
		System.out.println(itemlength);
		for(int i=0; i<itemlist.size(); i++) 
		{
			
			System.out.println(itemlist.get(i));
			String itemnam=itemlist.get(i);
		//String itemnam="TABLET CRASHER";      for single line item test
			com.Select_itemname(driver,itemnam);
			Handle_batchpopup(driver);
			Thread.sleep(1000);
			driver.findElement(quantity).sendKeys("1");
			
		    if (i!=itemlength-1) 
		    {
		        driver.findElement(quantity).sendKeys(Keys.ENTER);
		    }
		}
		
	return driver;
		
	}
	
	
//Create direct sales
	public WebDriver create_optical_sales(WebDriver driver) throws InterruptedException {
		
		ArrayList<String> itemlist = new ArrayList<String>();
		itemlist.add("HOYA  PRO HOYALUX ID CLASSIC PG 1.60 HVLL");
		itemlist.add("ARCADIO A AST");
		System.out.println(itemlist);
		int itemlength=itemlist.size();
		for(int i=0; i<itemlist.size(); i++) 
		{
			System.out.println(itemlist.get(i));
			String itemnam=itemlist.get(i);
			com.Select_Dynamic_dropdown(driver,itemnam);
			Handle_batchpopup(driver);
			Thread.sleep(1000);
			driver.findElement(quantity).sendKeys("1");
			
		    if (i!=itemlength-1) 
		    {
		        driver.findElement(quantity).sendKeys(Keys.ENTER);
		    }
		}
		
	return driver;
		
	}
	
	
//Workorder create for optical sales	
	public WebDriver create_workorder_delivery(WebDriver driver,String salesNo) throws InterruptedException {
		
		WebElement No= driver.findElement(salesno);
		No.sendKeys(salesNo);
		Thread.sleep(3000);
		driver.findElement(sales_No_dropdownselect).click();
		Thread.sleep(5000);
		
		  driver.findElement(workorderclick).click(); 
		  Thread.sleep(2000); 
		  Select sento= new Select(driver.findElement(sender)); 
		  sento.selectByIndex(0);
		  driver.findElement(overview).click(); 
		  driver.findElement(date).click();
		  driver.findElement(ordercreate).click(); 
		  Thread.sleep(3000);
		  driver.findElement(close_menu).click(); 
		  Thread.sleep(2000);
		  driver.findElement(rowchecker).click();
		  driver.findElement(workordersent).click();
		  Thread.sleep(2000);
		  driver.findElement(rowchecker).click();
		  driver.findElement(finishgoods).click();
		  driver.findElement(DCNO).sendKeys("222");
		  driver.findElement(updatebutton).click(); 
		  Thread.sleep(2000);
		  driver.findElement(rowchecker).click();  
		  Thread.sleep(2000);
		  driver.findElement(readytodeliver).click(); 
		  Thread.sleep(2000);
		 
		driver.findElement(rowchecker).click();
		driver.findElement(salesNo_click).click();
		com.Call_Explicitwait(driver, Deliver_button);
		Thread.sleep(2000);
		com.Click_button(driver,"Deliver");
	return driver;
		
	}
	

//Handling batch popup in sales screen
	
	public WebDriver Handle_batchpopup(WebDriver driver) {	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try 
		{
			int popuptext=driver.findElements(batch_headername).size();
			if(popuptext!=0) 
			{
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(batchpopup)).perform();
				action.moveToElement(driver.findElement(batchselect)).click().perform();
				//Thread.sleep(2000);
			}
		}
		
		catch(Exception e) {
			//System.out.println(e);
			System.out.println("Batch No is not available for the item");
		
			}
	return driver;
	
	}
}

