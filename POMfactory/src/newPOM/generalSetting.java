package newPOM;

import org.testng.annotations.Test;

public class generalSetting extends BaseTest{
	
	LoginPage loginPg;//phai lay tu LoginPage vi find Element nam o LoginPage
	
	generalPage genePg;
	
	
  @Test
  public void settingDIWEB() {
	  loginPg = new LoginPage(driver);
	  genePg = new generalPage(driver);
	 
	  //login diweb 1st
	  loginPg.login("diallusers","di17625;mai");
	  //login diweb 2nd
	  loginPg.login2("drupp","dicentral");
	  //Search customer's Name
	  loginPg.chooseCustomer("CTI");
	  
	  genePg.masterpageSetting();
	  
  }
}
