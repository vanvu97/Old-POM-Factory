package vPages;

import java.io.FileNotFoundException;
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
	@FindBy (css = "select.ng-pristine > option:nth-child(2)")
	WebElement types;
	@FindBy (css = "div.mrg10T:nth-child(3) > label:nth-child(1) > span:nth-child(2)")
	WebElement radioSynch;
	@FindBy (css = "div.mrg10T:nth-child(4) > label:nth-child(1) > span:nth-child(2)")
	WebElement radioEnable;
	@FindBy (css = "#collapse_fieldProfile > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	WebElement inpCode;
	@FindBy (css = "input.ng-invalid:nth-child(1)")
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
	//Click Next button
	@FindBy (css = ".pagination > li:nth-child(6) > a")
	static WebElement btnNext;
	//Get table
	@FindBy (css = ".table")
	WebElement customerTable;
	
	//Create account Name
	String randomAccountName = RandomStringUtils.randomNumeric(5);
	String accountName = "AccountTest" + randomAccountName;
	//Create a Random Email & Send String
	String createRandomEmail = RandomStringUtils.randomAlphabetic(6);
	String randomEmail = createRandomEmail + "@gmail.com";
	//Create random Code & Send String
	String createRandomCode = RandomStringUtils.randomNumeric(6);
	//Create full-name & Send String
	String createRandomName = RandomStringUtils.randomAlphabetic(6);
	//Create Address & Send String
	String createAddressNumb = RandomStringUtils.randomNumeric(3);
	String createAddressName = RandomStringUtils.randomAlphabetic(9);
	String address = createAddressNumb + " - " + createAddressName;
	//Company
	String[] Company = { "Google", "Facebook", "DI-Central", "Yahoo", "Honda", 
					"Yamaha"};
	//Create Country & Send String
	String[] Country = { "VietNam", "United States", "Japan", "Hong Kong", "India", 
			"Yamaha"};
	//Create Country Code
	String[] CountryCode = { "84", "1", "81", "852", "	91", 
			"Yamaha"};
	//Create random Phone No.
	String createPhoneNo = RandomStringUtils.randomNumeric(7);
	String PhoneNo = "090" + createPhoneNo;



	
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
	public void AddCustomer() {
		addCustomer.click();
		//Create account Name
		inpAccountName.sendKeys(accountName);
		//Create a Random Email & Send String
		inpEmail.sendKeys(randomEmail);
		//Choose account Type
		accType.click();
		types.click();
//		if(radioSynch.isSelected()) {
//			System.out.println("Synchronize is Selected");
//		}else if(radioEnable.isSelected()) {
//			System.out.println("Enable is Selected");
//		}else if(!radioEnable.isSelected()) {
//			System.out.println("Enable is Checking");
//			radioEnable.click();
//		}
		//Create random Code & Send String
		inpCode.sendKeys(createRandomCode);
		//Create full-name & Send String
		inpFullName.sendKeys(createRandomName);
		//Create Address & Send String
		inpAddress.sendKeys(address);
		//Company
		impCompany.sendKeys(Company[2]);
		//Create Country & Send String
		inpCountry.sendKeys(Country[1]);
		//Create Country Code
		inpCountryCode.sendKeys(CountryCode[1]);
		//Create random Phone No.
		inpPhoneNo.sendKeys(PhoneNo);
		//Save
		btnSave.click();
	}
	
	public void PrintInfo() {
		//Summary Information
		System.out.println("Account Name : " + accountName);
		System.out.println("Email : " + randomEmail);
		System.out.println("Code : " + createRandomCode);
		System.out.println("Name : " + createRandomName);
		System.out.println("Address : " + address);
		System.out.println("Country : " + Country[1]);
		System.out.println("Country Code : " + CountryCode[1]);
		System.out.println("PhoneNo : " + PhoneNo);
		System.out.println("=======================================");
	}
	public void setPassword() throws FileNotFoundException, InterruptedException { 
		
		List<WebElement> tableRows = customerTable.findElements(By.tagName("tr"));
		//Count numb rows in table
		int rowCount = tableRows.size();
		for (int row = 0; row < rowCount; row++) {
			List<WebElement> columnsRow = customerTable.findElements(By.tagName("td"));
			int columnsCount = columnsRow.size();
//			System.out.println("Numb of cells in Row " + row + " are " + columnsCount);
			for (int column = 0; column < columnsCount; column++) {
				 String celtext = columnsRow.get(column).getText();
//	    	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
				 if(celtext=="000") {
					 System.out.println("+++++++++++");
				 }else {
					 System.out.println("-----------");
				 }
				 System.out.println(celtext);
			}
			System.out.println("=======================================");
		}

		
	}
}
