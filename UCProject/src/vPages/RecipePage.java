package vPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecipePage {
	
	@FindBy (css = "button.font-black")
	WebElement btnCloseVideo;
	@FindBy (css = ".list__btn > li:nth-child(1) > a:nth-child(1)")
	WebElement BtnRecipe;
	@FindBy (css = "input.ng-valid-maxlength")
	WebElement InputName;
	@FindBy (css = ".btn-hover-stroke-info")
	WebElement btnCreate;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[2]/div[2]/ng-include/div/div[2]/div/div/div[3]/a")
	WebElement DISK;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[2]/div[2]/ng-include/div/div[2]/div/div/div[4]/a")
	WebElement SOAP;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[2]/div[2]/ng-include/div/div[2]/div/div/div[6]/a")
	WebElement MAP;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[3]/a/div[2]/h4")
	WebElement SOAP2;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[4]/a/div[2]/h4")
	WebElement MAP2;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[5]/a/div[2]/h4")
	WebElement DISK2;
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/ng-include/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[1]/a/div[2]/h4")
	WebElement to;
	@FindBy (css = "div.jtk-endpoint:nth-child(6) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement StartEnd;
	@FindBy (css = "div.jtk-endpoint:nth-child(9) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement SOAPStart;
	@FindBy (css = "div.jtk-endpoint:nth-child(8) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement SOAPEnd;
	@FindBy (css = "div.jtk-endpoint:nth-child(11) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement MAPStart;
	@FindBy (css = "div.jtk-endpoint:nth-child(10) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement MAPEnd;
	@FindBy (css = "div.jtk-endpoint:nth-child(13) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement DISKStart;
	@FindBy (css = "div.jtk-endpoint:nth-child(12) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement DISKEnd;
	@FindBy (css = "div.jtk-endpoint:nth-child(7) > svg:nth-child(1) > circle:nth-child(1)")
	WebElement End;
	@FindBy (css = "div.di__ui-layout-action:nth-child(4) > button:nth-child(1)")
	WebElement btnSave;

	
	
	WebDriver driver;
	WebDriverWait wait;

	
	public RecipePage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void CreateRecipe() {
		
		try {
		    
			Thread.sleep(3000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    }   
		
		if (btnCloseVideo.isDisplayed()) {
			
			btnCloseVideo.click();
			
		}
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", BtnRecipe);
		
		InputName.sendKeys("TestCreate");
		
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", btnCreate);
		
		try {
		    
			Thread.sleep(2000);
	    
		} catch (InterruptedException e) {
	    
			e.printStackTrace();
	    } 
		
		final String JS_DRAG_AND_DROP = "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEff"
				+ "ect:'',effectAllowed:'all',files:[],items:{},types:[],setData:f"
				+ "unction(format,data){this.items[format]=data;this.types.append("
				+ "format);},getData:function(format){return this.items[format];},"
				+ "clearData:function(format){}};var emit=function(event,target){v"
				+ "ar evt=document.createEvent('Event');evt.initEvent(event,true,f"
				+ "alse);evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);}"
				+ ";emit('dragstart',src);emit('dragenter',tgt);emit('dragover',tg"
				+ "t);emit('drop',tgt);emit('dragend',src);";

		JavascriptExecutor ShapeTo = (JavascriptExecutor) driver;
		ShapeTo.executeScript(JS_DRAG_AND_DROP, new Object[] { SOAP, to });
		
		Actions DropNe = new Actions(driver);
		DropNe.dragAndDropBy(SOAP2, 370, 104).build().perform();
		
		ShapeTo.executeScript(JS_DRAG_AND_DROP, new Object[] { MAP, to });
		
		DropNe.dragAndDropBy(MAP2, 133, 184).build().perform(); 
		
		ShapeTo.executeScript(JS_DRAG_AND_DROP, new Object[] { DISK, to });
		
		DropNe.dragAndDropBy(DISK2, 371, 188).build().perform(); 
		
		Actions DropConnect = new Actions(driver);
		
		DropConnect.dragAndDrop(StartEnd, SOAPStart).build().perform();
		
		DropConnect.dragAndDrop(SOAPEnd, MAPStart).build().perform();
		
		DropConnect.dragAndDrop(MAPEnd, DISKStart).build().perform();
		
		DropConnect.dragAndDrop(DISKEnd, End).build().perform();
		
	}
	
}
