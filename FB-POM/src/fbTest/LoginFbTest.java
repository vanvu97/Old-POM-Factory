package fbTest;

import org.testng.annotations.Test;

import fbPages.LoginFbPage;
import fbUtlities.BaseTest;
import fbUtlities.Links;
import fbUtlities.PersonalWall;

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
