package vPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XMLProfile {
	
	@FindBy (css = ".btn-stroke")
	WebElement btnNew;	
	@FindBy (css = "select.form-control")
	WebElement selectType;
	@FindBy (css = "select.form-control > optgroup:nth-child(3) > option:nth-child(1)")
	WebElement XMLprofile;
	@FindBy (css = "input.ng-invalid")
	WebElement inpName;
	@FindBy (css = ".btn-hover-stroke-info")
	WebElement btnCreate;
	@FindBy (css = "div.panel-table-cell:nth-child(3) > button:nth-child(1)")
	WebElement btnImport;
	@FindBy (css = ".font-black")
	WebElement adsElement;
	
	WebDriver driver;
	WebDriverWait wait;

	
	public XMLProfile(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void CreateXMLProfile() {
		
		try {
		    
			Thread.sleep(3000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		adsElement.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnNew);
		
		selectType.click();
		
		XMLprofile.click();

		inpName.sendKeys("Test");
		
		btnCreate.click();
		
//		btnImport.click();
		
		btnImport.sendKeys("C:\\Desktop\\Sublime\\Profile_NS_addList_Customer.xml");
		
	}
	
}
