package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\Features\\blogs.feature", // Path to the feature files
    glue="Stepdefinition",
    		plugin = {"pretty",
    				"html:target\\HtmlReportTestNg.html"
    		}
   
)
public class TestRunnerTestng extends AbstractTestNGCucumberTests {
    // This class will be used to run the Cucumber tests via JUnit
}
