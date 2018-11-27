package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	public static WebElement element = null;
	
	public static WebElement originTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-origin-hp-package"));
		return element;
	}
		
	public static WebElement destinationTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-destination-hp-package"));
		return element;
	}
	
	public static WebElement departureDateTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-departing-hp-package"));
		// //div[@id='package-departing-wrapper-hp-package']//span[@class='label']
		// /html//input[@id='package-returning-hp-package']
		return element;
	}
		
	public static WebElement returnDateTextBox(WebDriver driver){
		element = driver.findElement(By.id("package-returning-hp-package"));
		element.clear();
		return element;
	}
	
	public static WebElement searchButton(WebDriver driver){
		element = driver.findElement(By.id("search-button-hp-package"));
		return element;
	}
	
	public static void clickOnSearchButton(WebDriver driver){
		element = searchButton(driver);
		element.click();
	}
		
	public static void navigateToFlightsTab(WebDriver driver){
		
		//driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}

}
