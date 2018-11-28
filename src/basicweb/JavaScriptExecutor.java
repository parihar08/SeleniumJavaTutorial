import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SParihar\\Downloads\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.freecrm.com/");
	
	driver.findElement(By.name("username")).sendKeys("naveenk");
	driver.findElement(By.name("password")).sendKeys("test@123");
	Thread.sleep(2000);
	WebElement login = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
	
	//Flashes a WebElement
	flash(login, driver);
	
	//Draws Border across a WenElement
	drawBorder(login, driver);
	
	//Take Screenshot
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\FreeCRMTest.png";
	FileUtils.copyFile(src, new File(destination));
	
	//Generate Alerts
	//generateAlert(driver, "This is an Alert Message on Login Failure");
	
	//Click on Element using JS
	//clickElementByJS(login, driver);
	//login.click();
	
	//Refresh the page
	refreshBrowserByJS(driver);
	//driver.navigate().refresh();
	
	//Title
	System.out.println(getTitleByJS(driver));
	//driver.getTitle();
	
	//Get Page Inner Text
	System.out.println(getPageInnerText(driver));
	
	//Scroll Page Down
	//scrollPageDown(driver);
	
	//ScrollIntoView
	WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password')]"));
	scrollIntoView(forgotPassword, driver);
	Thread.sleep(2000);
	forgotPassword.click();
	
	driver.quit();

}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<20;i++) {
			changeColor("rgb(0,200,0)",element,driver);  //green color
			changeColor(bgcolor,element,driver); //default purple color
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {
			
		}
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver,String message){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String innerText = js.executeScript("return document.documentElement.innerText;").toString();
		return innerText;
		
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
}