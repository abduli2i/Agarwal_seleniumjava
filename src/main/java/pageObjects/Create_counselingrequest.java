package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.commonMethods;

public class Create_counselingrequest {
	
	commonMethods com=new commonMethods();
	
	By doubleclick_package=By.className("x-grid3-cell-inner x-grid3-col-PackageName");
	By doubleclick_status=By.className("x-grid3-cell-inner x-grid3-col-Status");
	By select_statusdropdown=By.id("COUNSELING_CONSOLE_CREATION_GRIDStatusTrigger");
	By sales_No_dropdownselect=By.xpath("//div[contains(text(),'Scheduled')]");
	By status_box=By.id("COUNSELING_CONSOLE_CREATION_GRIDStatusEditor");
	By scheduled_date=By.className("x-form-trigger x-form-date-trigger x-form-trigger-over");
	By date_textbox=By.className("x-form-text x-form-field x-form-focus");
	By add_service=By.id("COUNSELING_CONSOLE_CREATION_GRIDPackageNameEditor");
	By select_servicelist=By.id("COUNSELING_CONSOLE_CREATION_GRIDPackage NameListItem");
	By consultant_textbox=By.name("referredBy");
	
	
	
	public WebDriver Add_Counselingrequest(WebDriver driver) throws InterruptedException {
		
		
		com.Select_Dynamic_dropdown(driver, "payorName");
		com.Select_Dynamic_dropdown(driver, "bedType");
		
		
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("doubleclick_package"))).perform();
		driver.findElement(add_service).sendKeys("Blood urea");
		driver.findElement(select_servicelist).click();
		Actions action1 = new Actions(driver);
		action1.doubleClick(driver.findElement(By.xpath("doubleclick_status"))).perform();
		driver.findElement(select_statusdropdown).click();
		driver.findElement(sales_No_dropdownselect).click();
		driver.findElement(status_box).sendKeys(Keys.TAB);
		driver.findElement(scheduled_date).click();
		com.Click_button(driver, "Today");
		driver.findElement(date_textbox).sendKeys(Keys.ENTER);
		
		com.Add_discount(driver);
		com.Click_button(driver, "Save");
		
		
		com.Click_button(driver, "Create IP Admission");
		WebElement referredby=driver.findElement(consultant_textbox);
		referredby.sendKeys("A");
		referredby.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		com.Click_button(driver, "Create");
		return driver;
		
	}

}
