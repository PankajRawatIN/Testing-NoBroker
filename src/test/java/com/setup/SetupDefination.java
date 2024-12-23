package com.setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupDefination {

    private static WebDriver driver;

    // Initialize WebDriver (singleton pattern)
    public static WebDriver initializeDriver() {
        if (driver == null) {
        	ChromeOptions options = new ChromeOptions();

            // Add the headless argument
            options.addArguments("--headless");

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the instance
        }
    }

    // Getter for the driver
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }
}