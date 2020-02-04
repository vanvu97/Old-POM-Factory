package vTest;

import org.testng.annotations.Test;

import vPages.DISKPage;
import vPages.HTTPPage;
import vPages.JSONProfilePage;
import vPages.RecipePage;
import vPages.UCLoginPage;
import vPages.XMLProfilePage;
import vUtilyty.BaseTest;

public class RecipeTest extends BaseTest{
	UCLoginPage loginUC;
	RecipePage Recipe;
	DISKPage Disk;
	HTTPPage HTTP;
	XMLProfilePage profileXML;
	JSONProfilePage profileJSON;
	
	String HttpOpera = "!!!SpeciFic1";
	String HttpConnect = "!!!SpeciFic2";
	
	@Test()
	public void login() throws InterruptedException {
		loginUC = new UCLoginPage(driver);
		Recipe = new RecipePage(driver);
		HTTP = new HTTPPage(driver);
		Disk = new DISKPage(driver);
		loginUC.LoginUC("admin", "123456");
		
//		Disk.CreateDiskConnection("Target Full", "VanVu2");
//		Disk.CreateDiskOperation("Source Full");

		HTTP.CreateHttpOperation(HttpOpera);
		HTTP.CreateHttpConnection(HttpConnect, "https://my-json-server.typicode.com/typicode/demo/db");
		
		Recipe.CreateHTTPRecipe("HTTP Auto", HttpConnect, HttpOpera, "!!vvMapJson");
	}
	
}
