package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.amazonPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class amazonSteps {
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	amazonPages amazonPages = new amazonPages();
	@Given("^I am amazon home page$")
	public void i_am_amazon_home_page() throws Throwable {
	    webDriver.get("https://www.amazon.in");
    
	}

	@Given("^verify the title of amazon home page$")
	public void verify_the_title_of_amazon_home_page() throws Throwable {
		String title = webDriver.getTitle();
		System.err.println(title);
	    
	}

	@Then("^verify carrier of the page$")
	public void verify_carrier_of_the_page() throws Throwable {
		amazonPages.amazoncareer();
	    
	}



}
