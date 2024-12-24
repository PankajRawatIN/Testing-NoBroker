package Stepdefinition;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.parameters.ExcelReader;
import com.parameters.PropertiesReader;

import Pages.BasePage;
import Pages.BlogPage;
import Pages.CareerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import Setup.BaseSteps;
//import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CareerSetup {
	
	
	BasePage basepage;
	CareerPage careerpage;
	BlogPage blogpage;
	PropertiesReader propertiesReader=new PropertiesReader();
	WebDriver driver;
	//BaseSteps base;
	@Before
	public void setup() {
		driver = new ChromeDriver();  // Initialize WebDriver (you can configure it as per your setup)
		driver.manage().window().maximize();  // Maximize window if needed
		basepage = new BasePage(driver);
		careerpage = new CareerPage(driver);
		blogpage =new BlogPage(driver);
	}

	 //Quit WebDriver after all scenarios are finished
	@After
	public void doSomethingAfter(Scenario scenario){
	    // Do something after after scenario
		if (scenario.isFailed()) {
		    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(screenshot, "image/png", "name");
		}
		if (driver != null) {
			driver.quit();  // Close the browser and clean up
		}
	}
	public void tearDown() {
		
	}
	
	
	
	@Given("I open the NoBroker homepage")
	public void i_open_the_no_broker_homepage() throws IOException {
		System.out.println("testing");
		// Get WebDriver instance from BaseSteps
		//driver = new ChromeDriver();  // Initialize WebDriver (you can configure it as per your setup)
		//driver.manage().window().maximize();
//		driver.get(propertiesReader.getProperty("homepage.url")); 
		driver.get(ExcelReader.geturl());
		
//		basepage = new BasePage(driver);
//		careerpage = new CareerPage(driver);

		
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
		
		String url=careerpage.isnavigated();
		assertTrue("URL did not navigate to the career page", url.contains("careers"));
	}

	@Then("I should see the {string} text on the Career Page")
	public void i_should_see_the_text_on_the_career_page(String string) {
		
		String text=careerpage.gettext();

		assertEquals(text, string);

		
	}
	
	@Given("I am on the Careerpage")
	public void i_am_on_the_careerpage() {
	    
		System.out.println("testing2");
		
		//driver = new ChromeDriver();  // Initialize WebDriver (you can configure it as per your setup)
		//driver.manage().window().maximize();
		driver.get(propertiesReader.getProperty("careerpage.url")); 
		
//		basepage = new BasePage(driver);
//		careerpage = new CareerPage(driver);

		

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
	    
		 String currenturl=careerpage.navigatedToLinkedInPage();
         //String title = driver.getTitle();
		assertTrue("URL did not navigate to the linkedinpage for joblist button", currenturl.contains("jobs"));
		
		//Assert.assertTrue("The NoBroker homepage is not loaded", title.contains("Brokerage"));
		
	}
	
	@When("I click on the See all opertunities Button")
	public void i_click_on_the_see_all_opertunities_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		careerpage.clickSeeAllOpertunities();
	}

	@Then("I should be navigated to linkedin page")
	public void i_should_be_navigated_to_linkedin_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String currenturl=careerpage.navigatedToLinkedInPage();
		assertTrue("URL did not navigate to the linkedinpage page", currenturl.contains("jobs"));
		
	}
	
	@When("I click on the Forward Button")
	public void i_click_on_the_forward_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		careerpage.clickForwardButton();
	}

	@Then("I should see the next image displayed")
	public void i_should_see_the_next_image_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String text=careerpage.isNextImageDisplayed();
		assertTrue("'next Image' is not found on career page", text.contains("Saurabh"));
				
	}

	@Then("When I click on the Backward Button")
	public void when_i_click_on_the_backward_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		careerpage.clickBackwardButton();
	}

	@Then("I should see the previous image displayed")
	public void i_should_see_the_previous_image_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String text=careerpage.isPreviousImageDisplayed();
		assertTrue("'next Image' is not found on career page", text.contains("Amit"));
	
	}
	
	@When("I click on the {string} button in the navigation bar")
	public void i_click_on_the_button_in_the_navigation_bar(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		careerpage.clickNavigationNoBroker();
	}

	@Then("I should be navigated to the home page of NoBroker")
	public void i_should_be_navigated_to_the_home_page_of_no_broker() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String text=careerpage.isNavigatedToHomePage();
		assertTrue("'nobroker' is not found on career page", text.contains("NoBrokerage"));
	}

	@Then("the page URL should contain {string}")
	public void the_page_url_should_contain(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String url=careerpage.isHomePageUrl();
		assertTrue("URL did not navigate to the Home page", url.contains("nobroker"));
	}
	
	//------------------BLOG PAGE----------------------------------------------------------------
	
	@When("I select Blogs from the dropdown")
	public void i_select_blogs_from_the_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.clickblog();
	}

	@Then("I should be navigated to the Blog Page")
	public void i_should_be_navigated_to_the_blog_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String url=blogpage.isNavigatedBlockPage();
		assertTrue("URL did not navigate to the career page", url.contains("blog"));
	}

	@Given("I am on the blog page")
	public void i_am_on_the_blog_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.get(propertiesReader.getProperty("blogpage.url")); 
	}

	@When("I click on the Subscribe to our blogs button")
	public void i_click_on_the_subscribe_to_our_blogs_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.clickOnSubcribeToBlog();
	}

	@Then("I got the popup for subscribe")
	public void i_got_the_popup_for_subscribe() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String text=blogpage.validatePopUpForSubscribe();
		assertTrue("Text not found on BlogPage",text.contains("Get latest"));
	}

	@Then("When I enter the Valid E-MAIL id")
	public void when_i_enter_the_valid_e_mail_id() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.senddata();
	}

	@Then("When I select atleast {int} values from the given values")
	public void when_i_select_atleast_values_from_the_given_values(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.selectoptions();
	}

	@Then("When I click on the subscribe now button")
	public void when_i_click_on_the_subscribe_now_button() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		blogpage.subscribeNowButton();
	}

	@Then("I got the COnfirmation Msg")
	public void i_got_the_c_onfirmation_msg() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String text=blogpage.gotConfirmation();
		assertTrue("Subscription not done",text.contains("You're all set!"));
	}
	
	@Then("When I select less options from the given options")
	public void when_i_select_less_options_from_the_given_options() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.selectlessoptions();
	}

	@Then("I will get a alert Msg.")
	public void i_will_get_a_alert_msg() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String text=blogpage.gotalertmsg();
		assertTrue("you did not get the text from alert",text.contains("Please select"));
	}
	
	
	
	@When("I click on the Forward button on blog page")
	public void i_click_on_the_forward_button_on_blog_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.clickForwardButton();
	}

	@Then("I should see the next image displayed on blogpage")
	public void i_should_see_the_next_image_displayed_on_blogpage() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		blogpage.isNextImageDisplayed();
		//assertTrue("Next image is not displayed",text.contains(""));
	}

	@When("I click on the Backward button on blog page")
	public void i_click_on_the_backward_button_on_blog_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		blogpage.clickBackwardButton();
	}

	@Then("I should see the previous image displayed on blogpage")
	public void i_should_see_the_previous_image_displayed_on_blogpage() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		blogpage.isPreviousImageDisplayed();
	//assertTrue("Next image is not displayed",text.contains(""));
	}
	
	


}
