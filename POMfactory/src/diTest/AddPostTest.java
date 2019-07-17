package diTest;

import org.testng.annotations.Test;

import diPages.AddPostPage;
import diPages.LoginFbPage;
import diPages.PersonalWall;
import diUtlities.BaseTest;
import diUtlities.Links;

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
	  addNewPg.AddNewPost();
  }
}
