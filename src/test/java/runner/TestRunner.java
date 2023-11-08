package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

@CucumberOptions(
        features = "src/test/resources/features/", // Path to your feature files
        glue = "stepdefinition",// Package where your step definitions are located
        tags = "@azure",
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"} // Allure listener
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUpAllureResultsDirectory() {
        // Set the Allure results directory using System property
        String allureResultsDirectory = "target/allure-results";
        System.setProperty("allure.results.directory", allureResultsDirectory);
    }

}