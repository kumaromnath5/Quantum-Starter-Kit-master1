package com.quantum.Pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;

public class amazonPages extends WebDriverBaseTestPage<WebDriverTestPage> {
	CommonUtilities CommonUtilities = new CommonUtilities();
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	@FindBy(locator ="careeramazon")
	private  QAFWebElement Careeramazon;
	

	public  void amazoncareer() {
		try {
			CommonUtilities.scrollToview(Careeramazon);
			CommonUtilities.WaitUntilelementToBeClickable(Careeramazon, 2);
			//CommonUtilities.JseHighlightTheElement(Careeramazon);
			
			CommonUtilities.validateElementDisplayed(Careeramazon);
			CommonUtilities.wait(3);
			CommonUtilities.click(Careeramazon);
		} catch (Exception e) {
			//e.printStackTrace(s);
		}
	}
	
	
	
	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	

}
