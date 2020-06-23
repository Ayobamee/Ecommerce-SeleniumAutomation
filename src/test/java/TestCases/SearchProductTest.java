package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.MerchListLoginPage;
import ObjectRepository.SearchProductPage;

public class SearchProductTest {
public WebDriver driver;

	
	
@BeforeTest
public void SetUp () {
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");
driver.manage().window().maximize();
 

	}
	
	
@Test	
	
public void SearchProduct() throws IOException {
	
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);	

//Open Website
driver.get(prop.getProperty("URL"));  


//Call Object repo		
	
MerchListLoginPage ml = new MerchListLoginPage(driver);

SearchProductPage sl = new SearchProductPage(driver);


//Wait for 20 s.
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Select State

WebElement SelectState = ml.State();

Select dropDown = new Select (SelectState);

dropDown.selectByVisibleText("Lagos");

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Click Save
WebElement Save = ml.Save();

JavascriptExecutor js = (JavascriptExecutor) driver;

js.executeScript("arguments[0].scrollIntoView();", Save);

Save.click();



//Click Login
ml.Login().click();

//Enter Email Id
ml.Email().sendKeys(prop.getProperty("Username"));

//Enter Password
ml.Password().sendKeys(prop.getProperty("Password"));

//Click Login Button
ml.LoginButton().click();


//Validate that User is logged in successfully.

driver.get(prop.getProperty("BaseUrl"));
String actualTitle=driver.getTitle();


if(actualTitle.equals(prop.getProperty("expectedTitle"))){
  System.out.println("Login is Successful");
}
else{
  System.out.println("Login is Unsuccessful");
}

//Enter Nescafe in the search box

sl.SearchProducts().sendKeys("Nescafe");

//Click Search

sl.HitSearch().click();

// Validate that the Search box works

driver.get(prop.getProperty("SearchUrl"));
String secondActualTitle = driver.getTitle();


// Validate that users can search for products successfully.
if (secondActualTitle.equals(prop.getProperty("SearchExpectedTitle"))) {
	System.out.println("The product was searched for successfully");
	
}

else {
	System.out.println("Product search does not work or the product does not exist");
}



}
@AfterTest	
public void closePage () {
driver.quit();
		
}
	
	
	
}
