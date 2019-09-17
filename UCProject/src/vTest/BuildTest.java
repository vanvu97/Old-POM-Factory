package vTest;

import org.testng.annotations.Test;

import vPages.BuildPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class BuildTest extends BaseTest{
	
	UCLoginPage loginUC;
	BuildPage buildPgs;
	
  @Test
  public void main() {
	  
	  loginUC = new UCLoginPage(driver);
	  
	  buildPgs = new BuildPage(driver);
	  
	  loginUC.LoginUC("admin", "123456");
	  
	  buildPgs.buildProcess();
	  
  }
  
}
