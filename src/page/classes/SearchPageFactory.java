package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="tab-flight-tab-hp")
	WebElement flightsTab;
	
	@FindBy(id="package-origin-hp-package")
	WebElement originCity;
	
	@FindBy(id="package-destination-hp-package")
	WebElement destinationCity;
	
	@FindBy(id="package-departing-hp-package")
	WebElement departureDate;
	
	@FindBy(id="package-returning-hp-package")
	WebElement returnDate;
	
	@FindBy(id="search-button-hp-package")
	WebElement searchButton;
	
	public SearchPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);  //intElements initiates all the elements we are trying to find
												 //find all the elements defined above
	}
	
	public void clickFlightsTab(){
		flightsTab.click();
	}
	
	public void setOriginCity(String origin){
		originCity.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination){
		destinationCity.sendKeys(destination);
	}
	
	public void setDepartureDate(String depDate){
		departureDate.sendKeys(depDate);
	}
	
	public void setReturnDate(String retDate){
		returnDate.sendKeys(retDate);
	}
		
	public void clickOnSearchButton(){
		searchButton.click();
		}
	
}
