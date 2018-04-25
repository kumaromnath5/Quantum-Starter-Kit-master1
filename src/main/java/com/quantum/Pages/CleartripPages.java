package com.quantum.Pages;

import java.awt.AWTException;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;

public class CleartripPages extends WebDriverBaseTestPage<WebDriverTestPage> {
	CommonUtilities commonUtilities = new CommonUtilities();
	
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	@FindBy(locator="Cleartrip")
	private QAFWebElement CleartripN;
	
	@FindBy(locator="Firstsign")
	private QAFWebElement Firstsignbutt;
	
	@FindBy(locator="CleartripUser")
	private QAFWebElement Clearusername;
	
	@FindBy(locator="cleartripPass")
	private QAFWebElement Clearpass;
	
	@FindBy(locator="cleartripSigin")
	private QAFWebElement Clearsigin;
	
	@FindBy(locator="cleartripLogout")
	private QAFWebElement ClearLogout;
	
	@FindBy(locator="Framename")
	private QAFWebElement FRAM;
	
	
	public QAFWebElement getFRAM() {
		return FRAM;
	}


	public QAFWebElement getCleartripN() {
		return CleartripN;
	}


	public QAFWebElement getFirstsignbutt() {
		return Firstsignbutt;
	}




	public CommonUtilities getCommonUtilities() {
		return commonUtilities;
	}


	public QAFExtendedWebDriver getWebDriver() {
		return webDriver;
	}



	public QAFWebElement getClearusername() {
		return Clearusername;
	}

	public QAFWebElement getClearpass() {
		return Clearpass;
	}


	public QAFWebElement getClearsigin() {
		return Clearsigin;
	}



	public QAFWebElement getClearLogout() {
		return ClearLogout;
	}
	
	public void Firstcleartrip() throws InterruptedException, AWTException{
		
		commonUtilities.wait(2);
		commonUtilities.JseClick(getCleartripN());
		commonUtilities.wait(3);
		commonUtilities.JseClick(getFirstsignbutt());
		commonUtilities.wait(2);
		
		
		
	}
	
	public void usernamepassword(String UN , String PW){
		try {
			commonUtilities.Clickonchromenotification();
			commonUtilities.wait(2);
			webDriver.switchTo().frame(getFRAM());
		    commonUtilities.wait(3);
			commonUtilities.JseHighlightTheElement(getClearusername());
			commonUtilities.typeTextToTextBox(getClearusername(), UN);
			commonUtilities.wait(2);
			commonUtilities.JseHighlightTheElement(getClearpass());
			commonUtilities.typeTextToTextBox(getClearpass(), PW);
			commonUtilities.wait(3);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void loginbutt(){
		try {
			commonUtilities.JseClick(getClearsigin());
			commonUtilities.wait(3);
		    commonUtilities.switchToDefaultContent();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
public void logoutbutt(){
	try {
		commonUtilities.wait(2);
		commonUtilities.JseClick(getClearLogout());
	} catch (Exception e) {
		e.printStackTrace();
	}
}





















	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	

}
