package vPages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buildPages {
	
	@FindBy (css = "li.menu-level-0:nth-child(6) > a:nth-child(1)")
	WebElement btnBUILD;
	@FindBy (css = ".btn-left_panel")
	WebElement btnNew;
	
	//Switch Form
	@FindBy (css = "select.form-control")
	WebElement choiceType;
	@FindBy (css = "select.form-control > optgroup:nth-child(2) > option:nth-child(1)")
	WebElement choiceProcess;
	@FindBy (css = "input.ng-invalid")
	WebElement inputName;
	@FindBy (css = ".btn-hover-stroke-info")
	WebElement btnCreate;
	
	//Drag and Drop
	@FindBy (css = "div.clearfix:nth-child(4) > a:nth-child(1)")
	WebElement iconSOAP;
	@FindBy (css = "#\\32 5ce21f6-2707-4d64-82b2-84cb4c6d6ddb_wfcanvas")
	WebElement tableMap;
	@FindBy (css = "div.jtk-endpoint:nth-child(3) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement StartP1;
	@FindBy (css = "div.jtk-endpoint:nth-child(4) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement EndP1;
	

	WebDriver driver;
	WebDriverWait wait;
	
	public buildPages(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void buildSection() throws InterruptedException {
		btnBUILD.click();
		btnNew.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
		//driver.switchTo().frame("newComponentForm");
		choiceType.click();
		choiceProcess.click();
		//driver.switchTo().defaultContent();
		
		final String randomNumbers = RandomStringUtils.randomNumeric(4);
		
		inputName.sendKeys("Monthly" + randomNumbers);
		btnCreate.click();
		
		//Using Action class for drag and drop.
		Actions act = new Actions(driver);
	    //Dragged and dropped.      
		Action dragAndDrop2 = act.clickAndHold(iconSOAP).moveToElement(EndP1, 15, 15).release(iconSOAP).build();
		dragAndDrop2.perform();
		
		Thread.sleep(2000);
		
		Actions act2 = new Actions(driver);
		Action dragAndDrop = act2.clickAndHold(StartP1).moveToElement(EndP1).release(StartP1).build();
		dragAndDrop.perform();
		
	}
	
}
