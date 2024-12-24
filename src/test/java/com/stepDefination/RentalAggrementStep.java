package com.stepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.RentalAgreementPage;
import com.parameters.ExcelReader;
import com.parameters.FileReading;
import com.setup.SetupDefination;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RentalAggrementStep {
    WebDriver driver;
    Properties prop;
    RentalAgreementPage rentalAgreementPage;
    WebDriverWait wait;
    ExcelReader excelReader;
    public WebElement waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increase timeout as needed
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Method to click on the element after waiting for visibility
    public void clickOnRentalAgreement() {
        By rentalAgreementLocator = By.xpath("//*[@id='modalContent']/div/div/div[2]/div[2]/div[3]");
        WebElement rentalAgreementElement = waitForElementVisible(rentalAgreementLocator);
        rentalAgreementElement.click();
    }
    //Background
    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() throws IOException {
    	prop=FileReading.reader();
        driver = SetupDefination.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        driver.get(excelReader.geturl());
        rentalAgreementPage = new RentalAgreementPage(driver);
    }
    
    @When("the user clicks on the Rental Agreement")
    public void the_user_clicks_on_the_rental_agreement() {
        rentalAgreementPage.clickRentalAgreementLink();
    }
    //Scenario 1
    @Then("the user should see Rental Agreement icon displayed correctly")
    public void the_user_should_see_rental_agreement_icon_displayed_correctly() {
        // Define locators for the icons
        By rentalAgreementIcon = By.xpath("//div[contains(@class, 'nb__1IQvp')]//span[contains(text(), 'Rental Agreement')]"); 
        // Verify Rental Agreement icon is displayed
        WebElement rentalAgreementElement = driver.findElement(rentalAgreementIcon);
        Assert.assertTrue(rentalAgreementElement.isDisplayed(), "Rental Agreement icon is not displayed correctly");

        System.out.println("Rental Agreement and Next Day Delivery icons are displayed correctly.");
    }
    //Scenario 2 
    @Then("the Next Day Delivery icon should be displayed correctly")
    public void the_next_day_delivery_icon_should_be_displayed_correctly() {
        WebElement deliveryIconElement = rentalAgreementPage.getDeliveryIcon();
        assert deliveryIconElement.isDisplayed() : "Delivery Icon not displayed";
    }
    @Then("Multiple citites Option Should be visible")
    public void multiple_citites_option_should_be_visible(){
        // Ensure driver is initialized
        if (driver == null) {
            driver = SetupDefination.getDriver(); 
        }
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindowHandle = windowHandles.toArray(new String[0])[windowHandles.size() - 1];
        driver.switchTo().window(currentWindowHandle);
        WebElement availabilityOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='modalContent']/div/div/div[2]/div[2]/div[3]")));

        boolean check = availabilityOption.isDisplayed();
        Assert.assertTrue(check, "Element Not Visible");
    }
    @Then("Click on chennai")
    public void click_on_chennai() {
        // Ensure driver is initialized
        if (driver == null) {
            driver = SetupDefination.getDriver();
        }
        WebElement chennai = driver.findElement(By.xpath("//*[@id='modalContent']/div/div/div[2]/div[2]/div[3]"));
        chennai.click();
    }
//Scenario 3
    @Then("Click on Pune")
    public void click_on_Pune() {
    	
        // Ensure driver is initialized
        if (driver == null) {
            driver = SetupDefination.getDriver();  // Re-initialize the driver if needed
        }
        WebElement Pune = driver.findElement(By.xpath("//*[@id=\"modalContent\"]/div/div/div[2]/div[2]/div[4]/img"));
        Pune.click();
    }

    @Then("the user should be redirected to the Sign-Up page")
    public void the_user_should_be_redirected_to_the_sign_up_page() {
    	
    	WebElement chk = driver.findElement(By.xpath("//*[@id=\"NewRootRoot\"]/div/div[1]/div[1]/div/div[1]"));
    	
        Assert.assertTrue(chk.isDisplayed(), "Not redirected to the Sign-Up page!");
    }


    @Then("the user clicks on the helpline link")
    public void the_user_clicks_on_the_helpline_link() {
        // Locate the helpline link using XPath or CSS selector
        WebElement helplineLink = driver.findElement(By.xpath("//a[@href='tel:+91 9243012802']"));
        helplineLink.click();
    }

    @Then("the user should be redirected to the about:blank page")
    public void the_user_should_be_redirected_to_the_about_blank_page() {
        // Wait for the page to redirect to about:blank
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://www.nobroker.in/rental-agreement-in-pune?nbFr=home_top_card"));

        // Verify if the current page URL is about:blank
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.nobroker.in/rental-agreement-in-pune?nbFr=home_top_card", "The user is not redirected to about:blank!");
    }
//   Scenario 4
    @Then("Click on Banglore")
    public void click_on_Banglore() {
    	
        // Ensure driver is initialized
        if (driver == null) {
            driver = SetupDefination.getDriver();  // Re-initialize the driver if needed
        }
        WebElement Banglore = driver.findElement(By.xpath("//*[@id=\"modalContent\"]/div/div/div[2]/div[2]/div[1]/img"));
        Banglore.click();
    }
    @Then("the user clicks on My Bookings")
    public void the_user_clicks_on_my_bookings() {
       
    	 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/header/nav/div[2]/button/span")).click();
    }
    @Then("the user is on the Sign-Up Page")
    public void the_user_is_on_the_sign_up_page() {
    	 driver = SetupDefination.getDriver();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize WebDriverWait here after driver
         driver.get("https://www.nobroker.in/rental-agreement-in-hyderabad?nbFr=home_top_card");
         rentalAgreementPage = new RentalAgreementPage(driver);
    }
    @Then("the user enters the name {string}")
    public void the_user_enters_the_name(String name) {
            RentalAgreementPage.enterName(name);  // Call the method in FormPage to input the name into the form
         new io.cucumber.java.PendingException();
    }
    

    // Step: Enter phone number
    @Then("the user enters the phone number {string}")
    public void the_user_enters_the_phone_number(String phoneNumber) {
    	RentalAgreementPage.enterPhoneNumber(phoneNumber);  // Calling FormPage method to enter phone number
    }

    // Step: Enter email
    @Then("the user enters the email {string}")
    public void the_user_enters_the_email(String email) {
    	RentalAgreementPage.enterEmail(email);  // Calling FormPage method to enter email
    }

    // Step: Click continue button
    @Then("the user clicks on continue")
    public void the_user_clicks_on_continue() {
        RentalAgreementPage.clickContinue();  // Calling FormPage method to click the continue button
    }

    // Step: Verify form submission success
    @Then("the form should be submitted successfully")
    public void the_form_should_be_submitted_successfully() {
        Assert.assertTrue(RentalAgreementPage.isFormSubmittedSuccessfully(), "Form was not submitted successfully");  // Verifying the success message
    }

    // Close WebDriver after test
    @After
    public void tearDown() {
        driver.quit();  // Quit the WebDriver after the test is complete
    }
    //Scenario 5 
  @Then("click on Noida")
   public void click_on_noida() throws InterruptedException {
        // Ensure driver is initialized
        if (driver == null) {
            driver = SetupDefination.getDriver();  
        }
        WebElement Noida = driver.findElement(By.xpath("//*[@id=\"modalContent\"]/div/div/div[2]/div[2]/div[8]/img"));
        Noida.click();
        Thread.sleep(5000);
    }
    @Then("clik on Proceed")
    public void clik_on_proceed() throws InterruptedException {
      
     	JavascriptExecutor js = (JavascriptExecutor) driver;
	             js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div[3]/div[5]/span")));
	             Thread.sleep(3000);
	             wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content-wrapper']/div[2]/div/div[4]/button[2]"))).click();

             Thread.sleep(3000);
   }

  @Then("user enters the number")
    public void user_enters_the_invalid_number() throws InterruptedException {
        // Call the method in PageActions to enter an invalid number]
    	WebElement butoon= driver.findElement(By.xpath("//*[@id=\"signUp-phoneNumber\"]"));
       Actions action = new Actions(driver);
       action.click(butoon).sendKeys("97813375").perform();
       Thread.sleep(5000);
       
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NewRootRoot\"]/div/div[1]/button"))).click();
       Thread.sleep(3000);
       
     WebElement sub= driver.findElement(By.xpath("//*[@id=\"NewRootRoot\"]/div/div[1]/div[2]/div/span"));
     boolean chk= sub.isDisplayed();
     Assert.assertTrue(chk, "Invalid");
    }
//parametrised Scenario 6
  @When("the user should enter {string}")
  public void the_user_should_enter(String cityName) {
      RentalAgreementPage.enterCity(cityName);
  }

  @Then("the user clicks on Agra option")
  public void the_user_clicks_on_agra_option() {
      // Call the method from RentalPage to click on the city suggestion ("Agra")
	  RentalAgreementPage.clickOnCitySuggestion((String)prop.get("firstCity"));
  }
  @After
  public void doSomethingAfter(Scenario scenario){
//  	if (scenario.isFailed()) {
  	    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  	    scenario.attach(screenshot, "image/png", "Scenario_Screenshot");
  	    driver.quit();
   // }
  }
}
 

    





