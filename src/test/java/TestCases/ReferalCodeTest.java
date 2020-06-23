package TestCases;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.MerchListAddToCartPage;
import ObjectRepository.MerchListCheckOutPage;
import ObjectRepository.MerchListLoginPage;
import ObjectRepository.ReferalCodePage;

public class ReferalCodeTest {
public WebDriver driver;


	
@BeforeTest
public void SetUp () {
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");
driver.manage().window().maximize();


	}
	
	
@Test	
	
public void ReferalCode() throws IOException {
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);	

//Open Website
driver.get(prop.getProperty("URL"));  
	

//Call Object repo	
MerchListLoginPage ml = new MerchListLoginPage(driver);
MerchListAddToCartPage mA = new MerchListAddToCartPage(driver);
MerchListCheckOutPage mC = new MerchListCheckOutPage(driver);
ReferalCodePage rC = new ReferalCodePage(driver);



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



//Click Product Category.
mA.Test().click();


driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	


//Add to Cart
mA.Cart().click();


if((mA.Toast())!= null){
	
	System.out.println("Product is added to cart successful");


}else{
	
	System.out.println("Product could not be added to cart successful");
	}


//Wait
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		


mC.Carts().click();


//Wait
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

mC.CheckOut().click();

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//mC.Email().sendKeys(EmailId);

mC.FirstName().sendKeys(prop.getProperty("FirstName"));

mC.LastName().sendKeys(prop.getProperty("LastName"));

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

mC.PhoneNumber().sendKeys(prop.getProperty("PhoneNumber"));

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

mC.Address().sendKeys(prop.getProperty("Address"));

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


WebElement SelectLGA = mC.LGA();

Select Seconddropdown = new Select (SelectLGA);

Seconddropdown.selectByVisibleText("Agege");

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	

rC.RefCode().sendKeys(prop.getProperty("ReferalCode"));

mC.PayNow().click();

// Validate that user can use the Referal code to check out successfully

if(mC.SuccessfulCheckOut()!= null){
	
	System.out.println("Check out with Referal code was successful");


}else{
	
	System.out.println("Oops! Check out was unsuccessful");
	}



}
	

@AfterTest	
public void closePage () {
driver.quit();
		
}

	
	
}
