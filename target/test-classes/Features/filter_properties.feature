Feature: Filter Properties by Availability and BHK Type
  
  As a user
  I want to filter properties by availability and type
  So that I can narrow down my search results

  @filter_immediate_availability
  Scenario: Filter properties with immediate availability in HSR Layout
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "HSR Layout, Bengaluru, Karnataka, India" in the locality search bar
    And I select "Full House" as the property type
    And I select "Immediate" under Availability
    And I click on the "Search" button
    Then I should see a list of properties in HSR Layout with immediate availability

  @filter_by_bhk
  Scenario: Filter properties by BHK type in Indiranagar
    Given I am on the NoBroker property search page
    When I select "Bangalore" as the city
    And I enter "Indiranagar" in the locality search bar
    And I select "2 BHK" as the BHK type
    And I click on the "Search" button
    Then I should see a list of "2 BHK" properties in Indiranagar, Bangalore

  #@filter_invalid_bhk_type
  #Scenario: Filter properties with an invalid BHK type
    #Given I am on the NoBroker property search page
    #When I select "Bangalore" as the city
    #And I enter "Whitefield" in the locality search bar
    #And I select "6 BHK" as the BHK type
    #And I click on the "Search" button
    #Then I should see an error message saying "Invalid BHK type"
