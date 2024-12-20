package com.stepDefination;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.RentalAgreementPage;
import com.setup.SetupDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RentalAggrementStep {

    WebDriver driver;
    RentalAgreementPage rentalAgreementPage;
    WebDriverWait wait;

    //Background
    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        driver = SetupDefination.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize WebDriverWait here after driver
        driver.get("https://www.nobroker.in/");
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
        By rentalAgreementIcon = By.xpath("//div[contains(@class, 'nb__1IQvp')]//span[contains(text(), 'Rental Agreement')]"); // Update with the actual ID or locator for the Rental Agreement icon

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
            driver = SetupDefination.getDriver();  // Re-initialize the driver if needed
        }
        
        Set<String> windowHandles = driver.getWindowHandles();
       // String parentWindowHandle = windowHandles.iterator().next();
        String currentWindowHandle = windowHandles.toArray(new String[0])[windowHandles.size() - 1];
        driver.switchTo().window(currentWindowHandle);

        // Wait for the element to be visible before interacting with it
        WebElement availabilityOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='modalContent']/div/div/div[2]/div[2]/div[3]")));

        boolean check = availabilityOption.isDisplayed();
        Assert.assertTrue(check, "Element Not Visible");
        //driver.switchTo().window(parentWindowHandle);
    }
    
    @Then("Click on chennai")
    public void click_on_chennai() {
        // Ensure driver is initialized
        if (driver == null) {
            driver = SetupDefination.getDriver();  // Re-initialize the driver if needed
        }

        WebElement chennai = driver.findElement(By.xpath("//*[@id='modalContent']/div/div/div[2]/div[2]/div[3]"));
        chennai.click();
    }

    //Scenario 3
//    @When("the user clicks on the Renew Your Agreement section")
//    public void the_user_clicks_on_the_section() throws Exception {
//        // Ensure the rentalAgreementPage is initialized before calling any method on it
//        if (rentalAgreementPage != null) {
//            rentalAgreementPage.clickRenewYourAgreementSection();  // This will now work
//        } else {
//            throw new NullPointerException("rentalAgreementPage is not initialized.");
//        }
//    }
//    
//    @Then("the text {string} should be visible")
//    public void the_text_should_be_visible(String expectedText) {
//        WebElement rentalAgreementTextElement = rentalAgreementPage.getRentalAgreementText();
//        assert rentalAgreementTextElement.getText().equals(expectedText) : "Expected text not displayed";
//    }
//
//    @Then("the icons for Rental Agreement and Next Day Delivery should be displayed correctly")
//    public void the_icons_for_rental_agreement_and_next_day_delivery_should_be_displayed_correctly() {
//        By nextDayDeliveryIcon = By.xpath("//span[contains(@class, 'nb__sk2nG') and contains(text(), 'Next Day Delivery')]");
//
//        // Verify Next Day Delivery icon is displayed
//        WebElement nextDayDeliveryElement = driver.findElement(nextDayDeliveryIcon);
//        Assert.assertTrue(nextDayDeliveryElement.isDisplayed(), "Next Day Delivery icon is not displayed correctly");
//
//        System.out.println("Rental Agreement and Next Day Delivery icons are displayed correctly.");
//    }
//
//    @Given("the user is on the Rental Agreement page")
//    public void the_user_is_on_the_rental_agreement_page() {
//        WebElement rentalAgreementLink = rentalAgreementPage.getRentalAgreementLink();
//        assert rentalAgreementLink.isDisplayed() : "Rental Agreement page not displayed";
//    }
//
//    @When("the user clicks on the Home icon")
//    public void the_user_clicks_on_the_home_icon() {
//        rentalAgreementPage.navigateToHomePage();
//    }
//
//    @Then("the user should be redirected to the Home page")
//    public void the_user_should_be_redirected_to_the_home_page() {
//        WebElement homePageHeader = driver.findElement(By.tagName("h1"));
//        assert homePageHeader.getText().equals("Welcome to Home Page") : "User not redirected to Home page";
//    }
//
//    @Given("the user is on the Legal Services page")
//    public void the_user_is_on_the_legal_services_page() {
//        // Initialize WebDriver
//        driver = SetupDefination.getDriver();
//
//        // Initialize the RentalAgreementPage
//        rentalAgreementPage = new RentalAgreementPage(driver);
//
//        // Navigate to the Legal Services page
//        driver.get("https://www.nobroker.in/legal-services");  // Update with the correct URL
//    }
//
//    @Then("the user should be redirected to the EnterMobileNumber page")
//    public void the_user_should_be_redirected_to_the_enter_mobile_number_page() {
//        // Specify the expected URL of the EnterMobileNumber page
//       String expectedUrl = "https://www.nobroker.in/rental-agreement-in-chennai?nbFr=home_top_card";  // Update with the correct URL
//       
//
//        // Assert that the current URL matches the expected URL
//       Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User is not redirected to the Enter Mobile Number page.");
//        
//        System.out.println("User successfully redirected to the Enter Mobile Number page.");
//    }
    
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
        // Write code here that turns the phrase above into concrete actions
    	 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/header/nav/div[2]/button/span")).click();
    }
///scnerio 4
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
}





