package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Utils{

    WebDriver driver = Hook.driver;

    public boolean isElementVisile(By locator,int duration){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long) duration));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("config.properties");
        properties.load(input);
        return properties.getProperty(key);
    }
}
