package diPages;

import org.openqa.selenium.WebDriver;

import diUtlities.Links;

public class PersonalWall {
	
	WebDriver driver;
	 
	public PersonalWall(WebDriver driver) {
		this.driver = driver;
	}
 
	public boolean isDisplayed() {
		if (Links.URL_Facebook.equals(driver.getCurrentUrl())) {
			return true;
		} else {
			return false;
		}
	}

	public AddPostPage moveToAddPostPage() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
