package vTest;

import org.testng.annotations.Test;

import vPages.ActivatedProcessPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class ActivatedProcessTest extends BaseTest{
	
	UCLoginPage loginUC;
	ActivatedProcessPage activatePgs;
	
  @Test
  public void createShedule() {
	  
	  loginUC = new UCLoginPage(driver);
	  
	  activatePgs = new ActivatedProcessPage(driver);
	  
	  loginUC.LoginUC("admin", "123456");
	  
	  activatePgs.reachToDocumentTrackingSection();
	  
	  activatePgs.createSchedule("SOAP");
	  
  }
  
}
