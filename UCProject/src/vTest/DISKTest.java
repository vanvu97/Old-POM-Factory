package vTest;

import org.testng.annotations.Test;

import vPages.DISKPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class DISKTest extends BaseTest{
	UCLoginPage loginUC;
	DISKPage DiskOperation;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		DiskOperation = new DISKPage(driver);
		loginUC.LoginUC("admin", "123456");
		
		DiskOperation.CreateDiskOperation("Disk Operation Name");
		
		DiskOperation.CreateDiskConnection("Disk Connection Name","Directory");
		
	}
	
}
