package AgarwalRegression;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CheckinPage;
import pageObjects.LoginPage;
import pageObjects.Sales_CreationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Phar_Directsales_with_Discount extends Base{
	
	@Test(enabled=true)
	public void create_phar_directsales() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com=new commonMethods();
		com.clickparentMenu(driver, "Sales");
		com.clickchildMenu(driver, "Direct Sales");
		Thread.sleep(2000);
		Sales_CreationPage sal=new Sales_CreationPage();
		sal.Create_Direct_salesheader(driver);
		com.Select_departmentname_dropdown(driver,"departments","Pharmacy");
		sal.create_pharmacy_sales(driver);
		com.Add_discount(driver);
		Thread.sleep(2000);
		com.Click_button(driver,"RECORD PAYMENT");
		Thread.sleep(5000);
		//Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Sales No')]")).isDisplayed());
		//String Created_sales_No=driver.findElement(By.id("ticketId")).getText();
		//System.out.println("Customer Optical  sales created successfully with sales No : "+Created_sales_No);

		com.logout(driver);
	}
}
