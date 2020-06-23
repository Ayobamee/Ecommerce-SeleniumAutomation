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
import ObjectRepository.SeeMorePage;

public class ListMoreBusinessesTest {
public WebDriver driver;

	
	
@BeforeTest
public void SetUp () {
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");

driver.manage().window().maximize();
 

	}
	
	
@Test	
	
public void ListMoreBusinesses() throws IOException {

Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);	

//Open Website
driver.get(prop.getProperty("URL"));  


//Call Object repo		
	
MerchListLoginPage ml = new MerchListLoginPage(driver);

SeeMorePage sM = new SeeMorePage(driver);



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


//Click See more
sM.SeeMore().click();


//Validate that See more page works appropriately.

driver.get(prop.getProperty("BaseUrl2"));
String actualTitle2= driver.getTitle();


if(actualTitle2.equals(prop.getProperty("expectedTitle2"))){
  System.out.println("See more paging is working");
}
else{
  System.out.println("See more paging is not working");
}



}
@AfterTest	
public void closePage () {
driver.quit();
		
}
	
	
	
}
