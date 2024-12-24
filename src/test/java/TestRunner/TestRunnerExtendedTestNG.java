package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	 
	@CucumberOptions(features = "src/test/resources/Features/RentalAggrement.feature",
	glue="com.stepDefination",
	plugin= {"pretty",		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	})
		



public class TestRunnerExtendedTestNG extends AbstractTestNGCucumberTests{

}
