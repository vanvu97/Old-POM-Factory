package vTest;

import org.testng.annotations.Test;

import vPages.UCLoginPage;
import vPages.buildPages;
import vUtilyty.BaseTest;
import vUtilyty.Links;

public class buildTest extends BaseTest{
	buildPages buildPg;
	UCLoginPage loginUC;
	
  @Test
  public void createProcess() throws InterruptedException {
	  loginUC = new UCLoginPage(driver);
	  buildPg = new buildPages(driver);
	  
	  driver.get(Links.URL_UC);
	  loginUC.LoginUC("admin", "123456");
	  buildPg.buildSection();
	  
	  
  }
}
