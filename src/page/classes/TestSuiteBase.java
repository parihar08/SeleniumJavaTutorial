package page.classes;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestSuiteBase {
	
	protected WebDriver driver;
	protected SearchPageFactoryGrid searchPage;
	
	@Parameters({"platform","browser","version","url"})
	@BeforeClass(alwaysRun=true)
	public void setUp(String platform,String browser,String version, String url) throws Exception {
		
		driver = getDriverInstance(platform, browser, version, url);
		searchPage = PageFactory.initElements(driver, SearchPageFactoryGrid.class);
	}
	
	public static WebDriver getDriverInstance(String platform,String browser,String version, String url) throws Exception{
		String nodeUrl = "http://10.0.0.121:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//Platforms
		if(platform.equalsIgnoreCase("windows")){
			caps.setPlatform(Platform.WINDOWS);
		}
		if(platform.equalsIgnoreCase("mac")){
			caps.setPlatform(Platform.MAC);
		}		
		//Browsers		
		if(browser.equalsIgnoreCase("firefox")){
			caps = DesiredCapabilities.firefox();	
		}
		if(browser.equalsIgnoreCase("chrome")){
			caps = DesiredCapabilities.chrome();			
		}	
		//Version		
		caps.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeUrl),caps);		
		//Maximize the browser's window		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
		//Open the application		
		driver.get(url);
		return driver;
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}