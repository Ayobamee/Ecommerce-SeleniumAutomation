package TestCases;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.MerchListLoginPage;

public class LoginFailureTest {
public WebDriver driver;


	
	
@BeforeTest
public void SetUp () throws IOException {		
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");


driver.manage().window().maximize();


	}
	
	

@Test	
	
public void LoginFailure() throws IOException {
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);	

driver.get(prop.getProperty("URL")); 

//Call Object repo
MerchListLoginPage ml = new MerchListLoginPage(driver);

//Click Shop Now
//ml.ShopNow().click();

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

//Enter Wrong Email Id
ml.Email().sendKeys(prop.getProperty("WrongUsername"));

//Enter Wrong Password
ml.Password().sendKeys(prop.getProperty("WrongPassword"));

//Click Login Button
ml.LoginButton().click();



//Validate that User is not logged in successfully.

if(driver.findElement(By.xpath("//p[@class='text-danger']"))!= null){
	
	System.out.println("Login is Unsuccessful");


	}else{
	System.out.println("Login is Successful");
	}

	}
	
	
	
@AfterTest	
public void closePage () {
driver.quit();
		
}
	
	
}
