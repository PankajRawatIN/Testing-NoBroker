package com.StepDefinition;


import java.time.Duration;
import org.junit.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.pages.PayRentPage;
import com.pages.PostYourPropInvalidCase;
import com.pages.PostYourPropertyDetails;
import com.pages.PostYourPropertyhomePage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class PostYourPropStepDef {
		WebDriverWait wait;
		WebDriver driver;
		PostYourPropertyhomePage HomePage;
		PostYourPropertyDetails details;
		PostYourPropInvalidCase invalidCase;
		PayRentPage payRentPage;
		
//		@Before
//		public void setUP()
//		{
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get(" https://www.nobroker.in");
//			
//		}
		
//Scenario1-------------------------------------------------------------------------------------------------------------------------------------
		
		@Given("I am on the homepage of NoBroker")
	    public void i_am_on_the_homepage_of_no_broker() {
	        driver = new ChromeDriver();
	        HomePage = new PostYourPropertyhomePage(driver);
	        HomePage.openHomePage();
	    }

	    @When("I click on the Main Menu button")
	    public void i_click_on_the_main_menu_button() {
	        HomePage.clickMainMenuButton();
	    }

	    @When("I select the Post Your Property option from the menu")
	    public void i_select_the_post_your_property_option_from_the_menu() {
	        HomePage.selectPostYourPropertyOption();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

//		------------------------------------------------------------------------------------------------------------------------------------------
//		Scenario 2: ------------------------------------------------------------------------------------------------------------------------------
	    
	    @Given("I am on the Post Your Property page")
	    public void i_am_on_the_post_your_property_page() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--start-maximized");

	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(options);

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        details = new PostYourPropertyDetails(driver);

	        details.openPostYourPropertyPage();
	    }

	    @When("I enter valid property details such as {string}, {string} and  {string}")
	    public void i_enter_valid_property_details_such_as_and(String name, String emailId, String mobileNo) throws InterruptedException {
	       details.enterName(name);
	       details.enterEmail(emailId);
	       details.enterMobileNumber(mobileNo);
	       details.selectCity();
	    }

	    @When("I click on the Start Posting Your Ad for Free button")
	    public void i_click_on_the_start_posting_your_ad_for_free_button() throws InterruptedException {
	    	details.clickStartPostingButton();
	    }
//		-------------------------------------------------------------------------------------------------------------------------------------------
//		Scenario 3:--------------------------------------------------------------------------------------------------------------------------------
		
	    @Given("I am on a Post the Property Homepage")
	    public void i_am_on_post_your_property_homepage() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--start-maximized");

	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        invalidCase = new PostYourPropInvalidCase(driver, wait);

	        driver.manage().window().maximize();
	        invalidCase.openHomePage();
	    }

	    @When("I enter invalid of property such as {string}, {string} and {string}")
	    public void i_enter_invalid_property_details(String name, String email, String phoneNumber) throws InterruptedException {
	        invalidCase.enterInvalidDetails(name, email, phoneNumber);
	    }

	    @When("I click on Start Posting Your Adds for Free button On Webpage")
	    public void i_click_on_start_posting_your_adds_for_free_button_on_webpage() throws InterruptedException {
	        invalidCase.clickStartPostingButton();
	    }

	    @Then("I should see an error message indicating the invalid field")
	    public void i_should_see_an_error_message_indicating_the_invalid_field() {
	        boolean isDisplayed = invalidCase.isErrorMessageDisplayed("Enter your Email");
	        Assert.assertTrue("Error message is not displayed as expected!", isDisplayed);
	    }
	  
	
//		-------------------------------------------------------------------------------------------------------------------------------------------
//	    Scenario 4:--------------------------------------------------------------------------------------------------------------------------------
	   
	    
	    @Given("the user is on the post your property webpage")
	    public void the_user_is_on_the_post_your_property_webpage() {
	        // Initialize WebDriver and open the webpage
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized", "--disable-notifications");
	        driver = new ChromeDriver(options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        
	        // Open the URL
	        driver.get("https://www.nobroker.in/list-your-property-for-rent-sale?nbFr=Home_page");
	        
	        // Initialize the PayRentPage object
	        payRentPage = new PayRentPage(driver);
	    }

	    @When("I click on Pay Rent button")
	    public void i_click_on_the_pay_rent_button() {
	        // Call the clickPayRentButton method from PayRentPage
	        payRentPage.clickPayRentButton();
	    }

	    @Then("I should redirect to the Pay Rent Page")
	    public void i_should_redirect_to_the_pay_rent_page() {
	        // Retrieve the current URL after the redirection
	        String currentUrl = payRentPage.getCurrentUrl();
	        System.out.println("Current URL: " + currentUrl);

	        // Define the expected URL
	        String expectedUrl = "https://www.nobroker.in/list-your-property-for-rent-sale?nbFr=Home_page";
	        System.out.println("Expected URL: " + expectedUrl);

	        // Assert that the current URL matches the expected URL
	        AssertJUnit.assertTrue("URL did not match", currentUrl.startsWith(expectedUrl));

	        System.out.println("It redirected to the Pay Rent Page");
	    }



	    
//	    ---------------------------------------------------------------------------------------------------------------------------------	
//	    Scenario 5:----------------------------------------------------------------------------------------------------------------------
	    
	    @Given("I am on the Pay Rent page")
	    public void i_am_on_the_pay_rent_page() {
	        // Set up WebDriver and navigate to the Pay Rent page
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized", "--disable-notifications");
	        driver = new ChromeDriver(options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        
	        // Open the URL
	        driver.get("https://www.nobroker.in/pay-property-rent-online?nbFr=home_page");
	        
	        // Initialize the PayRentPage object
	        payRentPage = new PayRentPage(driver);
	    }

	    @When("I enter valid details of mine such as {string}, {string} and  {string}")
	    public void i_enter_valid_details_of_mine_such_as_and(String name, String mobile, String email) throws InterruptedException {
	        // Use PayRentPage method to enter tenant details
	        payRentPage.selectPaymentType();
	        payRentPage.enterTenantDetails(name, mobile, email);
	        payRentPage.clickStartPostingButton();
	    }

	    @Then("I click on checkbox")
	    public void i_click_on_checkbox() throws InterruptedException {
	        // Use PayRentPage method to click the checkbox
	        payRentPage.clickCheckbox();
	    }

	    @When("I click on the Get Started button")
	    public void i_click_on_the_get_started_button() {
	        // Use PayRentPage method to click the "Get Started" button
	        payRentPage.clickGetStartedButton();
	    }

//
//
////------------------------------------------------------------------------------------------------------------------------------------------------------
//	    
}
	
	



