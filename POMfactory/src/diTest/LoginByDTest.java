package diTest;

import org.testng.annotations.Test;

import diLinks.BaseTest;
import diPages.LoginByDPage;

public class LoginByDTest extends BaseTest {
	
	LoginByDPage loginByD;
	
  @Test
  public void loginByD() {
	  loginByD = new LoginByDPage(driver);
	  
	  loginByD.loginByDesign("dicentral", "EDIforSAP1");
	  
  }
}
