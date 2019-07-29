package diUtlities;
 
import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Screenshot {
 
    Generator gen;
    WebDriver driver;
 
    public Screenshot(WebDriver driver) {
        this.gen = gen;
        this.driver = driver;
    }
 
    public void takeScreenshot(String filename) throws IOException {
        String fileName = filename + "-" + gen.getTime() + ".png";
        String directory = Links.PATHTO_IMG;
 
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
    }
}