Feature: Search Rental Properties

  As a user
  I want to search for rental properties
  So that I can find a suitable home to rent

  @search_full_house
  Scenario: Search for a Full House in Whitefield
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Whitefield" in the locality search bar
    And I select "Full House" as the property type
    And I click on the "Search" button
    Then I should see a list of rental properties in Whitefield, Bangalore

  @search_flatmates
  Scenario: Search for Flatmates in Marathahalli
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Marathahalli" in the locality search bar
    And I select "Flatmates" as the property type
    And I click on the "Search" button
    Then I should see a list of properties for flatmates in Marathahalli, Bangalore

  @search_invalid_city
  Scenario: Search for properties in an unsupported city
    Given I am on the NoBroker property search page
    When I select "Chennai" as the city
    And I enter "Adyar" in the locality search bar
    And I select "Full House" as the property type
    And I click on the "Search" button
    Then I should see an error message saying "City not supported"
