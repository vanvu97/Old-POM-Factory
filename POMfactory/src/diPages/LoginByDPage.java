package diPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginByDPage{
	
	WebDriver driver;
	
	public LoginByDPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginByDesign(String ByDName, String ByDPassword) {
		//Input User name
		driver.findElement(By.id("__control0-user-inner")).sendKeys(ByDName);
		//Input Password
		driver.findElement(By.id("__control0-pass-inner")).sendKeys(ByDPassword);
		//Click Log On button
		driver.findElement(By.id("sapMBtnContent")).click();
		
	}
}
