package diUtlities;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;

public class Links {
	
	final static String randomMiddle = RandomStringUtils.randomNumeric(4);
	
	public static final String URL_login_DIWeb = "http://diweb5test.dicentral.com/Main.aspx";
	public static final String URL_Login_SapByDesign = "https://my347733.sapbydesign.com/";
	public static final String URL_Facebook = "https://fb.com";
	public static final String URL_ByDesign_347733 = "https://my347733.sapbydesign.com";
	public static final String PATH_TO_EXCEL = System.getProperty("user.dir") + File.separator + "data" + File.separator + "data.xlsx";
	public static final String PATHTO_IMG = "D:\\Selenium Error img\\Error" + randomMiddle + ".jpg";
	

  }
