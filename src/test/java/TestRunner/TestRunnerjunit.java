package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/RentalAggrement.feature" , 
				glue="com.stepDefination",
				plugin= {"pretty","html:target/cucumber-reports.html"})
public class TestRunnerjunit {
 
	
}
