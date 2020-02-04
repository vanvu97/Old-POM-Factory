package vPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapPage {
	
	@FindBy (css = "button.font-black")
	WebElement btnCloseVideo;
	@FindBy (css = ".btn-stroke")
	WebElement btnNew;	
	@FindBy (css = "select.form-control")
	WebElement selectType;
	@FindBy (xpath = "/html/body/div[1]/div/div/form/div[2]/div/div[1]/div[1]/select/optgroup[3]/option")
	WebElement MapEditor;
	@FindBy (css = "input.ng-invalid")
	WebElement inpName;
	@FindBy (css = ".btn-hover-stroke-info")
	WebElement btnCreate;
	@FindBy (css = ".lobibox-notify")
	WebElement notificationPopup;
	
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[1]/div[1]/div[1]/button")
	WebElement sourceProfile;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[3]/div[1]/div/button")
	WebElement targetProfile;
	@FindBy (css = "#sourceProfileName")
	WebElement chooseSource;
	@FindBy (css = "#targetProfileName")
	WebElement ChooseTarget;
	@FindBy (css = ".open > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
	WebElement firstSelect;
	
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[1]/div[2]/div/ul/li/ul/li[1]/span/span[3]")
	WebElement firstSourceElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[3]/div[2]/div/ul/li/ul/li[1]/span/span[3]")
	WebElement firstTargetElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[1]/div[2]/div/ul/li/ul/li[2]/ul/li[1]/span/span[3]")
	WebElement secondSourceElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[3]/div[2]/div/ul/li/ul/li[2]/ul/li[1]/span/span[3]")
	WebElement secondTargetElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[1]/div[2]/div/ul/li/ul/li[2]/ul/li[2]/ul/li[1]/span/span[3]")
	WebElement thirdSourceElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[3]/div[2]/div/ul/li/ul/li[2]/ul/li[2]/ul/li[1]/span/span[3]")
	WebElement thirdTagetElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[1]/div[2]/div/ul/li/ul/li[2]/ul/li[2]/ul/li[2]/ul/li/span/span[3]")
	WebElement fourthSourceElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[3]/div[2]/div/ul/li/ul/li[2]/ul/li[2]/ul/li[2]/ul/li/span/span[3]")
	WebElement fourthTargetElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[1]/div[2]/div/ul/li/ul/li[2]/ul/li[2]/ul/li[3]/ul/li/span/span[3]")
	WebElement fifthSourceElement;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div/div[2]/div/div[3]/div[2]/div/ul/li/ul/li[2]/ul/li[2]/ul/li[3]/ul/li/span/span[3]")
	WebElement fifthTargetElement;
	
	
	
	WebDriver driver;
	WebDriverWait wait;

	
	public MapPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void CreateMapEditor(String SourceName, String TargetName, String MapName) {
	
		try {
		    
			Thread.sleep(3000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		if (btnCloseVideo.isDisplayed()) {
			
			btnCloseVideo.click();
			
		}
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", btnNew);
		
		try {
		    
			Thread.sleep(1000);
			
			selectType.click();
			
			executor.executeScript("arguments[0].click();", selectType);
			
			MapEditor.click();
			
			inpName.sendKeys(MapName);
	    
			executor.executeScript("arguments[0].click();", btnCreate);
				
			executor.executeScript("arguments[0].click();", sourceProfile);

			chooseSource.sendKeys("!!!VVSource");
			
			Thread.sleep(3000);
			
			firstSelect.click();
			
			executor.executeScript("arguments[0].click();", targetProfile);
			
			ChooseTarget.sendKeys("!!!VVTarget");
			
			Thread.sleep(3000);
			
			firstSelect.click();
			
			Actions DragDrop = new Actions(driver);
			
			Thread.sleep(1000);
			
			DragDrop.dragAndDrop(firstSourceElement, firstTargetElement).build().perform();

			DragDrop.clickAndHold(firstSourceElement).moveToElement(firstTargetElement).release(firstTargetElement).perform();
			
			
//			DragDrop.dragAndDrop(secondSourceElement, secondTargetElement).build().perform();
//			
//			DragDrop.dragAndDrop(thirdSourceElement, thirdTagetElement).build().perform();
//			
//			DragDrop.dragAndDrop(fifthSourceElement, fifthTargetElement).build().perform();
			
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }  
		
		
		
	}
	
}
