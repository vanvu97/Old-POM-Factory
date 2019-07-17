package diUtlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import diPages.AddPostPage;
import diPages.PersonalWall;

public class BasePage {
	
	@FindBy (xpath = ".//*[@href='https://www.facebook.com/Van8931JofkVu2605']")
	WebElement personalWall;
	@FindBy (xpath = ".//*[@class='_1mwp navigationFocus _395 _1mwq _4c_p _5bu_ _3t-3 _34nd _21mu _5yk1']//*[@id='placeholder-e3mqa']")
	WebElement addNewPost;
	
	WebDriver driver;
	Actions action;
  
  public BasePage(WebDriver driver) {
	  	this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
  }
  
  public PersonalWall moveToPersonalWall() {
	  	personalWall.click();
	  	return new PersonalWall(driver);
  }
  
  public AddPostPage moveToAddPostPage() {
	  action.moveToElement(personalWall).click().perform();
	  addNewPost.click();
	  return new AddPostPage(driver);
  }
}
