package diTest;

import org.junit.Assert;
import org.testng.annotations.Test;

import diPages.LoginDIwebPage;
import diUtlities.BaseTest;
import diUtlities.Links;
 
public class LoginDIwebTest extends BaseTest {
	
	LoginDIwebPage loginPg;

	@Test
	public void loginDIWeb() throws InterruptedException {
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
	
//	@Test(dataProvider="loginData")
//	public void loginFail(String userName, String password) {
//		loginPg = new LoginDIwebPage(driver);
//		loginPg.login(userName, password);
//		Assert.assertTrue(loginPg.isDisplayed());
//	}
//	
//	@DataProvider (name = "loginData")
//	public Object[][] dataProvider() throws Exception {
//		ReadExcelFile.setExcelFile(Links.PATH_TO_EXCEL, "LoginTest");
//		Object[][] testData = ReadExcelFile.getTestData("invalid");
//		return testData;
//	}
	
	
}
