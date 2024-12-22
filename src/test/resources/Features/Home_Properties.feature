Feature: Features on Home Page
  
  As a user
  I want to filter properties by availability and type
  So that I can narrow down my search results
#=====================================================
   #@filter_immediate_availability
  #Scenario: Filter properties with immediate availability in HSR Layout
    #Given I am on the NoBroker property search page
    #When I select "Bangalore" as the city
    #And I enter "HSR Layout, Bengaluru, Karnataka, India" in the locality search bar
    #And I select "Full House" as the property type
    #And I select "Immediate" under Availability
    #And I click on the "Search" button
    #Then I should see a list of properties in HSR Layout with immediate availability
    #Then close the browserr
#=========================================================================================
  #@filter_by_bhk
  #Scenario: Filter properties by BHK type in Indiranagar
    #Given I am on the NoBroker property search page
    #When I select "Bangalore" as the city
    #And I enter "Indiranagar" in the locality search bar
    #And I select "2 BHK" as the BHK type
    #And I click on the "Search" button
    #Then I should see a list of "2 BHK" properties in Indiranagar, Bangalore
     #Then close the browserr
  #
    #====================================================
    #
    #Scenario Outline: User Should be able to Visit property advertisement page With Invalid Cred
    #Given I visit the property advertisement page
    #When I click the "Post Free Property Ad" button
    #Then I should be directed to the property listing form
    #Then I should Click on The cross Button
    #When the user enters "<Name>" in the name field
    #And the user enters "<Email>" in the email field
    #And the user selects "<City>" from the city dropdown
    #And The user enters a Number
    #Then the form submission should "<ExpectedOutcome>"
#
    #Examples:
      #| Name           | Email                    | City            | ExpectedOutcome    |
      #|                | pankaj.rawgmail.com   | Pune            | be rejected        |
    #
      #Scenario Outline: User Should be able to Visit property advertisement page with Valid Cred
    #Given I visit the property advertisement page
    #When I click the "Post Free Property Ad" button
    #Then I should be directed to the property listing form
    #When the user enters "<Name>" in the name field
    #And the user enters "<Email>" in the email field
    #And the user selects "<City>" from the city dropdown
    #And The user enters a Number
    #Then the form submission should "<ExpectedOutcome>"
#
    #Examples:
      #| Name           | Email                    | City            | ExpectedOutcome    |
      #| Ramlal         |                          |Pune         | be rejected     |
      #| Pankaj Rawat   | pankaj.rawat@gmail.com   | Pune       | be accepted        |
    #
    #
    
  #==================

 

 # As a tester,
 # I want to verify multiple features of the NoBroker website in a single scenario
 # So that I can ensure its usability and functionality.

  Scenario: Comprehensive validation of the NoBroker homepage
    Given I am on the NoBroker property search pagee
    Then the page URL should contain "https://www.nobroker.in/"
    And the "Avoid Brokers" section should be displayed
    And the "Free Listing" section should be displayed

    When the user clicks on the "Avoid Brokers" link
    Then the URL should navigate to "/about/tenants"
    And the page content should include "Avoid Brokers"
    And the response status code should be 200

    When the user clicks on the "Free Listing" link
    Then the URL should navigate to "/list-your-property-for-rent-sale"
    And the page content should include "Free Listing"
    And the response status code should be 200

    Then the "Avoid Brokers" image should be visible
    And the "Free Listing" image should be visible

    When the user resizes the browser window to mobile size
    Then the "Avoid Brokers" section should remain visible
    And the "Free Listing" section should remain visible

    Then the "Avoid Brokers" link should have target="_self"
    And the "Free Listing" link should have target="_self"
 
 