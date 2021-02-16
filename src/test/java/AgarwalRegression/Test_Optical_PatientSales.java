package AgarwalRegression;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Sales_CreationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Optical_PatientSales extends Base{

	@Test(enabled=true)
	public void create_direct_optical_patsales() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com=new commonMethods();
		com.clickparentMenu(driver, "Sales");
		com.clickchildMenu(driver, "Patient Sales");
		Sales_CreationPage sal=new Sales_CreationPage();
		com.Select_departmentname_dropdown(driver,"departments","OPTICAL");
		sal.create_optical_sales(driver);
		com.Add_discount(driver);
		Thread.sleep(2000);
		com.Click_button(driver,"RECORD PAYMENT");
		//Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Sales No')]")).isDisplayed());
		//String Created_sales_No=driver.findElement(By.id("ticketId")).getText();
		//System.out.println("Patient optical sales created successfully with sales No : "+Created_sales_No);
		
		
		
		com.clickchildMenu(driver, "Sales History Console");
		com.Select_departmentname_dropdown(driver,"departments","OPTICAL");
		sal.create_workorder_delivery(driver,"data");
		com.logout(driver);
	}

}
