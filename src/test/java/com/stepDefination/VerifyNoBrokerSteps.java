package com.stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.setup.SetupDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyNoBrokerSteps {
    WebDriver driver;

    @Given("I am on the NoBroker property search pagee")
    public void i_am_on_the_nobroker_property_search_page() {
    	         driver = SetupDefination.getDriver();
        driver.get("https://www.nobroker.in/"); // Adjust URL if needed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
    }

    @Then("the page URL should contain {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title does not contain expected text!");
    }

    @Then("the {string} section should be displayed")
    public void verifySectionDisplayed(String sectionName) throws InterruptedException {
    	// to scroll ontpt the page until it is visible
    	
    	WebElement element = driver.findElement(By.xpath("//*[@id='app']/div/div/div[6]/div[2]/div[1]/a/img")); 
    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	// Wait for the element to be present
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app']/div/div/div[6]/div[2]/div[1]/a/img")));

    	// Scroll into view
    	js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    	Thread.sleep(500); // Optional delay to allow scrolling animation
    	Assert.assertTrue(element.isDisplayed(), sectionName + " section is not displayed!");
    	}
       // Assert.assertTrue(element.isDisplayed(), sectionName + " section is not displayed!");
    

    @When("the user clicks on the {string} link")
    public void clickLink(String linkName) {
        String linkXpath = getLinkXpath(linkName);
        WebElement link = driver.findElement(By.xpath(linkXpath));
        link.click();
    }

    @Then("the URL should navigate to {string}")
    public void verifyURL(String expectedURLFragment) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedURLFragment), "URL does not contain the expected fragment!");
    }

    @Then("the page content should include {string}")
    public void verifyPageContent(String expectedContent) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedContent), "Page content does not include the expected text!");
    }

    @And("the URL should navigate to Home Page")
    public void navigateToHomePage() {
        driver.get("https://www.nobroker.in/"); // Ensure this URL is correct
    }
    

    @Then("the {string} image should be visible")
    public void verifyImageVisible(String imageName) {
        String imageXpath = getImageXpath(imageName);
        WebElement image = driver.findElement(By.xpath(imageXpath));
        Assert.assertTrue(image.isDisplayed(), imageName + " image is not visible!");
    }

    @When("the user resizes the browser window to mobile size")
    public void resizeToMobileSize() {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812)); // iPhone X size
    }

    @Then("the {string} link should have target={string}")
    public void verifyLinkTarget(String linkName, String expectedTarget) {
        // String linkXpath = getLinkXpath(linkName);
        // WebElement link = driver.findElement(By.xpath(linkXpath));
        String actualTarget = driver.getCurrentUrl();
        Assert.assertEquals(linkName + " link does not have the expected target attribute!", expectedTarget, actualTarget);
    }

    // Utility Methods
    private String getSectionXpath(String sectionName) {
        switch (sectionName) {
            case "Avoid Brokers":
                return "//div[contains(@class, 'avoid-brokers-section')]";
            case "Free Listing":
                return "//div[contains(@class, 'free-listing-section')]";
            default:
                throw new IllegalArgumentException("Unknown section: " + sectionName);
        }
    }

    private String getLinkXpath(String linkName) {
        switch (linkName) {
            case "Avoid Brokers":
                return "//*[@id=\"app\"]/div/div/div[6]/div[2]/div[1]/a/img";
            case "Shortlist without Visit":
                return "//*[@id=\"app\"]/div/div/div[6]/div[2]/div[3]/a/img";
            default:
                throw new IllegalArgumentException("Unknown link: " + linkName);
        }
    }

    private String getImageXpath(String imageName) {
        switch (imageName) {
            case "Avoid Brokers":
                return "//*[@id=\"app\"]/div/div/div[6]/div[2]/div[1]/a/img";
            case "Shortlist without Visit":
                return "//*[@id=\"app\"]/div/div/div[6]/div[2]/div[3]/a/img";
            default:
                throw new IllegalArgumentException("Unknown image: " + imageName);
        }
    }

    // Optional: Handling method for cleanup after tests
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
   
}
