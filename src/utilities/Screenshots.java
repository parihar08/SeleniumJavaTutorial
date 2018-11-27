package utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshots {
	
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//find Elements    //button[@id='tab-flight-tab-hp']/span[@class='tab-label']
		
		WebElement flight_origin = driver.findElement(By.id("package-origin-hp-package"));
		WebElement flight_destination = driver.findElement(By.id("package-destination-hp-package"));
		WebElement departure_date = driver.findElement(By.id("package-departing-wrapper-hp-package"));
		WebElement return_date = driver.findElement(By.id("package-returning-hp-package"));
		WebElement search = driver.findElement(By.id("search-button-hp-package"));
	
		//send data to the elements
		
		flight_origin.sendKeys("New York");
		flight_destination.sendKeys("Calgary");
		departure_date.sendKeys("10/13/2018");
		return_date.clear();
		return_date.sendKeys("11/13/2018");
		search.click();
	}
	
	public static String getRandomString(int length){
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for(int i=0;i<length;i++){
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();		
	}
	
	@After
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "//Users//Parihar08//Desktop";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		
	
		Thread.sleep(3000);
		driver.quit();
	}
	
}
