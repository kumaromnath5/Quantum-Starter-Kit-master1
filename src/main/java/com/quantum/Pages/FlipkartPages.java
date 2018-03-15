package com.quantum.Pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;

public class FlipkartPages extends WebDriverBaseTestPage<WebDriverTestPage> {
	

	CommonUtilities CommonUtilities = new CommonUtilities();
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	@FindBy(locator ="careerflipkart")
	private  QAFWebElement Career;
	
	public  void career() {
		try {
			CommonUtilities.scrollToview(Career);
			CommonUtilities.JseHighlightTheElement(Career);
			
			CommonUtilities.validateElementDisplayed(Career);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}}
	
	
	
	
	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
