Feature: blog Page Navigation and validation on NoBroker Website

  #Scenario 1
  #Scenario: Navigate to blog Page and Verify Navigation
  #Given I open the NoBroker homepage
  #When I click on the "Menu" button
  #And I select Blogs from the dropdown
  #Then I should be navigated to the Blog Page
  
  #Scenario 2
  #Scenario: Check the functionality of 'Subscribe to our blogs' button
  #Given I am on the blog page
  #When I click on the Subscribe to our blogs button
  #Then I got the popup for subscribe
  #And When I enter the Valid E-MAIL id
  #And When I select atleast 3 values from the given values
  #And When I click on the subscribe now button
  #Then I got the COnfirmation Msg
  
  #Scenario 3(Negative Scenario)
  Scenario: Check the functionality of 'Subscribe to our blogs' button
  Given I am on the blog page
  When I click on the Subscribe to our blogs button
  Then I got the popup for subs+cribe
  And When I enter the Valid E-MAIL id
  And When I select less options from the given options
  And When I click on the subscribe now button
  Then I will get a alert Msg.
  
  #Scenario 4
  #Scenario: Verify functionality of Forward and Backward Buttons on the blog Page
    #Given I am on the blog page
    #When I click on the Forward button on blog page
    #Then I should see the next image displayed on blogpage
    #When I click on the Backward button on blog page
    #Then I should see the previous image displayed on blogpage
