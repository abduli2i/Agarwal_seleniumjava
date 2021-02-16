package AgarwalRegression;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Create_GRN_Page;
import pageObjects.Create_PO_Screen;
import pageObjects.LoginPage;
import resources.Base;
import resources.commonMethods;

public class Test_Create_Direct_GRN extends Base {

	@Test
	public void Select_GRN_from_PO() throws IOException, InterruptedException {
		driver = startbrowser();
		LoginPage login = new LoginPage();
		login.filllogindetails(driver);
		commonMethods com=new commonMethods();
		com.clickparentMenu(driver, "Purchase");
		com.clickchildMenu(driver, "Goods Received Note");
		//Create_Purchase_order po=new Create_Purchase_order();
		//po.Select_GRN_From_PO_Console(driver);
		Create_GRN_Page grn=new Create_GRN_Page();
		grn.Create_Direct_GRN(driver);
		com.close_print_window(driver);
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'GRN No')]")).isDisplayed());
		String Created_Grn_No=driver.findElement(By.id("ticketId")).getText();
		System.out.println("Grn created successfully : "+Created_Grn_No);
}
}
