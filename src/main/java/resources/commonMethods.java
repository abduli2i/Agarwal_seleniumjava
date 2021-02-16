package resources;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {

	//Application Logout
	public WebDriver logout(WebDriver driver) {
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		return driver;
	}
	
	//Clicking child menu screen
	public WebDriver clickchildMenu(WebDriver driver,String childmenuname) {
		driver.findElement(By.xpath("//a[contains(text(),'"+childmenuname+"')]")).click();
		return driver;
	}
	
	
	//Clicking parent menu screen
	public WebDriver clickparentMenu(WebDriver driver,String menuname) {
		driver.findElement(By.xpath("//span[contains(text(),'"+menuname+"')]")).click();
		return driver;
	}
	
	
	//Patient search filter
	public WebDriver patientsearch(WebDriver driver,String patname) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='Search Patient']")));
		driver.findElement(By.cssSelector("input[value='Search Patient']")).sendKeys(patname, Keys.ENTER);
		return driver;
	}
	
	
	
	//Select item functionality
	public WebDriver Select_itemname(WebDriver driver,String itemname) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@id,'ItemNameEditor')]")).sendKeys(itemname);
		Thread.sleep(2000);
		WebElement itemlist=driver.findElement(By.xpath("//div[contains(@id,'NameListItem')]"));
		//Thread.sleep(2000);
		itemlist.click();
		return driver;
	}

	
	//Dynamic Dropdown functionality(Date picker image,auto complete fields) 
	public WebDriver Select_Dynamic_dropdown(WebDriver driver,String dropdownname) throws InterruptedException {
		WebElement drop=driver.findElement(By.xpath("//input[contains(@id,'"+dropdownname+"')]/parent::div/img"));
		drop.click();
		WebElement consultant_click=driver.findElement(By.id(dropdownname));
		Thread.sleep(2000);
		consultant_click.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		return driver;	
	}
	
	//Select discount functionality for sales and service
	public WebDriver Add_discount(WebDriver driver) throws InterruptedException {
		
		WebElement value=driver.findElement(By.id("discountType"));
		value.click();
		value.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("discountReason")).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.id("discountPercentage")).sendKeys("2");
		return driver;
	}
	
	
	//Payment mode select (advance,add to bill,payment) 
	public WebDriver payment_type(WebDriver driver,String paytype) {
		driver.findElement(By.xpath("//div[contains(text(),'"+paytype+"')]")).click();;
		return driver;	
	}
	
	//Select and click create,save,cancel button
	public WebDriver Click_button(WebDriver driver,String buttonname) {
		driver.findElement(By.xpath("//button[contains(text(),'"+buttonname+"')]")).click();
		return driver;	
	}
	
	
	//Select department dropdown(sales,grn,po)
	public WebDriver Select_departmentname_dropdown(WebDriver driver,String dropname,String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'"+dropname+"')]/parent::div/img")));
		WebElement drop=driver.findElement(By.xpath("//input[contains(@id,'"+dropname+"')]/parent::div/img"));
		drop.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]")).click();		
		return driver;
		
	}
	
	public WebDriver Partial_search_text(WebDriver driver,String textname) {
		driver.findElement(By.xpath("//*[contains(text(),'"+textname+"')]")).click();
		return driver;	
	}
	
	
	//Explicit wait till element is  clickable
	public WebDriver Call_Explicitwait(WebDriver driver,By locatorname) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(locatorname));
		return driver;
	}
	
	
	
	public WebDriver close_print_window(WebDriver driver) throws InterruptedException {
	String parent = driver.getWindowHandle();
	//System.out.println(parent);
	Thread.sleep(6000);
	Set<String> allwindow = driver.getWindowHandles();
	
	 if (!allwindow.isEmpty()) {
		 driver.switchTo().window((String)allwindow.toArray()[allwindow.size() - 1]); 
		 driver.close();
	 driver.switchTo().window(parent); 
	 }
		/*
		 * ArrayList<String> tabs=new ArrayList<String>(allwindow);
		 * driver.switchTo().window(tabs.get(1)); System.out.println(parent);
		 * driver.close(); driver.switchTo().window(tabs.get(0));
		 */
		/*
		 * for(String child:allwindow) { if(!parent.equalsIgnoreCase(child)) {
		 * driver.close(); } }
		 */
	 
	return driver;
	 
	}
	
}



