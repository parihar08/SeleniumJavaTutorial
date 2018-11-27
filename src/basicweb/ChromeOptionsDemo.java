package basicweb;
	
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

		public static void main(String[] args) {
			// http://chromedriver.storage.googleapis.com/index.html
			String baseURL = "http://www.google.com";
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("/Users/Parihar08/Library/Application Support/Google/Chrome/Default/Extensions/fhbjgbiflinjbdggehcddcbncdddomop/5.5.3_0.crx"));
			
			driver = new ChromeDriver(options);
			driver.get(baseURL);
			driver.quit();
		}
	}
	
	
