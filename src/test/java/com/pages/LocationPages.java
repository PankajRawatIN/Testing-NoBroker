package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPages {
    WebDriver driver;

    // Locators
    private By cityNameLocator = By.id("cityName"); // Replace with actual locator
    private By elementToClick; // Define this dynamically when needed

    // Constructor
    public LocationPages(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    // Navigate to Rental Agreement page
    public void navigateToRentalAgreementPage(String url) {
        driver.get(url);
    }

    // Get the displayed city name
    public String getCityName() {
        WebElement cityNameElement = driver.findElement(cityNameLocator);
        return cityNameElement.getText();
    }

    // Click on an element based on a locator (pass the locator dynamically)
    public void clickOnElement(String cssLocator) {
        elementToClick = By.cssSelector(cssLocator); // Assuming it's a CSS Selector
        WebElement element = driver.findElement(elementToClick);
        element.click();
    }
}
