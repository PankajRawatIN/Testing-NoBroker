package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.BasePage;
import Pages.CareerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//import Setup.BaseSteps;
//import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareerSetup {
	
	
	BasePage basepage;
	CareerPage careerpage;
	WebDriver driver;
	//BaseSteps base;
	@Before
	public void setup() {
		driver = new ChromeDriver();  // Initialize WebDriver (you can configure it as per your setup)
		driver.manage().window().maximize();  // Maximize window if needed
	}

	// Quit WebDriver after all scenarios are finished
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();  // Close the browser and clean up
		}
	}
	
	
	
	@Given("I open the NoBroker homepage")
	public void i_open_the_no_broker_homepage() {
		System.out.println("testing");
		// Get WebDriver instance from BaseSteps
		//driver = new ChromeDriver();  // Initialize WebDriver (you can configure it as per your setup)
		//driver.manage().window().maximize();
		driver.get("https://www.nobroker.in/"); 
		
		basepage = new BasePage(driver);
		careerpage = new CareerPage(driver);

		
		System.out.println(driver);

		String title = driver.getTitle();
		
		Assert.assertTrue("The NoBroker homepage is not loaded", title.contains("Brokerage"));
	}


	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
		
		basepage.clickmenu();
	}

	@When("I select {string} from the dropdown")
	public void i_select_from_the_dropdown(String string) {
		
		basepage.clickcareer();
	}

	@Then("I should be navigated to the Career Page")
	public void i_should_be_navigated_to_the_career_page() {
		
		careerpage.isnavigated();
	}

	@Then("I should see the {string} text on the Career Page")
	public void i_should_see_the_text_on_the_career_page(String string) {
		
		careerpage.gettext();

		
		driver.quit();
	}
	
	@Given("I am on the Careerpage")
	public void i_am_on_the_careerpage() {
	    
		System.out.println("testing2");
		
		//driver = new ChromeDriver();  // Initialize WebDriver (you can configure it as per your setup)
		//driver.manage().window().maximize();
		driver.get("https://www.nobroker.in/careers"); 
		
		basepage = new BasePage(driver);
		careerpage = new CareerPage(driver);

		

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue("The NoBroker homepage is not loaded", title.contains("Brokerage"));
	}

	@When("I click on the {string} Button")
	public void i_click_on_the_button1(String string) {
	    
		careerpage.clickjoblist();
	}

	@Then("I should be navigated to the LinkedInpage")
	public void i_should_be_navigated_to_the_linked_inpage() {
	    
		careerpage.navigatedToLinkedInPage();
         String title = driver.getTitle();
		
		Assert.assertTrue("The NoBroker homepage is not loaded", title.contains("Brokerage"));
		
	}

}
