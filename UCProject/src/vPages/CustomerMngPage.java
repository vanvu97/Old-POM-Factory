package vPages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerMngPage {
	
	//Reach to Customer Management section
	@FindBy (css = "li.menu-level-0:nth-child(8) > a:nth-child(1)")
	WebElement btnMonitor;
	@FindBy (css = "li.menu-level-0:nth-child(8) > ul:nth-child(2) > li:nth-child(1)")
	WebElement clickOnCustomerMng;
	@FindBy (css = ".glyphicon-plus-sign")
	WebElement addCustomer;
	@FindBy (css = "li.menu-level-0:nth-child(8) > ul:nth-child(2)")
	WebElement subMenu;
	
	//Create a Account
	@FindBy (css = "#collapse_fieldAccount > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpAccountName;
	@FindBy (css = "input.ng-valid-email")
	WebElement inpEmail;
	@FindBy (css = "select.ng-pristine")
	WebElement accType;
	@FindBy (css = "select.form-control > option:nth-child(1)")
	WebElement trialType;
	@FindBy (css = "select.form-control > option:nth-child(2)")
	WebElement standardType;
	@FindBy (css = ".style-cb > span:nth-child(2)")
	WebElement btnEnable;
	@FindBy (css = "div.mrg10T:nth-child(3) > label:nth-child(1) > span:nth-child(2)")
	WebElement radioSynch;
	@FindBy (css = "div.mrg10T:nth-child(4) > label:nth-child(1) > span:nth-child(2)")
	WebElement radioEnable;
	@FindBy (css = "#collapse_fieldProfile > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCode;
	@FindBy (css = "input.ng-invalid-required")
	WebElement inpFullName;
	@FindBy (css = "div.form-group:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpAddress;
	@FindBy (css = "div.form-group:nth-child(4) > div:nth-child(2) > input:nth-child(1)")
	WebElement impCompany;
	@FindBy (css = "div.form-group:nth-child(5) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCountry;
	@FindBy (css = "div.form-group:nth-child(6) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCountryCode;
	@FindBy (css = "div.form-group:nth-child(7) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpPhoneNo;
	@FindBy (css = "button.btn")
	WebElement btnSave;
	@FindBy (css = ".page-header > h1:nth-child(1)")
	WebElement getTitle;
	@FindBy (css = "div.mrg10T:nth-child(4) > label:nth-child(1) > input:nth-child(1)")
	WebElement setPassword;
	@FindBy (css = "div.ng-scope:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
	WebElement newPassword;
	@FindBy (css = "input.ng-isolate-scope")
	WebElement retypeNewPassWord;
	@FindBy (css = "#data-table-customerList_filter > label:nth-child(1) > input:nth-child(1)")
	WebElement filterBox;
	@FindBy (css = ".sorting_1")
	WebElement chooseToEdit;
	@FindBy (css = ".glyphicon-edit")
	WebElement btnEdit;
	
	//Get table
	@FindBy (css = ".table")
	WebElement customerTable;
	@FindBy (css = ".table > tbody:nth-child(2)")
	WebElement customerTable2;
	
	//Notification
	@FindBy (css = ".lobibox-notify")
	WebElement errorDupEmail;
	@FindBy (css = ".has-error > div:nth-child(2) > p:nth-child(3)")
	WebElement wrongFormatEmail;
	@FindBy (css = ".lobibox-notify-wrapper")
	WebElement codeIsExist;
	@FindBy (css = ".lobibox-notify")
	WebElement createSuccessNoti;
	@FindBy (css = "div.has-error:nth-child(1) > div:nth-child(2) > p:nth-child(2)")
	WebElement errLimitPassword;
	
	//Button
	@FindBy (css = ".open > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)")
	WebElement btnDeleteAccount;
	@FindBy (css = ".swal2-confirm")
	WebElement btnYesDelete;
	@FindBy (css = ".open > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
	WebElement btnSetPassword;
	
	//login Account Test
	@FindBy (css = ".acc-btn")
	WebElement profileIcon;
	@FindBy (css = "li.last:nth-child(2) > a:nth-child(1)")
	WebElement btnSignOut;
	
	//Login Page
	@FindBy (id = "Username")
	WebElement vUsername;
	@FindBy (id = "Password")
	WebElement vPassword;
	@FindBy (css = ".buttonGreen")
	WebElement btnLogin;
	
	public static Date date = new Date();
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");

	public static String formattedDate = sdf.format(date);
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public CustomerMngPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
	}
	
	public void reachToCustomerSection() throws InterruptedException {
		
		Actions hover = new Actions(driver);
		
		hover.moveToElement(btnMonitor).build().perform();
		
		try {
	    
			Thread.sleep(5000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		clickOnCustomerMng.click();
		
		String titleCustomerPage = getTitle.getText();
		
		Assert.assertEquals("Customer Management", titleCustomerPage);
	
	}
	
	public void AddCustomer(String sAccountName, String sEmail, String sAccountType, String sEnable,String sNewPassword,String sRetypePassword, String sCode, 
			String sFullName, String sAddress, String Company, String sCountry, String CountryCode, String PhoneNo) {
		
		
		addCustomer.click();
		
		inpAccountName.sendKeys(sAccountName);
		
		inpEmail.sendKeys(sEmail + "@gmail.com");
		
		accType.click();
		
		if(sAccountType.contains("Standard")) {
			
			System.out.println("Account Type : Standard");
			
			standardType.click();
			
		}else {
			
			System.out.println("Account Type : Trial");
			
			trialType.click();
			
		}
		
		if(sEnable.contains("Y")) {
			
			System.out.println("Is Enable : Yes");
			
			btnEnable.click();
			
		}else {
			
			System.out.println("Is Enable : No");
			
		}
		
		if(setPassword.isEnabled()) {

			System.out.println("Sending Password...");
			
			System.out.println("Password : " + sNewPassword);
			
			newPassword.sendKeys(sNewPassword);
			
			retypeNewPassWord.sendKeys(sRetypePassword);
			
		}else {
			
			setPassword.click();
			
			System.out.println("Sending Password...");
			
			System.out.println("Password : " + sNewPassword);
			
			newPassword.sendKeys(sNewPassword);
			
			retypeNewPassWord.sendKeys(sRetypePassword);
			
		}
		
//		if(!errLimitPassword.isDisplayed()) {
//
//			System.out.println(errLimitPassword.getText().trim());
//			
//			Assert.assertNotEquals(errLimitPassword.getText().trim(), "Your password has at least 8 characters, maximize 20 characters.");
//			
//		}
		
		inpCode.sendKeys(sCode);
		
		inpFullName.sendKeys(sFullName);
		
		inpAddress.sendKeys(sAddress);
		
		impCompany.sendKeys(Company);
		
		inpCountry.sendKeys(sCountry);
		
		inpCountryCode.sendKeys(CountryCode);
		
		inpPhoneNo.sendKeys(PhoneNo);
		
		btnSave.click();
		
		try {
			
	        
			Thread.sleep(1000);
	
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		if(createSuccessNoti.getText().contains("The new account has created")) {
		
			System.out.println("Create account Successful");
			
		}else if(errorDupEmail.getText().contains("Email has existed in system")) {
		
			System.out.println("Email is exist. Please use another email");
	
		}else if(wrongFormatEmail.getText().contains("Wrong format")) {
			
			System.out.println("Wrong email format.");
		
		}else if (codeIsExist.getText().contains("Code has existed in system")) {
			
			System.out.println("Code has existed in system. Please use another email");
			
		}
		
		String getTitleCreateAccount = getTitle.getText();
		
		Assert.assertNotEquals(getTitleCreateAccount, "Create Account");
		
	}

	public void editAccount (String editAccount, String sAccountname) {
		
		filterBox.sendKeys(sAccountname);
		
		try {
	        
			Thread.sleep(1000);
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			executor.executeScript("arguments[0].click();", chooseToEdit);
			
			btnEdit.click();
	
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		}
	
	public void loginAccoutTest(String sAccountName, String sNewPassword) {
		
		Actions actions = new Actions(driver);
		
	  	actions.moveToElement(profileIcon).click().build().perform();
		
		try {
			
	        
			Thread.sleep(5000);
	    } 
		
		catch (InterruptedException e) {
	    
			e.printStackTrace();
			
	    }   
		
		btnSignOut.click();
		
		vUsername.sendKeys(sAccountName);
		
		vPassword.sendKeys(sNewPassword);
		
		btnLogin.click();
		
		try {
			
	        
			Thread.sleep(1000);
	    } 
		
		catch (InterruptedException e) {
	    
			e.printStackTrace();
			
	    }   
		
		String getProfileQuest = profileIcon.getText().trim();
		
		Assert.assertEquals(getProfileQuest, sAccountName);
		
		System.out.println("Login Guest Account Successful!");
		
		Actions actions2 = new Actions(driver);
		
	  	actions2.moveToElement(btnMonitor).click().build().perform();
		
		List<WebElement> guestMonitor = subMenu.findElements(By.tagName("li"));
		
		int getGuestMonitor = guestMonitor.size();		
		
		for(int i = 0; i < getGuestMonitor; i++) {
			
			String getListGuestMonitor = guestMonitor.get(i).getText();
			
			System.out.println(getListGuestMonitor);
			
		}
		
	}

	public void deleteAccount() {
		
		List<WebElement> tableRows = customerTable2.findElements(By.tagName("th"));
		
		int rowCount = tableRows.size();
		
		for(int i = 1; i < rowCount; i++) {
			
			WebElement hoverSettingBtn = driver.findElement(By.cssSelector("tr.ng-scope:nth-child("+ (i+1) +") > th:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)"));
			
			Actions hoverSetting = new Actions(driver);

			hoverSetting.moveToElement(hoverSettingBtn).click().build().perform();
			
			if(hoverSettingBtn.isDisplayed()) {
				
				btnDeleteAccount.click();
				
				btnYesDelete.click();
				
			}else {
				
				System.out.println("Nothing to delete!");
	
			}
			
		}

	}
	
}
