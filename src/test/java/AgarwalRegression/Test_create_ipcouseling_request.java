package AgarwalRegression;



import java.io.IOException;

import pageObjects.Create_counselingrequest;
import pageObjects.LoginPage;
import resources.Base;
import resources.commonMethods;

public class Test_create_ipcouseling_request extends Base {
	
	public void create_counseling_request() throws IOException, InterruptedException {
	
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com = new commonMethods();
		com.clickparentMenu(driver, "Counseling");
		com.clickchildMenu(driver, "Create Counseling Request");
		Create_counselingrequest Iprequest=new Create_counselingrequest();		
	}

}
