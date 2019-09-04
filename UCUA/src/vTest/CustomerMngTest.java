package vTest;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vPages.CustomerMngPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.ExportFile;

public class CustomerMngTest extends BaseTest {
  
	UCLoginPage loginUC;
	CustomerMngPage MngPgs;
	
	@Test(dataProvider="loginData")
  public void CreateAccount(String userName, String password) throws InterruptedException, FileNotFoundException {
		loginUC = new UCLoginPage(driver);
		MngPgs = new CustomerMngPage(driver);
		
		loginUC.LoginUC(userName, password);
		MngPgs.reachToCustomerSection();
//		MngPgs.AddCustomer();
//		MngPgs.PrintInfo();
		MngPgs.setPassword();
	}
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() throws Exception {
		String filePath = System.getProperty("user.dir")+"\\src\\data\\";
		
	     Object[][] testObjArray = ExportFile.getTableArray(filePath + "ExportExcel.xlsx","LoginData", 0);

	     return (testObjArray);
	}
}

