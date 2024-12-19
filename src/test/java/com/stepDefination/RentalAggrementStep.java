package com.stepDefination;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import com.pages.RentalAgreementPage;
import com.setup.SetupDefination;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class RentalAggrementStep {
 
    WebDriver driver;
    RentalAgreementPage rentalAgreementPage;
 
    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        driver = SetupDefination.getDriver();
        driver.get("https://www.nobroker.in/");
        rentalAgreementPage = new RentalAgreementPage(driver);
    }
 
    @When("the user clicks on the Rental Agreement")
    public void the_user_clicks_on_the_rental_agreement() {
        rentalAgreementPage.clickRentalAgreementLink();
    }
 
    @Then("the Next Day Delivery icon should be displayed correctly")
    public void the_next_day_delivery_icon_should_be_displayed_correctly() {
        WebElement deliveryIconElement = rentalAgreementPage.getDeliveryIcon();
        assert deliveryIconElement.isDisplayed() : "Delivery Icon not displayed";
    }
 
    @Then("the text {string} should be visible")
    public void the_text_should_be_visible(String expectedText) {
        WebElement rentalAgreementTextElement = rentalAgreementPage.getRentalAgreementText();
        assert rentalAgreementTextElement.getText().equals(expectedText) : "Expected text not displayed";
    }
 
    @Then("the icons for Rental Agreement and Next Day Delivery should be displayed correctly")
    public void the_icons_for_rental_agreement_and_next_day_delivery_should_be_displayed_correctly() {
        rentalAgreementPage.verifyIconsDisplayed();
    }
 
    @Given("the user is on the Rental Agreement page")
    public void the_user_is_on_the_rental_agreement_page() {
        WebElement rentalAgreementLink = rentalAgreementPage.getRentalAgreementLink();
        assert rentalAgreementLink.isDisplayed() : "Rental Agreement page not displayed";
    }
 
    @When("the user clicks on the Home icon")
    public void the_user_clicks_on_the_home_icon() {
        rentalAgreementPage.navigateToHomePage();
    }
 
    @Then("the user should be redirected to the Home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        WebElement homePageHeader = driver.findElement(By.tagName("h1"));
        assert homePageHeader.getText().equals("Welcome to Home Page") : "User not redirected to Home page";
    }
    @Then("the user should see Rental Agreement and Next Day Delivery icons displayed correctly")
    public void the_user_should_see_rental_agreement_and_next_day_delivery_icons_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("close the browser")
    public void close_the_browser() {
        SetupDefination.quitDriver();
    }
}