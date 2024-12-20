package com.stepDefination;


import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class PostYourPropStepDef {
		WebDriverWait wait;
		WebDriver driver;
		
		@Before
		public void setUP()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(" https://www.nobroker.in");
			
		}
		
//Scenario1-------------------------------------------------------------------------------------------------------------------------------------
		
		@Given("I am on the homepage of NoBroker")
		public void i_am_on_the_homepage_of_no_broker() 
		{
			// Write code here that turns the phrase above into concrete actions
//		    driver = new ChromeDriver();
//		    driver.manage().window().maximize();
//	        driver.get("https://www.nobroker.in");
		}

		@When("I click on the Main Menu button")
		public void i_click_on_the_main_menu_button() 
		{
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			WebElement mainMenuButton = driver.findElement(By.xpath("//div[img[@alt='hamburger'] and text()='Menu']"));
			mainMenuButton.click();
		}

		@When("I select the Post Your Property option from the menu")
		public void i_select_the_post_your_property_option_from_the_menu() 
		{
		    // Write code here that turns the phrase above into concrete actions
		    WebElement postYourproperty = driver.findElement(By.xpath("//a[text()='Post Your Property']"));
		    postYourproperty.click();
		     wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		}

//		------------------------------------------------------------------------------------------------------------------------------------------
//		Scenario 2: ------------------------------------------------------------------------------------------------------------------------------
		

		@Given("I am on the Post Your Property page")
		public void i_am_on_the_post_your_property_page() 
		{
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--start-maximized"); // Start browser maximized
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(options);
	        wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		    // Write code here that turns the phrase above into concrete actions
			//driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.nobroker.in/list-your-property-for-rent-sale?nbFr=Home_page"); 
		}
		
		@When("I enter valid property details such as {string}, {string} and  {string}")
		public void i_enter_valid_property_details_such_as_and(String name, String emailId, String mobileNo) throws InterruptedException 
		{
			// Locate and fill the Name field
	        WebElement nameField = driver.findElement(By.xpath("//input[@id='userName']")); // Update with the actual ID or locator
	        nameField.sendKeys(name);

	        // Locate and fill the Email ID field
	        WebElement emailField = driver.findElement(By.xpath("//input[@id='userEmail']")); // Update with the actual ID or locator
	        emailField.sendKeys(emailId);

	        // Locate and fill the Mobile Number field
	        WebElement mobileField = driver.findElement(By.xpath("//input[@id='userPhone']")); // Update with the actual ID or locator
	        mobileField.sendKeys(mobileNo);
	        
	        
	        
	        WebElement cityField = driver.findElement(By.xpath("//div[@class='css-1hwfws3 nb-select__value-container']/div[@class='css-151xaom-placeholder nb-select__placeholder']"));
	        cityField.click();
	        //Thread.sleep(50000);
	 
	    
	        
	        
	        
	        WebElement selectField = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[2]/div/div[1]"));
	        selectField.click();
	        Thread.sleep(5000);
	        
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        WebElement cityDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1pahdxg")));
//
//	        // Now select the city from the dropdown by its visible text (you can change this to other locators based on your need)
//	        WebElement cityOption = driver.findElement(By.xpath("//div[@class='css-1pahdxg'] //div[contains(text(), 'Desired City Name')]"));
//	        cityOption.click()
//	        
	        
		}
		
		@When("I click on the Start Posting Your Ad for Free button")
		public void i_click_on_the_start_posting_your_ad_for_free_button() throws InterruptedException 
		{
			 
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		     // Wait for the "Our Top Interior Designers" heading
		             WebElement startPostingButton = wait.until(ExpectedConditions.presenceOfElementLocated(
		                     By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[4]/button[1]")));
		             
		             // Scroll into view
		             js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", startPostingButton);
		             
		             Thread.sleep(5000);
	
		     startPostingButton.click();
		}
		

				
		
		
//		-------------------------------------------------------------------------------------------------------------------------------------------
//		Scenario 3:--------------------------------------------------------------------------------------------------------------------------------
//		
//		@Given("I am on Post Your Property Homepage")
	    public void i_am_on_post_your_property_homepage() 
	    {
//	        // Initialize the WebDriver
//	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//	        driver = new ChromeDriver();

	    	 // Write code here that turns the phrase above into concrete actions
			WebElement mainMenuButton2 = driver.findElement(By.xpath("//div[img[@alt='hamburger'] and text()='Menu']"));
			mainMenuButton2.click();
	    }

	    @When("I enter invalid {string}")
	    public void i_enter_invalid(String invalidInput) 
	    {
	        // Locate the input field and enter invalid data
	        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']")); // Adjust the locator as needed
	        emailField.clear();
	        emailField.sendKeys(invalidInput);
	    }

	    @When("I click on Start Posting Your Adds for Free button On Webpage")
	    public void i_click_on_start_posting_your_adds_for_free_button_on_webpage() 
	    {
	        // Locate the button and click it
	        WebElement postButton = driver.findElement(By.xpath("html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[4]/button[1]")); // Replace with the actual button ID or locator
	        postButton.click();
	    }

	    @Then("I should see an error message indicating the invalid field")
	    public void i_should_see_an_error_message_indicating_the_invalid_field() 
	    {
	        // Validate the error message
	        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Enter your Email']")); // Replace with the actual error message ID or locator
	       assertTrue("Error message is not displayed!", errorMessage.isDisplayed());
	        assertEquals("Enter your Email", errorMessage.getText()); // Replace with the actual expected message
	    }
	
//		
		
		
//		-------------------------------------------------------------------------------------------------------------------------------------------
		
//	    WebDriver driver=new ChromeDriver();  // Assuming you have initialized WebDriver elsewhere
//
//	    @Given("I am on the homepage of NoBroker")
//	    public void i_am_on_the_homepage_of_no_broker() {
//	        driver.get("https://www.nobroker.in/"); // Replace with the actual URL
//	    }
//
//	    @When("I click on the Main Menu button")
//	    public void i_click_on_the_main_menu_button() {
//	        WebElement mainMenuButton = driver.findElement(By.linkText("Menu")); // Replace with the actual ID or locator
//	        mainMenuButton.click();
//	    }
//
//	    @When("I select the Post Your Property option from the menu")
//	    public void i_select_the_post_your_property_option_from_the_menu() {
//	        WebElement postPropertyOption = driver.findElement(By.linkText("Post Your Property")); // Replace with the actual text or locator
//	        postPropertyOption.click();
//	    }
//
//	    @Then("I should be redirected to the Post Your Property page")
//	    public void i_should_be_redirected_to_the_post_your_property_page() throws InterruptedException {
//	        Thread.sleep(5000); // Wait for 5 seconds (adjust if needed)
//	        String expectedUrlFragment = "post-property"; // Replace with the actual URL fragment
//	        if (!driver.getCurrentUrl().contains(expectedUrlFragment)) {
//	            throw new AssertionError("The page URL does not contain the expected fragment: " + expectedUrlFragment);
//	        }
//	    }
//
//	    @Given("I am on the Post Your Property page")
//	    public void i_am_on_the_post_your_property_page() {
//	        String currentUrl = driver.getCurrentUrl();
//	        if (!currentUrl.contains("post-property")) { // Replace with the actual URL fragment
//	            throw new AssertionError("Not on the Post Your Property page");
//	        }
//	    }
//
//	    @When("I enter valid property details such as {string}, {string} and  {string}")
//	    public void i_enter_valid_property_details_such_as_and(String string, String string2, String string3) {
//	        driver.findElement(By.id("nameFieldId")).sendKeys(string); // Replace with actual locators
//	        driver.findElement(By.id("emailFieldId")).sendKeys(string2);
//	        driver.findElement(By.id("locationFieldId")).sendKeys(string3);
//	    }
//
//	    @When("I click on the Start Posting Your Ad for Free button")
//	    public void i_click_on_the_start_posting_your_ad_for_free_button() {
//	        driver.findElement(By.id("postAdButtonId")).click(); // Replace with actual ID or locator
//	    }
//
//	    @Then("the property details should be submitted successfully")
//	    public void the_property_details_should_be_submitted_successfully() throws InterruptedException {
//	        Thread.sleep(5000); // Wait for 5 seconds (adjust if needed)
//	        WebElement successMessage = driver.findElement(By.id("successMessageId")); // Replace with the actual ID
//	        if (!successMessage.isDisplayed()) {
//	            throw new AssertionError("Success message was not displayed");
//	        }
//	    }
//
//	    @Then("I should see a confirmation message to proceed with the next step")
//	    public void i_should_see_a_confirmation_message_to_proceed_with_the_next_step() {
//	        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessageId")); // Replace with actual ID
//	        assert confirmationMessage.isDisplayed();
//	    }
//
//	    @When("I enter invalid {string}")
//	    public void i_enter_invalid(String field) {
//	        driver.findElement(By.id(field + "FieldId")).sendKeys("InvalidValue"); // Replace with actual logic for invalid values
//	    }
//
//	    @Then("I should see an error message indicating the invalid field")
//	    public void i_should_see_an_error_message_indicating_the_invalid_field() {
//	        WebElement errorMessage = driver.findElement(By.id("errorMessageId")); // Replace with actual ID
//	        assert errorMessage.isDisplayed();
//	    }
//
//	    @Given("I have successfully submitted my property details")
//	    public void i_have_successfully_submitted_my_property_details() {
//	        // You can call the previous methods here to simulate property submission
//	    }
//
//	    @When("I receive an OTP on my registered mobile number")
//	    public void i_receive_an_otp_on_my_registered_mobile_number() {
//	        // Simulate OTP received
//	    }
//
//	    @When("I enter the OTP correctly")
//	    public void i_enter_the_otp_correctly() {
//	        driver.findElement(By.id("otpFieldId")).sendKeys("123456"); // Replace with the actual OTP input field ID
//	    }
//
//	    @When("I click on the Continue button")
//	    public void i_click_on_the_continue_button() {
//	        driver.findElement(By.id("continueButtonId")).click(); // Replace with actual ID
//	    }
//
//	    @Then("I should be redirected to the next step of the property posting process")
//	    public void i_should_be_redirected_to_the_next_step_of_the_property_posting_process() throws InterruptedException {
//	        Thread.sleep(5000); // Wait for 5 seconds
//	        String currentUrl = driver.getCurrentUrl();
//	        if (!currentUrl.contains("next-step")) { // Replace with the actual URL fragment
//	            throw new AssertionError("Redirection to the next step did not occur");
//	        }
//	    }
//
//	    @When("I enter the OTP incorrectly")
//	    public void i_enter_the_otp_incorrectly() {
//	        driver.findElement(By.id("otpFieldId")).sendKeys("000000"); // Simulate entering an incorrect OTP
//	    }
//
//	    @Then("I should see an error message indicating the OTP is incorrect or expired")
//	    public void i_should_see_an_error_message_indicating_the_otp_is_incorrect_or_expired() {
//	        WebElement otpErrorMessage = driver.findElement(By.id("otpErrorMessageId")); // Replace with actual ID
//	        assert otpErrorMessage.isDisplayed();
//	    }
	}
	
	



