package diPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDIwebPage{
	
	//Login section
	@FindBy (css = "input[name='fTbxUserName']")
	WebElement inpUsername;
	@FindBy (css = "[name='fTbxPassword']")
	WebElement inputPassword;
	@FindBy (css = "#fBtnLogin")
	WebElement btnLogin;
	
	//Login2 section
	@FindBy (id = "fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpUserId_I")
	WebElement inpUsername2;
	@FindBy (id = "fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpSecPassword_I")
	WebElement inpPassword2;
	@FindBy (id = "fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fBtnLogin_B")
	WebElement btnLogin2;
	
	//Choose Customer section
	@FindBy (id = "fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fTbxSearchName_I")
	WebElement inpCustomerName;
	@FindBy (xpath = ".//*[@id='fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fBtnSearch_B']//*[@id='fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fBtnSearch_CD']")
	WebElement btnSearch;
	@FindBy (xpath =".//*[@value='27228']")
	WebElement customerID;
	@FindBy (id = "fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fBtnOK_B")
	WebElement btnOK;
	
	
	WebDriver driver;
	WebDriverWait wait;
	 
	public LoginDIwebPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	public void login(String userName, String password) {
		inpUsername.sendKeys(userName);
		inputPassword.sendKeys(password);
		
		//WebElement ele = driver.findElement(By.cssSelector("#fBtnLogin"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnLogin);
		
	}
	public void login2 (String userName2, String password2) {
		//Switch to frame
		driver.switchTo().frame("frameUserSelection");
		inpUsername2.sendKeys(userName2);
		inpPassword2.sendKeys(password2);
		btnLogin2.click();
		//Switch back to default page
		driver.switchTo().defaultContent();
	}	
		
	public void chooseCustomer(String customersName) {
		//Switch to frame
		driver.switchTo().frame("frameUserSelection");
		//Wait for element is display
		WebDriverWait waitTitle = new WebDriverWait(driver, 15);
		waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.id("fCbpUserSelection_ASPxPanel2_fPnlUserSelection_fTbxSearchName_I")));
		inpCustomerName.sendKeys(customersName);
		btnSearch.click();
		//Choose Customer value (Customer's name)
		customerID.click();
		btnOK.click();
		//Switch back to default page
		driver.switchTo().defaultContent();
	}
		
}
