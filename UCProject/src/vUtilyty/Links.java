package vUtilyty;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;

public class Links {
	
	
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	static LocalDateTime now = LocalDateTime.now();  
	static String getDatetime = (dtf.format(now));
	
	final static String randomMiddle = RandomStringUtils.randomNumeric(4);
	
	public static final String URL_login_DIWeb = "http://diweb5test.dicentral.com/Main.aspx";
	public static final String URL_Login_SapByDesign = "https://my347733.sapbydesign.com/";
	public static final String URL_Facebook = "https://fb.com";
	public static final String URL_ByDesign_347733 = "https://my347733.sapbydesign.com";
	public static final String PATH_TO_EXCEL = System.getProperty("user.dir") + File.separator +"data" + File.separator + "ExportExcel.xlsx";
	public static final String PATHTO_IMG = "D:\\Selenium Error img\\Error" + randomMiddle + ".jpg";
	public static final String URL_UC = "http://172.16.0.104:8089/#!/";
	public static final String URL_UC_Customer = "http://172.16.0.104:8089/#!/customers";
	static String filePath = System.getProperty("user.dir")+"\\Error\\Error" + randomMiddle + ".png";
	
	

  }
