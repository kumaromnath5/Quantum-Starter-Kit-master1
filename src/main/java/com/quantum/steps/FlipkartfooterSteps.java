package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.FlipkartPages;
import com.quantum.Pages.flipkartfooterPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


@QAFTestStepProvider
public class FlipkartfooterSteps {
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	FlipkartPages FlipkartPages = new FlipkartPages();
	flipkartfooterPages flipkartfooterPages = new flipkartfooterPages();
	
	@Given("^I am in footer section of shiping$")
	public void i_am_in_footer_section_of_shiping() throws Throwable {
		webDriver.get("https://www.flipkart.com/");
		
		flipkartfooterPages.shipping();
	   
	}

	@Given("^verify contact us$")
	public void verify_contact_us() throws Throwable {
	    flipkartfooterPages.contus();
	}

	@Then("^verify payment$")
	public void verify_payment() throws Throwable {
	    flipkartfooterPages.payment();
	}

}
