package keypress;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressDemo1 {
	
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
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("pari_indiana88@yahoo.com");
		Thread.sleep(2000);
		driver.findElement(By.id("user_password")).sendKeys("parihar_08");
		Thread.sleep(2000);
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}

	@Test
	public void test1() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
		driver.findElement(By.id("user_email")).sendKeys("pari_indiana88@yahoo.com");
		Thread.sleep(2000);
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		driver.findElement(By.id("user_password")).sendKeys("parihar_08");
		Thread.sleep(2000);
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}
	
	
	@Test
	public void test2() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a");
		Thread.sleep(2000);
		driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
		Thread.sleep(2000);
	}
	
	@Test
	public void test3() throws Exception{
		driver.get(baseUrl);
		Thread.sleep(2000);
		String selectAll = Keys.chord(Keys.COMMAND, "a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
