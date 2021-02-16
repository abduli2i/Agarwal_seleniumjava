package AgarwalRegression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.Base;
import resources.commonMethods;

public class Test_NewPatientRegistration extends Base{

	@Test
	public void newPatientRegistration() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods common = new commonMethods();
		common.clickparentMenu(driver, "Reception");
		common.clickchildMenu(driver, "Registration");
		Thread.sleep(2000);
		RegistrationPage regi = new RegistrationPage();
		regi.createRegiistration(driver);
		Assert.assertTrue(driver.findElement(By.id("create_new")).isDisplayed());
		common.logout(driver);
		
}
}
