package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\Features\\Home_Properties.feature",
    glue = { "com.stepDefination" },
    plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}