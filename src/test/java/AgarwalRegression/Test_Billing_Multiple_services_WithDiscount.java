package AgarwalRegression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Billing_Multiple_services_WithDiscount extends Base {

	@Test(enabled=false)
	public void billingwithdiscount() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods common = new commonMethods();
		common.clickparentMenu(driver, "Reception");
		common.clickchildMenu(driver, "Registration");
		Thread.sleep(2000);
		RegistrationPage regi = new RegistrationPage();
		regi.createRegiistration(driver);
		common.clickparentMenu(driver, "Billing");
		common.clickchildMenu(driver, "Patient Billing");
		common.logout(driver);
	}
}
