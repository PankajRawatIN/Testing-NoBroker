package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src\\test\\resources\\Features"},

glue = {"src\\test\\java\\com\\stepDefination"},

plugin= {"pretty" , "html:target/htmlreport.html"}		)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{

}
