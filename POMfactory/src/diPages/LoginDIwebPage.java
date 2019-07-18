package diPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDIwebPage{
	
	//Login section
	@FindBy (css = "input[name='fTbxUserName']")
	WebElement inpUsername;
	@FindBy (css = "[name='fTbxPassword']")
	WebElement inpPassword;
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
	
	//Search Keyword
	@FindBy (css = "[name='fInboxControl$fTbxDocId']")
	WebElement searchBox;
	@FindBy (id ="fInboxControl_btnSearch")
	WebElement btnSearchKeyWord;
	
	//tick Document ID
	@FindBy (css = "#headerRepeater > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
	WebElement tickCheckBox;
	
	//Choose action export
	@FindBy (css = "[name='fInboxControl$fCbxUpAction']")
	WebElement actionLists;
	@FindBy (xpath = ".//*[@value='btnExportToCloudSalesOrder|cloud/BYD/ExportSO_V2.aspx']")
	WebElement chooseExport;
	@FindBy (css = "[name='fInboxControl$btnUpGo']")
	WebElement btnOK2;
	
	//Switch to new windows and perform
	@FindBy (xpath = ".//*[@role='gridcell']//*[@class='cbox cbox']")
	WebElement tickCheckBox2;
	@FindBy (id = "reSend")
	WebElement btnReSend;
	
	//Get text in Message box
	@FindBy (xpath = "/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")
	WebElement messageBox;
	@FindBy (xpath = "/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")
	WebElement getSaleID;
	
	WebDriver driver;
	WebDriverWait wait;
	 
	public LoginDIwebPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	public void login(String userName, String password) {
		inpUsername.sendKeys(userName);
		inpPassword.sendKeys(password);
		
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
	public void search850files(String keyword) throws InterruptedException {
		
	//Wait for element is display
		WebDriverWait waitTitle = new WebDriverWait(driver, 15);
		waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='fInboxControl$fTbxDocId']")));
		searchBox.sendKeys(keyword);
		btnSearchKeyWord.click();
//		------------------------------
		
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		    wait.until(new ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver wdriver) {
		            return ((JavascriptExecutor) driver).executeScript(
		                "return document.readyState"
		            ).equals("complete");
		        }
		    });
		
//		------------------------------
		
		Thread.sleep(5000);
		
		//tickCheckBox.click();
		WebDriverWait waitTitle2 = new WebDriverWait(driver, 15);
		waitTitle2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headerRepeater > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")));
		
		//tickCheckBox.click();
		WebElement ele = driver.findElement(By.cssSelector("#headerRepeater > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		//actionLists.click();
		WebElement ele2 = driver.findElement(By.cssSelector("[name='fInboxControl$fCbxUpAction']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", ele2);
		//choose Export
		chooseExport.click();
		btnOK2.click();
		}
	
	 // Store the current window handle
	public void getSalesID() throws InterruptedException {
		for(String winHandle : driver.getWindowHandles()){
		  	  driver.switchTo().window(winHandle);
			}
		
		String getTextMessages = messageBox.getText();
		int DoDai = getTextMessages.length();
		
		if(tickCheckBox2.isDisplayed()) {
		//Tick on check box and resends
		tickCheckBox2.click();
		btnReSend.click();
		
		//Wait for Message Box appears
		WebDriverWait waitMessageBox = new WebDriverWait(driver, 15);
		waitMessageBox.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")));
		//Get text on messages box and print
		String Sales_Order_ID = getTextMessages.substring(getTextMessages.lastIndexOf(" ")+1);
		System.out.println(DoDai);
		System.out.println(Sales_Order_ID);
		
		}else{
		
		WebDriverWait waitMessageBox = new WebDriverWait(driver, 15);
		waitMessageBox.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")));
		
		String Sales_Order_ID = getTextMessages.substring(getTextMessages.lastIndexOf(" ")+1);
		System.out.println(DoDai);
		System.out.println(Sales_Order_ID);
		}
	}
	
	public boolean bodyHasKeyword(String keyword) {
		List<WebElement> paragraphs = driver.findElements(By.id("headerRepeater"));
		for (int i = 0; i < paragraphs.size(); i++) {
			String p = paragraphs.get(i).getText();
			if (!(p.contains(keyword))) {
				return true;
			}
		}
		return false;
	}
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
		
}
