package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyNoBrokerPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By avoidBrokersSection = By.xpath("//*[@id='app']/div/div/div[6]/div[2]/div[1]/a/img");
    private By shortlistWithoutVisitSection = By.xpath("//*[@id='app']/div/div/div[6]/div[2]/div[3]/a/img");

    public VerifyNoBrokerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to NoBroker Home Page
//    public void navigateToHomePage() {
//        driver.get("https://www.nobroker.in/");
//    }

    // Verify Page URL
    public boolean isURLContains(String expectedFragment) {
        return driver.getCurrentUrl().contains(expectedFragment);
    }

    // Verify Section Displayed
    public boolean isSectionDisplayed(String sectionName) throws InterruptedException {
        By sectionLocator = getSectionLocator(sectionName);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(sectionLocator));

        // Scroll into view
        scrollToElement(element);

        return element.isDisplayed();
    }

    // Click on Link
    public void clickLink(String linkName) {
        By linkLocator = getLinkLocator(linkName);
        WebElement link = driver.findElement(linkLocator);
        link.click();
    }

    // Verify Image Visibility
    public boolean isImageVisible(String imageName) {
        By imageLocator = getImageLocator(imageName);
        WebElement image = driver.findElement(imageLocator);
        return image.isDisplayed();
    }

    // Verify Page Content
    public boolean isContentPresent(String expectedContent) {
        return driver.getPageSource().contains(expectedContent);
    }

    // Resize Browser to Mobile Size
    public void resizeToMobileSize() {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812)); // iPhone X size
    }

    // Scroll to Element
    private void scrollToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Thread.sleep(500); // Optional delay for animation
    }

    // Utility Methods for Locators
    private By getSectionLocator(String sectionName) {
        switch (sectionName) {
            case "Avoid Brokers":
                return avoidBrokersSection;
            case "Shortlist without Visit":
                return shortlistWithoutVisitSection;
            default:
                throw new IllegalArgumentException("Unknown section: " + sectionName);
        }
    }

    private By getLinkLocator(String linkName) {
        switch (linkName) {
            case "Avoid Brokers":
                return avoidBrokersSection;
            case "Shortlist without Visit":
                return shortlistWithoutVisitSection;
            default:
                throw new IllegalArgumentException("Unknown link: " + linkName);
        }
    }

    private By getImageLocator(String imageName) {
        switch (imageName) {
            case "Avoid Brokers":
                return avoidBrokersSection;
            case "Shortlist without Visit":
                return shortlistWithoutVisitSection;
            default:
                throw new IllegalArgumentException("Unknown image: " + imageName);
        }
    }
    public void navigateToHomePage() {
        // Assuming the home page URL is constant
        String homePageURL = "https://www.nobroker.in/";
        driver.get(homePageURL);

        // Optional: Verify that the navigation was successful by checking the current URL
        if (!driver.getCurrentUrl().equals(homePageURL)) {
            throw new AssertionError("Failed to navigate to the NoBroker Home Page.");
        }
    }
}
