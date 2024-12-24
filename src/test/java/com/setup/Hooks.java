package com.setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
	
	
	  WebDriver driver;

	    @Before
	    public void setUp() {
	        driver = SetupDefination.initializeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        System.out.println("Welcome to new scenerio");
	    }
	    
	 

//	    @After
//	    public void tearDown() {
//	    
//	     SetupDefination.quitDriver(); 	
//	    
//
//	    }
}
