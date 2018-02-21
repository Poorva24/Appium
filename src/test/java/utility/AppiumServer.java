package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.util.Properties;

public class AppiumServer  {

	

	//Class for Starting the Appium Server

	public static AppiumDriverLocalService service;

	public static void start() {
		
		// Function to start Appium
		String APPIUMPATH="";
		String NODEJSPATH="";
		Properties prop = new Properties();
		FileInputStream fis;
		try {

			// Reading property file 
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/AppiumServer.properties");

			// Loading property file
			prop.load(fis);

			// Getting Appium and nodejs Path from file
			APPIUMPATH = prop.getProperty("Appium_Path");
			NODEJSPATH = prop.getProperty("Node_Path");


			System.out.println("Node JS Path"+NODEJSPATH);

			System.out.println("Appium Path"+APPIUMPATH);


			// code to Invoke Appium server
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder()
							.usingDriverExecutable(new File(NODEJSPATH))
							.withAppiumJS(new File(APPIUMPATH)));



			service.start();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}






	}


	//Stopping the Appium Server

	public static void stop() throws IOException {

		service.stop();
	}


}
