Feature: Career Page Navigation and validation on NoBroker Website

  #Scenario 1
  Scenario: Navigate to Career Page and Verify Navigation
    Given I open the NoBroker homepage
    When I click on the "Menu" button
    And I select "Career" from the dropdown
    Then I should be navigated to the Career Page
    And I should see the "Careers at NoBroker" text on the Career Page

  #Scenario 2
  #Scenario: Click on the JobsListing and Verify
    #Given I am on the Careerpage
    #When I click on the 'JobListing' Button
    #Then I should be navigated to the LinkedInpage

  #Scenario 3
  #Scenario: Click on the see all opertunities and veriyfy
    #Given I am on the Careerpage
    #When I click on the See all opertunities Button
    #Then I should be navigated to linkedin page

  #Scenario 4
  #Scenario: Verify functionality of Forward and Backward Buttons on the Career Page
    #Given I am on the Careerpage
    #When I click on the Forward Button
    #Then I should see the next image displayed
    #And When I click on the Backward Button
    #Then I should see the previous image displayed

  # Scenario 5
  #Scenario: Verify navigation to NoBroker home page when clicking on the NOBROKER button
    #Given I am on the Careerpage
    #When I click on the 'NOBROKER' button in the navigation bar
    #Then I should be navigated to the home page of NoBroker
    #And the page URL should contain 'nobroker'
