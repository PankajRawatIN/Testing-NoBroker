package com.stepDefination;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.setup.SetupDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PropertyAdSteps {

    WebDriver driver;

    @Given("I visit the property advertisement page")
    public void iVisitThePropertyAdvertisementPage() {
    	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 driver = SetupDefination.getDriver();
        driver.get("https://www.nobroker.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)"); 
    }

@When("The user enters a Number")
public void the_user_enters_a_number() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	WebElement num = driver.findElement(By.id("userPhone"));
	num.clear();
	num.sendKeys("9990103266");
}


    @Given("Verify form accepts valid inputs and rejects invalid inputs")
    public void iAmOnAdvertisementPage() {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.nobroker.in/list-your-property-for-rent-sale");
  
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@id=\'pypAd\']/button")).click();
    }

    @Then("I should be directed to the property listing form")
    public void iShouldBeDirectedToThePropertyListingForm() {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("your-property-for-rent-sale"));
    }
    @Then("I should Click on The cross Button")
    public void i_should_click_on_the_cross_button() throws InterruptedException {
      
     // new WebDriverWait(driver, Duration.ofSeconds(20)); // 10-second timeout
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	 WebElement iframeElement = driver.findElement(By.id("webWidget"));

         // Switch to the iframe
         driver.switchTo().frame(iframeElement);
    	
    	
    	Thread.sleep(5000);
    	// Wait until the button is visible
        driver.findElement(By.xpath("//*[@id=\"Embed\"]/div/div/div/div/div/div/header/div/button[2]")).click();
        driver.switchTo().defaultContent();

        // Click the button
     //   button.click();
    }
    
    
    @When("the user enters {string} in the name field")
    public void the_user_enters_in_the_name_field(String string) {
    	
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
    	WebElement inp = driver.findElement(By.id("userName"));
    	
    	inp.clear();
    	inp.sendKeys(string);
    	
    }

    @And("the user enters {string} in the email field")
    public void the_user_enters_in_the_email_field(String string) {
    	
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement inp = driver.findElement(By.id("userEmail"));
    	
    	inp.clear();
    	inp.sendKeys(string);
    }

    @And("the user selects {string} from the city dropdown")
    public void the_user_selects_from_the_city_dropdown(String string) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	   WebElement cityDropdown = driver.findElement(By.xpath("//*[@id=\"citySelectContainer\"]/div[1]/div[1]/div"));
           cityDropdown.click();

           WebElement cityOption = driver.findElement(By.id("react-select-5-option-1"));
           cityOption.click();
    }

    @Then("the form submission should {string}")
    public void the_form_submission_should(String string) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate and scroll to the submit button
        WebElement sub = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div[4]/button"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", sub);

        // Locate and scroll to the username input
        WebElement user = driver.findElement(By.id("userName"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", user);

        boolean chk = true;

        // Check for error elements
        By errorLocator = By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/span");
        if (isElementDisplayed(errorLocator)) {
            chk = false;
        }

        // Output the result
      

        // Assert the result
        Assert.assertTrue(chk);
    }

    // Helper method to check if an element is displayed
    private boolean isElementDisplayed(By locator) {
        try {
            // Use findElements to avoid exceptions
            List<WebElement> elements = driver.findElements(locator);
            return !elements.isEmpty() && elements.get(0).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            // Handle cases where the element may not be present or is stale
            return false;
        }
    }

  
}
