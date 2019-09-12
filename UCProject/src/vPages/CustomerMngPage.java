package vPages;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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
	@FindBy (css = ".font-black")
	WebElement addCustomer;
	
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
	
	//Delete account
	@FindBy (css = ".open > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)")
	WebElement btnDeleteAccount;
	@FindBy (css = ".swal2-confirm")
	WebElement btnYesDelete;
	@FindBy (css = ".open > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
	WebElement btnSetPassword;
	
	//input New Password
	@FindBy (css = "input.ng-valid-pattern")
	WebElement newPassword;
	@FindBy (css = "input.ng-isolate-scope")
	WebElement confirmNewPassword;
	@FindBy (css = "button.btn")
	WebElement btnSavePassword;
	
	//login Account Test
	@FindBy (css = "#topmenu > div > ul > li.navbar-acc.parent > a")
	WebElement profileIcon;
	@FindBy (css = "#topmenu > div > ul > li.navbar-acc.parent > ul > li.menu-level-1.last > a")
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
	
	//Create account Name
	String randomAccountName = RandomStringUtils.randomNumeric(5);
	String accountName = "Test" + formattedDate;
	
	//Random Password
	String numbPass = RandomStringUtils.randomNumeric(3);
	String alphabestPass = RandomStringUtils.randomAlphabetic(9);
	String passWord = alphabestPass + numbPass;

	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public CustomerMngPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
	}
	
	public void reachToCustomerSection() throws InterruptedException {
		
		String titleUA = driver.getTitle();
		
		Assert.assertEquals("Universal Center | DiCentral", titleUA);
		
		//Hover on MonitorButton
		Actions hover = new Actions(driver);
		
		hover.moveToElement(btnMonitor).build().perform();
		
		try {
	    
			Thread.sleep(5000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		clickOnCustomerMng.click();
	
	}
	
	public void AddCustomer(String sAccountName, String sEmail, String sAccountType, String sEnable, String sCode, String sFullName, String sAddress, String Company, String sCountry
			, String CountryCode, String PhoneNo) {
		
		addCustomer.click();
		
		inpAccountName.sendKeys(sAccountName);
		
		inpEmail.sendKeys(sEmail + "@gmail.com");
		
		accType.click();
		
		if(sAccountType.contains("Standard")) {
			
			standardType.click();
			
		}else {
			
			trialType.click();
			
		}
		
		if(sEnable.contains("Y")) {
			
			System.out.println("Is Enable : Yes");
			
			btnEnable.click();
			
		}else {
			
			System.out.println("Is Enable : No");
			
		}
		
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
			
			String types = standardType.getText();
		
			System.out.println("Create account Successful");
			
			System.out.println("Createe Account : " + sAccountName);
			
			System.out.println("Account Type : " + types);
			
		}else if(errorDupEmail.getText().contains("Email has existed in system")) {
		
			System.out.println("Email is exist. Please use another email");
			
			inpEmail.clear();
			
			inpEmail.sendKeys(sEmail + "vv" + "@gmail.com");
	
		}else if(wrongFormatEmail.getText().contains("Wrong format")) {
			
			System.out.println("Wrong email format.");
		
		}else if (codeIsExist.getText().contains("Code has existed in system")) {
			
			System.out.println("Code has existed in system.");
			
			inpCode.clear();
			
			inpCode.sendKeys(sCode + "99");
			
		}
		
	}
	
public void setPassword(String sAccountName, String sPassword) throws FileNotFoundException, InterruptedException {
	
		WebElement enabled_next_page_btn = driver.findElement(By.cssSelector("[ng-click='nextPage()']"));
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
	
		js2.executeScript("arguments[0].click();", enabled_next_page_btn);
		
		try {
			
	        Thread.sleep(1500);
	        
	    } catch (InterruptedException e) {
	    	
	        e.printStackTrace();
	        
	    }   
	    
	    List<WebElement> tableRows = customerTable2.findElements(By.tagName("tr"));
		
		int rowCount = tableRows.size();
		
		for (int row = 0; row < rowCount; row++) {
			
			String getCells = tableRows.get(row).getText().trim();
			
			String firstAccountName = getCells.substring(0, getCells.indexOf(" "));  

				if(firstAccountName.contains(sAccountName)){
				
					System.out.println(firstAccountName + " == PASSED ==");	
					 
					WebElement hoverHintSetting = driver.findElement(By.xpath("//*[contains(text(), '" + sAccountName + "')]"));
					
					Actions builds = new Actions(driver);
					
					builds.moveToElement(hoverHintSetting).click(hoverHintSetting).build().perform();
					
					for (int i = 0; i < rowCount ; i++) {
						
						WebElement btnHINT =  driver.findElement(By.cssSelector("tr.ng-scope:nth-child("+ (i+1) +") > th:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)"));
						
						try {
							
					        
							Thread.sleep(1000);
					    } 
						
						catch (InterruptedException e) {
					    
							e.printStackTrace();
					    }   
						
						JavascriptExecutor js = (JavascriptExecutor)driver;
						
						js.executeScript("arguments[0].click();", btnHINT);
						
					}
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					
					js.executeScript("arguments[0].click();", btnSetPassword);
					
					newPassword.sendKeys(sPassword);
					
					confirmNewPassword.sendKeys(sPassword);
					
					btnSavePassword.click();
					
					System.out.println("Password : " + sPassword);
					
					System.out.println("Set password successfuly");
					
				 }else{
					 
					 System.out.println(firstAccountName + " == FAILED ==");
					 
					 }
					 
				 }
	
			}

	public void editAccount (String editAccount, String sAccountname) {
		
		WebElement enabled_next_page_btn = driver.findElement(By.cssSelector("[ng-click='nextPage()']"));
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
	
		js2.executeScript("arguments[0].click();", enabled_next_page_btn);
	    
	    List<WebElement> tableRows = customerTable2.findElements(By.tagName("tr"));
		
		int rowCount = tableRows.size();
		
		for (int row = 0; row < rowCount; row++) {
			
			String getCells = tableRows.get(row).getText().trim();
			
			String firstAccountName = getCells.substring(0, getCells.indexOf(" "));  

				if(firstAccountName.contains(sAccountname)){
				
					System.out.println(firstAccountName + " == PASSED ==");	
					 
					WebElement hoverHintSetting = driver.findElement(By.xpath("//*[contains(text(), '" + sAccountname + "')]"));
					
					Actions builds = new Actions(driver);
					
					builds.moveToElement(hoverHintSetting).click(hoverHintSetting).build().perform();
					
					for (int i = 1; i < rowCount ; i++) {
						
						WebElement btnHINT =  driver.findElement(By.cssSelector("tr.ng-scope:nth-child("+ (i+1) +") > th:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)"));
						
						JavascriptExecutor js = (JavascriptExecutor)driver;
						
						js.executeScript("arguments[0].click();", btnHINT);
						
					}
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					
					js.executeScript("arguments[0].click();", btnSetPassword);
					
					newPassword.sendKeys(passWord);
					
					confirmNewPassword.sendKeys(passWord);
					
					btnSavePassword.click();
					
					System.out.println("Set password successfuly");
					
				 }else{
					 
					 System.out.println(firstAccountName + " == FAILED ==");
					 
					 }
					 
				 }
		
		}
	public void loginAccoutTest(String sAccountName, String sPassword) {
		
		profileIcon.click();
		
		btnSignOut.click();
		
		try {
			
	        
			Thread.sleep(1000);
	    } 
		
		catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		vUsername.sendKeys(sAccountName);
		
		vPassword.sendKeys(sPassword);
		
		btnLogin.click();
		
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

