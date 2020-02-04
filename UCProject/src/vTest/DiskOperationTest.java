package vTest;

import org.testng.annotations.Test;

import vPages.DISKBase;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class DiskOperationTest extends BaseTest{
	UCLoginPage loginUC;
	DISKBase DiskOperation;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		DiskOperation = new DISKBase(driver);
		loginUC.LoginUC("admin", "123456");
		
		DiskOperation.CreateDiskOperation("Disk Operation Name");
		
		DiskOperation.CreateDiskConnection("Disk Connection Name","Directory");
		
	}
	
}
