package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Hook {

    static WebDriver driver;



    @Before
    public void start() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.tagra\\Desktop\\AzurePipeline\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

    }

    @After
    public void quitDriver() throws InterruptedException {
        driver.quit();
    }



    public WebDriver getDriver() {
        return driver;
    }
}
