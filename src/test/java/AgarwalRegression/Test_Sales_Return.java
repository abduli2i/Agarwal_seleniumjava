package AgarwalRegression;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Do_Sales_Return;
import pageObjects.LoginPage;
import pageObjects.Sales_CreationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Sales_Return extends Base {
	
	@Test
	public void Do_Full_Sales_return() throws IOException, InterruptedException {

		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com = new commonMethods();
		com.clickparentMenu(driver, "Sales");
		com.clickchildMenu(driver, "Sales History Console");
		Do_Sales_Return salreturn= new Do_Sales_Return();
		salreturn.Click_SalesReturn_From_sales_Console(driver, "salNo");
			
		}
}