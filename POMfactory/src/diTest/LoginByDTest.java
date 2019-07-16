package diTest;

import org.testng.annotations.Test;

import diLinks.Links;
import diPages.LoginByDPage;

public class LoginByDTest extends Links {
	
	LoginByDPage loginByD;
	 
  @Test
  public void loginByD() {
	  loginByD = new LoginByDPage(driver);
	  
	  driver.get(Links.URL_Facebook);
	  loginByD.loginByDesign("dicentral", "EDIforSAP1");
	  
  }
}
