package vTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vPages.BuildPage;
import vPages.UCLoginPage;
import vUtilyty.BaseTest;
import vUtilyty.Links;
import vUtilyty.BuildExcel;

public class BuildTest extends BaseTest{
	
	UCLoginPage loginUC;
	BuildPage buildPgs;
	
	@Test(dataProvider = "buildProcess"/*, invocationCount = 3*/)
  public void main(String ProcessName) {
	  
	  loginUC = new UCLoginPage(driver);
	  
	  buildPgs = new BuildPage(driver);
	  
	  loginUC.LoginUC("admin", "123456");
	  
	  buildPgs.buildProcess(ProcessName);
	  
  }
  
  @DataProvider(name = "buildProcess")
  public Object[][] dataProvider() throws Exception {
		
		Object[][] testObjArray = BuildExcel.getTableArray(Links.PATH_TO_EXCEL_Build,"BuildProcess", 1);

		return (testObjArray);
		
	}
  
  @AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {	  
    
		if (testResult.getStatus() == ITestResult.FAILURE) { 
    
			String directory = Links.PATH_TO_IMG;
    	
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
			FileUtils.copyFile(screenshot, new File(directory));
    	
			System.out.print("Screenshot is captured and stored in your " + directory);
    
		}
		
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			
			String directory = Links.PATH_TO_EXCEL_Build;
			 
//			 FileInputStream fis = new FileInputStream(directory);
//			 
//			 Workbook workbook = new XSSFWorkbook(fis);
//			 
//			 Sheet sheet = workbook.getSheetAt(0);
//			 
//			 Row row = sheet.getRow(1);
//			 
//			 Cell cell = row.createCell(15);
//			 
//			 cell.setCellValue("FAILED");
//			 
//			 FileOutputStream fos = new FileOutputStream(directory);
//			 
//			 workbook.write(fos);
//			 
//			 fos.close();
			
			 
			 FileInputStream fis = new FileInputStream(directory);
			 
			 Workbook workbook = new XSSFWorkbook(fis);
			 
			 Sheet sheet = workbook.getSheetAt(0);
			 
			 int lastRow = sheet.getLastRowNum();
			 
			 for(int i=1; i<=lastRow; i++){
			 
			 Row row = sheet.getRow(i);
			 
			 Cell cell = row.createCell(15);
			 
			 cell.setCellValue("FAILED");
			 
			 }
			 
			 FileOutputStream fos = new FileOutputStream(directory);
			 
			 workbook.write(fos);
			 
			 fos.close();
			
		}else {
			
			String directory = Links.PATH_TO_EXCEL_Build;
			 
//			 FileInputStream fis = new FileInputStream(directory);
//			 
//			 Workbook workbook = new XSSFWorkbook(fis);
//			 
//			 Sheet sheet = workbook.getSheetAt(0);
//			 
//			 Row row = sheet.getRow(1);
//			 
//			 Cell cell = row.createCell(15);
//			 
//			 cell.setCellValue("PASSED");
//			 
//			 FileOutputStream fos = new FileOutputStream(directory);
//			 
//			 workbook.write(fos);
//			 
//			 fos.close();
			
			 
			 FileInputStream fis = new FileInputStream(directory);
			 
			 Workbook workbook = new XSSFWorkbook(fis);
			 
			 Sheet sheet = workbook.getSheetAt(0);
			 
			 int lastRow = sheet.getLastRowNum();
			 
			 for(int i=1; i<=lastRow; i++){
			 
			 Row row = sheet.getRow(i);
			 
			 Cell cell = row.createCell(15);
			 
			 cell.setCellValue("PASSED");
			 
			 }
			 
			 FileOutputStream fos = new FileOutputStream(directory);
			 
			 workbook.write(fos);
			 
			 fos.close();
			
		}

		driver.close();

	}
  
}
