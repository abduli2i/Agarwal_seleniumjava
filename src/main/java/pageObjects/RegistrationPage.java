 package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {

	By salutation_name = By.name("salutation");
	By Patientname_name = By.name("patientName");
	By age_name = By.name("age");
	By gender_name = By.name("gender");
	By contactaddress_name = By.name("contactAddress");
	By countrycode = By.name("country_Code");
	By mobilenumber_name = By.name("mobileNo");
	By emailid_name = By.name("emailId");
	By pincode_name = By.name("patientArea");
	//referredBy,primaryConsult
	By consultant_name = By.name("primaryConsult");
	By charge_name = By.name("consultCharge");
	By occupation_name = By.name("occupation");
	By create_id = By.id("create");
	
	
	
	//New patient registration
	public WebDriver createRegiistration(WebDriver driver) throws InterruptedException {
		Select salutation = new Select(driver.findElement(salutation_name));
		salutation.selectByVisibleText("Mr");		
		driver.findElement(Patientname_name).sendKeys("Makri");
		driver.findElement(age_name).sendKeys("23");
		Select gender = new Select(driver.findElement(gender_name));
		gender.selectByValue("Male");
		driver.findElement(contactaddress_name).sendKeys("Chennai");
		driver.findElement(countrycode).sendKeys("91");
		driver.findElement(mobilenumber_name).sendKeys("1234567890");
		driver.findElement(emailid_name).sendKeys("automation@gmail.com");
		//pincode(driver);
		consultant(driver);
		//charge(driver);
		//Select occupation =  new Select(driver.findElement(occupation_name));
		//occupation.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(create_id).click();
		Thread.sleep(5000);
		String Patientid = driver.findElement(By.xpath("//*[starts-with(@id,'patientId')]")).getText();
		System.out.println("New Patient generated successfully with patientid as "+Patientid);
		return driver;
		
	}
	
	
	//Method for selecting consultant
	public WebDriver consultant(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(consultant_name));
		WebElement consultant = driver.findElement(consultant_name);
		consultant.sendKeys("d");
		Thread.sleep(2000);
		consultant.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		return driver;
	}
	
	
	//Method for selecting charge in reg
	public WebDriver charge(WebDriver driver) throws InterruptedException {
		WebElement charge = driver.findElement(charge_name);
		charge.sendKeys("Consultation Charge");
		Thread.sleep(2000);
		charge.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		return driver;
		
	}
	
	
	//Method for selecting pincode
	public WebDriver pincode(WebDriver driver) throws InterruptedException {
		WebElement pincode = driver.findElement(pincode_name);
		pincode.sendKeys("600080");
		Thread.sleep(2000);
		pincode.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		return driver;
		
	}
	
	
}
