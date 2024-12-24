package com.TestRunner;
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features = "src/test/resources/Features/RentReceipt.feature", 
				 glue = "com.stepdefination")
public class TestRunnerParallelTest extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
 
}