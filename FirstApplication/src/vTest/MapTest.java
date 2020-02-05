package vTest;

import org.testng.annotations.Test;

import vPages.MapPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class MapTest extends BaseTest{
	UCLoginPage loginUC;
	MapPage Map;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		Map = new MapPage(driver);
		loginUC.LoginUC("VV02052020", "VV02052020");
		
		Map.CreateMapEditor("Source XML TestAuto","Target XML TestAuto", "Test Map Editor");
	}
	
}
