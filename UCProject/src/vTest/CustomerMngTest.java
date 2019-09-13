package vTest;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vPages.CustomerMngPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.ReadFile;

public class CustomerMngTest extends BaseTest {
  
	UCLoginPage loginUC;
	CustomerMngPage MngPgs;
	
	@Test(dataProvider="loginData"/*, invocationCount = 3*/)
  public void CreateAccount(String userName, String password, String sAccountName, String sEmail, String sAccountType, String sEnable, String sCode, String sFullName
		  , String sAddress, String Company, String sCountry, String CountryCode, String PhoneNo) throws InterruptedException, FileNotFoundException {
		
		loginUC = new UCLoginPage(driver);
		
		MngPgs = new CustomerMngPage(driver);
		
		loginUC.LoginUC(userName, password);
		
		MngPgs.reachToCustomerSection();
		
//		MngPgs.AddCustomer(sAccountName, sEmail, sAccountType, sEnable, sCode, sFullName, sAddress, Company, sCountry, CountryCode, PhoneNo);
	
//		MngPgs.setPassword(sAccountName, sPassword); 
		
//		MngPgs.editAccount(password, sAccountName); 
		
//		MngPgs.loginAccoutTest(sAccountName, sPassword);
		
//		MngPgs.deleteAccount();
		
	}
	
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() throws Exception {
		
		String filePath = System.getProperty("user.dir")+"\\src\\data\\";
		
	     Object[][] testObjArray = ReadFile.getTableArray(filePath + "ExportExcel.xlsx","LoginData", 1);

	     return (testObjArray);
		
		
		
	}
}

