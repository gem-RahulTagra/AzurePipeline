package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

}
