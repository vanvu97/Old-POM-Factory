package diLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;
	
	public static final String URL_login_DIWeb = "http://diweb5test.dicentral.com/Main.aspx";
	public static final String URL_Login_SapByDesign = "https://my347733.sapbydesign.com/sap/public/ap/ui/repository/SAP_UI/HTMLOBERON5/client.html?app.component=/SAP_UI_CT/Main/root.uiccwoc&rootWindow=X&redirectUrl=/sap/public/byd/runtime";
	
	@BeforeMethod
	public void setUp() {
//		FirefoxOptions options = new FirefoxOptions();
//		options.setProfile(new FirefoxProfile());
//		options.addPreference("dom.webnotifications.enabled", false);
//		driver = new FirefoxDriver(options);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vuvan\\Downloads\\Driver\\ChromeDriver 75.0.3770.140\\chromedriver");
		WebDriver driver =new ChromeDriver(options);
		
		driver.get(URL_Login_SapByDesign);
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Done!!!!");
	}
  }
