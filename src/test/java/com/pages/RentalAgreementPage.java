package com.pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class RentalAgreementPage {
 
    WebDriver driver;
 
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
	}
	
