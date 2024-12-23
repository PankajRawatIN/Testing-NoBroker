package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostYourPropInvalidCase {
    private WebDriver driver;
    private WebDriverWait wait;

    public PostYourPropInvalidCase(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openHomePage() {
        driver.get("https://www.nobroker.in/list-your-property-for-rent-sale?nbFr=Home_page");
    }

    public void enterInvalidDetails(String name, String email, String phoneNumber) throws InterruptedException {
        // Enter Name
        WebElement nameField = driver.findElement(By.xpath("//input[@id='userName']"));
        nameField.clear();
        nameField.sendKeys(name);

        // Enter Email
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

        // Enter Phone Number
        WebElement phoneField = driver.findElement(By.xpath("//input[@id='userPhone']"));
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);

        // Select City
        WebElement cityDropdown = driver.findElement(By.xpath("//div[@class='css-1hwfws3 nb-select__value-container']/div[@class='css-151xaom-placeholder nb-select__placeholder']"));
        cityDropdown.click();

        WebElement cityOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[2]/div/div[1]"));
        cityOption.click();

        Thread.sleep(5000);
    }

    public void clickStartPostingButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement startPostingButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[4]/button[1]")));

        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", startPostingButton);
        Thread.sleep(5000);

        startPostingButton.click();
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='" + expectedMessage + "']"));
        return errorMessage.isDisplayed() && errorMessage.getText().equals(expectedMessage);
    }
}
