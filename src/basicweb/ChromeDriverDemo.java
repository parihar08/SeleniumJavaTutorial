package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "https://www.expedia.com";
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver;
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		//driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		//driver.quit();
		

	}

}
