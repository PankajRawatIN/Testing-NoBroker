Feature: Sort Properties by Price or Distance

  As a user
  I want to sort properties by price or distance
  So that I can find the most relevant options quickly

  @sort_by_price_low_to_high
  Scenario: Sort properties by lowest price
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Whitefield" in the locality search bar
    And I click on the "Search" button
    And I sort the properties by "Price: Low to High"
    Then I should see the properties sorted by ascending price

  @sort_by_distance
  Scenario: Sort properties by nearest distance
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "HSR Layout" in the locality search bar
    And I click on the "Search" button
    And I sort the properties by "Nearest First"
    Then I should see the properties sorted by proximity

  @sort_invalid_criteria
  Scenario: Sort properties by an invalid criteria
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Koramangala" in the locality search bar
    And I click on the "Search" button
    And I attempt to sort the properties by "Size: Smallest First"
    Then I should see an error message saying "Invalid sorting criteria"
