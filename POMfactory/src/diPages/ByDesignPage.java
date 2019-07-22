package diPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ByDesignPage{
	ExportSalesOrderPage exportSalesID;
	
	//Login section
	@FindBy (id = "__control0-user-inner")
	WebElement sapUsername;
	@FindBy (id = "__control0-pass-inner")
	WebElement sapPassword;
	@FindBy (id = "__control0-logonBtn-content")
	WebElement btnLogin_ByDesign;
	@FindBy (id = "__control1-continueBtn-inner")
	WebElement btnContinue_ByDesign;
	
	//Create Sales Order
	@FindBy (id = "__button0")
	WebElement btn_SapMenu;
	@FindBy (css = "#__item151 > div:nth-child(3)")
	WebElement btn_SalesOrder;
	@FindBy (css = "#__item847")
	WebElement btn_SalesOrder_2nd;
	
	//Choose All Order
	@FindBy (css = "#__pane1-defaultSetDDLB-label")
	WebElement list_SalesOrder;
	@FindBy (css = "html.sapBUiShell.sap-desktop.sapUiTheme-sap_belize.sapUiMedia-Std-Desktop.sapUiMedia-StdExt-Desktop body.sapUiSizeCompact.sapBUiShellBackground.sapBUiBody div#content.sapBUiContent div#__shell0 div div.__sapBUiShHdr.sapBUiGlobalBackgroundColor main.sapBUiShellMainCont div.__sapUiBCACA div#__shell0-scrollbox.shell-scroll-container.scrollbox.scrollbox-delayed div#__shell0-content.sapBUiMainScrollContent.scrollbox-content div#__presenter0 div#__component1.sapBUiTransparentPaper table.sapBUiContentTable tbody tr td div#__container3.sapBUiComponent.sapBUiViewContainer div#__view1.sapBUiView table.sapBUiViewLayoutTable tbody tr td.sapBUiViewLayoutTileCell.sapBUiGlobalBackgroundColor div#__container4.sapBUiPaneContainer div#__pane0 div#__container6.sapBUiViewContainer div#__view2.sapBUiView table.sapBUiViewLayoutTable tbody tr td.sapBUiViewLayoutCell div#__container7.sapBUiPaneContainer div#__pane1 div.sapBUiDefSetBar div#__pane1-searchField.sapMSF form#__pane1-searchField-F.sapMSFF.sapMSFReload input#__pane1-searchField-I.sapMSFI")
	WebElement searchBox;
	@FindBy (css = "#__pane1-searchField-search")
	WebElement searchButton;
	
	//Edit sales
	@FindBy (css = "#__button12-content")
	WebElement btnEdit;
	@FindBy (css = "#__input8-inner")
	WebElement Employee_Responsible;
	@FindBy (css = "#__field42-inner")
	WebElement inpPrices;
	@FindBy (css = "#__button81-content")
	WebElement btnSaveEditOrder;
	
	//Outbound Logistics Control
	@FindBy (css = "#__item397 > div:nth-child(3)")
	WebElement OutboundLogisticsControl;
	@FindBy (xpath = ".//*[@id='__group96']//*[@class='sapBUiCenterMnuItem sapBUiCenterMnuItemHoverable']")
	WebElement CustomerDemand;
	@FindBy (css = "#__pane10-defaultSetDDLB-label")
	WebElement CustomerDemandList;
	@FindBy (css = "#__pane10-searchField-I")
	WebElement searchCustomerDemand;
	@FindBy (css = "#__list27 > li:nth-child(10)")
	WebElement AllOrdersDemand;
	@FindBy (css = "#__pane10-searchField-search")
	WebElement searchCustomerDemandButton;
	@FindBy (css = "#__button118-content")
	WebElement btnRelease;
	
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ByDesignPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

  public void loginByDesign(String ByDesign_Username, String ByDeign_Password) {
	  //Login By Design
	  sapUsername.sendKeys(ByDesign_Username);
	  sapPassword.sendKeys(ByDeign_Password);
	  btnLogin_ByDesign.click();
	  btnContinue_ByDesign.click();
  }
  
  public void createSalesOrder() {
	  //Create Sales Order
	  btn_SapMenu.click();
	  btn_SalesOrder.click();
	  btn_SalesOrder_2nd.click();
  }
  public void searhSalesOrder(String Sales_ID) throws InterruptedException {
	  exportSalesID = new ExportSalesOrderPage(driver);
	  
	  //input sales Order id
	  searchBox.sendKeys(Sales_ID);
	  searchButton.click();
	  
	  //edit order
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	
	  Thread.sleep(5000);
//	------------------------------
	}
  public void editSalesOrder(String EmployeeResponsible, String sPrices) throws InterruptedException {
	  btnEdit.click();
	  //Wait for loading
	  WebDriverWait waitLoading = new WebDriverWait(driver, 30);
	  waitLoading.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	
	  Thread.sleep(5000);
//	------------------------------
	  //check_Employee_Responsible
	  ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", Employee_Responsible);
	  
	  String check_Employee_Responsible = Employee_Responsible.getText();
	  
	  if(check_Employee_Responsible != null) {
		  System.out.println("There is no Employee Responsible! Sending....!!!");
		  Employee_Responsible.sendKeys(EmployeeResponsible);
	  }else {
		  System.out.println("Employee Responsible : " + check_Employee_Responsible);
	  }
	  
	  //Wait for loading
	  WebDriverWait waitLoading2 = new WebDriverWait(driver, 30);
	  waitLoading2.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	  Thread.sleep(3000);
	  
	  //Check prices
	  ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", inpPrices);
	  
	  String check_Prices = inpPrices.getText();
	  
	  if(check_Prices != null) {
		  System.out.println("There is no Prices! Sending....!!!");
		  inpPrices.clear();
		  inpPrices.sendKeys(sPrices);
	  }else {
		  System.out.println("Employee Responsible : " + check_Employee_Responsible);
	  }
	  
	  btnSaveEditOrder.click();
  }
  
  public void OutBoundLogicsControl(String Sales_ID) throws InterruptedException {

	  btn_SapMenu.click();
	  ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", OutboundLogisticsControl);
	  OutboundLogisticsControl.click();
	  
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='__group96']//*[@class='sapBUiCenterMnuItem sapBUiCenterMnuItemHoverable']"))));
	  
	  CustomerDemand.click();
	  CustomerDemandList.click();
	  
	  AllOrdersDemand.click();
	  
	  searchCustomerDemand.sendKeys(Sales_ID);
	  
	  searchCustomerDemandButton.click();
	  
	  btnRelease.click();
  
  }

}
