package diPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExportSalesOrderPage {
			//Search Keyword
			@FindBy (css = "[name='fInboxControl$fTbxDocId']")
			WebElement searchBox;
			@FindBy (id ="fInboxControl_btnSearch")
			WebElement btnSearchKeyWord;
			
			//tick Document ID
			@FindBy (css = "#headerRepeater > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
			WebElement tickCheckBox;
			
			//Choose action export
			@FindBy (css = "[name='fInboxControl$fCbxUpAction']")
			WebElement actionLists;
			@FindBy (xpath = ".//*[@value='btnExportToCloudSalesOrder|cloud/BYD/ExportSO_V2.aspx']")
			WebElement chooseExport;
			@FindBy (css = "[name='fInboxControl$btnUpGo']")
			WebElement btnOK2;
			
			//Switch to new windows and perform
			@FindBy (css = "#jqg_jsGrid_2019030000046436")
			WebElement tickCheckBox2;
			@FindBy (id = "reSend")
			WebElement btnReSend;
			
			//Get text in Message box
			@FindBy (xpath = "/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")
			WebElement messageBox;
			@FindBy (xpath = "/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")
			WebElement getSaleID;
			
			//research
			@FindBy (css = "#the-list td a")
			private List<WebElement> postList; 
		
			WebDriver driver;
			WebDriverWait wait;
			
			public ExportSalesOrderPage(WebDriver driver) {
				this.driver = driver;
				wait = new WebDriverWait(driver, 20);
				PageFactory.initElements(driver, this);
			}
	
			public void search850files(String keyword) throws InterruptedException {
	
	//Wait for element is display
//			WebDriverWait waitTitle = new WebDriverWait(driver, 15);
//			waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='fInboxControl$fTbxDocId']")));
//		searchBox.sendKeys(keyword);
//		btnSearchKeyWord.click();
//		
//		//Wait for element is display
//		
//		Thread.sleep(2000);
		
		//tickCheckBox.click();
		WebDriverWait waitTitle2 = new WebDriverWait(driver, 15);
		waitTitle2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headerRepeater > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")));
		
		//tickCheckBox.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", tickCheckBox);

		//actionLists.click();
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", actionLists);
		//choose Export
		chooseExport.click();
		btnOK2.click();
		
		 // Store the current window handle
		
	}

	public void getSalesID() throws InterruptedException {
		for(String winHandle : driver.getWindowHandles()){
		  	  driver.switchTo().window(winHandle);
			}
			tickCheckBox2.click();
			btnReSend.click();	
			Thread.sleep(3000);
			
		String getTextMessages = messageBox.getText();
		int DoDai = getTextMessages.length();
		
		if(!getSaleID.isDisplayed()) {				
			if(DoDai >= 60) {
				String Sales_Order_ID = getTextMessages.substring(getTextMessages.lastIndexOf(" ")+1);
				System.out.println(Sales_Order_ID);
			}else {
				System.out.println("Can't Get Sales Ordder ID!!!" + getTextMessages);
			} 
		}else {
			WebDriverWait waitMessageBox = new WebDriverWait(driver, 15);
			waitMessageBox.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[4]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]")));
			
			String Sales_Order_ID = getTextMessages.substring(getTextMessages.lastIndexOf(" ")+1);
			System.out.println(DoDai + "words"); 
			System.out.println(Sales_Order_ID);
			
		}	
	}
	
//	public boolean bodyHasKeyword(String keyword) {
//		List<WebElement> paragraphs = driver.findElements(By.id("headerRepeater"));
//		for (int i = 0; i < paragraphs.size(); i++) {
//			String p = paragraphs.get(i).getText();
//			if (!(p.contains(keyword))) {
//				return true;
//			}
//		}
//		return false;
//	}
//	public boolean isDisplayed() {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
