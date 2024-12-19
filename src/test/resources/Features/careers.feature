Feature: Career Page Navigation and validation on NoBroker Website


  Scenario: Navigate to Career Page and Verify Navigation
    Given I open the NoBroker homepage
    When I click on the "Menu" button
    And I select "Career" from the dropdown
    Then I should be navigated to the Career Page
    And I should see the "Careers at NoBroker" text on the Career Page
  #
    #Background:
     #Given I am on the Careerpage
#
    Scenario: Click on the JobsListing and Verify
    Given I am on the Careerpage
    When I click on the 'JobListing' Button
    Then I should be navigated to the LinkedInpage
    
    Scenario: Click on the see all opertunities and veriyfy
    Given I am on the Careerpage
    When I click on the 'See all opertunities' Button 
    Then I should be navigated to linkedin page
    
   
    
   #Scenario: login as a user in linkedin
    #Given I am on the linkedinpage
    #When I click on the 'Sign in' Button
    #Then I should be navigated to the LinkedLoginPage