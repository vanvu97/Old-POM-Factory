package diUtlities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import net.sf.cglib.beans.BeanCopier.Generator;

public class BaseTest {
	
	public WebDriver driver;
	Screenshot screenshot;
	
	@BeforeMethod
	public void setUp() {
		screenshot = new Screenshot (gen, driver);
		
//		FirefoxOptions options = new FirefoxOptions();
//		options.setProfile(new FirefoxProfile());
//		options.addPreference("dom.webnotifications.enabled", false);
//		driver = new FirefoxDriver(options);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vuvan\\Downloads\\Driver\\ChromeDriver-76.0.3809.25\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.get(URL_login_DIWeb);
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            screenshot.takeScreenshot(testResult.getName());
        }
		
	}
}
