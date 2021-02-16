package AgarwalRegression;

import java.io.IOException;

import pageObjects.Lab_diagnosticmodule;
import pageObjects.LoginPage;
import resources.Base;
import resources.commonMethods;

public class Test_record_labsample extends Base {
	
	public void Create_PurchaseOrderitems() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com=new commonMethods();
		com.clickparentMenu(driver, "Lab");
		com.clickchildMenu(driver, "Diagnostic Orders");
		Lab_diagnosticmodule lab=new Lab_diagnosticmodule();
		lab.Record_lab_samples(driver);

	}
}
