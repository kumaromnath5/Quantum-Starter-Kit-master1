package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

import com.quantum.Pages.facebooknew;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
@QAFTestStepProvider
public class facebooknewStep {
	facebooknew facebooknew = new facebooknew();
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	@Given("^I enter Username$")
	public void i_enter_Username() throws Throwable {
	   
	facebooknew.Username(1, 0);
	}

	@Given("^I enter password$")
	public void i_enter_password() throws Throwable {
	    
		facebooknew.password(1, 1);
	}

	@Given("^i clcik on login button$")
	public void i_clcik_on_login_button() throws Throwable {
		facebooknew.clcikonbtn();
	    
	}

	@Then("^i am on home page$")
	public void i_am_on_home_page() throws Throwable {
		String yt = webDriver.getTitle();
		System.out.println(yt);
	    
	}
}
