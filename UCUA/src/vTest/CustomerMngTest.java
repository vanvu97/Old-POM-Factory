package vTest;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vPages.CustomerMngPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.ExportFile;
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
		MngPgs.reachToCustomerSection();
//		MngPgs.AddCustomer();
//		MngPgs.PrintInfo();
		MngPgs.setPassword();
  }
	@DataProvider
	public Object[][] Authentication() throws Exception{
		String filePath = System.getProperty("user.dir")+"\\src\\vUtilyty\\";
		
	     Object[][] testObjArray = ExportFile.getTableArray(filePath + "ExportExcel.xlsx","LoginData", 0);

	     return (testObjArray);

		}
}
