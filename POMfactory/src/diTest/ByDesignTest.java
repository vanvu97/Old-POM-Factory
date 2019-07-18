package diTest;

import org.testng.annotations.Test;

import diPages.ByDesignPage;
import diUtlities.BaseTest;
import diUtlities.Links;

public class ByDesignTest extends BaseTest {
	
	ByDesignPage ByDesign;
	
	
  @Test
  public void createSalesOrderTest() {
	  ByDesign = new ByDesignPage(driver);
	  
	  driver.get(Links.URL_ByDesign_347733);
	  ByDesign.loginByDesign("dicentral", "EDIforSAP1");
	  ByDesign.createSalesOrder();
	  
  }
  
}
