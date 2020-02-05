package vTest;

import org.testng.annotations.Test;

import vPages.UCLoginPage;
import vPages.XMLProfilePage;
import vUtilyty.BaseTest;

public class XMLProfileTest extends BaseTest{
	UCLoginPage loginUC;
	XMLProfilePage XML;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		XML = new XMLProfilePage(driver);
		loginUC.LoginUC("admin", "123456");
		
		XML.CreateXMLProfile("Source XML TestAuto","Target XML TestAuto");
	}
	
}
