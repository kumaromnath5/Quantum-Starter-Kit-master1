package com.quantum.Pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;

public class HuaweihomepageBrand extends WebDriverBaseTestPage<WebDriverTestPage>{
	CommonUtilities CommonUtilities = new CommonUtilities();
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	
	@FindBy(locator ="brandnameclick")
	private  QAFWebElement Brandname;
	
	@FindBy(locator ="Huaweilogout")
	private  QAFWebElement LogoutBTn;
	
	
	
	public QAFWebElement getLogoutBTn() {
		return LogoutBTn;
	}

	public QAFWebElement getBrandname() {
		return Brandname;
	}
	
	public void clickonbrandname(){
		try {
			CommonUtilities.wait(3);
			CommonUtilities.JseHighlightTheElement(getBrandname());
			CommonUtilities.wait(3);
			CommonUtilities.validateElementDisplayed(getBrandname());
			CommonUtilities.wait(3);

			CommonUtilities.click(getBrandname());
			CommonUtilities.wait(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void logout(){
//		try {
//			CommonUtilities.WaitForTheVisibilityOfElement(getLogoutBTn(), 60);
//			CommonUtilities.WaitUntilelementToBeClickable(getLogoutBTn(), 60);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}



	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
