package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MerchListCheckOutPage {
	
WebDriver driver;
	
	
public  MerchListCheckOutPage(WebDriver driver) {
		
this.driver=driver;
	}
	
	
By Carts = By.xpath("//a[contains(@class,'link-decoration nav-link')]");

By CheckOut = By.xpath("//button[@class='btn btn-success btn-block']");

By Email = By.xpath("//input[@id='email']");

By FirstName = By.xpath("//input[@id='firstName']");

By LastName = By.xpath("//input[@id='lastName']");

By PhoneNumber = By.xpath("//input[@id='phoneNumber']");

By Address = By.xpath("//input[@id='address']");

By State = By.xpath("//select[@id='state']");

By LGA = By.xpath("//select[@id='lga']");

By PayNow = By.xpath("//button[@class='btn btn-success']");

By SuccessfulCheckOut = By.xpath("//div[@class='col-md-4 mb-4']");



	
	
	
	public WebElement Carts () {
		
		return driver.findElement(Carts);	
			
		}
	
	
     public WebElement CheckOut () {
		
		return driver.findElement(CheckOut);	
			
		}
	
	
     
     public WebElement Email  () {
  		
  		return driver.findElement(Email);	
  			
  		}
     
     
	
     public WebElement FirstName  () {
 		
 		return driver.findElement(FirstName);	
 			
 		}
     
     
     public WebElement LastName  () {
  		
  		return driver.findElement(LastName);	
  			
  		}
     
     
     public WebElement PhoneNumber  () {
   		
   		return driver.findElement(PhoneNumber);	
   			
   		}
 	
     public WebElement Address  () {
    		
    		return driver.findElement(Address);	
    			
    		}
     
     
     public WebElement State  () {
 		
 		return driver.findElement(State);	
 			
 		}
     
     
     public WebElement LGA  () {
  		
  		return driver.findElement(LGA);	
  			
  		}
     
     
     
     public WebElement PayNow  () {
   		
   		return driver.findElement(PayNow);	
   			
   		}
     
     
     public WebElement SuccessfulCheckOut () {
    		
    		return driver.findElement(SuccessfulCheckOut);	
    			
    		}
	
}
