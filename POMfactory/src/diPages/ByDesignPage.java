package diPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy (css = ".sapBUiSessionListContainer > li")
	int DICENTRAL;
	@FindBy (css = "#__box0-CbBg")
	WebElement tickBoxDelete;
	
	//Create Sales Order
	@FindBy (css = "#__button0")
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
	@FindBy (xpath = "//*[@id=\"__button118-content\"]")
	WebElement btnRelease;
	@FindBy (css = "#__table2_r0_c4 >div:nth-child(1)")
	WebElement releaseStatus;
	
	//Outbound Logistics
	@FindBy (id = "__group25")
	WebElement btnOutboundLogistics;
	@FindBy (css = "#__group109 > div:nth-child(2)")
	WebElement deliveryProposals;
	@FindBy (css = "#__pane14-defaultSetDDLB-label")
	WebElement listDeliveryProposals;
	@FindBy (css = "#__list30 > li:nth-child(11)")
	WebElement allProposals;
	@FindBy (css = "#__pane14-searchField-I")
	WebElement searchDeliveryProposals;
	@FindBy (css = "#__pane14-searchField-search")
	WebElement searchDeliveryProposalsButton;
	@FindBy (css = "#__button134-content")
	WebElement createWarehouseRequest;
	//Task COntrol
	@FindBy (css = "#__item1281")
	WebElement taskControl;
	@FindBy (css = "#__pane19-defaultSetDDLB-label")
	WebElement listTaskControl;
	@FindBy (css = "#__list33 > li:nth-child(7)")
	WebElement allWarehouse;
	@FindBy (css = "#__pane19-searchField-I")
	WebElement searchTaskControl;
	@FindBy (id = "__pane19-searchField-search")
	WebElement searchTaskControlButton;
	@FindBy (css = "#__button156-content")
	WebElement btnConfirm;
	@FindBy (css = "#__table4_r0_c0")
	WebElement assertTaskControl;
	//Outbound Deliveries
	@FindBy (css = ".sapBUiCenterMenuCol > div:nth-child(6)")
	WebElement outboundDeliveries;
	@FindBy (css = "#__pane23-defaultSetDDLB-label")
	WebElement listOutboundDeliveries;
	@FindBy (css = "#__list36 > li:nth-child(8)")
	WebElement allOutboundDeliveries;
	@FindBy (css = "#__pane23-searchField-I")
	WebElement searchOutboundDeliveries;
	@FindBy (css = "#__pane23-searchField-search")
	WebElement searchOutboundDeliveriesButton;
	@FindBy (css = ".sapBUiMessageAreaInner")
	WebElement errListProposals;
	@FindBy (css = "#__text207")
	WebElement errorText;
	@FindBy (css = "#__text209")
	WebElement errorText2;
	//Customer Invoices
	@FindBy (css = "#__item172 > div:nth-child(3)")
	WebElement customerInvoices;
	@FindBy (css = ".sapBUiCenterMenuCol > div:nth-child(03)")
	WebElement InvoiceRequest;
	@FindBy (css = ".sapBUiDefSetBar > div:nth-child(1)")
	WebElement listInvoiceRequest;
	@FindBy (css = "#__list39 > li:nth-child(7)")
	WebElement allInvoiceRequests;
	@FindBy (css = "#__pane28-searchField-I")
	WebElement searchInvoiceRequests;
	@FindBy (css = "#__pane28-searchField-search")
	WebElement searchInvoiceRequestsButton;
	
	
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
	  
	  if(DICENTRAL <= 5) {
		  tickBoxDelete.click();
		  btnContinue_ByDesign.click();
		  System.out.println("Login Successfull!");
	  }else if(btnContinue_ByDesign.isDisplayed()) {
		  btnContinue_ByDesign.click();
	  }else if (!btnContinue_ByDesign.isDisplayed()) {
		  System.out.println("There is no Continues button! Skip this step...");
	  }else {
		  System.out.println("Continues....");
		  System.out.println("Login Successfull!");
	  }
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
	  System.out.println("Search Sales Order Successfull!");
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
	  
	  String check_Employee_Responsible = Employee_Responsible.getTagName();
	  
	  if(!check_Employee_Responsible.isEmpty()) {
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
	  
	  if(!check_Prices.isEmpty()) {
		  System.out.println("There is no Prices! Sending....!!!");
		  inpPrices.clear();
		  inpPrices.sendKeys(sPrices);
	  }else {
		  System.out.println("Prices is : " + check_Prices);
	  }
	  
	  btnSaveEditOrder.click();
	  
  }
  
  public void OutBoundLogicsControl(String SoSalesID) throws InterruptedException {

	  btn_SapMenu.click();
	  ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", OutboundLogisticsControl);
	  OutboundLogisticsControl.click();
	  
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='__group96']//*[@class='sapBUiCenterMnuItem sapBUiCenterMnuItemHoverable']"))));
	  
	  System.out.println("Customer Demand customing...");
	  
	  CustomerDemand.click();
	  CustomerDemandList.click();
	  
	  AllOrdersDemand.click();
	  
	  WebDriverWait waitLoading2 = new WebDriverWait(driver, 30);
	  waitLoading2.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	  Thread.sleep(2000);
	  
	  searchCustomerDemand.sendKeys(SoSalesID);
	  
	  searchCustomerDemandButton.click();
	  
	  Thread.sleep(2000);
//	  JavascriptExecutor executor = (JavascriptExecutor)driver;
//	  executor.executeScript("arguments[0].click();", btnRelease);
	  
	  String getReleaseStatus = releaseStatus.getText();
	  
	  if(getReleaseStatus != "Released") {
		  System.out.println("Customer Demand Released....");
	  }else {
		  btnRelease.click();
		  System.out.println("Clicked on Release");
	  }
  }
  
public void OutboundLogistics(String SoSalesID) throws InterruptedException {
	  Actions builder = new Actions(driver);
	  System.out.println("Creating Warehouse Request (Delivery Proposals)...");
	  //Click on outbound logistics
	  btnOutboundLogistics.click();
	  //Click on delivery proposal
	  deliveryProposals.click();
	  //Click on list Delivery Proposals
	  listDeliveryProposals.click();
	  //Chooses all proposals
	  allProposals.click();
	  
	  //Input sales order ID
	  searchDeliveryProposals.sendKeys(SoSalesID);
	  
	  WebDriverWait waitLoading2 = new WebDriverWait(driver, 30);
	  waitLoading2.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	  
	  Thread.sleep(1000);
	  //Click on search button;
	  searchDeliveryProposalsButton.click();
	  
	  WebDriverWait waitLoading3 = new WebDriverWait(driver, 30);
	  waitLoading3.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	  
	  Thread.sleep(2000);
	  
	  //Click on create Warehouse Request
	  createWarehouseRequest.click();
	  
//	  ----------------------------------
	  
	 
	  if(errListProposals.isDisplayed()) {
		  builder.moveToElement(errListProposals).build().perform();
		  
		  Thread.sleep(500);
		  
		  String getErrorText = errorText.getText();
		  System.out.println("Error!!!: " + getErrorText + " :Error!!!");
		  
		  String getErrorText2 = errorText2.getText();
		  System.out.println("Error!!!: " + getErrorText2 + " :Error!!!");
		  
		  Assert.assertNotEquals(getErrorText, "Save failed; refresh list to perform further actions");
	  }else {
		  System.out.println("Create Warehouse Request Successfull!!!");
	  } 

	  Thread.sleep(1000);
	  
	  btnOutboundLogistics.click();
	  
	  //Click on outbound logistics
	  //btnOutboundLogistics.click();
	  //Click on Task control
	  taskControl.click();
	  //List task control
	  listTaskControl.click();
	  allWarehouse.click();
	  
	  Thread.sleep(1000);
	  
	  searchTaskControl.sendKeys(SoSalesID);
	  
	  Actions actions = new Actions(driver);
	  actions.moveToElement(searchTaskControlButton).click().build().perform();
	  
	  Thread.sleep(2000);
	  
	  String compareTaskControlID = assertTaskControl.getText();
	  Assert.assertEquals(compareTaskControlID, SoSalesID);
	  System.out.println("Assert PASSED!!!!" + compareTaskControlID + " = " + SoSalesID);
	  
	  Thread.sleep(2000);
	  
	  btnConfirm.click();
	  
//	  ----------------------------------
	  
	  //Click on outbound logistics
	  btnOutboundLogistics.click();
	  //
	  outboundDeliveries.click();
	  listOutboundDeliveries.click();
	  allOutboundDeliveries.click();
	  
	  Thread.sleep(1000);
	  
	  searchOutboundDeliveries.sendKeys(SoSalesID);
	  
	  WebDriverWait waitLoading6 = new WebDriverWait(driver, 30);
	  waitLoading6.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	  
	  searchOutboundDeliveriesButton.click();	  
  }
  
  public void CustomerInvoices(String SoSalesID) throws InterruptedException {
	  
	  ((JavascriptExecutor) driver).executeScript ("arguments[0].scrollIntoView();", customerInvoices);
	  customerInvoices.click();
	  InvoiceRequest.click();
	  
	  //List invoice request
	  listInvoiceRequest.click();
	  allInvoiceRequests.click();
	  //Search invoice requests
	  Thread.sleep(1000);
	  searchInvoiceRequests.sendKeys(SoSalesID);
	  
	  WebDriverWait waitLoading6 = new WebDriverWait(driver, 30);
	  waitLoading6.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	  
	  searchInvoiceRequestsButton.click();
	  
	  
  }

}
