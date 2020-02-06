package vTest;

import org.testng.annotations.Test;

import vPages.HTTPPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class HTTPTest extends BaseTest{
	UCLoginPage loginUC;
	HTTPPage HTTP;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		HTTP = new HTTPPage(driver);
		loginUC.LoginUC("admin", "123456");
		
		HTTP.CreateHttpOperation("HTTP Operation Name");
		
		HTTP.CreateHttpConnection("HTTP Connection Name","https://my-json-server.typicode.com/typicode/demo/db");
		
	}
	
}