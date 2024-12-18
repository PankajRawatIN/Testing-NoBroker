Feature: Search PG and Hostel Properties

  As a user
  I want to search for PG accommodations
  So that I can find suitable housing for short stays

  @search_pg_koramangala
  Scenario: Search for PG in Koramangala
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Koramangala" in the locality search bar
    And I select "PG/Hostel" as the property type
    And I click on the "Search" button
    Then I should see a list of PGs in Koramangala, Bangalore

  @search_pg_indiranagar
  Scenario: Search for PG in Indiranagar
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Indiranagar" in the locality search bar
    And I select "PG/Hostel" as the property type
    And I click on the "Search" button
    Then I should see a list of PGs in Indiranagar, Bangalore

  @search_invalid_property_type
  Scenario: Search with an invalid property type
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Koramangala" in the locality search bar
    And I select "Villa" as the property type
    And I click on the "Search" button
    Then I should see an error message saying "Invalid property type"
