package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
	
WebDriver driver;
	
	
public  PaymentPage(WebDriver driver) {
		
this.driver=driver;
	}
	
	
By Card = By.xpath("//div[@id='test-cards']/div/div/div/div/div");

By Sub = By.xpath("//button[@type='submit']");


	
	
	public WebElement Card () {
		
		return driver.findElement(Card);	
			
		}
	
	
public WebElement Sub () {
		
		return driver.findElement(Sub);	
			
		}
	
	
     
}
