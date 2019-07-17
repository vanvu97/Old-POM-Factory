package fbPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPostPage {
	
	@FindBy (xpath = ".//*[@class='_5rpb']//*[@class='notranslate _5rpu']")
	WebElement addNewPost;
	@FindBy (xpath = ".//*[@class='_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft _42fr']")
	WebElement btnShare;
	@FindBy()
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AddPostPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void AddNewPost() {
		addNewPost.click();
		addNewPost.sendKeys("Test");
		btnShare.click();	
		
		driver.quit();
	}
	
	
}
