package tutorial.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPageFactory;;

public class FrameworkTest {
	
	private WebDriver driver;
	private String baseUrl;
	SearchPageFactory searchPage;

	@Before
	public void setUp() throws Exception {
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com";
		searchPage = new SearchPageFactory(driver);	
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		//searchPage.clickFlightsTab();;
		searchPage.setOriginCity("NewYork");;
		searchPage.setDestinationCity("Chicago");
		searchPage.setDepartureDate("12/25/2018");
		searchPage.setReturnDate("12/31/2018");
		searchPage.clickOnSearchButton();	
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
