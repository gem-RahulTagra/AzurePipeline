package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/", // Path to your feature files
        glue = "stepdefinition",// Package where your step definitions are located
        tags = "@azure",
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"} // Allure listener
)
public class TestRunner extends AbstractTestNGCucumberTests {
}