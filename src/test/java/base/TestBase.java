package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import utility.AppiumServer;
import utility.CommonUtils;
import utility.ExcelReader;

public class TestBase {

	// Test base class to start Appium server
	public static AppiumDriver<MobileElement> driver;
	
	//Loading Android properties
	public static String loadPropertyFile = "Android_Ebayapp.properties";
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/properties/testdata.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	public  Logger logger4j =Logger.getLogger("Google");
	
	// Setup Method for Appium
	
	@BeforeSuite
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			AppiumServer.start();
			
			// configure log4j properties file
		  
			  PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");
		    logger4j.debug("Execution started");
		    
			log.debug("Appium server started");
			if (loadPropertyFile.startsWith("IOS")) {

			// Need to implement

			} else if (loadPropertyFile.startsWith("Android")) {

				//Code for Android configuration
				logger4j.debug("Execution started");
				log.debug("Starting on Android");
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}

		}

	}

	
	// Method to stop Appium server
	@AfterSuite
	public void tearDown() throws IOException {

		logger4j.debug("execution ended");
		driver.quit();
		AppiumServer.stop();

		
	}

}
