package com.setup;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;


public class BaseSteps {

	protected WebDriver driver;
	
    public WebDriver setupBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        
        return driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    
    public void takeScreenShotOnError(Scenario scenario){
	    // Do something after after scenario
		if (scenario.isFailed()) {
		    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(screenshot, "image/png", "name");
		    System.out.println("jbdvkjsbvkjbskjbvksbevk................");
		}
    }
    
    
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    

//	public WebDriver setupBrowser(String browser) throws Exception {
//		if (browser.equalsIgnoreCase("ie")) {
//			return driver = new InternetExplorerDriver();
//		}
//
//		else if (browser.equalsIgnoreCase("chrome")) {
//			return driver = new ChromeDriver();
//		}
//
//		else {
//			throw new Exception("No browser specified");
//			System.out.println("Invalid browser specified");
//		}
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		return driver;
//
//	}

//	public void navigateToUrl(String Url) {
//		driver.navigate().to(Url);
//	}

}
