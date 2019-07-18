package diPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ByDesignPage{
	
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
	
	WebDriver driver;
	WebDriverWait wait;
	
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
	  
	  //input sales Order id
	  
	  searchBox.sendKeys("key");
	  
  }
  
}
