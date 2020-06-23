package TestCases;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
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

import ObjectRepository.GeographicalRestrictionPage;
import ObjectRepository.MerchListLoginPage;

public class GeographicalRestrictionTest {
public WebDriver driver;

		
@BeforeTest
public void SetUp () throws IOException {

System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");

driver.manage().window().maximize();

	}
	
	
@Test	
	
public void GeographicalRestriction() throws IOException {

Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\data\\datadriven.properties");
prop.load(fis);	

//Open Website
driver.get(prop.getProperty("URL"));  


//Call Object repo	
MerchListLoginPage ml = new MerchListLoginPage(driver);
GeographicalRestrictionPage gR = new GeographicalRestrictionPage(driver);

//Wait for 20 s.
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Select State from Geographical restriction

WebElement SelectState = ml.State();

Select dropDown = new Select (SelectState);

dropDown.selectByVisibleText("Lagos");

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Click Save
WebElement Save = ml.Save();

JavascriptExecutor js = (JavascriptExecutor) driver;

js.executeScript("arguments[0].scrollIntoView();", Save);

Save.click();


//Validate test product can be selected after geoprahical restriction drop down is selected.
if((gR.TestProd())!= null){
	
	System.out.println("Geographical restriction works");


}else{
	
	System.out.println("Geographical restriction does not work");
	}





}


@AfterTest	
public void closePage () {
driver.quit();
		
}
	

	
}
