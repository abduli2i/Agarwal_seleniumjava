package AgarwalRegression;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Sales_CreationPage;
import resources.Base;
import resources.commonMethods;

public class Test_Sales_History_Console extends Base{

		@Test(enabled=true)
		public void select_sales_SalesHistoryConsole() throws IOException, InterruptedException {
			driver = startbrowser();
			LoginPage login = new LoginPage();
			login.filllogindetails(driver);
			commonMethods com=new commonMethods();
			com.clickparentMenu(driver, "Sales");
			com.clickchildMenu(driver, "Sales History Console");
			Sales_CreationPage sal=new Sales_CreationPage();
			sal.create_workorder_delivery(driver,"PRR/OPT/5248");
			com.logout(driver);
}
}
