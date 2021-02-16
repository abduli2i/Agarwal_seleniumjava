package AgarwalRegression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Create_Customer_Servicebill;
import pageObjects.Create_PO_Screen;
import pageObjects.Do_GRN_Return;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Grn_Return extends Base {
	@Test
	public void Return_GRN() throws IOException, InterruptedException {
		
		
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com = new commonMethods();
		com.clickparentMenu(driver, "Purchase");
		com.clickchildMenu(driver, "GRN Management Console"); 
		Do_GRN_Return grnreturn=new Do_GRN_Return();
		grnreturn.Click_GRNReturn_From_GRN_Console(driver, "GRNNO");
		grnreturn.Return_grn_quantity(driver);
}
}