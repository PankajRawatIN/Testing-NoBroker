package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\\test\\resources\\Features",
    glue = "com.stepDefination",
    plugin = {"pretty" , "html:target/JniutReport.html"}
)
public class TestRunnerjunit {
}
