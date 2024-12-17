package com.stepDefination;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RentalAggrementStep {

    static WebDriver driver;

    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.nobroker.in/");
    }

    @When("the user clicks on the Rental Aggrement link")
    public void the_user_clicks_on_the_rental_agreement_link() {
        driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div")).click();

        // Switch to the newly opened window
        String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
        Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles

        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // Switch to the new window
                break;
            }
        }
    }

    @Then("the user should be redirected to the Rental Aggrement page")
    public void the_user_should_be_redirected_to_the_rental_agreement_page(){
    	
    	
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.findElement(By.xpath("//*[@id=\"modalContent\"]/div/div/div[2]/div[2]/div[1]/img")).click();
    	
      //  Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"modalContent\"]/div/div/div[2]/div[2]/div[1]")).isDisplayed(), null);
        }
    
    @Then("close the browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }}
  

