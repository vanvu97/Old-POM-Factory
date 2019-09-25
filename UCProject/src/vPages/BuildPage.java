package vPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildPage {
	
	@FindBy (css = "li.menu-level-0:nth-child(6) > a:nth-child(1) > span:nth-child(2)")
	WebElement btnBuild;
	@FindBy (css = "button.btn-stroke")
	WebElement addNewProcess;
	@FindBy (css = "select.form-control")
	WebElement typeList;
	@FindBy (css = "select.form-control > optgroup:nth-child(2) > option:nth-child(1)")
	WebElement processType;
	@FindBy (css = "input.ng-invalid")
	WebElement setProcessName;
	@FindBy (css = ".btn-hover-stroke-info")
	WebElement btnCreate;
	@FindBy (css = "div.window:nth-child(4) > a:nth-child(1) > div:nth-child(1)")
	WebElement SOAP;
	@FindBy (css = "div.jtk-endpoint:nth-child(7) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement startSOAP;
	@FindBy (css = "div.jtk-endpoint:nth-child(6) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement endSOAP;
	@FindBy (css = "div.jtk-endpoint:nth-child(4) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement radioFlashStart;
	@FindBy (css = "div.jtk-endpoint:nth-child(5) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement radioFlashEnd;
	@FindBy (css = ".jtk-demo-main")
	WebElement sTable;
	@FindBy (css = ".page-header > h1:nth-child(1)")
	WebElement geaderTitle;
	@FindBy (css = "div.footer:nth-child(3) > button:nth-child(1)")
	WebElement btnSave;
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public BuildPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
	}
	
	public void buildProcess (String ProcessName) {
		
		try {
		    
			Thread.sleep(4000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
			
	    }   
		
		btnBuild.click();
		
//		if (geaderTitle.isDisplayed()) {
//			
//			btnBuild.click();
//			
//		}else {
//			
//			System.out.println("Done!");
//			
//		}
		
		addNewProcess.click();
		
		typeList.click();
		
		processType.click();
		
		setProcessName.sendKeys(ProcessName);
		
		btnCreate.click();
		
		try {
		    
			Thread.sleep(4000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
			
	    }   
		
		Actions ats2 = new Actions(driver);
		
		ats2.dragAndDrop(radioFlashStart, startSOAP).build().perform();
		
		ats2.dragAndDrop(endSOAP, radioFlashEnd).build().perform();
		
		btnSave.click();
		
	}
	
}
