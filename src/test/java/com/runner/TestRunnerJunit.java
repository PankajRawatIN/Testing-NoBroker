package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src\\test\\resources\\Features\\blogs.feature","src\\test\\resources\\Features\\careers.feature"}, // Path to the feature files
    glue="Stepdefinition",
    		plugin = {"pretty",
    				"html:target\\HtmlReport.html"
    		}
   
)
public class TestRunnerJunit {
    // This class will be used to run the Cucumber tests via JUnit
}
