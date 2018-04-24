package com.quantum.Pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;

public class flipkartfooterPages extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	CommonUtilities CommonUtilities = new CommonUtilities();
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	@FindBy(locator ="Shippingflip")
	private  QAFWebElement Shipingfooter;
	
	@FindBy(locator ="contactu")
	private  QAFWebElement footercontactus;
	
	@FindBy(locator ="paymenttt")
	private  QAFWebElement footerpayment;
	
	public QAFWebElement getShipingfooter() {
		return Shipingfooter;
	}

	public QAFWebElement getFootercontactus() {
		return footercontactus;
	}

	public QAFWebElement getFooterpayment() {
		return footerpayment;
	}

	
	public void shipping(){
		try {
			CommonUtilities.wait(8);
			CommonUtilities.scrollToview(Shipingfooter);
			CommonUtilities.JseHighlightTheElement(getShipingfooter());
		    CommonUtilities.validateElementDisplayed(getShipingfooter());
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void contus(){
		try {
			CommonUtilities.JseHighlightTheElement(footercontactus);
			CommonUtilities.validateElementDisplayed(getFootercontactus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void payment(){
		try {
			CommonUtilities.JseHighlightTheElement(getFooterpayment());
			CommonUtilities.validateElementDisplayed(getFooterpayment());
			CommonUtilities.JseClick(getFooterpayment());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

	
}
