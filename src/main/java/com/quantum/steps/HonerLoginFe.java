package com.quantum.steps;



import org.openqa.selenium.By;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.HonerLoginFePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider

public class HonerLoginFe {
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	HonerLoginFePage HonerLoginFePage = new HonerLoginFePage();
	
	
	@Given("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String arg1, String arg2) throws Throwable {
		HonerLoginFePage.usernamepassword(arg1);
		
	   
	}

	@Then("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		HonerLoginFePage.Loginbutton();
	    
	}

	@Then("^I login successfully$")
	public void i_login_successfully() throws Throwable {
	    
	}

	@Then("^I logout from Facebook page$")
	public void i_logout_from_Facebook_page() throws Throwable {
	    
	}
}
