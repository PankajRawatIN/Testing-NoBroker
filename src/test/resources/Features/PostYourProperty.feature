Feature: Validating post your property features

  As a property owner
  I want to validate the Post Your Property feature
  So that I can ensure the functionality is working as expected

 #Scenario1:
  Scenario: Click on the main menu and post your property
    Given I am on the homepage of NoBroker
    When I click on the Main Menu button
    Then I select the Post Your Property option from the menu
    #

#Scenario 2:
  Scenario: Entering property details and clicking on Start Posting Your Ad for Free
    Given I am on the Post Your Property page
    When I enter valid property details such as "Roopa", "ammukonuguru@gmail.com" and  "7013195537"
    And I click on the Start Posting Your Ad for Free button
    #
    
  #Scenario 3: Give one value as wrong and try to click on "Start Posting Your Ad for Free"
  #Scenario: Entering incorrect property details and trying to post the ad
    #Given I am on  Post Your Property Homepage
    #When I enter invalid "EmailId"
    #And I click on Start Posting Your Adds for Free button On Webpage
    #Then I should see an error message indicating the invalid field
    
#
  # Scenario 4: OTP should be entered properly and click on continue
  #Scenario: Entering OTP and clicking on continue
    #Given I have successfully submitted my property details
    #When I receive an OTP on my registered mobile number
    #And I enter the OTP correctly
    #And I click on the Continue button
    #Then I should be redirected to the next step of the property posting process
#
  # Scenario 5: Give OTP in wrong way and try to click on continue, it will give error statement
  #Scenario: Entering incorrect OTP and attempting to continue
    #Given I have successfully submitted my property details
    #When I receive an OTP on my registered mobile number
    #And I enter the OTP incorrectly
    #And I click on the Continue button
    #Then I should see an error message indicating the OTP is incorrect or expired
    
