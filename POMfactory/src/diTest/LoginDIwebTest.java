package diTest;

import org.junit.Assert;
import org.testng.annotations.Test;

import diPages.LoginDIwebPage;
import diUtlities.BaseTest;
import diUtlities.Links;
 
public class LoginDIwebTest extends BaseTest {
	
	LoginDIwebPage loginPg;

	@Test
	public void loginDIWeb() {
		loginPg = new LoginDIwebPage(driver);
		
		driver.get(Links.URL_login_DIWeb);
		  //login 1st
		loginPg.login("diallusers","di17625;mai");
		  //login 2nd
		loginPg.login2("drupp","dicentral");
		  //Search customer's Name
		loginPg.chooseCustomer("CTI");
		  //Check Login
		String titlles = driver.getTitle();
		Assert.assertEquals(driver.getTitle(), titlles);  
	  }
	
}
