package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.commonMethods;


public class Lab_diagnosticmodule {
	
	commonMethods com=new commonMethods();
	
	By pat_No_dropdownselect=By.xpath("//div[@class='x-combo-list-item']");
	By patient_textbox=By.id("diagnosticPatientId");
	By sample_icon=By.cssSelector("img[src*='/images/sample.gif']");
	By row_checker=By.cssSelector("div[class='x-grid3-hd-checker']");
	By response_text=By.xpath("//center[@id='message_label']//p");
	By close_menu=By.cssSelector("img[src*='/newui/images/default/layout/expand.gif']");
	By report_icon=By.cssSelector("img[src*='/images/report.gif']");
	By result_doubleclick=By.className("x-grid3-cell-inner x-grid3-col-Result");
	By result_count=By.className("x-grid3-cell-inner x-grid3-col-ResultName");
	By result_value=By.cssSelector("div[class='x-layer x-editor x-small-editor x-grid-editor'] textarea");
	By print_icon=By.cssSelector("img[src*='/images/print.gif']");
	By dispatch_icon=By.cssSelector("div[class='x-grid3-cell-inner x-grid3-col-Dispatch'] img");
	By dispatch_textbox=By.id("dispatchedTo");
	By digital_sign_icon=By.cssSelector("div[class='x-grid3-cell-inner x-grid3-col-DigitalSignature'] img");
	
	
	


public WebDriver Record_lab_samples(WebDriver driver) throws InterruptedException {
	
	com.Select_departmentname_dropdown(driver, "diagnosticStatus", "Pending");
	Thread.sleep(2000);
	WebElement No= driver.findElement(patient_textbox);
	No.sendKeys("");
	Thread.sleep(3000);
	driver.findElement(pat_No_dropdownselect).click();
	Thread.sleep(5000);
	
	
	driver.findElement(sample_icon).click();
	Thread.sleep(3000);
	driver.findElement(row_checker).click();
	com.Click_button(driver, "Record Sample");
	String response=driver.findElement(response_text).getText();
	Thread.sleep(3000);
	Assert.assertTrue(response.contains("Success"));
	System.out.println(response);
	Thread.sleep(3000);
	driver.findElement(close_menu).click();
	
	
	Thread.sleep(2000);
	driver.findElement(report_icon).click();
	Thread.sleep(2000);
	Actions action1 = new Actions(driver);
	action1.doubleClick(driver.findElement(result_doubleclick)).perform();
	
	
	List<WebElement> total_count=driver.findElements(result_count);
	for(int i=0; i<total_count.size(); i++) 
	{
		Thread.sleep(1000);
		WebElement result_box=driver.findElement(result_value);
		result_box.sendKeys("20");
		result_box.sendKeys(Keys.TAB);
	}
	com.Click_button(driver,"Save");
	Thread.sleep(3000);
	Assert.assertTrue(response.contains("Success"));
	driver.findElement(close_menu).click();
	Thread.sleep(2000);
	
	
	driver.findElement(print_icon).click();
	List<WebElement> print_rowlist=driver.findElements(digital_sign_icon);
	for(int i=0; i<print_rowlist.size(); i++)
	{
		Thread.sleep(2000);
		driver.findElement(digital_sign_icon).click();
		com.Select_Dynamic_dropdown(driver, "technicianId");
		Thread.sleep(2000);
		com.Click_button(driver, "update");	
	}
	driver.findElement(row_checker).click();
	com.Click_button(driver, "Print Report");
	Thread.sleep(2000);
	com.close_print_window(driver);
	
	
	Thread.sleep(2000);
	driver.findElement(dispatch_icon).click();
	Thread.sleep(2000);
	driver.findElement(dispatch_textbox).sendKeys("Test");
	driver.findElement(row_checker).click();
	com.Click_button(driver, "Dispatch");
	Thread.sleep(2000);
	com.close_print_window(driver);
	
	return driver;
	}
}
