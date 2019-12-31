package vTest;

import org.testng.annotations.Test;

import vPages.ApplyPage;
import vUtilyty.BaseTest;

public class ApplyTest extends BaseTest{
	
	ApplyPage app;
	
	@Test
  public void createShedule() {
	  app = new ApplyPage(driver);
	  
	  driver.get("http://demo.automationtesting.in/Register.html");
	  
	  app.ApplyHL();
	  
	  driver.quit();
  
	}
	
//	@DataProvider(name = "loginData")
//	  public Object[][] dataProvider() throws Exception {
//			
//			Object[][] testObjArray = ScheduleExcelFile.getTableArray(Links.PATH_TO_EXCEL_Schedule,"LoginData", 1);
//
//			return (testObjArray);
//			
//		}
  
}
