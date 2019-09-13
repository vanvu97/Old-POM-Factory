package vPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivatedProcessPage {
	
	//Reach to Activate
	@FindBy (css = "ul.noBrd-tree:nth-child(4) > li:nth-child(1) > ul:nth-child(4)")
	WebElement listUl;
	@FindBy (css = "li.menu-level-0:nth-child(7) > a:nth-child(1) > span:nth-child(2)")
	WebElement btnActivate;
	
	//Title
	@FindBy (css = ".page-header > h1:nth-child(1)")
	WebElement getTitle;
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ActivatedProcessPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void reachToDocumentTrackingSection() {
		
		Actions hover = new Actions(driver);
		
		hover.moveToElement(btnActivate).doubleClick().build().perform();
		
		try {
	    
			Thread.sleep(5000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    } 
		
		try {
		    
			Thread.sleep(5000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    } 
		
		btnActivate.click();
		
	}
	
	public void createSchedule(String sProcessName) {
		
		try {
		    
			Thread.sleep(5000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    } 
	
		List<WebElement> uiLines = listUl.findElements(By.tagName("a"));
		
		int uiLineCount = uiLines.size();
		
		for (int row = 0; row < uiLineCount; row++) {
			
			String getProcessName = uiLines.get(row).getText().trim();
	
				if (getProcessName.contains(sProcessName)){
					 
					WebElement hoverListProcess = driver.findElement(By.xpath("//*[contains(text(), '" + sProcessName + "')]/preceding-sibling::a[1]"));
					
					System.out.println(hoverListProcess);
					
					try {
					    
						Thread.sleep(5000);
				    
					} catch (InterruptedException e) {
				    
						e.printStackTrace();
				    } 
					
					hoverListProcess.click();
					
					WebElement cursorPointer = driver.findElement(By.xpath("//*[contains(text(), 'Create a schedule')]"));
					
					if(cursorPointer.isDisplayed() && cursorPointer.isEnabled()) {
						
						WebDriverWait wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Create a schedule')]"))).click();
						
						
						
					}
				
				} 
			
			}
	
		}
	
}
