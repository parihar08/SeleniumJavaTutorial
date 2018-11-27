package extentreports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() throws IOException {
		report = ExtentFactory.getInstance();
		test = report.startTest("Verify Welcome Text");
		baseUrl = "http://www.letskodeit.com/";
		driver = new FirefoxDriver();
		test.log(LogStatus.INFO, "Browser Started");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web Application Loaded");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		test.log(LogStatus.INFO, "Clicked on SignUp Link");
		
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		test.log(LogStatus.INFO, "Clicked on Login Link");
		
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Entered Username");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc");
		test.log(LogStatus.INFO, "Entered Password");
		
		WebElement goButton = driver.findElement(By.id("memberLoginDialogoklabel"));
		goButton.click();
		test.log(LogStatus.INFO, "Clicked on Go Button");
		
		Thread.sleep(3000);
		
		WebElement welcomeText = null;
		
		try {
			welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(welcomeText != null);	
		test.log(LogStatus.PASS, "Verified Welcome Text");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}

