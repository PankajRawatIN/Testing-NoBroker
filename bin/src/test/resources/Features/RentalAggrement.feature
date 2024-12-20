Feature: Link Redirection
  
  As a user,
  I want to click on a link and be redirected to the correct page
  So that I can access the intended content.

  Scenario: User clicks on a link and lands on the correct page
    Given the user is on the Home page
    When the user clicks on the Rental Aggrement link
    Then the user should be redirected to the Rental Aggrement page
    Then close the browser
