package com.setup;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
	
	
	  WebDriver driver;

	    @Before
	    public void setUp() {
	        driver = SetupDefination.initializeDriver();
	    }

	    @After
	    public void tearDown() {
	        SetupDefination.quitDriver();
	    }

}
