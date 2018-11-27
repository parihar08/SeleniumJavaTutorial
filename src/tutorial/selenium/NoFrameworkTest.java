package tutorial.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPage;

public class NoFrameworkTest {
	
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}


	@Test
	public void test() {
		driver.get(baseUrl);
		SearchPage.originTextBox(driver).sendKeys("New York");
		SearchPage.destinationTextBox(driver).sendKeys("Chicago");
		SearchPage.departureDateTextBox(driver).sendKeys("12/25/2018");
		SearchPage.returnDateTextBox(driver).sendKeys("12/31/2018");
		SearchPage.clickOnSearchButton(driver);
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
