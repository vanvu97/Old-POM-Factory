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
	@FindBy (css = "div.window:nth-child(4)")
	WebElement SOAP;
	@FindBy (css = "div.jtk-endpoint:nth-child(3) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement radioFlashStart;
	@FindBy (css = "div.jtk-endpoint:nth-child(4) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement radioFlashEnd;
	@FindBy (css = ".jtk-connector > path:nth-child(2)")
	WebElement lines;
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public BuildPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
	}
	
	public void buildProcess () {
		
		try {
		    
			Thread.sleep(4000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		btnBuild.click();
		
		addNewProcess.click();
		
		typeList.click();
		
		processType.click();
		
		setProcessName.sendKeys("Test123123");
		
		btnCreate.click();
		
		try {
		    
			Thread.sleep(2000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
			
	    }   
		
		Actions ats2 = new Actions(driver);
		
		ats2.dragAndDrop(radioFlashStart, radioFlashEnd).build().perform();
		
		try {
		    
			Thread.sleep(2000);
			
			Actions ats = new Actions(driver);
			
			ats.dragAndDrop(SOAP, radioFlashEnd).build().perform();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
	    }   
		
	}
	
}
