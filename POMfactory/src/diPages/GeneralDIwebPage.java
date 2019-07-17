package diPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralDIwebPage {
	
	//Windows 1
	@FindBy (css = "[name='fInboxControl$fCbxUpAction']")
	WebElement click_Action_List;
	@FindBy (xpath = ".//*[@value='btnImportFromCloudImportInvoice|cloud/BYD/Syn.aspx?type=SET']")
	WebElement choose_Master_Page_Setting;
	@FindBy (id = "fInboxControl_btnUpGo")
	WebElement btnOK;
	@FindBy (id = "generalSetting")
	
	//Wait for new windows appear
	WebElement btnGenearal;
	@FindBy (id = "tradingPartners")
	WebElement choose_TradingPartners;
	@FindBy (xpath = ".//*[@value='628']")
	WebElement trading_Partner_ID;
	
	//Check first Invoice Settings (810) tick box
	@FindBy (xpath = ".//*[@class='checkbox']//*[@id='Consolidate810']")
	WebElement Consolidate_Invoices;
	@FindBy (xpath = ".//*[@class='checkbox']//*[@id='EDIProcessMode810']")
	WebElement Send_manual_Invoices;
	
	WebDriver driver;
	WebDriverWait wait;
	public GeneralDIwebPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
  public void masterPageSetting() {
	  //Click on actions list
	  click_Action_List.click();
	  //Chooses Master Page Setting
	  choose_Master_Page_Setting.click();
	  //Click Ok
	  btnOK.click();
	  
	  //Handle new opened browser windows
	  String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	  //Setting general
		btnGenearal.click();
	  //click on list trading partner
		choose_TradingPartners.click();
	  //choose Trading partner theo value
		trading_Partner_ID.click();
	  
	  //Star check checkbox
	  System.out.println("Checking Invoice Settings (810)");
	  //Check first Invoice Settings (810) checkbox
	  if(Consolidate_Invoices.isSelected()) {
		  System.out.println("Consolidate Invoices 810 is : Checked " );
	  }else{
		  System.out.println("Consolidate Invoices 810 is : unChecked " );
	  } 
	  if(Send_manual_Invoices.isSelected()) {
		  System.out.println("Send manual Invoices 810 is : Checked " );
	  }else {
		  System.out.println("Send manual Invoices 810 is : unChecked " );
	  }
	  
	  // Close the new window, if that window no more required
	  driver.close();
	  // Switch back to original browser (first window)
	  driver.switchTo().window(winHandleBefore);
	  //Close first window
	  driver.close();
	  
	  
  }
}
