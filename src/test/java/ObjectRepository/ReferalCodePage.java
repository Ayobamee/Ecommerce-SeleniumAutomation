package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReferalCodePage {
	
WebDriver driver;
	
	
public  ReferalCodePage(WebDriver driver) {
		
this.driver=driver;
	}
	
	
By RefCode = By.xpath("//input[@placeholder='Referral code ( Optional )']");


	
	
	public WebElement RefCode () {
		
		return driver.findElement(RefCode);	
			
		}
	
	
     
}
