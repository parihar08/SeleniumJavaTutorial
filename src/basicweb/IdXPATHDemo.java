package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdXPATHDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.google.com";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.findElement(By.id("lst-ib")).sendKeys("cricbuzz");
		
		driver.findElement(By.xpath(".//*[@id='mKlEF']")).click();

	}

}
