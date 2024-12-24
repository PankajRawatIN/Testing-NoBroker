package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src\\test\\resources\\Features"},

glue = {"com.stepDefination"},

plugin= {"pretty" , "html:target/htmlreport1.html"}		)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}