package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByLinkText {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.findElement(By.partialLinkText("Pract")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		
	}

}
