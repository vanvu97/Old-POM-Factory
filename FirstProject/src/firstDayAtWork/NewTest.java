package firstDayAtWork;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;


public class NewTest {
	private String sUserID = "vanvu.vv97@gmail.com";
	private String sPassword = "2";
	
	WebDriver driver;
  @Test
  public <FirefoxProfiles> void main() throws InterruptedException{
	  
	  WebElement inputEmail = driver.findElement(By.cssSelector("input[name='email']"));
	  inputEmail.sendKeys(sUserID);
	  
	  WebElement inputPass = driver.findElement(By.cssSelector("[name='pass']"));
	  inputPass.sendKeys(sPassword);
	  
	  driver.findElement(By.cssSelector("#loginbutton")).click();
	  
	  driver.findElement(By.xpath(".//*[@class='uiToggle _4962 _1z4y _330i _4kgv']//*[@class='jewelButton _3eo8']")).click();
	  
	  driver.findElement(By.xpath(".//*[@href='https://www.facebook.com/messages/t/2130213913663112']")).click();
	  
	  final String randomNumb = RandomStringUtils.randomNumeric(7);
	  
	  final String phoneNumber = "090" + randomNumb;
	  
	  WebElement inpiText = driver.findElement(By.xpath(".//*[@class='_5rpb']//*[@role='combobox']"));
	  
	  inpiText.sendKeys(phoneNumber);
	 

	  
	  
	  driver.findElement(By.xpath(".//*[@class='_6gd _21u1']//*[@class='_6gb _6wm4 _6987']")).click();
	  
	  driver.findElement(By.id("userNavigationLabel")).click();
	  
	  driver.findElement(By.xpath(".//*[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")).click();
	  
	  driver.close();
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  
//	  WebElement inpUserID = driver.findElement(By.id("__control0-user-inner"));
//	  inpUserID.click();
//	  inpUserID.sendKeys(sUserID);
//	  
//	  WebElement inpPassword = driver.findElement(By.id("__control0-pass-inner"));
//	  inpPassword.click();
//	  inpPassword.sendKeys(sPassword);
//	  //click login button
//	  driver.findElement(By.id("__control0-logonBtn-content")).click();
//	  //click continue button
//	  driver.findElement(By.id("__control1-continueBtn-content")).click();
//	  //Wait until visible
//	  WebDriverWait waitTitle = new WebDriverWait(driver, 15);
//	  waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.id("__text3")));
//	  
////	  WebElement listMenu = driver.findElement(By.xpath(".//*[@class='sapBUiNoPrint']//*[@id=\"__button0\"]"));
////	  listMenu.click();
//	  
//	  WebElement users = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='sapBUiNoPrint']//*[@id=\\\"__button0\\\"]")));
//	  users.click();
//	  
//	  WebElement Element = driver.findElement(By.xpath(".//*[@id='__item437']//*[contains(text(), 'Outbound Logistics')]"));
//	  js.executeScript("arguments[0].scrollIntoView();", Element);
//	  Element.click();
//	  
//	  driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div/div[1]/div[2]/div[2]/div[2]")).click();
	  
//	  //Click to show list select
//	  driver.findElement(By.id("__button0")).click();
//	  //Click Sales Orders line
//	  driver.findElement(By.xpath(".//*[@id='__item127']")).click();
//	  //Click on New Sales Order
//	  driver.findElement(By.xpath(".//*[@class='sapBUiCenterMnuItem sapBUiCenterMnuItemHoverable sapBUiCenterMnuItemIndent']//*[contains(text(), 'New Sales Order')]")).click();
//	  //Wait for New Sales Order
//	  WebDriverWait waitNewSalesOrder = new WebDriverWait(driver, 15);
//	  waitNewSalesOrder.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='__input2']//*[@class='sapMInputBaseInner']")));
//	  
//	  //Wait until the overlay disappears
//	 
//
//	  //Input Account'Name
//	  WebElement AccountName = driver.findElement(By.xpath(".//*[@id='__input2']//*[@class='sapMInputBaseInner']"));
//	  AccountName.click();
//	  AccountName.sendKeys("N-082");
//	  //Choose Name
//	  WebElement ExternalReference = driver.findElement(By.id("__item406-__input2-0-dli-content"));
//	  ExternalReference.click();
//	  ExternalReference.sendKeys("112233");
	  
	 /* ----------------------------------------------*/
	  
//	  driver.get("http://diweb5test.dicentral.com/Main.aspx");
//	  
//	  
//	  WebElement diwebUser = driver.findElement(By.id("fTbxUserName"));
//	  diwebUser.click();
//	  diwebUser.sendKeys("diallusers");
//	  
//	  WebElement diwebPass = driver.findElement(By.id("fTbxPassword"));
//	  diwebPass.click();
//	  diwebPass.sendKeys("di17625;mai");
//	  
//	  WebElement secondsUserID = driver.findElement(By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpUserId_I"));
//	  secondsUserID.click();
//	  secondsUserID.sendKeys("drupp");
//	  
//	  WebElement secondsPassword = driver.findElement(By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpSecPassword_I"));
//	  secondsPassword.click();
//	  secondsPassword.sendKeys("dicentral");
//	  
//	  driver.findElement(By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fBtnLogin_CD")).click();
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\vuvan\\Downloads\\Driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	  ChromeOptions options = new ChromeOptions();
//	  options.addArguments("disable-infobars");
//	  WebDriver driver = new ChromeDriver(options);
	  driver.get("https://fb.com");
		
  }

  @AfterTest
  public void afterTest() {
  }

}
