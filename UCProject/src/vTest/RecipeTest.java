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
	
	String HttpOperationFile = "!!!SpeciFic1";
	String HttpConnectionFile = "!!!SpeciFic2";
	String DiskOperationName = "!!A Disk Operation";
	String DiskConnectionName = "!!A Disk Connection";
	String HttpConnectionUrl = "https://my-json-server.typicode.com/typicode/demo/db";
	String DiskDirectory = "vvVanVu";
	String RecipeName = "Recipe HTTP";
	String importMapName = "Map Name";
	
	@Test()
	public void login() throws InterruptedException {
		loginUC = new UCLoginPage(driver);
		Recipe = new RecipePage(driver);
		HTTP = new HTTPPage(driver);
		Disk = new DISKPage(driver);
		loginUC.LoginUC("admin", "123456");
		
//		Disk.CreateDiskConnection("Target Full", "VanVu2");
//		Disk.CreateDiskOperation("Source Full");

		HTTP.CreateHttpOperation(HttpOperationFile);
		HTTP.CreateHttpConnection(HttpConnectionFile, HttpConnectionUrl);
		
		Disk.CreateDiskConnection(DiskConnectionName, DiskDirectory);
		Disk.CreateDiskOperation(DiskOperationName);
		
		Recipe.CreateHTTPRecipe(RecipeName, HttpConnectionFile, 
				HttpOperationFile, importMapName, DiskOperationName, DiskConnectionName);
	}
	
}
