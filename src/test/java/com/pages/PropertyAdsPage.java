package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyAdsPage {
    WebDriver driver;

    public PropertyAdsPage(WebDriver driver) {
     
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void visitPropertyAdvertisementPage() {
        driver.get("https://www.nobroker.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement num = driver.findElement(By.id("userPhone"));
        num.clear();
        num.sendKeys(phoneNumber);
    }

    public void verifyFormPage() {
        driver.get("https://www.nobroker.in/list-your-property-for-rent-sale");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@id='pypAd']/button")).click();
    }

    public void verifyRedirection() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("your-property-for-rent-sale")) {
            throw new AssertionError("Redirection failed");
        }
    }

    public void clickCrossButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement iframeElement = driver.findElement(By.id("webWidget"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='Embed']/div/div/div/div/div/div/header/div/button[2]")).click();
        driver.switchTo().defaultContent();
    }

    public void enterName(String name) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement inp = driver.findElement(By.id("userName"));
        inp.clear();
        inp.sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement inp = driver.findElement(By.id("userEmail"));
        inp.clear();
        inp.sendKeys(email);
    }

    public void selectCity(String city) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cityDropdown = driver.findElement(By.xpath("//*[@id='citySelectContainer']/div[1]/div[1]/div"));
        cityDropdown.click();
        WebElement cityOption = driver.findElement(By.id("react-select-5-option-1"));
        cityOption.click();
    }

    public void submitForm() {
        // Set an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Use JavaScript to scroll the element into view and click it
        WebElement sub = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div[4]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", sub);

        // Wait until the element is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sub));

        // Click the element
        sub.click();
    }


    public boolean isErrorDisplayed() {
        By errorLocator1 = By.xpath("//*[@id='app']/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/span");
        By errorLocator2 = By.xpath("//*[@id='app']/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/span");

        // Check if either of the elements is visible
        boolean isError1Visible = !driver.findElements(errorLocator1).isEmpty() && driver.findElements(errorLocator1).get(0).isDisplayed();
        boolean isError2Visible = !driver.findElements(errorLocator2).isEmpty() && driver.findElements(errorLocator2).get(0).isDisplayed();

        // Return false if any of the elements is visible, otherwise return true
        return !(isError1Visible || isError2Visible);
    }
}