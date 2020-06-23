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

import ObjectRepository.ForgotPasswordPage;
import ObjectRepository.MerchListLoginPage;
//import ObjectRepository.MerchListLoginPage;

public class ForgotPasswordTest {
public WebDriver driver;

	
	
	
	
@BeforeTest
public void SetUp () {
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");

driver.manage().window().maximize();


	}
	
	
@Test	
	
public void ForgotPassword() throws IOException {
	
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);		

//Open Website
driver.get(prop.getProperty("URL"));  


//Call Object repo	
MerchListLoginPage ml = new MerchListLoginPage(driver);

ForgotPasswordPage fp = new ForgotPasswordPage(driver);

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

//Wait for 20 s.
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Click Forgot Password
fp.ForgotPass().click();

//Enter Email
fp.ForgottenEmail().sendKeys(prop.getProperty("EmailIdentity"));

//Click Verify Email
fp.VerifyEmail().click();

//Verify onscreen message indicating password reset

if ((fp.SuccessfulVer())!=null) {
	
	System.out.println("Email has been sent to complete the forgot password process.");
}

else {
	System.out.println("Forgot Password is not working");
}



}
@AfterTest	
public void closePage () {
driver.quit();
		
}
	
	
	
}
