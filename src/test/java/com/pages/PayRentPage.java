package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PayRentPage {
    
    WebDriver driver;
    WebDriverWait wait;
    
    // Constructor to initialize driver and wait
    public PayRentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    //Scenario 4-------------------------------------------------------------------------------------------------
    
    // Method to click the "Pay Rent" button
    public void clickPayRentButton() {
        WebElement payRentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-header-text-color' and text()='Pay Rent']")));
        payRentButton.click();
    }
    
    // Method to verify the current URL after redirection
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    //-----------------------------------------------------------------------------------------------------------------
    //Scenario5--------------------------------------------------------------------------------------------------------
    
 // Method to select payment type
    public void selectPaymentType() {
        WebElement payMentTypeField = driver.findElement(By.xpath("//span[@class='text-14' and text()='House Rent']"));
        payMentTypeField.click();

        WebElement selectField = driver.findElement(By.xpath("//span[@class='text-14' and text()='House Rent']"));
        selectField.click();
    }

    // Method to enter tenant details
    public void enterTenantDetails(String name, String mobile, String email) throws InterruptedException {
        WebElement nameField = driver.findElement(By.xpath("//input[@id='tenant_name']"));
        nameField.clear();
        nameField.sendKeys(name);

        WebElement mobileField = driver.findElement(By.xpath("//input[@id='tenant_phone']"));
        mobileField.clear();
        mobileField.sendKeys(mobile);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='tenant_email']"));
        emailField.clear();
        emailField.sendKeys(email);
        emailField.sendKeys(Keys.TAB);
    }

    // Method to scroll to the "Start Posting" button and click it
    public void clickStartPostingButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement startPostingButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='nb__3jJt4']")));
        
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", startPostingButton);
        Thread.sleep(5000);
        startPostingButton.click();
    }

    // Method to click the checkbox
    public void clickCheckbox() {
        WebElement checkBoxField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"rentoPayGettingStart\"]/div[5]/div[1]/div/label/input")));
        checkBoxField.click();
    }

    // Method to click the "Get Started" button
    public void clickGetStartedButton() {
        WebElement getStartedButton = driver.findElement(By.xpath("//*[@id='rentoPayGettingStart']/div[5]/div[2]/button"));
        getStartedButton.click();
    }
}
