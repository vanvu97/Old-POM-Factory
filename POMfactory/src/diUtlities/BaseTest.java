package diUtlities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vuvan\\Downloads\\Driver\\ChromeDriver-75.0.3770.140\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		WebDriver driver = new ChromeDriver(options);
		
		//driver.get(URL_login_DIWeb);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Done!!!!");
		
	}
}
