package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

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

    @When("User enters {string}")
    public void userEnters(String key) {
        try {
            if (utils.isElementVisile(By.xpath("//input[@name='" + key + "']"), 10)) {
                driver.findElement(By.xpath("//input[@name='" + key + "']")).sendKeys(utils.getProperty(key));
                Allure.addAttachment("Enter " + key, key + " enterd successfully");
            } else {
                Assert.fail(key + " field not found");
            }
        } catch (Exception e) {
            Assert.fail("Unable to enter " + key);
        }
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        try {
            if (utils.isElementVisile(By.xpath("//button"), 10)) {
                driver.findElement(By.xpath("//button")).click();
                Allure.addAttachment("Click Login Button", "Login Button Clicked Successfully");
            } else {
                Assert.fail("Login button is not present");
            }
        } catch (Exception e) {
            Assert.fail("Unable to click login button");
        }
    }

    @Then("Verify if user is logged in or not")
    public void verifyIfUserIsLoggedInOrNot() {
        if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
            Allure.addAttachment("Login inside Application", "User logged in successfully");
        } else {
            Assert.fail("Login Failed");
        }
    }

    @When("User opens {string} tab")
    public void userOpensTab(String tabName) {
        try {
            if (utils.isElementVisile(By.xpath("//span[text()='" + tabName + "']//parent::a"), 10)) {
                driver.findElement(By.xpath("//span[text()='" + tabName + "']//parent::a")).click();
                Allure.addAttachment("Open Tab: " + tabName, tabName + " tab opened successfully");
            } else {
                Assert.fail("Tab is not present");
            }
        } catch (Exception e) {
            Assert.fail("Unable to open tab: " + tabName);
        }
    }

    @And("User switches to {string} tab")
    public void userSwitchesToTab(String tab) {
        try {
            if (utils.isElementVisile(By.xpath("//a[text()='" + tab + "']"), 10)) {
                driver.findElement(By.xpath("//a[text()='" + tab + "']")).click();
                Allure.addAttachment("Switch Tab: " + tab, tab + " tab switched successfully");
                Thread.sleep(2000);
            } else {
                Assert.fail("Tab is not present");
            }
        } catch (Exception e) {
            Assert.fail("Unable to switch tab: " + tab);
        }
    }
}
