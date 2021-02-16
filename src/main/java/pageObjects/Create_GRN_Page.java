package pageObjects;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Create_GRN_Page extends Create_PO_Screen {

	

		By billedquantity_doubleclick=By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-BilledQuantity']");  //Billed quantity double click
		By GRN_quantity=By.xpath("//input[@id='GRN_GRIDItemNameEditor']//following::input[1]");  //Billed quantity text box
		By batchNo_doubleclick=By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-BatchNo']"); //Batch double click
		By Enter_batchNo=By.xpath("//input[@id='GRN_GRIDItemNameEditor']//following::input[2]");  //Batch textbox
		By click_expirydate=By.xpath("//div[@class='x-form-field-wrap x-form-field-trigger-wrap x-trigger-wrap-focus']//img"); //Date picker image
		By click_next_month=By.xpath("//td[@class='x-date-right']//a");
		By select_expirydate=By.xpath("//span[contains(text(),'30')]"); //Select date
		By Move_nextrow_discount=By.xpath("//input[@id='GRN_GRIDItemNameEditor']//following::input[5]");  //Discount textbox to move next row
		By grandtotal=By.id("grantTotal");  //Grandtotal value
		By invoice_No=By.id("invoiceNo");  //Invoice text box
		By invoicevalue=By.id("invoiceValue"); //Invoice value  textbox
		By save_GRN=By.xpath("//table[@id='save_grn']//td[@class='x-btn-mc']");  //Save GRN Button
		By row_checker=By.xpath("//div[contains(@class,'x-grid3-row-checker')]");
		By batch_po_grn= By.xpath("//div[@class='x-layer x-editor x-small-editor x-grid-editor'][2]/input");
		By grnquantity=By.xpath("//div[@class='x-layer x-editor x-small-editor x-grid-editor'][1]/input");
		
	
		
		
	//Create direct grn from goods received note
	public WebDriver Create_Direct_GRN(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		com.Select_departmentname_dropdown(driver,"deptId","Pharmacy");
		com.Select_Dynamic_dropdown(driver,"goodsSupplier");
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		action1.doubleClick(driver.findElement(item_field_doubleclick)).perform();
		
		ArrayList<String> itemlist = new ArrayList<String>(); //Array intialize
		itemlist.add("TABLET CRASHER");
		itemlist.add("T-BACT OINTMENT 5G");
		//itemlist.add("TAMDURA");
		System.out.println(itemlist);
		int itemlength=itemlist.size();
		System.out.println(itemlength);
		
		for(int i=0; i<itemlist.size(); i++)  //Looping items
		{
		System.out.println(itemlist.get(i));
		String itemnam=itemlist.get(i);
		//String itemnam="TABLET CRASHER";      //for single line item test
		com.Select_itemname(driver,itemnam);
		int increment=i+1;
		System.out.println(increment);
		Thread.sleep(1000);
		Action_To_Double_click(driver,"BilledQuantity", increment);
		Thread.sleep(1000);
		driver.findElement(GRN_quantity).sendKeys("2");
		
			try {
				//WebElement batch=driver.findElement(batchNo_doubleclick);
				
			//if(batch.size()<=0) {
			
			Action_To_Double_click(driver,"BatchNo", increment); 
			driver.findElement(Enter_batchNo).sendKeys("333",Keys.ENTER);
			driver.findElement(click_expirydate).click();
			Thread.sleep(1000);
			WebElement next_month=driver.findElement(click_next_month);
			next_month.click();
			next_month.click();
			next_month.click();
			Thread.sleep(1000);
			driver.findElement(select_expirydate).click();
			}
	
			catch(Exception e) {
				System.out.println("Batch no not required");
			}
		
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		action2.doubleClick(driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increment+"]//div[@class='x-grid3-cell-inner x-grid3-col-Discount']"))).perform();
		Thread.sleep(2000);
			if (i!=itemlength-1) 
			{
				driver.findElement(Move_nextrow_discount).sendKeys(Keys.ENTER);
			}
		}
		
		Get_total_invoice(driver);	
		return driver;
	}
	

	
	
	//Method for double click on the fields
	public WebDriver Action_To_Double_click(WebDriver driver,String datalocator,int increment) {
		
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increment+"]//div[contains(@class,'"+datalocator+"')]"))).perform();
		return driver;
		
	}
	
	public WebDriver Create_GRN_from_PO(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		int rowchecker=driver.findElements(row_checker).size();
		System.out.println(rowchecker);
		
		for(int i=0; i<=rowchecker-1; i++)  //Looping items
		{
		int increment=i+1;
		System.out.println(increment);
		Thread.sleep(1000);
		//Action_To_Double_click(driver,"BilledQuantity", increment);
		Thread.sleep(1000);
		//driver.findElement(grnquantity).sendKeys("2");
		
			try {
				//WebElement batch=driver.findElement(batchNo_doubleclick);
				//if(batch.isEnabled())
			
			Action_To_Double_click(driver,"BatchNo", increment); 
			driver.findElement(batch_po_grn).sendKeys("333",Keys.ENTER);
			driver.findElement(click_expirydate).click();
			Thread.sleep(1000);
			driver.findElement(select_expirydate).click();
			}
		
			catch(Exception e) {
				System.out.println("Batch no not required");
			}
		}
		
		Thread.sleep(1000);
		Get_total_invoice(driver);
		
		return driver;
		
	}
	
	
	
	public WebDriver Get_total_invoice(WebDriver driver) throws InterruptedException {
		String total=driver.findElement(grandtotal).getText();
		System.out.println(total);
		Float floatVal = Float.valueOf(total).floatValue();
		System.out.println(floatVal);
		int invoice=(Math.round(floatVal));
		String invoiceamount=String.valueOf(invoice);
		System.out.println(invoice);
		driver.findElement(invoice_No).sendKeys(invoiceamount);
		Thread.sleep(2000);
		driver.findElement(invoicevalue).sendKeys(invoiceamount);
		com.Click_button(driver,"Save GRN");
		//driver.findElement(save_GRN).click();
		return driver;
	}
	
	
	
}


//public boolean isreadOnly(element) {        
//Boolean readOnly = false;       
//readOnly = ((element.getAttribute("disabled") != null) || (element.getAttribute("readonly") != null));  
// return readOnly;        
//}


//WebElement rowcount=driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increm+"]//following::td[2]"));
//System.out.println(rowcount);



	

////div[contains(@class,'x-grid3-row-checker')]




