package usefulmethods;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethodsOld;

public class ElementsListDemo {
	
	private WebDriver driver;
	private String baseUrl;
	private GenericMethodsOld gm;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethodsOld(driver);
		//Maximize the browser the window
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	
	@Test
	public void testMethod() throws Exception {
		driver.get(baseUrl);
		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
		int size = elementList.size();
		System.out.println("Size of the element list is: "+size);
	}
	
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000);
		//driver.quit();
	}

}
