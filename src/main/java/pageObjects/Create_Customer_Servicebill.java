package pageObjects;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;
import resources.commonMethods;


public class Create_Customer_Servicebill {
	
	commonMethods com=new commonMethods();
	
	By customer_name=By.id("customerName");
	By mobile_No=By.id("mobileNo");
	By cus_address=By.id("address");
	By age=By.id("age");
	By service_search=By.id("NON_PATIENT_BILL_GRIDChargeEditor");
	By service_select=By.id("NON_PATIENT_BILL_GRIDChargeListItem");
	
	
	
	
	
	public WebDriver create_customer_header_info(WebDriver driver) throws InterruptedException {
		
		driver.findElement(customer_name).sendKeys("TEST");
		driver.findElement(mobile_No).sendKeys("1234567890");
		driver.findElement(cus_address).sendKeys("CHENNAI");
		com.Select_Dynamic_dropdown(driver,"gender");
		driver.findElement(age).sendKeys("21");
		com.Select_Dynamic_dropdown(driver,"referred");
		com.Select_Dynamic_dropdown(driver,"accUnit");
		
		return driver;
		
	}
	
	
	 public WebDriver create_customer_services(WebDriver driver) throws InterruptedException {
		 
		 ArrayList<String> servicelist = new ArrayList<String>();  //Array initialize
			servicelist.add("BLOOD UREA");
			servicelist.add("Blood Sugar - Fasting (F)");
			System.out.println(servicelist);
			int servicelength=servicelist.size();
			
			for(int i=0; i<servicelist.size(); i++)  // Looping items
			{
				String Servicename=servicelist.get(i);
				com.Select_itemname(driver,Servicename);
				driver.findElement(service_search).sendKeys(Servicename);
				Thread.sleep(2000);
				WebElement servicelist1=driver.findElement(By.xpath("service_select"));
				//Thread.sleep(2000);
				servicelist1.click();
				
				 if (i!=servicelength-1)  //Loop until final row in array
				    {
					 
					 driver.findElement(service_search).sendKeys(Keys.ENTER);
				    }
			}
		 
		 
		 
		return driver;
		 
	 }
	 
	 
		
}
