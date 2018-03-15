package com.quantum.steps;





import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.facebookloginpage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class Facebooklogin {
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	facebookloginpage facebookloginpage = new facebookloginpage();
	
	@Given("^open facebook page$")
	public void open_facebook_page(String arg1) throws Throwable {
		webDriver.get("https://www.facebook.com/");
		System.err.println(webDriver.getTitle());
		Thread.sleep(2000);
	    //facebookloginpage.LoginMethod(arg1);
	}
	@Given("^Enter \"([^\"]*)\"$")
	public void enter(String arg1) throws Throwable {
		facebookloginpage.username(arg1);
	}

	

	@Given("^Enter Password$")
	public void enter_Password(String arg1) throws Throwable {
		facebookloginpage.password(arg1);
	}

	@Then("^I am on home page$")
	public void i_am_on_home_page() throws Throwable {
		facebookloginpage.Loginbutton();
	}


}
