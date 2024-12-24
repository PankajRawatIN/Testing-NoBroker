package com.pages;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class RentalAgreementPage {
 
    static WebDriver driver;
 
    // Constructor
    public RentalAgreementPage(WebDriver driver) {
        this.driver = driver;
    }
 
    // Locator for Rental Agreement icon
    private By rentalAgreementLink = By.cssSelector(".nb__1YnwY");
 
    // Locator for Delivery Icon
    private By deliveryIcon = By.xpath("//div[contains(@class, 'nb__1IQvp')]//span[contains(text(), 'Rental Agreement')]");
 
    // Locator for Rental Agreement text
    private By rentalAgreementText = By.xpath("//span[contains(text(),'Rental Agreement | Next Day Delivery')]");
 
    public WebElement getRentalAgreementLink() {
        return driver.findElement(rentalAgreementLink);
    }
 
    public WebElement getDeliveryIcon() {
        return driver.findElement(deliveryIcon);
    }
 
    public WebElement getRentalAgreementText() {
        return driver.findElement(rentalAgreementText);
    }
 
    public void clickRentalAgreementLink() {
        getRentalAgreementLink().click();
    }
 
    public void navigateToHomePage() {
        // Assuming there's a home icon with a specific locator
        By homeIcon = By.cssSelector(".home-icon");
        driver.findElement(homeIcon).click();
    }
 
    public void verifyIconsDisplayed() {
        assert getDeliveryIcon().isDisplayed() : "Delivery Icon is not displayed";
        // Additional icons verification logic can be added here
    }
    private By cityNameLocator(String cityName) {
        return By.xpath("//span[@class='font-semibold text-16' and contains(text(), '" + cityName + "')]");
    }

    // Method to navigate to the RentalAgreement page
    public void navigateToRentalAgreementPage(String url) {
        driver.get(url); // Opens the provided URL
        System.out.println("Navigated to RentalAgreement page.");
    }

    // Method to verify if the city name is displayed
    public boolean isCityNameDisplayed(String cityName) {
        try {
            WebElement cityNameElement = driver.findElement(cityNameLocator(cityName));
            return cityNameElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("City name element not found: " + e.getMessage());
            return false;
        }


    }

    // Method to get the actual city name displayed
    public String getCityName(String cityName) {
        try {
            WebElement cityNameElement = driver.findElement(cityNameLocator(cityName));
            return cityNameElement.getText();
        } catch (Exception e) {
            System.out.println("Error getting city name: " + e.getMessage());
            return null;
        }
    }


	    public void clickMyBookings() {
	        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/header/nav/div[2]/button/span")).click();
	    }
	    // Locator for the helpline link
        private By helplineLink = By.xpath("//*[@id=\"app\"]/div/div/div/div/header/nav/div[2]/a");

        // Method to click on the helpline link
        public void clickHelplineLink() {
            WebElement helplineButton = driver.findElement(helplineLink);
            helplineButton.click();
        }
        public static void enterName(String name) {
            WebElement nameElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
            nameElement.clear();
            nameElement.sendKeys(name);
        }

        // Method to enter phone number
        public static void enterPhoneNumber(String phoneNumber) {
            WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"signUp-phoneNumber\"]"));
            phoneElement.clear();
            phoneElement.sendKeys(phoneNumber);
        }

        // Method to enter email
        public static void enterEmail(String email) {
            WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            emailElement.clear();
            emailElement.sendKeys(email);
        }

        // Method to click the continue button
        public static void clickContinue() {
            WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"NewRootRoot\"]/div/div[1]/button"));
            continueBtn.click();
        }
        // Method to verify if form submission was successful
        public static boolean isFormSubmittedSuccessfully() {
            WebElement successMsg = driver.findElement(By.linkText("https://www.nobroker.in/myBookings/legal-services"));
            return successMsg.isDisplayed();
        }
        public void clickOnProceed() {
        	JavascriptExecutor js = (JavascriptExecutor) driver;
		             WebElement startPostingButton = driver.findElement(By.xpath("//*[@id=\\\"content-wrapper\\\"]/div[2]/div/div[4]/button[2]"));		             
		             // Scroll into view
		             js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\\\"content-wrapper\\\"]/div[2]/div/div[4]/button[2]")));
		             startPostingButton.click();
        }
        public void enterNumber() {
            WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id=\"signUp-phoneNumber\"]"));
            phoneNumberField.sendKeys("");  
        }
        private static By citySearchInput = By.name("city-search");

        // Method to enter a city name in the search input
        public static void enterCity(String cityName) {
            WebElement searchInput = driver.findElement(citySearchInput);
            searchInput.sendKeys(cityName);
        }

        // Method to click on a specific city suggestion
        public static void clickOnCitySuggestion(String cityName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
            WebElement suggestion = driver.findElement(By.xpath("//*[@id=\"modalContent\"]/div/div/div[1]/div[4]/div"));
            suggestion.click();
        }
 }
	
