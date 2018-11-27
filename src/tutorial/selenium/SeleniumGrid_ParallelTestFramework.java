package tutorial.selenium;

import org.testng.annotations.*;
import page.classes.TestSuiteBase;;

public class SeleniumGrid_ParallelTestFramework extends TestSuiteBase{

	@BeforeClass
	public void beforeClass() throws Exception {
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
	}

}
