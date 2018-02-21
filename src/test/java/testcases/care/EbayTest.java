package testcases.care;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import listener.ExtentReporterNG;
import screens.ebay.StartEbay;




public class EbayTest extends TestBase {
	StartEbay Ebay;
	
	// Initializing driver
	@BeforeTest
	public void init(){
		Ebay = new StartEbay(driver);
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException{
	// Calling login function
		
	Ebay.login();
	
	Reporter.log("Login function executed");
	
	}
	
	@Test(priority=2)
	public void Shopping(){
	// Calling method to Add product
		
		Ebay.AddProduct();
		Reporter.log("Add Product function executed");
		//ExtentReporterNG.getTest().setDescription("Executed Add product function and Product added in cart");
	}
	
	
	@Test(priority=3)
	public void SwipeScroll(){
	// Calling method for Swipe	
		
		Ebay.Swipe();
	
		Reporter.log("Scroll function executed");
		//ExtentReporterNG.getTest().setDescription("Performed swipe");
	}
	
	
	
	
}
	

