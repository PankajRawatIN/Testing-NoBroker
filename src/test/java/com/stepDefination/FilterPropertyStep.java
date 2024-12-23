package com.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.FilterPropertyPage;
import com.parameters.ExcelReader;
import com.setup.SetupDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterPropertyStep {

    WebDriver driver;
    FilterPropertyPage filterPropertyPage;

    @Given("I am on the NoBroker property search page")
    public void i_am_on_the_nobroker_property_search_page() throws IOException {
    	         driver = SetupDefination.getDriver();
        driver.get(ExcelReader.geturl()); // Adjust URL if needed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        filterPropertyPage = new FilterPropertyPage(driver);
    }

    @When("I select {string} as the city")
    public void i_select_as_the_city(String city) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterPropertyPage.selectCity(city);
    }

    @When("I enter {string} in the locality search bar")
    public void i_enter_in_the_locality_search_bar(String locality) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterPropertyPage.enterLocality(locality);
    }

    @When("I select {string} as the property type")
    public void i_select_as_the_property_type(String propertyType) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterPropertyPage.selectPropertyType(propertyType);
    }

    

    @When("I select {string} under Availability")
    public void i_select_under_availability(String availability)  {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterPropertyPage.selectAvailability(availability);
    }

    @When("I select {string} as the BHK type")
    public void i_select_as_the_bhk_type(String bhkType) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterPropertyPage.selectBHKType(bhkType);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String button) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        filterPropertyPage.clickSearchButton();
    }

    @Then("I should see a list of properties in {string} with immediate availability")
    public void i_should_see_a_list_of_properties_in_with_immediate_availability(String locality) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean isDisplayed = filterPropertyPage.verifyPropertiesDisplayed(locality);
        assert isDisplayed : "No properties found with immediate availability in " + locality;
    }

    @Then("I should see a list of {string} properties in {string}, Bangalore")
    public void i_should_see_a_list_of_properties_in_bangalore(String bhkType, String locality) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean isDisplayed = filterPropertyPage.verifyBHKPropertiesDisplayed(bhkType, locality);
        assert isDisplayed : "No " + bhkType + " properties found in " + locality + ", Bangalore";
    }

    @Then("I should see an error message saying {string}")
    public void i_should_see_an_error_message_saying(String expectedMessage) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean isErrorMessageDisplayed = filterPropertyPage.verifyErrorMessage(expectedMessage);
        assert isErrorMessageDisplayed : "Expected error message not displayed: " + expectedMessage;
    }

    @Then("I should see a list of properties in HSR Layout with immediate availability")
    public void i_should_see_a_list_of_properties_in_hsr_layout_with_immediate_availability() {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	    boolean isDisplayed = filterPropertyPage.verifyImmediateAvailability();
    	    assert isDisplayed : "No properties found with immediate availability in HSR Layout.";
    }

    @Then("I should see a list of {string} properties in Indiranagar, Bangalore")
    public void i_should_see_a_list_of_properties_in_indiranagar_bangalore(String string) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	boolean isTitleCorrect = filterPropertyPage.verifyPageTitleContains("Flats, Houses, Apartments for Rent, Buy, Sale Without Brokerage in India");
    	Assert.assertTrue(isTitleCorrect, "The page title does not contain the expected text.");

      // Verify the count of properties displayed matches the expected BHK count
     boolean CorrectBHKCount = filterPropertyPage.verifySpecificBHKCount(string);
    Assert.assertTrue(CorrectBHKCount , "Yes you landed on correct page");
    }
    @Then("close the browserr")
    public void close_the_browser() {  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SetupDefination.quitDriver();
    }
}