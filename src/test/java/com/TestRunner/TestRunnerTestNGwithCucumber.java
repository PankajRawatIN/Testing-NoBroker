package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features/RentReceipt.feature",
		glue = "com.stepdefination",
		plugin = {"pretty", "html:target/HtmlReportTestNG.html"}
		)	

public class TestRunnerTestNGwithCucumber extends AbstractTestNGCucumberTests{
	
}

