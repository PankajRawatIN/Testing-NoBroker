package com.TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/RentReceipt.feature",
				glue = {"com.stepdefination","com.runner"},
				plugin = {"pretty", "html:target/HtmlReport.html"}
				)
public class TestRunnerJunit {
	
	

}

