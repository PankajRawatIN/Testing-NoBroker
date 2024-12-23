package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features = "src/test/resources/Features/RentReceipt.feature",
glue = {"com.stepdefination","com.runner"},
plugin= {"pretty",		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
	

public class TestRunnerExtentedTestNG extends AbstractTestNGCucumberTests{

}
