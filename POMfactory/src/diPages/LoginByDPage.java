package diPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginByDPage{
	// Equal driver.findElement(By.name(""));
	@FindBy( css = "[name='email']")
	WebElement inpUserName;
	
	@FindBy(css = "input[name='pass']")
	WebElement inpPassword;
	
	@FindBy(id = "loginbutton")
	WebElement btnLogin;
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginByDPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void loginByDesign(String ByDName, String ByDPassword) {
		//Input User name
		inpUserName.sendKeys(ByDName);
		//Input Password
		inpPassword.sendKeys(ByDPassword);
		//Click Log On button
		btnLogin.click();
		
	}
}
