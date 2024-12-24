package com.setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupDefination {

    private static WebDriver driver;

    // Initialize WebDriver (singleton pattern)
    public static WebDriver initializeDriver() {
    	ChromeOptions options = new ChromeOptions();

        // Add the headless argument
    	options.addArguments("--headless=new"); // Use "--headless=new" for Chrome 109+
        options.addArguments("--disable-gpu"); // Necessary for Windows
        options.addArguments("--no-sandbox");  // Required for some environments
        options.addArguments("--disable-dev-shm-usage"); // Handle low-memory issues
        options.addArguments("--window-size=1920,1080"); // Ensure proper viewport size
        
        if (driver == null) {
        
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
