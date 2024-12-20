Feature: Rental Agreement Page Interaction
 
  As a user,
  I want to interact with the Rental Agreement section
  So that I can view details and other associated information.
 
  #Background: Given the user is on the Home page
  
  Scenario: User clicks on Rental Agreement and views next day delivery option
  Given the user is on the Home page
  	When the user clicks on the Rental Agreement
    Then the user should see Rental Agreement icon displayed correctly
 
  Scenario: User views Next Day Delivery option
  Given the user is on the Home page
  	When the user clicks on the Rental Agreement
    Then the Next Day Delivery icon should be displayed correctly
    Then Multiple citites Option Should be visible
    Then Click on chennai
    
   
  Scenario: Click on My Bookings and navigate to Sign-Up page
    Given the user is on the Home page
    When the user clicks on the Rental Agreement
    Then Multiple citites Option Should be visible
    Then Click on Banglore
    Then the user clicks on My Bookings
    Then the user should be redirected to the Sign-Up page
 
  #Scenario: Enter details in the sign-up form and submit
    #Given the user is on the Sign-Up page
    #When the user enters the phone number "9876543210"
    #And the user enters the name "John Doe"
    #And the user enters the email "johndoe@example.com"
    #Then Click on continue
    #Then the form should be submitted successfully
    #
    
 Scenario: Click on the helpline link and verify redirection to about:blank page
  Given the user is on the Home page
  When the user clicks on the Rental Agreement
  Then Multiple citites Option Should be visible
  Then Click on Pune
  Then the user clicks on the helpline link
  Then the user should be redirected to the about:blank page

   

 
  
    
   
    