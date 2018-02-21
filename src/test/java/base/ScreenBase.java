package base;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

// Base class for objects and common methods
public class ScreenBase extends TestBase{


	// Ebay Application locators define here
	@AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
	protected
	WebElement Signin;

	@AndroidFindBy(id="com.ebay.mobile:id/home")
	protected WebElement MainMenu;

	@AndroidFindBy(id="com.ebay.mobile:id/design_menu_item_text")
	protected WebElement Home;

	@AndroidFindBy(id="com.ebay.mobile:id/recycler_view_main")
	protected WebElement bottomElement;

	@AndroidFindBy(id="com.ebay.mobile:id/button_all_collections")
	protected MobileElement MorebottomElement;

	@AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
	protected  WebElement UserName;

	@AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
	protected WebElement Password;

	@AndroidFindBy(id="com.ebay.mobile:id/search_box")
	protected WebElement SearchBoxIcon;

	@AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
	protected WebElement SearchTextbox;

	@AndroidFindBy(id="com.ebay.mobile:id/text")
	protected WebElement ProdSugg;


	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_title")
	protected WebElement ProductDesc;

	@AndroidFindBy(id="com.ebay.mobile:id/menu_search")
	protected WebElement SearchIcon;

	@AndroidFindBy(id="com.ebay.mobile:id/cell_collection_item")
	protected WebElement Product;

	@AndroidFindBy(id="com.ebay.mobile:id/button_bin")
	protected WebElement Buyitnow;

	@AndroidFindBy(id="com.ebay.mobile:id/take_action")
	protected WebElement Review;

	@AndroidFindBy(id="proceedToPay")
	protected WebElement proceedToPayButton;


	@AndroidFindBy(id="com.ebay.mobile:id/home")
	protected WebElement close;

	@AndroidFindBy(id="com.ebay.mobile:id/textview_sign_in_status")
	protected WebElement SigninMenu;

	@AndroidFindBy(id="com.ebay.mobile:id/design_menu_item_text")
	protected WebElement Signout;

	@AndroidFindBy(id="android:id/button1")
	protected WebElement SingouOk;

	public static WebDriver drivers;
	public AppiumDriver<MobileElement> driver;

	public WebDriverWait wait;


	// Function to  initialize driver
	public ScreenBase(AppiumDriver<MobileElement> driver){

		logger4j.debug("initlizae driver");
		this.driver = driver;

	}

	// Function for explicit wait

	public void waitforElement(long duration, String locator){

		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));


	}

	// Function to hide keyboard
	public void hideKeyboard(){

		driver.hideKeyboard();
	}


	// Function for swipe

	public boolean swipeToDirection( MobileElement Element, String direction) {
		try {

			logger4j.debug("Execution startedfor swipe");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> swipeObject = new HashMap<String, String>();
			if (direction.equals("d")) {
				System.out.println("before down");
				swipeObject.put("direction", "down");
				System.out.println("down");

			} else if (direction.equals("u")) {
				swipeObject.put("direction", "up");
			} else if (direction.equals("l")) {
				swipeObject.put("direction", "left");
			} else if (direction.equals("r")) {
				swipeObject.put("direction", "right");
			}
			swipeObject.put("element", Element.getAttribute("height"));
			js.executeScript("mobile:swipe", swipeObject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Function for click
	public void Click(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element ");
				element.click();


			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}


	// Function for wait
	public void waitMethod(int time) {
		try {
			logger4j.debug("Execution startedfor wait");

			Thread.sleep(time);
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
	}




}	





