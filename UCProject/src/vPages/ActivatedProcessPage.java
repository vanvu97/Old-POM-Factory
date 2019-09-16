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
	@FindBy (css = "#settingSchedule > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > label:nth-child(2)")
	WebElement runWeekly;
	@FindBy (css = "div.di__table-cell:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > label:nth-child(2)")
	WebElement runMonthly;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
	WebElement recurEvery;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)")
	WebElement listDays;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > label:nth-child(1) > input:nth-child(1)")
	WebElement sMonday;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > label:nth-child(1) > input:nth-child(1)")
	WebElement sTuesday;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > label:nth-child(1) > input:nth-child(1)")
	WebElement sWednesday;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(5) > label:nth-child(1) > input:nth-child(1)")
	WebElement sThursday;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(6) > label:nth-child(1) > input:nth-child(1)")
	WebElement sFriday;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(7) > label:nth-child(1) > input:nth-child(1)")
	WebElement sSaturday;
	@FindBy (css = "#settingSchedule > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(8) > label:nth-child(1) > input:nth-child(1)")
	WebElement sSunday;
	
	//Error Message
	@FindBy (css = ".lobibox-notify-body")
	WebElement error10Mins;
	
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
	
//		List<WebElement> uiLines = listUl.findElements(By.tagName("li"));
//		
//		int uiLineCount = uiLines.size();
//		
//		for (int row = 0; row < uiLineCount; row++) {
//			
//			String getProcessName = uiLines.get(row).getText().trim();
//	
//				System.out.println(getProcessName);
//			
//			}
		
		firstProcess.click();
		
		createScheduleText.click();
		
		listProcessName.click();
		
		driver.findElement(By.xpath(".//option[contains(text(), '"+ sProcessName  +"')]")).click();
		
		btnSetting.click();
	
		Assert.assertEquals(titlePanel.getText().trim(), "Create a schedule");
		

	}
	
	public void runOnetime(String setTime, String recurTime, String runKinds, String sOption) {
		
		switch(runKinds) {
		
		  case "Onetime":
			  
			  fromDate.click();
				
			  System.out.println(formattedDate);
				
			  Actions actions = new Actions(driver);
				
			  actions.moveToElement(btnToday).click().build().perform();
			  	
			  timeStar.clear();
			  	
			  timeStar.sendKeys(setTime);
				
			  btnSave.click();
			  
			  String getText10Mins = error10Mins.getText();
			  
			  Assert.assertNotEquals(getText10Mins, "Scheduler could not run immediately. Time to run scheduler need to be greater than current time 10 minutes.");
				  	
			  break;	
		    
		  case "Daily":
			  
			  runDaily.click();
				
			  fromDate.click();
				
			  System.out.println(formattedDate);
				
			  Actions actions2 = new Actions(driver);
				
			  actions2.moveToElement(btnToday).click().build().perform();
	
			  timeStar.click();
			  	
			  timeStar.clear();
			  	
			  timeStar.sendKeys(setTime);
			  		
			  recurEvery.clear();
			  	
			  recurEvery.sendKeys(recurTime);
			  	
			  btnSave.click();
			  
			  String getText10Mins2 = error10Mins.getText();
			  
			  Assert.assertNotEquals(getText10Mins2, "Scheduler could not run immediately. Time to run scheduler need to be greater than current time 10 minutes.");
			  
			  break;
			  	
		  case "Weekly":
			  
			  runWeekly.click();
			  
			  if(sOption.contains("246cn")) {
		  			
		  			JavascriptExecutor executor = (JavascriptExecutor)driver;
		  			executor.executeScript("arguments[0].click();", listDays);
		  			
		  			sMonday.click();
		  			
		  			sWednesday.click();
		  			
		  			sFriday.click();
		  			
		  			sSunday.click();
		  			
		  			btnSave.click();
	  			
			  	}else if(sOption.contains("357")) {
	  				
	  				JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		  			executor2.executeScript("arguments[0].click();", listDays);
		  			
		  			sTuesday.click();
		  			
		  			sThursday.click();
		  			
		  			sSaturday.click();
		  			
			  	}else if(sOption.contains("all")) {
	  				
	  				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		  			executor3.executeScript("arguments[0].click();", listDays);
	  				
	  				sMonday.click();
		  			
		  			sTuesday.click();
		  			
		  			sWednesday.click();
		  			
		  			sThursday.click();
		  			
		  			sFriday.click();
		  			
		  			sSaturday.click();
		  			
		  			sSunday.click();
		  			
			  }
			  
			  fromDate.click();
				
			  System.out.println(formattedDate);
				
			  Actions actions3 = new Actions(driver);
			
			  actions3.moveToElement(btnToday).click().build().perform();
			  
			  timeStar.click();
			  	
			  timeStar.clear();
			  	
			  timeStar.sendKeys(setTime);
				
			  btnSave.click();
			  
			  String getText10Mins3 = error10Mins.getText();
			  
			  Assert.assertNotEquals(getText10Mins3, "Scheduler could not run immediately. Time to run scheduler need to be greater than current time 10 minutes.");
			  
			  break;
			  
		  case "Monthly":
		    
			  runMonthly.click();
			  
			  System.out.println("Deeploying....");
			  
			  String getText10Mins4 = error10Mins.getText();
			  
			  Assert.assertNotEquals(getText10Mins4, "Scheduler could not run immediately. Time to run scheduler need to be greater than current time 10 minutes.");
			  
			  break;
			  
		  default:
			  
			  System.out.println("Looking for the Process's Name...");
			  
		}
		
	}
	
}
