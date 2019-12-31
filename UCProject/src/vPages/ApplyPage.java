package vPages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyPage {
	
	public static Date date = new Date();
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

	public static String formattedDate = sdf.format(date);
	
	@FindBy (css = "#msdd")
	WebElement clickLanguage;
	@FindBy (css = "#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul")
	WebElement listLanguage;
	
	
	
	
	String PhoneNumb = RandomStringUtils.randomNumeric(8);
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ApplyPage(WebDriver driver) {
		
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void ApplyHL() {
		
		clickLanguage.click();
		
		List<WebElement> getListLanguage = listLanguage.findElements(By.tagName("li"));
		int rowCount = getListLanguage.size();
		
		for (int row = 0; row < rowCount; row++) {
			String rowtext = getListLanguage.get(row).getText();
			System.out.println(rowtext);

		
		}
	}
	
}
