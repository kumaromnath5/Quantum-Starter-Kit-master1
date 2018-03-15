package CommonUtilities;



	import java.util.concurrent.TimeUnit;

	import com.qmetry.qaf.automation.ui.WebDriverTestBase;


	public class CreateDriver {
		public void beforeScenario(String url,int timeunit){
			new WebDriverTestBase().getDriver().navigate().to(url);
			WaitForPageToLoad(timeunit);
			//new WebDriverTestBase().getDriver().manage().deleteAllCookies();
			//new WebDriverTestBase().getDriver().manage().window().maximize();
			
		}

		public void WaitForPageToLoad(int timeunit) {
			new WebDriverTestBase().getDriver().manage().timeouts().pageLoadTimeout(timeunit, TimeUnit.SECONDS);
			
		}
		public void WaitForPageToLoad1(int timeunit) {
			new WebDriverTestBase().getDriver().manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
		}
		public void PageNavigateBack(){
			new WebDriverTestBase().getDriver().navigate().back();
			WaitForPageToLoad(200);
		}

	}



