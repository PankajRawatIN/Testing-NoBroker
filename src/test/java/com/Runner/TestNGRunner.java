package com.Runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src/test/resources/Features/PostYourProperty.feature"
		, glue="com.stepDefination",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
 
public class TestNGRunner extends AbstractTestNGCucumberTests{
}