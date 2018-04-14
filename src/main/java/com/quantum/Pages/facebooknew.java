package com.quantum.Pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;


public class facebooknew extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	CommonUtilities CommonUtilities = new CommonUtilities();
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	
	@FindBy(locator ="facebooknewuser")
	private  QAFWebElement FacebookUsername;
	
	@FindBy(locator ="facebooknewpass")
	private  QAFWebElement FacebookPassword;
	
	
	@FindBy(locator ="facebookloginbtn")
	private  QAFWebElement FacebookLoginbtn;
	
	
	
	
	public QAFWebElement getFacebookUsername() {
		return FacebookUsername;
	}




	public QAFWebElement getFacebookPassword() {
		return FacebookPassword;
	}




	public QAFWebElement getFacebookLoginbtn() {
		return FacebookLoginbtn;
	}

public void Username(int rownum,int column){
	
	try {
		CommonUtilities.wait(2);
		CommonUtilities.JseHighlightTheElement(getFacebookUsername());
		String Usern = CommonUtilities.getcelldata(rownum, column);
		CommonUtilities.typeTextToTextBox(getFacebookUsername(), Usern);	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void password(int rownum,int column){
	try {
		CommonUtilities.wait(5);
		CommonUtilities.JseHighlightTheElement(getFacebookUsername());
		String Pwtbx = CommonUtilities.getcelldata(rownum, column);
		CommonUtilities.typeTextToTextBox(getFacebookPassword(), Pwtbx);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	public void clcikonbtn(){
		try {
			CommonUtilities.wait(3);
			CommonUtilities.JseHighlightTheElement(getFacebookLoginbtn());
			CommonUtilities.JseClick(getFacebookLoginbtn());
			CommonUtilities.wait(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	}


