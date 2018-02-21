package listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility.TestUtil;

// Listeners class for listening to the event 
public class CustomListeners implements ITestListener {
	
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		System.out.println("I am in onStart method " + iTestContext.getName());
        
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	// Listener for failure
	public void onTestFailure(ITestResult arg0) {


		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Reporter.log("<a target='_blank' href=\""+TestUtil.destFile+"\">Capture Screenshot</a>");
		System.out.println("Capture Screenshot");
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		 System.out.println("I am in onTestSkipped method ");
	     
		
	}

	// Listener for start
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	// Listener for Success
	public void onTestSuccess(ITestResult arg0) {

		
		System.out.println("Test successfully executed");
		
	}

	
	
}
