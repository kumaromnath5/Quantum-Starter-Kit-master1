package CommonUtilities;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "scenarios", glue = "com.quantum.steps", tags ={"@amazonpage"}, dryRun = false, strict = false)

public class Runner extends AbstractTestNGCucumberTests {
	@Test
	public void one(){
		
	}

}
