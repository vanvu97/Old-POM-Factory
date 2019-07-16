package firstDayAtWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class sapByDesignLogin {
    private WebDriver driver;
    private By byEmail = By.id("fTbxUserName");
    private By byPassword = By.id("fTbxPassword");
    private By byBtnLogin = By.id("fBtnLogin");
    private By byEmail2 = By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpUserId_I");
    private By ByPassword2 = By.id("fCbpUserSelection_ASPxPanel1_fPnlEmpIdentification_fTbxEmpSecPassword_I");
     
    public sapByDesignLogin(WebDriver driver) {
        this.driver = driver;
        
    }
     
    public sapByDesignHomePage login(String email, String password, String email2, String password2) {
        // enter email
        driver.findElement(byEmail).sendKeys(email);
        // enter passwor
        driver.findElement(byPassword).sendKeys(password);
        // click login button
        driver.findElement(byBtnLogin).click();
        
        driver.findElement(byEmail2).sendKeys(email2);
        
        driver.findElement(ByPassword2).sendKeys(password2);
        
        // return home page
        return new sapByDesignHomePage(driver);
        
    }
}
