package vTest;

import org.testng.annotations.Test;

import vPages.JSONProfileBase;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class JSONProfileTest extends BaseTest{
	UCLoginPage loginUC;
	JSONProfileBase JSON;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		JSON = new JSONProfileBase(driver);
		loginUC.LoginUC("admin", "123456");
		
		JSON.CreateJSONProfile("Source JSON TestAuto","Target JSON TestAuto");
	}
	
}
