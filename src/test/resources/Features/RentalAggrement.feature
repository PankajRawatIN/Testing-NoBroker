Feature: Rental Agreement Page Interaction
  
  As a user,
  I want to interact with the Rental Agreement section
  So that I can view details and other associated information.

  #Background: Given the user is on the Home page

  #Scenario: User clicks on Rental Agreement and views next day delivery option
    #Given the user is on the Home page
    #When the user clicks on the Rental Agreement
    #Then the user should see Rental Agreement icon displayed correctly
#
  #Scenario: User views Next Day Delivery option
    #Given the user is on the Home page
    #When the user clicks on the Rental Agreement
    #Then the Next Day Delivery icon should be displayed correctly
    #Then Multiple citites Option Should be visible
    #Then Click on chennai
#
  #Scenario: Click on the helpline link and verify redirection to about:blank page
    #Given the user is on the Home page
    #When the user clicks on the Rental Agreement
    #Then Multiple citites Option Should be visible
    #Then Click on Pune
    #Then the user clicks on the helpline link
    #Then the user should be redirected to the about:blank page
#
  #Scenario Outline: Click on My Bookings and navigate to Sign-Up page
    #Given the user is on the Home page
    #When the user clicks on the Rental Agreement
    #Then Multiple citites Option Should be visible
    #Then Click on Banglore
    #Then the user clicks on My Bookings
    #Then the user enters the phone number "<PhoneNumber>"
    #And the user enters the name "<Name>"
    #And the user enters the email "<Email>"
    #Then the user clicks on continue
   #
#
#Examples:
    #| PhoneNumber | Name        | Email                    |
    #| 6303172203  | Ayesha      | ayesha1009@example.com  |
   #
#
  #Scenario: Click on the helpline link and verify redirection to about:blank page
    #Given the user is on the Home page
    #When the user clicks on the Rental Agreement
    #Then Multiple citites Option Should be visible
    #Then click on Noida
    #Then clik on Proceed
    #And user enters the number
    
    Scenario: Search and select a city
    Given the user is on the Home page
    When the user clicks on the Rental Agreement
    Then Multiple citites Option Should be visible
    Then the user should enter "Agra"
    Then the user clicks on Agra option
 