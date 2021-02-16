package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public WebDriver startbrowser() throws IOException {
		
	Properties prop = new Properties();
	FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Abdul\\AgarwalRegression\\src\\main\\java\\resources\\property");
	prop.load(file);
	String browsername = prop.getProperty("browser");
	String url = prop.getProperty("url");
	System.out.println(browsername);
	if (browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Abdul\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	else {
		System.out.println("Not a chrome browser");
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	}
}
