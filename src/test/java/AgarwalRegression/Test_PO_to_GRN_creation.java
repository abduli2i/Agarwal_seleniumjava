package AgarwalRegression;


import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Create_GRN_Page;
import pageObjects.Create_PO_Screen;
import pageObjects.LoginPage;
import resources.Base;
import resources.commonMethods;

//Test_Purchase_Order_Creation

public class Test_PO_to_GRN_creation extends Base {
	
	
	@Test
	public void Select_GRN_from_PO() throws IOException, InterruptedException {
	
	driver = startbrowser();
	LoginPage login = new LoginPage();
	login.filllogindetails(driver);
	commonMethods com=new commonMethods();
	com.clickparentMenu(driver, "Purchase");
	com.clickchildMenu(driver, "Purchase Order");
	Create_PO_Screen po=new Create_PO_Screen();
	po.Create_PO_items(driver);
	Thread.sleep(1000);
	Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'PO No')]")).isDisplayed());
	String Created_Po_No=driver.findElement(By.id("PoNO")).getText();
	System.out.println("Po created successfully : "+Created_Po_No);
	
	//com.clickparentMenu(driver, "Purchase");
	Thread.sleep(2000);
	com.clickchildMenu(driver, "Purchase Order Console");
	Thread.sleep(2000);
	po.Select_GRN_From_PO_Console(driver,Created_Po_No);
	Create_GRN_Page grn=new Create_GRN_Page();
	grn.Create_GRN_from_PO(driver);
	Thread.sleep(4000);
	Set<String> windowHandles = driver.getWindowHandles();
	if (!windowHandles.isEmpty()) {
	    driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
	    driver.close();
	}
	
	Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'GRN No')]")).isDisplayed());
	String Created_Grn_No=driver.findElement(By.id("ticketId")).getText();
	System.out.println("Grn created successfully : "+Created_Grn_No);
	 
	
	
	}
}
