package newPOM;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	LoginPage loginPg;

	@Test
	public void loginDIWeb() {
		loginPg = new LoginPage(driver);
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
	@Test
	public void changeGeneral() {
		
		
	}
}
