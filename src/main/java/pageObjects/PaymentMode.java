package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.commonMethods;

public class PaymentMode {
	commonMethods com=new commonMethods();
	
	By cardtype=By.xpath("//div[contains(text(),'Card')]");
	By cardno=By.xpath("//div[contains(@id,'CardNo')");
	By batchno=By.xpath("//div[contains(@id,'BatchNo')");
	By cheque=By.xpath("//div[contains(text(),'Cheque')]");
	By chequeno=By.xpath("//div[contains(@id,'ChequeNo')]");
	By DD=By.xpath("//div[contains(text(),'DD')]");
	By DDNo=By.xpath("//*[contains(text(),'DD Number')]//following::input[1]");
	By fund=By.xpath("//div[contains(text(),'Fund Transfer')]");
	By transaction=By.xpath("//div[contains(@id,'TransactionId')]");
	By paytm=By.xpath("//div[contains(text(),'Paytm')]");
	By orderid=By.xpath("//*[contains(text(),'Order Id')]//following::input[1]");
	By paytmtransid=By.xpath("//*[contains(text(),'Order Id')]//following::input[2]");
	By advanceamt=By.id("advanceAmount");
	By referenceno=By.xpath("//div[contains(@id,'ReferenceNumber')]");
	By transactionno=By.xpath("//div[contains(@id,'TransactionNumber')]");
	By deposit=By.xpath("//div[contains(text(),'Deposit')]");
	By paymentdropdown=By.xpath("//input[contains(@id,'PaymentMode')]/parent::div/img");
	
	
	
	
	
	
	//Select type of payment mode for payment
	public WebDriver modeofpayment(WebDriver driver,String mode) throws InterruptedException {
		
		driver.findElement(paymentdropdown).click();


		if(mode=="cash") {
			System.out.println("Cash payment");
			com.Click_button(driver,"RECORD PAYMENT");
			} 
		else if(mode=="card") {
			driver.findElement(cardtype).click();
			driver.findElement(cardno).sendKeys("1234");
			com.Select_Dynamic_dropdown(driver,"addServiceCardType");
			driver.findElement(batchno).sendKeys("222");
			com.Select_Dynamic_dropdown(driver,"ExpiryDate");
			//com.buttons(driver,"OK");
			try {
			com.Select_Dynamic_dropdown(driver,"SwipeMachine");
				}
			catch(Exception e) {
				System.out.println("Not available");
				}
			}
		else if(mode=="cheque") {
			driver.findElement(cheque).click();
			driver.findElement(chequeno).sendKeys("111");
			com.Select_Dynamic_dropdown(driver,"ankName");
			com.Select_Dynamic_dropdown(driver,"ChequeDate");
			com.Select_Dynamic_dropdown(driver,"OK");
			
			}
		else if(mode=="DD") {
			driver.findElement(DD).click();
			driver.findElement(DDNo).sendKeys("111");
			com.Select_Dynamic_dropdown(driver,"BankName");
			
			}
		else if(mode=="Fund Transfer") {
			driver.findElement(fund).click();
			com.Select_Dynamic_dropdown(driver,"TransactionType");
			com.Select_Dynamic_dropdown(driver,"BankName");
			driver.findElement(transaction).sendKeys("111");
			}
		else if(mode=="Paytm") {
			driver.findElement(paytm).click();
			driver.findElement(orderid).sendKeys("111");
			driver.findElement(paytmtransid).sendKeys("111");
			com.Select_Dynamic_dropdown(driver,"aytmDate");
			com.Click_button(driver,"OK");	
			}
		
		else if(mode=="Online Services") {
			driver.findElement(referenceno).sendKeys("111");
			driver.findElement(transactionno).sendKeys("111");
			}
		
		else if(mode=="deposit") {
			driver.findElement(deposit).click();
			
			}
	
		try {
			driver.findElement(advanceamt).sendKeys("1");
		}
		
		catch(Exception e) {
			System.out.println("Advance amount not needed");
		}
		finally {
			com.Click_button(driver,"RECORD PAYMENT");
			System.out.println("Payment successfull with '"+mode+"'");
			}
	return driver;
	}
		
	
}


