package CommonUtilities;

	/**
	 * This CommonUtilities class has all generic methods. We can use these methods across the
	 * projects. We consider the LFG Cucumber-Selenium project as base and converted the common generic libraries of that project
	 * into Quantum framework 
	 */
	

	import static org.testng.Assert.fail;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.lang.StringUtils;
	import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.RemoteWebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	import com.google.common.base.Function;
	import com.qmetry.qaf.automation.ui.WebDriverTestBase;
	import com.qmetry.qaf.automation.ui.util.QAFWebDriverWait;
	import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
	import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
	import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
	import com.qmetry.qaf.automation.util.FileUtil;

	public class CommonUtilities implements IAutoConst  {
		public static XSSFWorkbook wb;
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		static String value;
		static FileInputStream fis;
		
		
		

		public static String beforeWindowHandle = "";
		public static String currentWindowHandle = "";
		public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
		private static final Logger LOG = Logger.getLogger(CommonUtilities.class);
		public boolean throwActionException;

		
		CreateDriver objCreateDriver= new CreateDriver();

		/**
		 * User validate current URL of page
		 * 
		 * @return true
		 */
		public boolean urlContainsSubstring(String substring) {
			LOG.info("Current URL: " + webDriver.getCurrentUrl());
			return webDriver.getCurrentUrl().contains(substring);
		}

		public void click(QAFWebElement object) {
			LOG.info("Click " + object);
			try {
				object.click();
			} catch (final Exception e) {
				e.getMessage();
			}
		}

		public boolean validateElementSelected(final QAFWebElement elementName) throws Exception, Exception {
			LOG.info("Verify expected element is displayed");
			boolean actualValue = elementName.isSelected();

			if (actualValue) {
				LOG.debug("expected element" + elementName.getText() + " is Selected");
			} else {
				throw new Exception("Object should be Selected, Object is is not Selected");
			}
			return actualValue;
		}

		public boolean validateElementNotSelected(final QAFWebElement elementName) throws Exception, Exception {
			LOG.info("Verify expected element is displayed");
			boolean actualValue = elementName.isSelected();

			if (actualValue == false) {
				LOG.debug("expected element" + elementName.getText() + " is not Selected");
			} else {
				throw new Exception("Object should not be Selected, Object is Selected");
			}
			return actualValue;
		}

		public String getText(QAFWebElement object) throws Exception {
			String value = object.getText();
			return value;
		}

		public boolean validateElementisEnabled(final QAFWebElement elementName) throws Exception, Exception {
			LOG.debug("Verify expected element is enabled");

			boolean actualValue = elementName.isEnabled();
			if (actualValue) {
				LOG.debug("Object is enabled");

			} else {

				throw new Exception("Object should be enabled,Objedct is not enabled");
			}
			return actualValue;
		}

		/**
		 * User validate current Title of page
		 * 
		 * @return true
		 */
		public boolean pageContainsTitleSubstring(String subString) {
			LOG.info("Current Title: " + webDriver.getTitle());
			return webDriver.getTitle().contains(subString);
		}

		/**
		 * User enter text in to textField
		 * 
		 */
		public void typeTextToTextBox(QAFWebElement element, String text) throws Exception {
			LOG.info("Enter text in to textField: " + text);
			clearText(element);
			element.sendKeys(text);
		}

		/**
		 * User clear text in text field
		 * 
		 */
		public void clearText(QAFWebElement element) throws Exception {
			LOG.info("Clear text in text field");
			element.clear();
		}

		/**
		 * User switch to the window
		 * 
		 */
		public void switchToNewWindow() {
			LOG.info("Switch to the window");
			try {
				System.out.println("Current window: " + webDriver.getCurrentUrl());
				for (String winHandle : webDriver.getWindowHandles()) {
					LOG.info(String.format("Window Handle - [%s].", winHandle));
					if (winHandle != webDriver.getWindowHandle()) {
						webDriver.switchTo().window(winHandle);
						webDriver.manage().window().maximize();
						LOG.info("Getting new window: " + webDriver.getCurrentUrl());
						System.out.println("Getting new window: " + webDriver.getCurrentUrl());
					}
				}
			} catch (final NoSuchElementException e) {
				LOG.error("Expected window handle is not present");
				return;
			}

		}

		/**
		 * User moving focus to parent window
		 * 
		 */
		public void moveFocusToParentWindow() throws Exception {
			final Set<String> handles = webDriver.getWindowHandles();
			final String firstWinHandle = webDriver.getWindowHandle();

			handles.remove(firstWinHandle);
			try {

				LOG.info("Moving focus to parent window");
				final String secondWinHandle = (String) handles.iterator().next();

				if (secondWinHandle != firstWinHandle) {
					Thread.sleep(2000);
					webDriver.switchTo().window(secondWinHandle);
					Thread.sleep(2000);
					webDriver.switchTo().window(firstWinHandle);
					Thread.sleep(2000);
				}
			} catch (final NoSuchElementException e) {
				LOG.error("Not focused to parent window");
				return;
			}
		}

		/**
		 * Switching to default content
		 * 
		 */
		public void switchToDefaultContent() {
			LOG.info("Switching to default content");
			webDriver.switchTo().defaultContent();
		}

		/**
		 * Switching back to previous window
		 * 
		 */
		public void switchBackToPreviousWindow() {
			LOG.info("Switching back to previous window");
			webDriver.navigate().back();
		}

		/**
		 * User Get screenshot on page
		 * 
		 * @param filePath
		 *            Describes path to save the screenshots
		 */
		public void getScreenShot(String filePath) {

			LOG.info("Get screenshot on page");
			try {
				File tempFile, destinationFile;
				destinationFile = new File(filePath);
				TakesScreenshot myScreenshot = (TakesScreenshot) webDriver;
				tempFile = myScreenshot.getScreenshotAs(OutputType.FILE);
				LOG.info(String.format("copy file from - [%s] to destination - [%s].", tempFile, destinationFile));
				FileUtil.copyFile(tempFile, destinationFile);
			} catch (WebDriverException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Select expected value from drop down
		 * 
		 * @param webElement
		 *            Describe web element of a select drop down
		 * @param actualSelectText
		 *            Actual text to select in drop down
		 */
		public void selectDropdown(QAFWebElement webElement, String actualSelectText) {
			LOG.info(String.format("Select expected value - [%s] from dropdown", actualSelectText));
			Select dropDown = new Select(webElement);
			int flag = 0;
			try {
				if (!dropDown.isMultiple()) {
					List<WebElement> dropDownCategories = dropDown.getOptions();
					for (WebElement dropDownCategory : dropDownCategories) {
						if (dropDownCategory.getText().equals(actualSelectText)) {
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						dropDown.selectByVisibleText(actualSelectText);
					}
				}
			} catch (Exception e) {
				LOG.error(String.format("Expected value - [%s] is not present in dropdown", actualSelectText));
			}

		}

		/**
		 * User Click on expected link text
		 * 
		 */
		public void ClickText(final String text) throws Exception {
			LOG.info(String.format("Click on expected link text - [%s] .", text));
			webDriver.findElement(By.linkText(text)).click();
		}

		/**
		 * User Wait for some time to visible element
		 * 
		 */
		public void wait(int object) throws InterruptedException {
			LOG.info("Wait for some time");
			TimeUnit.SECONDS.sleep(object);
		}

		/**
		 * Refresh current window
		 * 
		 */
		public void refresh_success() throws Exception {
			LOG.info("Refresh current window");
			webDriver.navigate().refresh();
		}

		/**
		 * Close current window browser
		 * 
		 */
		public void close_success() throws Exception {
			LOG.info("Close current window browser");
			webDriver.close();
		}

		/**
		 * Quit all browsers opened through web driver
		 * 
		 */
		public void quit_success() throws Exception {
			LOG.info("Quit all browsers opened through webdriver");
			webDriver.quit();
		}

		/**
		 * Validate title of the web page
		 * 
		 */
		public String getPageTitle_success() throws Exception {
			String title = null;
			try {
				title = webDriver.getTitle();
				LOG.info(String.format("User get the title as - [%s].", title));
				fail();
			} catch (Exception e) {
				return null;
			}
			return title;
		}

		/**
		 * User getting the current URL
		 * 
		 * @return current url
		 */
		public String getCurrentUrl() {
			LOG.info("User getting the current URL");
			return webDriver.getCurrentUrl();
		}

		/**
		 * Validate user maximize the window
		 * 
		 */
		public void maximizeWindow_exception() throws Exception {
			LOG.info("Validate user maximize the window");
			try {
				webDriver.manage().window().maximize();
				fail();
			} catch (Exception e) {
				return;
			}
		}

		/**
		 * Switching to expected frame Id name
		 * 
		 * @param frameName
		 *            Describes frame tag name
		 * @param expectedFrameID
		 *            Described frame id name to switch
		 */
		public void switchToFrameByID(final String frameName, String expectedFrameID) {
			LOG.info(String.format("Switch to expected frame with frameID name - [%s]", expectedFrameID));
			List<QAFWebElement> frameToSelect = new WebDriverTestBase().getDriver().getElements(By.tagName(frameName));

			int flag = 0;

			for (int i = 0; i <= frameToSelect.size(); i++) {
				String actualFrameID = frameToSelect.get(i).getAttribute("id");
				if (expectedFrameID.equals(actualFrameID)) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				webDriver.switchTo().frame(expectedFrameID);
			}

		}

		/**
		 * Switching to expected frame Id index
		 * 
		 * @param frameName
		 *            Describes frame tag name
		 * @param frameIndex
		 *            Described index number of a frame to switch
		 */
		public void switchToFrameByIndex(final String frameName, final int frameIndex) {
			LOG.info(String.format("Switching to expected frame Id index - [%s]", frameIndex));
			List<QAFWebElement> frameToSelect = new WebDriverTestBase().getDriver().getElements(By.tagName(frameName));
			try {
				webDriver.switchTo().frame(frameToSelect.get(frameIndex));
			} catch (Exception e) {
				e.getMessage();
			}
		}

		/**
		 * Execute user action
		 * 
		 */
		public void executeAction(final Actions action) {
			LOG.info("Exceute user action");
			if (throwActionException) {
				throw new TimeoutException("Throwing test Exception as directed");
			}
		}

		/**
		 * User moving action to expected element
		 * 
		 */
		public void moveToObject(final QAFWebElement element) throws Exception {
			LOG.info("User moving action to expected element");
			final Actions action = new Actions(webDriver);
			final Action performAction;
			performAction = action.moveToElement(element).build();
			performAction.perform();
			executeAction(action);
		}

		/**
		 * Validate User moving action to page down
		 * 
		 */
		public void pageDown_exception() throws Exception {
			try {
				pageDown();
				fail();
			} catch (Exception e) {
				LOG.error("unable to move action to down");
				return;
			}

		}

		/**
		 * Validate User moving action to page up
		 * 
		 */
		public void pageUp_exception() throws Exception {
			try {
				pageUp();
				fail();
			} catch (Exception e) {
				LOG.error("unable to move action to up");
				return;
			}

		}

		/**
		 * User moving action to page down
		 * 
		 */
		public void pageDown() throws Exception {
			LOG.info("User moving action to page down");
			final Actions action = new Actions(webDriver);
			action.sendKeys(Keys.PAGE_DOWN);
			executeAction(action);
		}

		/**
		 * User moving action to page up
		 * 
		 */
		public void pageUp() throws Exception {
			LOG.info("User moving action to page up");
			final Actions action = new Actions(webDriver);
			action.sendKeys(Keys.PAGE_UP);
			executeAction(action);
		}

		/**
		 * Open link in a new window
		 * 
		 * @param element
		 *            describes WebElement of a link/button to click
		 * 
		 */
		public void openLinkInNewWindow(final QAFWebElement element) throws Exception {
			LOG.info("User clicks and open link in new window");
			final Actions action = new Actions(webDriver);
			action.keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).build().perform();
		}

		/**
		 * Get all page source objects
		 */
		public String getPageSource() throws Exception {
			LOG.info("Getting all page source object in current window");
			return webDriver.getPageSource();
		}

		/**
		 * Delete all cookies
		 */
		public void deleteAllCookies() throws Exception {
			LOG.info("Delete all cookies");
			webDriver.manage().deleteAllCookies();
		}

		/**
		 * Convert the passed String to a long. If the conversion is not successful,
		 * return the default value.
		 * 
		 * @param value
		 *            String value to be converted to a long. Null-safe
		 * @return long representation of String value if String can successfully be
		 *         converted. Otherwise return defaultValue
		 */
		public static long toLong(final String value) {
			LOG.info("Convert the passed String to a long. If the conversion is not successful, return the default value.");
			try {
				return new Long(value).longValue();
			} catch (final Exception e) {
				return 0;
			}
		}

		/**
		 * Convert the passed String to an integer value. If the conversion is not
		 * successful, return the default value.
		 * 
		 * @param value
		 *            String value to be converted to an int. Null-safe
		 * @return Integer representation of String value if String can successfully be
		 *         converted. Otherwise return defaultValue
		 */
		public static int toInt(final String value) {
			LOG.info(
					"Convert the passed String to an integer value. If the conversion is not successful, return the default value.");
			try {
				return new Integer(value).intValue();
			} catch (final Exception e) {
				return 0;
			}
		}

		public void validateAllLinks(String domainname) {
			LOG.info("Inside broken link method1");
			HttpURLConnection huc = null;
			int responseCode;
			String url = null;
			// switchToNewWindow();
			List<QAFWebElement> links = new WebDriverTestBase().getDriver().getElements(By.tagName("a"));
			Iterator<QAFWebElement> iterator = links.iterator();
			while (iterator.hasNext()) {
				LOG.info("Inside broken link method2");
				url = ((RemoteWebElement) iterator.next()).getAttribute("href");
				if (!url.startsWith("javascrript")) {
					LOG.info("URL : " + url);
					if (url == null || url.isEmpty()) {
						LOG.info(url + "- is either not configured for anchor tag or it is empty");
						continue;
					}
					if (!url.startsWith(domainname)) {
						LOG.info(url + "-URL belongs to another domain, skipping it.");
						continue;
					}
					try {
						huc = (HttpURLConnection) (new URL(url).openConnection());
						huc.setRequestMethod("GET");
						huc.connect();
						responseCode = huc.getResponseCode();
						LOG.info("Response code : " + responseCode);
						if (responseCode >= 400) {
							LOG.info("url is a broken link : " + url);
						} else {
							LOG.info("url is a valid link : " + url);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		public void checkCookie(final String object) throws Exception {

			try {
				Set<Cookie> cookiesForCurrentURL = new WebDriverTestBase().getDriver().manage().getCookies();
				for (Cookie cookie : cookiesForCurrentURL) {
					System.out.println(" Cookie Name - " + cookie.getName() + " Cookie Value - " + cookie.getValue());
					String output = " " + cookie.getValue();

					if (object.equalsIgnoreCase(output)) {
						System.out.println(
								" Cookie Name - " + cookie.getName() + " Equals Cookie Value - " + cookie.getValue());
						Assert.assertEquals(object, output);
						break;
					}

				}
			} catch (final Exception e) {
				e.getMessage();
			}
		}

		public void moveSlider(final String object) throws Exception {

			LOG.info("Moving the slider to some position --");
			try {
				WebElement element = getElementWithoutWait(object);
				Actions action = new Actions(webDriver);
				action.click(element).build().perform();
				Thread.sleep(1000);
				action.sendKeys(Keys.ARROW_LEFT).build().perform();
				Thread.sleep(100);
				action.sendKeys(Keys.ARROW_RIGHT).build().perform();

			} catch (final Exception e) {
				e.printStackTrace();
			}

		}

		/**
		 * Get the specified web element. If not found, returns
		 * 
		 * @param object
		 *            Web element to be retrieved
		 * 
		 * @return WebElement for the specified object if it exists. Null if an error
		 *         occurs or element can't be found.
		 */
		public QAFWebElement getElementWithoutWait(final String object) {

			try {
				LOG.debug("Getting element " + object);
				final QAFWebElement element = (QAFWebElement) new WebDriverTestBase().getDriver()
						.getElements(By.xpath(object));
				LOG.debug("Got element " + object);
				return element;
			} catch (final Exception e) {
				LOG.debug("Could not get element " + object + ", returning  " + e.getMessage());
				return null;
			}
		}

		/**
		 * Verify that the passed object is of a specified size.
		 * 
		 * @param object
		 *            Web element to be validated
		 * @param expectedSize
		 *            Expected size in format widthXheight (e.g. "10X100" for width=10
		 *            and height=100)
		 * @throws Exception
		 */
		public void validateElementSize(final QAFWebElement object, final String expectedSize) throws Exception {

			String actualSize = null;
			try {

				actualSize = object.getSize().toString();
				LOG.debug("Size='" + actualSize + "'");
			} catch (final Exception e) {

				return;
			}

			if (StringUtils.equals(actualSize, expectedSize)) {
				LOG.debug("Image size for " + object + " is correct");
			} else {
				throw new Exception("Image size is not eqaul");
			}
		}

		/**
		 * Verify that the passed object Text is present.
		 * 
		 * @param object
		 *            Web element to be validated
		 * @throws Exception
		 */
		public void verifyTextPresent(final String object) throws Exception {
			try {
				LOG.info("Verifiy text is present in a webPage");
				String Verifytext = new WebDriverTestBase().getDriver().findElement(By.tagName("body")).getText().trim();
				Assert.assertTrue(Verifytext.contains(object));
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Verify expected element is not displayed.
		 * 
		 * @param object
		 *            Web element to be validated
		 * @throws Exception
		 */
		public boolean validateElementNotDisplayed(final QAFWebElement elementName) throws Exception {

			LOG.info("Verify expected element is not displayed");
			boolean actualValue = elementName.isDisplayed();
			if (!actualValue) {
				LOG.debug("expected element" + elementName.getText() + " is not present");
			} else {
				throw new Exception("Object should not present ,but Object is present");
			}

			return actualValue;
		}

		/**
		 * Verify expected element is displayed.
		 * 
		 * @param object
		 *            Web element to be validated
		 * @throws Exception
		 */
		public boolean validateElementDisplayed(final QAFWebElement elementName) throws Exception, Exception {
			LOG.info("Verify expected element is displayed");
			boolean actualValue = elementName.isDisplayed();

			if (actualValue) {
				LOG.debug("expected element" + elementName.getText() + " is present");
			} else {
				throw new Exception("Object should be displayeddd, Object is is not displaying");
			}
			return actualValue;
		}

		/**
		 * Verify expected element is disable.
		 * 
		 * @param object
		 *            Web element to be validated
		 * @throws Exception
		 */
		public boolean validateElementisDisable(final QAFWebElement elementName) throws Exception, Exception {
			LOG.debug("Verify expected element is disable");

			boolean actualValue = elementName.isEnabled();
			if (!actualValue) {
				LOG.debug("expected element" + elementName.getText() + " is present");

			} else {
				throw new Exception("Object should be in disable,Object is Enable");

			}
			return actualValue;
		}

		/**
		 * Verify if actual value in same as entered value
		 * 
		 * @param object
		 *            Web element to be validated
		 * @throws Exception
		 */
		public void validateText(QAFWebElement object, String value_Entered) throws Exception {
			LOG.info("Checking if value in  " + object + " is same as value entered");
			String value = object.getAttribute("value");
			if (value.equalsIgnoreCase(value_Entered)) {
				LOG.info("Enterd value is appearing in the page");
			} else {
				throw new Exception("Text should be same ,Text values are not matching");
			}

		}

		/**
		 * Verify if actual value in and are same
		 * 
		 * @param object1
		 *            First Web element to be validated
		 * @param object2
		 *            Second Web element to be validated
		 * @throws Exception
		 */
		public void ValidateText_object1_Object2(final QAFWebElement object1, final QAFWebElement object2)
				throws Throwable {

			LOG.info("Checking if value in  " + object1.getText() + " and  " + object2.getText() + " are same ");

			String actualtext = object1.getText();
			String expectedtext = object2.getText();

			if (actualtext.equalsIgnoreCase(expectedtext)) {

				LOG.info("value in  " + object1.getText() + " and " + object2.getText() + " are same");
			} else {
				throw new Exception(
						object1.getText() + "and" + object2.getText() + "Text should be same, Text are not matching");
			}

		}

		// method to validate the broken links response code
		public int VerifyBrokenLink(QAFExtendedWebElement qafWebElement) {

			HttpURLConnection huc = null;
			int respCode = 200;
			String url;

			// WebElement links = new
			// WebDriverTestBase().getDriver().findElement(By.linkText(xpath));

			url = qafWebElement.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");

			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.connect();
				respCode = huc.getResponseCode();
			} catch (Exception e) {

				e.printStackTrace();
			}

			return respCode;

		}

		// Method to close the newly opened tab while verify all the link clicks and its
		// navigation to new screen
		public void CloseNewTabOpened() throws InterruptedException {

			String parentHandle = new WebDriverTestBase().getDriver().getWindowHandle();

			Set<String> win = new WebDriverTestBase().getDriver().getWindowHandles();
			Iterator<String> it = win.iterator();

			if (win.size() > 1) {
				while (it.hasNext()) {
					String handle = it.next();
					if (!handle.equalsIgnoreCase(parentHandle)) {
						new WebDriverTestBase().getDriver().switchTo().window(handle);
						new WebDriverTestBase().getDriver().close();

					}
				}
			}
			new WebDriverTestBase().getDriver().switchTo().window(parentHandle);

		}

		public void Highlighting_Element(QAFExtendedWebDriver qafExtendedWebDriver, QAFWebElement header) throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) qafExtendedWebDriver;
			for (int iCnt = 0; iCnt < 2; iCnt++) {
				js.executeScript("arguments[0].style.border='5px dotted red';", header);

				Thread.sleep(700);
				js.executeScript("arguments[0].style.border=''", header);
			}

		}

		public QAFExtendedWebElement getElement(String loc) {
			return new QAFExtendedWebElement(loc);
		}

//		public void clickingelement(QAFWebElement element) {
//			JavascriptExecutor executor = (JavascriptExecutor) new WebDriverTestBase().getDriver();
//			executor.executeScript("arguments[0].click();", element);
//			objCreateDriver.waitForPageLoad(TestData.LONG_TIMEOUT);
//
//		}

		public void ValidatePresenceOfElement(List<QAFWebElement> all) throws Exception

		{
			int a = all.size();
			if (a > 0) {
				throw new Exception("Element is Displayed");
			}
		}

		public String getRandomText(int length) {
			LOG.info("Generating Random Text");
			String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");

			int n = alphabet.length();
			String result = new String();
			Random r = new Random();

			for (int i = 0; i < length; i++) {
				result = result + alphabet.charAt(r.nextInt(n));
			}
			LOG.info("Generating Random Text" + result);
			return result;

		}

		public String getRandomNumber(int length) {
			LOG.info("Generating Random Text");
			String alphabet = new String("0123456789");

			int n = alphabet.length();
			String result = new String();
			Random r = new Random();

			for (int i = 0; i < length; i++) {
				result = result + alphabet.charAt(r.nextInt(n));
			}
			LOG.info("Generating Random number");
			return result;

		}

		public String getRandomEmailId() {
			LOG.info("Generating Random emailid");
			String emailid = getRandomText(10) + "@" + getRandomText(3) + ".com";
			LOG.info("Generating Random emailid" + emailid);
			return emailid;
		}

		public void scrollToview(QAFWebElement element) {
			LOG.info("Scrolling to the Eelement" + element);
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void JseHighlightTheElement(QAFWebElement header) throws Exception {
			LOG.info("Highlightging the Element " + header);
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			for (int iCnt = 0; iCnt < 2; iCnt++) {
				js.executeScript("arguments[0].style.border='5px dotted red';", header);

			}

		}

		public void JseClick(QAFWebElement element) {
			try {
				LOG.info("Clicking on the Element " + element);
				JavascriptExecutor executor = (JavascriptExecutor) webDriver;
				executor.executeScript("arguments[0].click();", element);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		public void JseMouseOver(QAFWebElement element) {
			LOG.info("Mouse overing to the Element " + element);
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			executor.executeScript("arguments[0].onmouseover()", element);
		}

		public QAFWebElement FluientWait(final String Ele, int timeOut) {

			Wait<QAFExtendedWebDriver> wait = new FluentWait<QAFExtendedWebDriver>(webDriver);

			((FluentWait<QAFExtendedWebDriver>) wait).withTimeout(timeOut, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			@SuppressWarnings("unused")
			QAFWebElement ele = wait.until(new Function<QAFExtendedWebDriver, QAFWebElement>() {

				@Override
				public QAFWebElement apply(QAFExtendedWebDriver input) {

					return webDriver.findElement(Ele);

				}
			});

			return webDriver.findElement(Ele);
		}

		public void WaitUntilelementToBeClickable(QAFWebElement Ele, int timeOut) {
			LOG.info("ExplicitWait for the Element " + Ele + "With the timeout " + timeOut);
			Wait<QAFExtendedWebDriver> wait = new QAFWebDriverWait(timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(Ele));

		}

		public void WaitForTheVisibilityOfElement(QAFWebElement Ele, int timeOut) {
			LOG.info("WaitForTheVisibilityOfElement " + Ele + "With the timeout " + timeOut);
			Wait<QAFExtendedWebDriver> wait = new QAFWebDriverWait(timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(Ele));

		}

		public void RobotMouseOver(QAFWebElement element) throws AWTException {
			LOG.info("Mouse overing to the Element " + element);
			Point point = element.getLocation();
			Robot Robot = new Robot();
			Robot.mouseMove(point.getX(), point.getY());

		}

		public void selectDropDown(QAFWebElement webElement, int index) {
			Select dropDown = new Select(webElement);
			try {
				dropDown.selectByIndex(index);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		public void validatemessagepresent(QAFWebElement object, String value_Entered) throws Exception {
			LOG.info("Checking if value in  " + object + " is same as value entered");
			String value = object.getText();
			if (value.equalsIgnoreCase(value_Entered)) {
				LOG.info("Enterd value is appearing in the page");
			} else {
				throw new Exception("Text should be same ,Text values are not matching");
			}
		}
		public void ClickonPrinticonAndEsc() throws AWTException {
			LOG.info("esc on click print "  );
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		}

	public void moveFocusToParentWindow1() throws Exception {

		final Set<String> handles = webDriver.getWindowHandles();
		LOG.info("Switch to recent window");
		for (String obj : handles) {

			webDriver.switchTo().window(obj);

			System.out.println(obj);

		}

	}

	public void CaptureC() {

		beforeWindowHandle = webDriver.getWindowHandle();
		LOG.info("Capturing the window of current control");

	}

	public void Moveback() {

		webDriver.switchTo().window(beforeWindowHandle);
		LOG.info("move again to parent window");

	}
	// to get value from excel sheet to application
		public  String getcelldata(int rownum ,int column) throws IOException{
			
			fis = new FileInputStream(XLPATH);
			
			 wb= new XSSFWorkbook(fis);
			 sheet = wb.getSheet(SheetTABname);
			row = sheet.getRow(rownum);
			 cell = row.getCell(column);
			return value = cell.getStringCellValue();
			
		}
		public void scrollToWebElement(WebElement element){
			LOG.info("scroll to element by getting its x & y axis");
			int x= element.getLocation().x;
			int y = element.getLocation().y;
			JavascriptExecutor js = (JavascriptExecutor)webDriver;
			//substracting 150 pixel for adjustment
			js.executeScript("scroll"+ x +","+(y-150) +")");
			
			
		}
		public void ExplicitwaitForVisiblity(String Xpath){
			LOG.info("Explicitly wait for element");
			WebDriverWait wait = new WebDriverWait(webDriver, 60);
			wait.until(ExpectedConditions.visibilityOf(webDriver.findElementByXPath(Xpath)));
			LOG.info("Got the element");
			}
		public void ExplicitwaitForINVisiblity(String Xpath){
			LOG.info("Explicitly wait for element");
			WebDriverWait wait = new WebDriverWait(webDriver, 60);
			wait.until(ExpectedConditions.invisibilityOfAllElements(webDriver.findElementsByXPath(Xpath)));
			LOG.info("element is invisible");
		}
		public void AssertEquals(String exp, String act){
			LOG.info("Asserting text for element");
			if(exp.equals(act)){
				LOG.info("Assert text pass");
				
				
			}else{
				try {
					throw new Exception("Assert Text Fail");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		public void FocusOutOfTextBox(QAFWebElement ELE){
			LOG.info("Moving the focus out"+ ELE);
			ELE.sendKeys(Keys.TAB);
		}
       public String getRandomSpecialChar(int length){
    	   LOG.info("Generating Random Special Char");
    	   String alphabet = new String("!@#$%^&*()++==[]{}|?:");
    	   int n= alphabet.length();
    	   String result = new String();
    	   Random r = new Random();
    	   for(int i = 0;i< length;i++){
    		   result=result+alphabet.charAt(r.nextInt(n));
    		   }
    	   LOG.info("Generating Random text"+ result);
    	  return  result;
			
		}
       public void selectfromDropdownList(QAFWebElement webElement, String Text) {
    	   
    	   LOG.info("SELECT FROM DROPDOWN BY TEXT");
    	   Select Select = new Select(webElement);
    	   Select.selectByVisibleText(Text);
       }
       
      public String popupAcceptAllert(){
    	  LOG.info("accept allert popup success");
    	   String alert = webDriver.switchTo().alert().getText();
    	  webDriver.switchTo().alert().accept();
    	  return alert;
    	}
      
      public String PopupDismissAllert(){
    	  LOG.info("Dismiss allert popup success");
    	   String alertdismiss = webDriver.switchTo().alert().getText();
    	  webDriver.switchTo().alert().dismiss();
    	  return alertdismiss;
    	}
      
      public void Clickonchromenotification() throws AWTException {
			LOG.info("dismiss chrome notification "  );
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		}

      
	}
	
	


