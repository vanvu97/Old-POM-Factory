package vTest;

import org.testng.annotations.Test;

import vPages.GetDocumentTrackingPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class GetDocumentTrackingTest extends BaseTest{
	UCLoginPage loginUC;
	GetDocumentTrackingPage DMT;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		DMT = new GetDocumentTrackingPage(driver);
		loginUC.LoginUC("VV01312020", "VV01312020");
		
		DMT.CreateXMLProfile("01312020 - Daily - 10m/1d");
	}
	
}
