package AgarwalRegression;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Sales_CreationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Phar_Patientsales extends Base{

	@Test(enabled=true)
	public void create_phar_patientsale() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com=new commonMethods();
		com.patientsearch(driver,"2019/KVT/17612");
		Thread.sleep(2000);
		com.clickparentMenu(driver, "Sales");
		com.clickchildMenu(driver, "Patient Sales");
		Sales_CreationPage psal=new Sales_CreationPage();
		com.Select_departmentname_dropdown(driver,"departments","Pharmacy");
		psal.create_pharmacy_sales(driver);
		com.Add_discount(driver);
		com.Click_button(driver,"RECORD PAYMENT");
		//Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Sales No')]")).isDisplayed());
		//String Created_sales_No=driver.findElement(By.id("ticketId")).getText();
		//System.out.println("Patient optical sales created successfully with sales No : "+Created_sales_No);
		com.logout(driver);
	}
}


