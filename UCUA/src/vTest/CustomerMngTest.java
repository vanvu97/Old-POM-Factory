package vTest;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import vPages.CustomerMngPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.Links;

public class CustomerMngTest extends BaseTest {
  
	UCLoginPage loginUC;
	CustomerMngPage MngPgs;
	
	@Test
  public void CreateAccount() throws InterruptedException, FileNotFoundException {
		loginUC = new UCLoginPage(driver);
		MngPgs = new CustomerMngPage(driver);
		
		driver.get(Links.URL_UC);
		loginUC.LoginUC("admin", "123456");
		MngPgs.CustomerMngSection();
		MngPgs.AddCustomer();
		MngPgs.PrintInfo();
		MngPgs.setPassword();
  }
}
