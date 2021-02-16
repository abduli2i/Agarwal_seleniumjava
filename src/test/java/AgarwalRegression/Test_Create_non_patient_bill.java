package AgarwalRegression;




import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Create_Customer_Servicebill;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.Base;
import resources.commonMethods;


	
public class Test_Create_non_patient_bill extends Base{
	@Test
	public void nonpatientbill_creation() throws IOException, InterruptedException {
		
		
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com = new commonMethods();
		com.clickparentMenu(driver, "Billing");
		com.clickchildMenu(driver, "Non Patient Bill");
		Create_Customer_Servicebill nonpat= new Create_Customer_Servicebill();
		nonpat.create_customer_header_info(driver);
		nonpat.create_customer_services(driver);
		com.Click_button(driver, "Record Payment");
		
}

}
