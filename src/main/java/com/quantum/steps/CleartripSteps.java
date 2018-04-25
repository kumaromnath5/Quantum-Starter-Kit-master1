package com.quantum.steps;

import org.openqa.selenium.Alert;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.CleartripPages;

import CommonUtilities.CommonUtilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CleartripSteps {
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	CleartripPages CleartripPages = new CleartripPages();
	
	
	@Given("^i am on cleartrip home page$")
	public void i_am_on_cleartrip_home_page() throws Throwable {
		webDriver.get("https://www.cleartrip.com/");
		
		
		    
	}

	@Given("^i enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String arg1, String arg2) throws Throwable {
		CleartripPages.Firstcleartrip();
		CleartripPages.usernamepassword(arg1, arg2);
	    	}

	@Then("^i login successfully$")
	public void i_login_successfully() throws Throwable {
		CleartripPages.loginbutt();
	   	}

	@Then("^i logout successfully from cleartrip application$")
	public void i_logout_successfully_from_cleartrip_application() throws Throwable {
		CleartripPages.logoutbutt();
	    
	}

}
