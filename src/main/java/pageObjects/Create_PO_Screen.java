package pageObjects;




import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.commonMethods;



public class Create_PO_Screen {
	//String Po_NUMBER;

	commonMethods com=new commonMethods();
	
	By quantitytextbox = By.cssSelector("input[id*=ext-comp-]");  //Quantity text box
	//By discounttexthover = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-Discount']"); //Discount double click
	By discounttextclick= By.xpath("//div[@class='x-layer x-editor x-small-editor x-grid-editor'][3]/input"); //Discount text box click
	//By PO_save_button= By.xpath("//table[@id='save_po']//td[@class='x-btn-mc']");  //Po save button
	By Purchase_S_No= By.id("PoNO"); // po search No
	By select_GRN_Icon= By.xpath("//img[contains(@src,'/images/Prescribe.png')]");  // GRN icon
	By item_field_doubleclick= By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-ItemName']"); // itemname field double click
	By PO_No_search=By.id("poNoCombo");
	By PO_No_dropdownselect=By.xpath("//div[@class='x-combo-list-item']");

	
	
	
	
	//Create purchase order from po screen 
	public WebDriver Create_PO_items(WebDriver driver) throws InterruptedException {
		
		
		com.Select_departmentname_dropdown(driver,"deptId","Pharmacy");
		com.Select_Dynamic_dropdown(driver,"goodsSupplier");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(item_field_doubleclick)).perform();

		ArrayList<String> itemlist = new ArrayList<String>();  //Array initialize
		itemlist.add("TABLET CRASHER");
		itemlist.add("TAMDURA");
		System.out.println(itemlist);
		int itemlength=itemlist.size();
		
		for(int i=0; i<itemlist.size(); i++)  // Looping items
		{
			int increment=i+1;
			System.out.println(itemlist.get(i));
			String itemnam=itemlist.get(i);
			com.Select_itemname(driver,itemnam);
			Thread.sleep(2000);
			driver.findElement(quantitytextbox).sendKeys("1");
			 Actions action2 = new Actions(driver);
				action2.doubleClick(driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]["+increment+"]//div[@class='x-grid3-cell-inner x-grid3-col-Discount']"))).perform();
				Thread.sleep(2000);
			
			 if (i!=itemlength-1)  //Loop until final row in array
			    {
				 
				 driver.findElement(discounttextclick).sendKeys(Keys.ENTER);
			    }

		}
		

		Thread.sleep(2000);
		com.Click_button(driver, "Save");
		String Po_NUMBER=driver.findElement(Purchase_S_No).getText();   //Get PO No
		System.out.println(Po_NUMBER);
	return driver;
		
	}
	
	
	//Select the GRN from purchase order console
	public WebDriver Select_GRN_From_PO_Console(WebDriver driver,String PONo) throws InterruptedException {
		
		Thread.sleep(2000);
		/*
		 * //WebDriverWait wait = new WebDriverWait(driver,30);
		 * //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[contains(@id,'deptId')]/parent::div/img"))); WebElement
		 * drop=driver.findElement(By.xpath(
		 * "//input[contains(@id,'deptId')]/parent::div/img")); drop.click();
		 * driver.findElement(By.xpath("//div[contains(text(),'Pharmacy')]")).click();
		 */
		com.Select_departmentname_dropdown(driver,"deptId","Pharmacy");
		WebElement No= driver.findElement(PO_No_search);
		No.sendKeys(PONo);
		//String a= Po_NUMBER;
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'"+PONo+"')]")).click();
		//driver.findElement(PO_No_dropdownselect).click();
		Thread.sleep(5000);
	
		//com.Select_Dynamic_dropdown(driver,"poNoCombo");
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(select_GRN_Icon));
		driver.findElement(select_GRN_Icon).click();
		return driver;	
	}
	

}
