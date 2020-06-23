package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MerchListLoginPage {
	
WebDriver driver;
	
	
public  MerchListLoginPage(WebDriver driver) {
		
this.driver=driver;
	}
	

By State = By.xpath("//select[@class='form-control custom-select ng-untouched ng-pristine ng-invalid']");
By Save = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select A Delivery Location'])[1]/following::button[1]");
By ShopNow = By.xpath("//button[@class='btn-1']");
By Login =   By.linkText("Login");
By Username = By.xpath("//div[@class='col-md-12']//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
By Password = By.xpath("//div[@class='col-lg-12 col-md-12']//input[@class='form-control ng-untouched ng-pristine ng-invalid']");
By LoginButton = By.xpath("//button[contains(@class,'form-control')]");
	
	
	
public WebElement State () {
	
	return driver.findElement(State);	
			
		}


public WebElement Save () {
	
	return driver.findElement(Save);	
			
		}


	public WebElement ShopNow () {
		
	return driver.findElement(ShopNow);	
			
		}
	
	
     public WebElement Login () {
		
		return driver.findElement(Login);	
			
		}
	
	
	
	public WebElement Email () {
		
	return driver.findElement(Username);	
		
	}


	public WebElement Password () {
		
	return driver.findElement(Password);	
		
	}
	
	
	public WebElement LoginButton () {
		
		return driver.findElement(LoginButton);	
			
		}
	
	
	
}
