package keypress;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressDemo3 {
	
	//Actions Class to send the KeyPress events

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception{
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
	}

	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
