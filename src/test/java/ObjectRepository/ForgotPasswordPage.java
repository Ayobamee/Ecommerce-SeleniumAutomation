package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
WebDriver driver;
	
	
public  ForgotPasswordPage(WebDriver driver) {
		
this.driver=driver;
	}
	
	
By ForgotPass = By.partialLinkText("Forgot Passwor");

By ForgottenEmail = By.xpath("//input[@id='validationCustom03']");

By VerifyEmail = By.xpath("//button[@class='btn btn-success form-control']");

By SuccessfulVer = By.xpath("//p[@class='text-success']");

	
	
	
	public WebElement ForgotPass () {
		
	return driver.findElement(ForgotPass);
			
		}
	
	
	public WebElement ForgottenEmail () {
		
		return driver.findElement(ForgottenEmail);
				
			}
	
	
public WebElement VerifyEmail () {
		
		return driver.findElement(VerifyEmail);
				
			}
   
	

public WebElement SuccessfulVer () {
	
	return driver.findElement(SuccessfulVer);
			
		}

	
}
