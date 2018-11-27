package basicweb;
	
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxProfilesDemo {

		public static void main(String[] args) {
			// http://chromedriver.storage.googleapis.com/index.html
			String baseURL = "http://www.letskodeit.com";
			WebDriver driver;
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile fxProfile = profile.getProfile("automationprofile");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(fxProfile);
			
			driver = new FirefoxDriver(options);
			driver.get(baseURL);
			driver.quit();
		}
	}
	
	
