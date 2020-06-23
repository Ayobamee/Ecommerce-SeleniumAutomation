package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductPage {
	
WebDriver driver;
	
	
public  SearchProductPage(WebDriver driver) {
		
this.driver=driver;
	}
	
	
By SearchProducts = By.xpath("//input[@placeholder='Search Products']");

By HitSearch = By.xpath("//i[@class='fas fa-search oranges pt-1']");

	
	
	
	public WebElement SearchProducts () {
		
	return driver.findElement(SearchProducts);	
			
		}
	
	
	public WebElement HitSearch () {
		
		return driver.findElement(HitSearch);	
				
			}
	
	
}
