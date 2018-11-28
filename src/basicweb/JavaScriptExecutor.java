import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {
	
	public static void main(String[] args) throws InterruptedException {
	
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
	flash(login, driver);
	driver.quit();

}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++) {
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
}