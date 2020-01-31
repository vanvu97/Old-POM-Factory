package vTest;

import org.testng.annotations.Test;

import vPages.RecipePage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;

public class RecipeTest extends BaseTest{
	UCLoginPage loginUC;
	RecipePage Recipe;
	
	@Test()
	public void login() {
		loginUC = new UCLoginPage(driver);
		Recipe = new RecipePage(driver);
		loginUC.LoginUC("admin", "123456");
		
		Recipe.CreateRecipe();
	}
	
}
