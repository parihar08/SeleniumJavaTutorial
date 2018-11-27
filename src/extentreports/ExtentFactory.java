package extentreports;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance() throws IOException{
		ExtentReports extent;
		String Path = "//Users⁩//⁨Parihar08⁩//⁨Desktop//LoginTest.html";
		extent = new ExtentReports(Path,false); //replaceExisting File > false
		extent
		.addSystemInfo("Selenium Version", "2.52")
		.addSystemInfo("Platform", "Mac");

		return extent;
	}

}
