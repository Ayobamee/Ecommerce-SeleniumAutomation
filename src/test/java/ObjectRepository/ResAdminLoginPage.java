package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResAdminLoginPage {
	
WebDriver driver;
	
	
public  ResAdminLoginPage(WebDriver driver) {
		
this.driver=driver;
	}
	

By Username = By.xpath("//input[@placeholder='User name']");

By Password = By.xpath("//input[@placeholder='Password']");

By Login = By.xpath("//button[@type='submit']");

By error = By.xpath("//p[@class= 'text-danger']");
	
	
public WebElement Username () {
	
	return driver.findElement(Username);	
			
		}


public WebElement Password () {
	
	return driver.findElement(Password);	
			
		}

	

public WebElement Login () {
	
	return driver.findElement(Login);	
			
		}

public WebElement error () {
	
	return driver.findElement(error);	
			
		}


	
	
}
