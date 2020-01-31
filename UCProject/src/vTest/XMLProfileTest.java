package vTest;

import org.testng.annotations.Test;

import vPages.RecipePage;
import vPages.UCLoginPage;
import vPages.XMLProfile;
import vUtilyty.BaseTest;

public class XMLProfileTest extends BaseTest{
	UCLoginPage loginUC;
	XMLProfile XML;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		XML = new XMLProfile(driver);
		loginUC.LoginUC("admin", "123456");
		
		XML.CreateXMLProfile();
	}
	
}
