package com.quantum.Pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;

public class HonerLoginFePage extends WebDriverBaseTestPage<WebDriverTestPage>  {
	CommonUtilities commonUtilities = new CommonUtilities();
	
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	@FindBy(locator="facebooknewuser")
	private QAFWebElement UNTB;
	
	@FindBy(locator = "facebooknewpass")
	private QAFWebElement PSTB;
	
	@FindBy(locator="facebookloginbtn")
	private QAFWebElement LBTN;
	
	@FindBy(locator="facebooklogout")
	private QAFWebElement LOGTB;
	
	
	public CommonUtilities getCommonUtilities() {
		
		return commonUtilities;
	}

    public QAFExtendedWebDriver getWebDriver() {
		return webDriver;
	}




	public QAFWebElement getUNTB() {
		return UNTB;
	}

	public QAFWebElement getPSTB() {
		return PSTB;
	}

	public QAFWebElement getLBTN() {
		return LBTN;
	}

	public QAFWebElement getLOGTB() {
		return LOGTB;
	}
	
	

public void usernamepassword(String arg1){
	try {
		commonUtilities.wait(2);
		commonUtilities.JseHighlightTheElement(getUNTB());
		commonUtilities.typeTextToTextBox(getUNTB(), arg1);
		commonUtilities.wait(3);
		commonUtilities.JseHighlightTheElement(getPSTB());
		commonUtilities.typeTextToTextBox(getPSTB(), arg1);
		commonUtilities.wait(4);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void Loginbutton(){
try {
	commonUtilities.JseClick(getLBTN());
	
} catch (Exception e) {
	e.printStackTrace();
}
}


















	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
