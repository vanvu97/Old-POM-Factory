package diTest;

import org.testng.annotations.Test;

import diPages.ByDesignPage;
import diPages.ExportSalesOrderPage;
import diUtlities.BaseTest;
import diUtlities.Links;

public class ByDesignTest extends BaseTest {
	
	ByDesignPage ByDesign;
	ExportSalesOrderPage exportSales;
	String SalesOrderID = "6866";
	
  @Test
  public void createSalesOrderTest() throws InterruptedException {
	  ByDesign = new ByDesignPage(driver);
	  exportSales = new ExportSalesOrderPage(driver);
	  
	  driver.get(Links.URL_ByDesign_347733);
	  ByDesign.loginByDesign("dicentral", "EDIforSAP1");
	  ByDesign.createSalesOrder();
	  ByDesign.searhSalesOrder(SalesOrderID);
	  ByDesign.editSalesOrder("10081","10");
	  ByDesign.OutBoundLogicsControl(SalesOrderID);
  }
  
}
