package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	

	
	By username = By.name("j_username");
	By password = By.name("j_password");
	By loginbutton = By.id("btnSubmit");
	



	public WebDriver filllogindetails(WebDriver driver) {
		//driver.findElement(username).sendKeys("prrideamed");
		//driver.findElement(password).sendKeys("I$eame$5");
		
		driver.findElement(username).sendKeys("prrideamed");
		driver.findElement(password).sendKeys("I$eame$5");
		driver.findElement(loginbutton).click();
		return driver;
	}

}
