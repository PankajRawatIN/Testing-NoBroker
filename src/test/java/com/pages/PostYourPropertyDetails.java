package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostYourPropertyDetails {
    WebDriver driver;
    WebDriverWait wait;

//    Scenario 2:---------------------------------------------------------------------------------------------------------------------
    
    // Locators
    private By nameField = By.xpath("//input[@id='userName']");
    private By emailField = By.xpath("//input[@id='userEmail']");
    private By mobileField = By.xpath("//input[@id='userPhone']");
    private By cityDropdown = By.xpath("//div[@class='css-1hwfws3 nb-select__value-container']/div[@class='css-151xaom-placeholder nb-select__placeholder']");
    private By selectCity = By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[2]/div/div[1]");
    private By startPostingButton = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[4]/button[1]");

    // Constructor
    public PostYourPropertyDetails(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Methods
    public void openPostYourPropertyPage() {
        driver.get("https://www.nobroker.in/list-your-property-for-rent-sale?nbFr=Home_page");
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void selectCity() throws InterruptedException {
        driver.findElement(cityDropdown).click();
        Thread.sleep(2000); // Replace with WebDriverWait for stability
        driver.findElement(selectCity).click();
    }

    public void clickStartPostingButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(startPostingButton));
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", button);

        Thread.sleep(2000); // Optional, to visually verify the scroll
        button.click();
    }
    

}
