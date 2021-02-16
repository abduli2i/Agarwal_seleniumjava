package AgarwalRegression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Create_PO_Screen;
import pageObjects.LoginPage;
import resources.Base;
import resources.commonMethods;
import java.io.IOException;

public class Test_Purchase_Order_Creation extends Base {
	
	
	@Test
	public void Create_PurchaseOrderitems() throws IOException, InterruptedException {
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
		
		com.logout(driver);
		//com.clickparentMenu(driver, "Purchase Order Console");
		
		
	}
	
	

}
