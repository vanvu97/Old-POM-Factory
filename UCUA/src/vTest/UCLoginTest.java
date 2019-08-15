package vTest;

import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.Links;

import org.testng.annotations.Test;


public class UCLoginTest extends BaseTest{
	UCLoginPage loginUC;
	
	@Test
	public void login() {
		loginUC = new UCLoginPage(driver);
		
		driver.get(Links.URL_UC);
		loginUC.LoginUC("admin", "123456");
		
	}
	
	
}
