package com.quantum.Pages;




import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import CommonUtilities.CommonUtilities;
import CommonUtilities.Excell;




public class facebookloginpage extends WebDriverBaseTestPage<WebDriverTestPage>  {
	
	
	

	CommonUtilities CommonUtilities = new CommonUtilities();
	public QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	Excell Excell = new Excell();
	
	
	@FindBy(locator ="facebook.Usernamefield")
	private  QAFWebElement UnTB;
	
	public QAFWebElement getUnTB() {
		return UnTB;
	}

	public QAFWebElement getPwTB() {
		return PwTB;
	}

	public QAFWebElement getLoginBTN() {
		return LoginBTN;
	}

	@FindBy(locator ="facebook.Passwordfield")
	private  QAFWebElement PwTB;
	
	@FindBy(locator ="facebook.LoginButton")
	private  QAFWebElement LoginBTN;
	
	public  void username(String Uname) {
		try {
			CommonUtilities.WaitForTheVisibilityOfElement(getUnTB(), 60);
			CommonUtilities.typeTextToTextBox(getUnTB(), Uname);
			CommonUtilities.JseHighlightTheElement(UnTB);
			String un = Excell.getcelldata(2, 0);
			System.err.println(un);

			CommonUtilities.typeTextToTextBox(getUnTB(), un);
			System.err.println(un);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public  void password (String pwd){
			try {
				CommonUtilities.typeTextToTextBox(getPwTB(), pwd);
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			}
	public  void Loginbutton(){
		try {
			CommonUtilities.JseHighlightTheElement(getLoginBTN());
			CommonUtilities.JseClick(LoginBTN);
			Excell.getcelldata(rownum, col)
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
		
		}

