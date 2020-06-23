package TestCases;

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
import ObjectRepository.PaymentPage;
import ObjectRepository.ReferalCodePage;

public class PaymentTest {
	public WebDriver driver;
	public String baseURL = "https://test.merchlist.co/";
	String baseUrl2="https://test.merchlist.co/buy";
	public String EmailId = "Ayobami.Elutade@outlook.com";
	public String Password = "Wiskolowiska2020!";
	public String expectedTitle="Merchlist Businesses";
    public String expectedTitle2="Product Details";
    String FirstName = "Ayobami";
    String LastName = "Elutade";
    String PhoneNumber = "07060406267";
    String Address ="24 oladimeji street, Meran, Lagos";
    String ReferalCode = "9419999";
	
	
@BeforeTest
public void SetUp () {
System.out.println("Browser opened"); //Open Browser
driver=Utilities.DriverFactory.open("chrome");

//driver.manage().window().fullscreen();

//driver.manage().window().setSize(new Dimension(1280,1024));

driver.manage().window().maximize();
//Dimension d = new Dimension (1382,744);

//driver.manage().window().setSize(d);

driver.get(baseURL);  

	}
	
	
@Test	
	
public void CheckOut() {
	
MerchListLoginPage ml = new MerchListLoginPage(driver);
MerchListAddToCartPage mA = new MerchListAddToCartPage(driver);
MerchListCheckOutPage mC = new MerchListCheckOutPage(driver);
ReferalCodePage rC = new ReferalCodePage(driver);
PaymentPage pP = new PaymentPage(driver);
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

//Enter Email Id
ml.Email().sendKeys(EmailId);

//Enter Password
ml.Password().sendKeys(Password);

//Click Login Button
ml.LoginButton().click();


//Validate that User is logged in successfully.

String BaseUrl="https://test.merchlist.co/buy";
String expectedTitle="Merchlist | Homepage";
driver.get(BaseUrl);
String actualTitle=driver.getTitle();


if(actualTitle.equals(expectedTitle)){
System.out.println("Login is Successful");
}
else{
System.out.println("Login is Unsuccessful");
}


//Click Product Category.
mA.Test().click();

//Select Store
/*mA.Store().click();


//driver.get(baseUrl2);

String actualTitle2= driver.getTitle();

if(actualTitle2.equals(expectedTitle2)){
    System.out.println("Product has been selected successfully from the store");
}

else{
    System.out.println("Product cannot be selected");
}
*/

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

mC.FirstName().sendKeys(FirstName);

mC.LastName().sendKeys(LastName);

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

mC.PhoneNumber().sendKeys(PhoneNumber);

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

mC.Address().sendKeys(Address);

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


WebElement SelectLGA = mC.LGA();

Select Seconddropdown = new Select (SelectLGA);

Seconddropdown.selectByVisibleText("Agege");

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	

rC.RefCode().sendKeys(ReferalCode);

mC.PayNow().click();



if(mC.SuccessfulCheckOut()!= null){
	
	System.out.println("Check out was successful");


}else{
	
	System.out.println("Oops! Check out was unsuccessful");
	}

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

pP.Card().click();

pP.Sub().click();




}
	

@AfterTest	
public void closePage () {
driver.quit();
		
}

	
	
}
