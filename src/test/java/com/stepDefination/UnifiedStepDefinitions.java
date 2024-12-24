package com.stepDefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.google.common.io.Files;
import com.pages.FilterPropertyPage;
import com.pages.PropertyAdsPage;
import com.pages.VerifyNoBrokerPage;
import com.parameters.ExcelReader;
import com.setup.SetupDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnifiedStepDefinitions {

    WebDriver driver;
    FilterPropertyPage filterPropertyPage;
    PropertyAdsPage propertyAdPage;
    VerifyNoBrokerPage noBrokerPage;

    public UnifiedStepDefinitions() {
        this.driver = SetupDefination.getDriver();
        this.filterPropertyPage = new FilterPropertyPage(driver);
        this.propertyAdPage = new PropertyAdsPage(driver);
        this.noBrokerPage = new VerifyNoBrokerPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ========================= Common Utilities =========================

    public static void takeScreenshot(WebDriver driver, String filePath) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ========================= Filter Property Steps =========================

    @Given("I am on the NoBroker property search page")
    public void i_am_on_the_nobroker_property_search_page() throws IOException {
        driver.get(ExcelReader.geturl());
        takeScreenshot(driver, "C:\\Users\\parawat\\Desktop\\Sprint\\NoBrokerProject\\Screenshots\\Homepage.jpg");
    }

    @When("I select {string} as the city")
    public void i_select_as_the_city(String city) {
        filterPropertyPage.selectCity(city);
    }

    @When("I enter {string} in the locality search bar")
    public void i_enter_in_the_locality_search_bar(String locality) {
        filterPropertyPage.enterLocality(locality);
    }

    @When("I select {string} as the property type")
    public void i_select_as_the_property_type(String propertyType) {
        filterPropertyPage.selectPropertyType(propertyType);
    }

    @When("I select {string} under Availability")
    public void i_select_under_availability(String availability) {
        filterPropertyPage.selectAvailability(availability);
    }

    @When("I select {string} as the BHK type")
    public void i_select_as_the_bhk_type(String bhkType) {
        filterPropertyPage.selectBHKType(bhkType);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String button) {
        filterPropertyPage.clickSearchButton();
    }

    @Then("I should see a list of properties in {string} with immediate availability")
    public void i_should_see_a_list_of_properties_in_with_immediate_availability(String locality) {
        boolean isDisplayed = filterPropertyPage.verifyPropertiesDisplayed(locality);
        assert isDisplayed : "No properties found with immediate availability in " + locality;
    }

    @Then("I should see a list of {string} properties in Indiranagar, Bangalore")
    public void i_should_see_a_list_of_properties_in_bangalore(String bhkType) {
        boolean isDisplayed = filterPropertyPage.verifyBHKPropertiesDisplayed(bhkType);
        assert isDisplayed : "No " + bhkType + " properties found";
    }

    @Then("I should see an error message saying {string}")
    public void i_should_see_an_error_message_saying(String expectedMessage) {
        boolean isErrorMessageDisplayed = filterPropertyPage.verifyErrorMessage(expectedMessage);
        assert isErrorMessageDisplayed : "Expected error message not displayed: " + expectedMessage;
    }

    // ========================= Property Advertisement Steps =========================

    @Given("I visit the property advertisement page")
    public void iVisitThePropertyAdvertisementPage() {
        propertyAdPage.visitPropertyAdvertisementPage();
    }

    @When("The user enters a Number")
    public void the_user_enters_a_number() {
        propertyAdPage.enterPhoneNumber("9990103266");
    }

    @Given("Verify form accepts valid inputs and rejects invalid inputs")
    public void verify_form_accepts_valid_inputs() {
        propertyAdPage.verifyFormPage();
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        propertyAdPage.clickButton();
    }

    @Then("I should be directed to the property listing form")
    public void iShouldBeDirectedToThePropertyListingForm() {
        propertyAdPage.verifyRedirection();
    }

    @Then("I should Click on The cross Button")
    public void i_should_click_on_the_cross_button() throws InterruptedException {
        propertyAdPage.clickCrossButton();
    }

    @When("the user enters {string} in the name field")
    public void the_user_enters_in_the_name_field(String name) {
        propertyAdPage.enterName(name);
    }

    @And("the user enters {string} in the email field")
    public void the_user_enters_in_the_email_field(String email) {
        propertyAdPage.enterEmail(email);
    }

    @And("the user selects {string} from the city dropdown")
    public void the_user_selects_from_the_city_dropdown(String city) {
        propertyAdPage.selectCity(city);
    }

    @Then("the form submission should {string}")
    public void the_form_submission_should(String result) {
        propertyAdPage.submitForm();
        boolean isErrorDisplayed = propertyAdPage.isErrorDisplayed();
       
         String actual;
        if(isErrorDisplayed) actual = "be accepted";
        else actual = "be rejected";
        
        Assert.assertEquals(actual , result);
    }

    // ========================= Verify NoBroker Page Steps =========================

    @Then("the page URL should contain {string}")
    public void verifyPageTitle(String expectedTitle) {
        boolean isURLCorrect = noBrokerPage.isURLContains(expectedTitle);
        Assert.assertTrue(isURLCorrect, "Page URL does not contain the expected text!");
    }

    @Then("the {string} section should be displayed")
    public void verifySectionDisplayed(String sectionName) throws InterruptedException {
        boolean isDisplayed = noBrokerPage.isSectionDisplayed(sectionName);
        Assert.assertTrue(isDisplayed, sectionName + " section is not displayed!");
    }

    @When("the user clicks on the {string} link")
    public void clickLink(String linkName) {
        noBrokerPage.clickLink(linkName);
    }

    @Then("the URL should navigate to {string}")
    public void verifyURL(String expectedURLFragment) {
        boolean isURLCorrect = noBrokerPage.isURLContains(expectedURLFragment);
        Assert.assertTrue(isURLCorrect, "URL does not contain the expected fragment!");
    }

    @Then("the page content should include {string}")
    public void verifyPageContent(String expectedContent) {
        boolean isContentPresent = noBrokerPage.isContentPresent(expectedContent);
        Assert.assertTrue(isContentPresent, "Page content does not include the expected text!");
    }

    @Then("the {string} image should be visible")
    public void verifyImageVisible(String imageName) {
        boolean isVisible = noBrokerPage.isImageVisible(imageName);
        Assert.assertTrue(isVisible, imageName + " image is not visible!");
    }

    @When("the user resizes the browser window to mobile size")
    public void resizeToMobileSize() {
        noBrokerPage.resizeToMobileSize();
    }

    @Then("close the browser")
    public void close_the_browser() {
        SetupDefination.quitDriver();
    }
    @Then("navigate to HomePage")
    public void navigate_to_home_page() {
        noBrokerPage.navigateToHomePage();
    }
}
