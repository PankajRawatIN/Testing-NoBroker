Feature: Rental Agreement Page Interaction

  As a user,
  I want to interact with the Rental Agreement section
  So that I can view details and other associated information.

  Scenario: User clicks on Rental Agreement and views next day delivery option
    Given the user is on the Home page
    When the user clicks on the Rental Agreement
    Then the user should see Rental Agreement and Next Day Delivery icons displayed correctly

  Scenario: User views Next Day Delivery option
    Given the user is on the Home page
    When the user clicks on the Rental Agreement
    Then the Next Day Delivery icon should be displayed correctly

  Scenario: User verifies the text and icons in Rental Agreement section
    Given the user is on the Home page
    When the user clicks on the Rental Agreement
    Then the text "Rental Agreement | Next Day Delivery" should be visible
    Then the icons for Rental Agreement and Next Day Delivery should be displayed correctly

  Scenario: User navigates back to the Home page
    Given the user is on the Rental Agreement page
    When the user clicks on the Home icon
    Then the user should be redirected to the Home page
    Then close the browser
