package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeeMorePage {
	
WebDriver driver;
	
	
public  SeeMorePage(WebDriver driver) {
		
this.driver=driver;
	}
	
	
By SeeMore = By.partialLinkText("See mo");

	
	
	
	public WebElement SeeMore () {
		
	return driver.findElement(SeeMore);	
			
		}
	
	
	
	
}
