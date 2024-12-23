Feature: Features on Home Page
  
  * As a user, 
  * I want to explore and validate various functionalities of the NoBroker website, 
  * including property search filters, advertisement features, and homepage validations, 
  * so that I can ensure the website is user-friendly and performs as expected.

  #=========================================================================================
  Scenario: Filter properties with immediate availability in HSR Layout
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "HSR Layout, Bengaluru, Karnataka, India" in the locality search bar
    And I select "Full House" as the property type
    And I select "Immediate" under Availability
    And I click on the "Search" button
    Then I should see a list of properties in HSR Layout with immediate availability

  #=========================================================================================
  Scenario: Filter properties by BHK type in Indiranagar
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Indiranagar" in the locality search bar
    And I select "2 BHK" as the BHK type
    And I click on the "Search" button
    Then I should see a list of "2 BHK" properties in Indiranagar, Bangalore

  #=========================================================================================
  Scenario Outline: User Should be able to Visit property advertisement page With Invalid Cred
    Given I visit the property advertisement page
    When I click the "Post Free Property Ad" button
    Then I should be directed to the property listing form
    Then I should Click on The cross Button
    When the user enters "<Name>" in the name field
    And the user enters "<Email>" in the email field
    And the user selects "<City>" from the city dropdown
    And The user enters a Number
    Then the form submission should "<ExpectedOutcome>"

    Examples: 
      | Name | Email               | City | ExpectedOutcome |
      |      | pankaj.rawgmail.com | Pune | be rejected     |

  #=========================================================================================
  Scenario Outline: User Should be able to Visit property advertisement page with Valid Cred
    Given I visit the property advertisement page
    When I click the "Post Free Property Ad" button
    Then I should be directed to the property listing form
    When the user enters "<Name>" in the name field
    And the user enters "<Email>" in the email field
    And the user selects "<City>" from the city dropdown
    And The user enters a Number
    Then the form submission should "<ExpectedOutcome>"

    Examples: 
      | Name         | Email                  | City | ExpectedOutcome |
      | Ramlal       |                        | Pune | be rejected     |
      | Pankaj Rawat | pankaj.rawat@gmail.com | Pune | be accepted     |

  #=========================================================================================
  Scenario: Comprehensive validation of the NoBroker homepage
    Given I am on the NoBroker property search pagee
    Then the page URL should contain "https://www.nobroker.in/"
    And the "Avoid Brokers" section should be displayed
    And the "Avoid Brokers" image should be visible
    When the user clicks on the "Avoid Brokers" link
    Then the URL should navigate to "/about/tenants"
    And the page content should include "We make sure that each property is verified and directly from owner"
    And the URL should navigate to Home Page
    And the "Shortlist without Visit" section should be displayed
    And the "Shortlist without Visit" image should be visible
    When the user clicks on the "Shortlist without Visit" link
    Then the URL should navigate to "/about/tenants"
    And the page content should include "without any broker acting as a middleman"
    And the URL should navigate to Home Page
