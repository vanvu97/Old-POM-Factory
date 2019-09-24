package vTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.CustomerExcelFile;

public class UCLoginTest extends BaseTest{
	UCLoginPage loginUC;
	
	@Test(dataProvider="loginData")
	public void login(String userName, String password) {
		loginUC = new UCLoginPage(driver);
		loginUC.LoginUC(userName, password);
	}
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() throws Exception {
		String filePath = System.getProperty("user.dir")+"\\src\\data\\";
		
	     Object[][] testObjArray = CustomerExcelFile.getTableArray(filePath + "ExportExcel.xlsx","LoginData", 1);

	     return (testObjArray);
	     
	}
	
}
