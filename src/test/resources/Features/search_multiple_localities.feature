Feature: Search Properties in Multiple Localities

  As a user
  I want to search for properties in multiple localities
  So that I can compare options across areas

  @multiple_localities_indiranagar_marathahalli
  Scenario: Search for properties in Indiranagar and Marathahalli
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Indiranagar, Marathahalli" in the locality search bar
    And I select "Full House" as the property type
    And I click on the "Search" button
    Then I should see a list of properties in Indiranagar and Marathahalli, Bangalore

  @multiple_localities_whitefield_hsr
  Scenario: Search for properties in Whitefield and HSR Layout
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Whitefield, HSR Layout" in the locality search bar
    And I select "Flatmates" as the property type
    And I click on the "Search" button
    Then I should see a list of properties in Whitefield and HSR Layout, Bangalore

  @invalid_multiple_localities
  Scenario: Search for properties in more than 3 localities
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Indiranagar, Marathahalli, HSR Layout, Koramangala" in the locality search bar
    And I select "Full House" as the property type
    And I click on the "Search" button
    Then I should see an error message saying "You can search for up to 3 localities only"
