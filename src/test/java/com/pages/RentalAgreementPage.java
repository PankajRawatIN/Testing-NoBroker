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
    private By deliveryIcon = By.cssSelector(".w-2.8p.relative.bottom-0.2p.h-2.8p");

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
}
