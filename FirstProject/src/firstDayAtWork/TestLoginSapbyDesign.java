package firstDayAtWork;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
 
public class TestLoginSapbyDesign {
	static WebDriver driver;
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vuvan\\Downloads\\Driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
  	  FirefoxOptions options = new FirefoxOptions();
  		options.setProfile(new FirefoxProfile());
  		options.addPreference("dom.webnotifications.enabled", false);
  		driver = new FirefoxDriver(options);
  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		
  		driver.get("http://diweb5test.dicentral.com/Main.aspx");
		

        // Login SapbyDesign
  		sapByDesignLogin sapByDesignLogin = new sapByDesignLogin(driver);
  		sapByDesignHomePage homePage = sapByDesignLogin.login("diallusers", "di17625;mai", "drupp", "dicentral");
        if (homePage.isDisplayed()) {
            System.out.println("Login Successfully!");
        } else {
            System.out.println("Login Fail!");
        }
        // Quit driver
      
        
    }
}
