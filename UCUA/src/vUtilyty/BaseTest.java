package vUtilyty;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vuvan\\Downloads\\Driver\\ChromeDriver-76.0.3809.68\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.get(URL_login_DIWeb);
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {	  		
        if (testResult.getStatus() == ITestResult.FAILURE) { 
        	String directory = Links.PATHTO_IMG;
        	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(screenshot, new File(directory));
        	
        	
        	
        	System.out.print("Screenshot is captured and stored in your " + directory);
        }
//        driver.quit();
    }
}
