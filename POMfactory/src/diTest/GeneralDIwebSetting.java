package diTest;

import org.testng.annotations.Test;

import diLinks.Links;
import diPages.GeneralDIwebPage;
import diPages.LoginDIwebPage;

public class GeneralDIwebSetting extends Links{
	
	LoginDIwebPage loginPg;//phai lay tu LoginPage vi find Element nam o LoginPage
	GeneralDIwebPage genePg;
	
	 
  @Test
  public void settingDIWEB() {
	  loginPg = new LoginDIwebPage(driver);
	  genePg = new GeneralDIwebPage(driver);
	 
	  //login diweb 1st
	  loginPg.login("diallusers","di17625;mai");
	  //login diweb 2nd
	  loginPg.login2("drupp","dicentral");
	  //Search customer's Name
	  loginPg.chooseCustomer("CTI");
	  
	  genePg.masterPageSetting();
	  
  }
}
