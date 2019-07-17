package diTest;

import org.testng.annotations.Test;

import diPages.PersonalWall;
import diPages.LoginFbPage;
import diUtlities.BaseTest;
import diUtlities.Links;

public class LoginFbTest extends BaseTest {
	
	LoginFbPage loginByD;
	PersonalWall dashboardPg;
	 
  @Test
  public void loginByD() {
	  loginByD = new LoginFbPage(driver);
	  
	  driver.get(Links.URL_Facebook);
	  dashboardPg = loginByD.loginSucces("vanvu.vv97@gmail.com", "zHelicopter123@!z");
	  
  }
}
