Feature: Online Rent Receipt Generator
  As a user, 
  I want to generate rent receipts easily by providing necessary details, 
  so that I can download or preview them.
 

	Background:  
	
  	Given I navigate to the Online Rent Receipt Generator page using "chrome" browser

	Scenario: Generate rent receipt successfully with valid data
	
	  When I enter "Mahesh Sharma" as the tenant name
	  And I enter "Pankaj Shukla" as the owner name
	  And I enter "15000" as the rent amount
	  And I enter "123 Main Street" as the rental property address
	  And I enter "545 Main Street" as the owner address
	  And I select start date as the start date and end date as the end date
	  And I enter "abc123@gmail.com" as the email address
	  Then I click on the "Generate Rent Receipt Now" button  
	  And the option to download the receipt as a PDF should be available
	  
	  
	  
	Scenario: Error for missing tenant name
	
#		Given I navigated to the Online Rent Receipt Generator page using "chrome" browser
	  When I leave the tenant name field empty
	  And I entered "Jane Smith" as the owner name
    And I entered "15000" as the rent amount
    And I entered "123 Main Street" as the rental property address
	  And I entered "545 Main Street" as the owner address
	  And I selected start date as the start date and end date as the end date
	  And I entered "abc123@gmail.com" as the email address
	  And I clicked on the "Generate Rent Receipt Now" button
	  Then I should see an error message saying "This is required field"
	
	 
#	Scenario: Error for invalid rent amount
#	
#	  When I enter "John Doe" as the tenant name
#	  And I enter "Jane Smith" as the landlord name
#	  And I enter "-5000" as the rent amount
#	  And I select "January 2024" as the start month and "December 2024" as the end month
#	  And I click on the "Generate Receipt" button
#	  Then I should see an error message saying "Rent amount must be a positive number"
#	
#	 
#	Scenario: Generate receipt with all optional fields filled
#	
#	  When I enter "John Doe" as the tenant name
#	  And I enter "Jane Smith" as the landlord name
#	  And I enter "15000" as the rent amount
#	  And I enter "ABCDE1234F" as the landlord PAN
#	  And I enter "123 Main Street" as the rental property address
#	  And I select "January 2024" as the start month and "December 2024" as the end month
#	  And I click on the "Generate Receipt" button
#	  Then the receipt preview should include the property address and landlord PAN
#	
#	 
#	Scenario: Error for invalid email format
#	
#	  When I enter "John Doe" as the tenant name
#	  And I enter "Jane Smith" as the landlord name
#	  And I enter "15000" as the rent amount
#	  And I enter "invalidemail" as the email address
#	  And I click on the "Generate Receipt" button
#	  Then I should see an error message saying "Please enter a valid email address"

 