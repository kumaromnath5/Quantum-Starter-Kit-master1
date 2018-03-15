package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.FlipkartPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class FlipkartSteps {
	
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	FlipkartPages FlipkartPages = new FlipkartPages();
	@Given("^i am on flipkart home page$")
	public void i_am_on_flipkart_home_page() throws Throwable {
		webDriver.get("https://www.flipkart.com/");
	    
	}

	@Given("^verify tittle of page$")
	public void verify_tittle_of_page() throws Throwable {
		String titl = webDriver.getTitle();
		System.err.println(titl);
	    
	}

	@Then("^verify career$")
	public void verify_career() throws Throwable {
		FlipkartPages.career();
		
	    
	}
}
