package fbTest;

import org.testng.annotations.Test;

import fbPages.AddPostPage;
import fbPages.LoginFbPage;
import fbUtlities.BaseTest;
import fbUtlities.Links;
import fbUtlities.PersonalWall;

public class AddPostTest extends BaseTest{

	LoginFbPage loginFB;
	PersonalWall dashboardPg;
	AddPostPage addNewPg;
	
  @Test
  public void addPost() {
	  loginFB = new LoginFbPage(driver);
	  
	  driver.get(Links.URL_Facebook);
	  dashboardPg = loginFB.loginSucces("vanvu.vv97@gmail.com", "zHelicopter123@!z");
	  addNewPg = dashboardPg.moveToAddPostPage();
	  dashboardPg.moveToAddPostPage();
  }
}
