package TestCases;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import ObjectRepository.MerchListLoginPage;
//import ObjectRepository.ResAdminLoginPage;
import ObjectRepository.ResMerchantLoginPage;

public class RestrictionMerchantTest {
public WebDriver driver;

	
	
	
	
@BeforeTest
public void SetUp () {
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");
driver.manage().window().maximize();

	}
	
	
@Test	
	
public void RestrictionAdmin() throws IOException {

Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);	

//Open Website
driver.get(prop.getProperty("AdminURL"));  


//Call Object repo	
	
ResMerchantLoginPage rM = new ResMerchantLoginPage(driver);


//Wait for 20 s.
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



//Click Login

rM.Username().sendKeys(prop.getProperty("Username"));

rM.Password().sendKeys(prop.getProperty("Password"));

rM.Login().click();

// Validate that user with Merch list credentails cannot log into the Merchant profile.
if(rM.error()!= null){
	
	System.out.println("Login is unsucessful");


}else{
	
	System.out.println("Test failed");


}
}

@AfterTest	
public void closePage () {
driver.quit();
		
}
	

	
}
