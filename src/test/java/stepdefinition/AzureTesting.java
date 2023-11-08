package stepdefinition;

import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AzureTesting {

    Utils utils = new Utils();

    WebDriver driver = Hook.driver;

    @Given("User launches {string}")
    public void launchUrl(String url) {
        try {
            driver.get(url);
            if (utils.isElementVisile(By.xpath("//div[@class='orangehrm-login-branding']"), 10)) {
                Allure.addAttachment("Check if url: " + url + " is launched and loaded", url + " is launched and loaded");
            } else {
                Assert.fail(url + " is not launched and loaded");
            }
        } catch (Exception e) {
            Assert.fail("Unable to launch url");
        }
    }

}
