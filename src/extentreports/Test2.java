package extentreports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test2 {
	
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() throws IOException {
		report = ExtentFactory.getInstance();
		test = report.startTest("Test Class2 --> Verification");
	}
	
	@Test
	public void testMethod() {
		test.log(LogStatus.INFO, "Test2  --> Test Method Started");
		test.log(LogStatus.INFO, "Test2  --> Test Method Continuing");
		test.log(LogStatus.INFO, "Test2  --> Test Method Ended");
	}
	
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}
}

