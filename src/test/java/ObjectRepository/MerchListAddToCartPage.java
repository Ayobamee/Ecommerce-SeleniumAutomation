package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MerchListAddToCartPage {
	
WebDriver driver;
	
	
public  MerchListAddToCartPage(WebDriver driver) {
		
this.driver=driver;
	}
	

By Test = By.partialLinkText("test");


By Store = By.xpath("//div[@class='container mt-3']//div[1]//app-product-card[1]//div[1]//div[2]//div[2]//div[1]");

By Toast = By.xpath("//div[@id='toast-container']");

By Cart = By.xpath("//div[@class='container mt-3']//div[1]//app-product-card[1]//div[1]//div[2]//div[2]//div[1]");
	
	



public WebElement Test () {
	
	return driver.findElement(Test);	
		
	}



	
	public WebElement Store () {
		
		return driver.findElement(Store);	
			
		}
	
	
     public WebElement Cart () {
		
		return driver.findElement(Cart);	
			
		}
	
	
	
     public WebElement Toast  () {
 		
 		return driver.findElement(Toast);	
 			
 		}
	
	
}
