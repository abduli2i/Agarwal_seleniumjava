package AgarwalRegression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CheckinPage;
import pageObjects.LoginPage;
import resources.Base;
import resources.commonMethods;

public class Test_OldpatientCheckin extends Base {
	
	@Test(enabled=true)
	public void create_old_patientcheckin() throws IOException, InterruptedException {
		driver=startbrowser();
		LoginPage login=new LoginPage();    //Login
		login.filllogindetails(driver);      //Username and password call
		commonMethods com=new commonMethods();   //create  object name for commonMethod class
		com.patientsearch(driver,"2019/KVT/17610");  //patient search
		com.clickparentMenu(driver, "Reception");
		Thread.sleep(2000);
		com.clickchildMenu(driver, "Check-In Patient");
		CheckinPage check=new CheckinPage();       //create  object name for Checkin class
		check.create_patient_checkin(driver);
		com.Click_button(driver,"Create");
		Assert.assertTrue(driver.findElement(By.id("create_new")).isDisplayed());   //Checking whether testcase is executed successfully
		System.out.println("Patient successfully checkin");
		com.logout(driver);	  //Logout	
	}

}
