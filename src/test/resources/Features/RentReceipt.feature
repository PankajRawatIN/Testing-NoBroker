Feature: Online Rent Receipt Generator
  As a user, 
  I want to generate rent receipts easily by providing necessary details, 
  so that I can download or preview them.
 

	Background:  
	
  	Given I navigate to the Online Rent Receipt Generator page using "chrome" browser

#	Scenario: Generate rent receipt successfully with valid data
#
#	  When I enter "Mahesh Sharma" as the tenant name
#	  And I enter "Pankaj Shukla" as the owner name
#	  And I enter "15000" as the rent amount
#	  And I enter "123 Main Street" as the rental property address
#	  And I enter "545 Main Street" as the owner address
#	  And I select start date as the start date and end date as the end date
#	  And I enter "abc123@gmail.com" as the email address
#	  Then I click on the "Generate Rent Receipt Now" button  
#	  And the option to download the receipt as a PDF should be available

#Scenario: Generate rent receipts for all rows in Excel
#	When I fetch all data from sheet "Sheet1"


# EXECEL====================================

Scenario Outline: Generate rent receipt successfully with valid data from Excel
  When I fetch data from sheet "<SheetName>" row "<RowNumber>"
  And I select start date as the start date and end date as the end date
  And I fetch email from sheet "<SheetName>" row "<RowNumber>"
  Then I click on the "<ButtonText>" button
  And the option to download the receipt as a PDF should be available

Examples:
  | Browser   | SheetName | RowNumber | ButtonText                 |
  | chrome    | Sheet1    | 0         | Generate Rent Receipt Now  |




#	Scenario Outline: Generate rent receipt successfully with valid data
  #When I enter "<Tenant Name>" as the tenant name
  #And I enter "<Owner Name>" as the owner name
  #And I enter "<Rent Amount>" as the rent amount
  #And I enter "<Rental Property Address>" as the rental property address
  #And I enter "<Owner Address>" as the owner address
  #And I select start date as the start date and end date as the end date
  #And I enter "<Email Address>" as the email address
  #Then I click on the "<Button Text>" button
  #And the option to download the receipt as a PDF should be available
#
#Examples:
  #| Tenant Name     | Owner Name     | Rent Amount | Rental Property Address | Owner Address     | Email Address      | Button Text                     |
  #| Mahesh Sharma   | Pankaj Shukla  | 15000       | 123 Main Street         | 545 Main Street   | abc123@gmail.com   | Generate Rent Receipt Now       |
  #| Ramesh Verma    | Suresh Yadav   | 20000       | 789 Oak Avenue          | 123 Pine Street   | xyz987@gmail.com   | Generate Rent Receipt Now       |
  #| Asha Mehta      | Rahul Sharma   | 18000       | 456 Elm Street          | 321 Maple Street  | test123@gmail.com  | Generate Rent Receipt Now       |
#
#	  
#	  
	Scenario: Error for missing tenant name
	
	  When I leave the tenant name field empty
	  And I entered "Jane Smith" as the owner name
    And I entered "15000" as the rent amount
    And I entered "123 Main Street" as the rental property address
	  And I entered "545 Main Street" as the owner address
	  And I selected start date as the start date and end date as the end date
	  And I entered "abc123@gmail.com" as the email address
	  And I clicked on the "Generate Rent Receipt Now" button
	  Then I should see an error message saying "This is required field"
#		
#	 
	Scenario: Verifiy the explore now content
	
	  When I get to Explore Now page
	  And I verify the title of explore now
	  And I verify the explore button
	  Then I verify it successfully navigated to another page
#	  
#	
	Scenario: Check the valid phone number
	
	  When I fill "Mahesh Sharma" as the tenant name
	  And I fill "Jane Smith" as the owner name
    And I fill "1234567890" as the tenant phone no
    And I fill "1234567890" as the owner phone no
    And I fill "15000" as the rent amount
    And I fill "123 Main Street" as the rental property address
	  And I fill "545 Main Street" as the owner address
	  And I fill start date as the start date and end date as the end date
	  And I fill "abc123@gmail.com" as the email address
	  Then I verify the phone numbers filled in fields
#
#
#
  Scenario: Check the Frequently Asked Questions page
		
		When I move to FAQS slide
		And I click on the FAQ point 
		Then I check content of FAQ is display
		And I verify the content of FAQ is correct
		
		
		
		
		
		
		
		
	
  #---------------------------------------------------------------------------------------------------------
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

 