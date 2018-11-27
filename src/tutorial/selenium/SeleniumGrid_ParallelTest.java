package tutorial.selenium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import page.classes.SearchPageFactory;;

public class SeleniumGrid_ParallelTest {
	
	private WebDriver driver;
	private String baseUrl;
	private String nodeUrl;
	SearchPageFactory searchPage;

	@BeforeClass
	public void setUp() throws Exception {
		
		baseUrl = "https://www.expedia.com";
		nodeUrl = "http://10.0.0.121:5555/wd/hub";
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.MAC);
		driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		
		
		searchPage = new SearchPageFactory(driver);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void searchFlights() throws Exception {
		
		//searchPage.clickFlightsTab();;
		searchPage.setOriginCity("NewYork");;
		searchPage.setDestinationCity("Chicago");
		searchPage.setDepartureDate("12/25/2018");
		searchPage.setReturnDate("12/31/2018");
		searchPage.clickOnSearchButton();	
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
