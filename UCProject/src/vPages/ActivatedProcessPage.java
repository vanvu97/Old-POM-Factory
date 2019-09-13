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

public class ActivatedProcessPage {
	
	public static Date date = new Date();
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

	public static String formattedDate = sdf.format(date);
	
	//Reach to Activate
	@FindBy (css = "ul.noBrd-tree:nth-child(4) > li:nth-child(1) > ul:nth-child(4)")
	WebElement listUl;
	@FindBy (css = "li.menu-level-0:nth-child(7) > a:nth-child(1) > span:nth-child(2)")
	WebElement btnActivate;
	
	//Title
	@FindBy (css = ".page-header > h1:nth-child(1)")
	WebElement getTitle;
	
	//Open Schedule Table
	@FindBy (css = "ul.noBrd-tree:nth-child(4) > li:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > ul:nth-child(4) > li:nth-child(1) > a:nth-child(2)")
	WebElement firstProcess;
	@FindBy (css = ".open > ul:nth-child(4) > li:nth-child(1) > a:nth-child(1)")
	WebElement createScheduleText;
	@FindBy (css = "#process_name")
	WebElement listProcessName;
	@FindBy (css = "#schedule_navtabs > li:nth-child(2) > a:nth-child(1)")
	WebElement btnSetting;
	@FindBy (css = ".panel-title")
	WebElement titlePanel;
	@FindBy (css = "#datepicker-1")
	WebElement fromDate;
	@FindBy (css = "#timepicker-1")
	WebElement timeStar;
	@FindBy (xpath = "/html/body/div[4]/div[3]/table/tfoot/tr[1]/th")
	WebElement btnToday;
	@FindBy (css = "button.btn-stroke")
	WebElement btnSave;
	@FindBy (css = "#settingSchedule > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > label:nth-child(2)")
	WebElement runDaily;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
	WebElement recurEvery;
	
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ActivatedProcessPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void doucumenentTrackingPgs() {
		
		Actions hover = new Actions(driver);
		
		hover.moveToElement(btnActivate).doubleClick().build().perform();
		
		try {
	    
			Thread.sleep(5000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    } 
		
		btnActivate.click();
		
	}
	
	public void scheduleSection(String sProcessName) {
		
		try {
		    
			Thread.sleep(3000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    } 
	
//		List<WebElement> uiLines = listUl.findElements(By.tagName("a"));
//		
//		int uiLineCount = uiLines.size();
//		
//		for (int row = 0; row < uiLineCount; row++) {
//			
//			String getProcessName = uiLines.get(row).getText().trim();
//	
//				if (getProcessName.contains(sProcessName)){
//					 
//					WebElement hoverListProcess = driver.findElement(By.xpath("//*[contains(text(), '" + sProcessName + "')]/preceding-sibling::a[1]"));
//					
//					System.out.println(hoverListProcess);
//					
//					try {
//					    
//						Thread.sleep(3500);
//				    
//					} catch (InterruptedException e) {
//				    
//						e.printStackTrace();
//				    } 
//					
//					hoverListProcess.click();
//					
//					WebElement cursorPointer = driver.findElement(By.xpath("//*[contains(text(), 'Create a schedule')]"));
//					
//					if(cursorPointer.isDisplayed() && cursorPointer.isEnabled()) {
//						
//						WebDriverWait wait = new WebDriverWait(driver, 30);
//						
//						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Create a schedule')]"))).click();
//						
//					}
//				
//				} 
//			
//			}
		
		firstProcess.click();
		
		createScheduleText.click();
		
		listProcessName.click();
		
		driver.findElement(By.xpath(".//option[contains(text(), '"+ sProcessName  +"')]")).click();
		
		btnSetting.click();
	
		Assert.assertEquals(titlePanel.getText().trim(), "Create a schedule");
		

	}
	
	public void runOnetime(String setTime) {
		
		fromDate.click();
		
		System.out.println(formattedDate);
		
		Actions actions = new Actions(driver);
		
	  	actions.moveToElement(btnToday).click().build().perform();
	  	
	  	timeStar.clear();
	  	
	  	timeStar.sendKeys(setTime);
		
//	  	btnSave.click();
		
	}
	
	public void runDaily(String setTime, String recurTime) {
		
		runDaily.click();
		
		fromDate.click();
		
		System.out.println(formattedDate);
		
		Actions actions = new Actions(driver);
		
	  	actions.moveToElement(btnToday).click().build().perform();

	  	timeStar.click();
	  	
	  	timeStar.clear();
	  	
	  	timeStar.sendKeys(setTime);
	  	
	  	recurEvery.clear();
	  	
	  	recurEvery.sendKeys(recurTime);
	  	
//	  	btnSave.click();

	}
	
}
