package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PostYourPropertyhomePage {
    WebDriver driver;

//    Scenario 1:---------------------------------------------------------------------------------------------------------------
    
    // Locators
    private By mainMenuButton = By.xpath("//div[img[@alt='hamburger'] and text()='Menu']");
    private By postYourPropertyOption = By.xpath("//a[text()='Post Your Property']");

    // Constructor
    public PostYourPropertyhomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openHomePage() {
        driver.get("https://www.nobroker.in");
        driver.manage().window().maximize();
    }

    public void clickMainMenuButton() {
        driver.findElement(mainMenuButton).click();
    }

    public void selectPostYourPropertyOption() {
        driver.findElement(postYourPropertyOption).click();
    }
    


}
