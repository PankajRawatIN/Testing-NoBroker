
	package com.stepDefination;



	import org.openqa.selenium.WebDriver;

import com.setup.SetupDefination;

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






