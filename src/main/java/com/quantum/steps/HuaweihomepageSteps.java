package com.quantum.steps;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.Pages.HuaweihomepageBrand;

import CommonUtilities.TestData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
@QAFTestStepProvider
public class HuaweihomepageSteps {
	
	
	public static QAFExtendedWebDriver webDriver = new WebDriverTestBase().getDriver();
	
	HuaweihomepageBrand HuaweihomepageBrand =new HuaweihomepageBrand();
	
	@Given("^I am on huaweiHonor home page of India$")
	public void i_am_on_huaweiHonor_home_page_of_India() throws Throwable {
	PrintStream ps = new PrintStream(new FileOutputStream("MyLog.txt"));
	System.setOut(ps);
	    webDriver.get(TestData.UAT_URL);
	    //webDriver.manage().window().maximize();
	}

	@Given("^I verify the tittle of page$")
	public void i_verify_the_tittle_of_page() throws Throwable {
		String Tittle = webDriver.getTitle();
		System.err.println(Tittle);
	    
	}

	@Then("^I click on Brand name on home page$")
	public void i_click_on_Brand_name_on_home_page() throws Throwable {
		HuaweihomepageBrand.clickonbrandname();
	    
	}

	@Then("^I log out of application$")
	public void i_log_out_of_application() throws Throwable {
		//HuaweihomepageBrand.logout();
	    
	}
}
