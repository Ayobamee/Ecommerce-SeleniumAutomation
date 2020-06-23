package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeographicalRestrictionPage {
	
WebDriver driver;
	
	
public  GeographicalRestrictionPage(WebDriver driver) {
		
this.driver=driver;
	}
	

By TestProd = By.partialLinkText("test");
	
	
	
public WebElement TestProd () {
	
	return driver.findElement(TestProd);	
			
		}



	
	
	
}
