package pageObjects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;


public class CheckinPage {
    By referraltype_name=By.name("referralType");  //Referral type select
    By payment_name=By.name("payment");     //Payment dropdown
    By credit_name=By.name("creditTypeList"); //credittype
    By payor_name=By.name("payorType");    //Payor type
    By tpano=By.name("tpaNO");    //TPA TEXT BOX
    By patcreate=By.id("create");   //Create button
    
    
    
    //Old patient checkin
    public WebDriver create_patient_checkin(WebDriver driver) throws InterruptedException {
    	
    	Thread.sleep(2000);
    	RegistrationPage reg=new RegistrationPage();
    	reg.consultant(driver);
    	//Select_paymentmethodtype(driver);
    	Select referraltype = new Select(driver.findElement(referraltype_name));
    	referraltype.selectByValue("Self");
    	reg.charge(driver);
    	reg.pincode(driver);
    	Thread.sleep(3000);
		String Patientid = driver.findElement(By.xpath("//*[starts-with(@id,'patientId')]")).getText();
		System.out.println("Patient successfully checked-in :"+Patientid);
    	return driver;
    }
    
    
//   method for changing payment type
    
    public WebDriver Select_paymentmethodtype(WebDriver driver) {
    	Scanner input=new Scanner(System.in);
    	String payment_type=input.nextLine();
    	System.out.println(payment_type);
    	input.close();
    	if(payment_type=="Credit") {
    		Select payment_method = new Select(driver.findElement(payment_name));
    		payment_method.selectByValue("Credit");
    		
    		if(payment_type=="insurance") {
    			Select credit_type = new Select(driver.findElement(credit_name));
    			credit_type.selectByValue("Credit");
    			Select payor_type = new Select(driver.findElement(payor_name));
    			payor_type.selectByIndex(0);
    			driver.findElement(tpano).sendKeys("123");
    			
    		}
    		
    		else {
    			Select credit_type = new Select(driver.findElement(credit_name));
    			credit_type.selectByValue("Company");
    			Select payor_type = new Select(driver.findElement(payor_name));
    			payor_type.selectByIndex(0);
    		}
    	}
	return driver;
    }
		

}
