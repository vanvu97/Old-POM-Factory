package vTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vPages.ActivatedProcessPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.ReadFile;

public class ActivatedProcessTest extends BaseTest{
	
	UCLoginPage loginUC;
	ActivatedProcessPage activatePgs;
	
	@Test(dataProvider="loginData"/*, invocationCount = 3*/)
  public void createShedule(String setTime, String recurTime) {
	  
	  loginUC = new UCLoginPage(driver);
	  
	  activatePgs = new ActivatedProcessPage(driver);
	  
	  loginUC.LoginUC("admin", "123456");
	  
	  activatePgs.doucumenentTrackingPgs();
	  
	  activatePgs.scheduleSection("zDaily1");
	  
	  activatePgs.runOnetime(setTime);
	  
	  activatePgs.runDaily(setTime, recurTime);
	  
  }
  
  @DataProvider(name = "loginData")
  public Object[][] dataProvider() throws Exception {
		
		String filePath = System.getProperty("user.dir")+"\\src\\data\\";
		
		Object[][] testObjArray = ReadFile.getTableArray(filePath + "ScheduleExcel.xlsx","LoginData", 1);

		return (testObjArray);
		
	}
  
}
