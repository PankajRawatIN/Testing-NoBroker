//package com.stepdefinition;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//import com.pages.RentReceiptPageFactory;
//import com.parameters.ExcelReader;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class RentReceiptStepsOriginal {
//
//    BaseSteps setup = new BaseSteps();
//    WebDriver driver;
//    RentReceiptPageFactory rentReceiptPage;
//    ExcelReader excelReader;
//    
//    String mainPageURL, navigatedPageURL;
//
//    @Given("I navigate to the Online Rent Receipt Generator page using {string} browser")
//    public void iNavigateToRentReceiptGeneratorPage(String browser) throws Exception {
//        driver = setup.setupBrowser(browser);
//        setup.navigateToUrl("https://www.nobroker.in/");
//        driver.manage().window().maximize();
//        
//        
//        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[1]")).click();
//        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[2]/a[6]")).click();
//        
//        rentReceiptPage = new RentReceiptPageFactory(driver);
//        excelReader = new ExcelReader();
//    }
//
//    @When("I enter {string} as the tenant name")
//    public void iEnterTenantName(String tenantName) {
//        rentReceiptPage.getTenantNameField().clear();
//        rentReceiptPage.getTenantNameField().sendKeys(tenantName);
//        
//    }
//
//    @And("I enter {string} as the owner name")
//    public void iEnterOwnerName(String ownerName) {
//        rentReceiptPage.getOwnerNameField().clear();
//        rentReceiptPage.getOwnerNameField().sendKeys(ownerName);
//    }
//
//    @And("I enter {string} as the rent amount")
//    public void iEnterRentAmount(String rentAmount) {
//        rentReceiptPage.getRentAmountField().clear();
//        rentReceiptPage.getRentAmountField().sendKeys(rentAmount);
//    }
//
//    @And("I enter {string} as the rental property address")
//    public void iEnterRentalAddress(String rentalAddress) {
//        rentReceiptPage.getRentalAddressField().clear();
//        rentReceiptPage.getRentalAddressField().sendKeys(rentalAddress);
//    }
//
//    @And("I enter {string} as the owner address")
//    public void iEnterOwnerAddress(String ownerAddress) {
//        rentReceiptPage.getOwnerAddressField().clear();
//        rentReceiptPage.getOwnerAddressField().sendKeys(ownerAddress);
//    }
//
//    @And("I select start date as the start date and end date as the end date")
//    public void iSelectStartAndEndMonth() throws InterruptedException {
//    	
//    	rentReceiptPage.getStartDateField().click();
////    	rentReceiptPage.getStartDateField();
//        rentReceiptPage.selectDate("rentrecipt-form-from_date-nbInput", 3, 3); // Example: 3rd row, 3rd column
//
//        // Pause for UI rendering
//        Thread.sleep(2000);
//
//        // Open the end date picker and select a date
//        rentReceiptPage.getEndDateField().click();
//        rentReceiptPage.selectDate("rentrecipt-form-to_date-nbInput", 4, 4); // Example: 4th row, 4th column
//
//        System.out.println("Start and End Dates have been selected successfully.");
//    	
//    	
//    	
////    	rentReceiptPage.getStartDateField().click();
////
////        // Wait for the calendar to be visible and select a specific date
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        
////        WebElement startDateToSelect = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//*[@id=\"rentrecipt-form-from_date-nbInput\"]/div/div[2]/div/div[2]/div[2]/div[3]/div[3]")));
////        startDateToSelect.click();
////
////        // Wait briefly before interacting with the end date field
////        Thread.sleep(3000);
////
////        // Locate the end date field and click to open the date picker
////        rentReceiptPage.getEndDateField().click();
////
////        // Wait for the calendar to be visible and select a specific date
////        WebElement endDateToSelect = wait.until(ExpectedConditions.elementToBeClickable(
////                By.xpath("//*[@id=\"rentrecipt-form-to_date-nbInput\"]/div/div[2]/div/div[2]/div[2]/div[3]/div[5]"))); 
////        endDateToSelect.click();
//        
//    }
//
//    @And("I enter {string} as the email address")
//    public void iEnterEmailAddress(String emailAddress) {
//        rentReceiptPage.getEmailField().clear();
//        rentReceiptPage.getEmailField().sendKeys(emailAddress);
//    }
//
//    @Then("I click on the {string} button")
//    public void iClickOnGenerateReceiptButton(String buttonText) throws InterruptedException {
//
//        // Delegate button click logic
//        rentReceiptPage.clickGenerateReceiptButton(buttonText);
//
//        System.out.println("Generate Receipt button clicked successfully.");
//    	
//    	
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////
////        js.executeScript("arguments[0].scrollIntoView(true);", rentReceiptPage.getGenerateButton());
////        rentReceiptPage.getGenerateButton().click();
////        Thread.sleep(2000);
//    }
//    
//    
//    @And("the option to download the receipt as a PDF should be available")
//    public void theOptionToDownloadPDFShouldBeAvailable() throws InterruptedException {
//    	Thread.sleep(3000);
//    	
//    	WebElement ButtonTitle = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/button"));
//    	String actulaButtonTitle = ButtonTitle.getText();
//    	String expectedButtonTitle = "Download Rent Receipt";
//        // Verify the PDF download option
//        boolean isAvailable = rentReceiptPage.isPdfDownloadOptionAvailable();
//        
//        if(isAvailable) {
//        	//==========================================================================================================================
//        	Assert.assertNotEquals(actulaButtonTitle, expectedButtonTitle);
//        }
//
//        System.out.println("The PDF download option is available.");
//        
//        driver.quit();
//    }
//    
//    
//    
//   // Scenario: Error for missing tenant name--------------------------------------------------------------------------
//    
////    @Given("I navigated to the Online Rent Receipt Generator page using {string} browser")
////    public void iNavigateToRentReceiptGeneratorPage1(String browser) throws Exception {
////        driver = setup.setupBrowser(browser);
////        setup.navigateToUrl("https://www.nobroker.in/");
////        driver.manage().window().maximize();
////        
////        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[1]")).click();
////        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[2]/a[6]")).click();
////        
////        rentReceiptPage = new RentReceiptPage(driver);
////    }
//    
//    
//    @When("I leave the tenant name field empty")
//    public void iLeaveTheTenantNameFieldEmpty() {
//
//        rentReceiptPage.getTenantNameField().clear();
//        System.out.println("Tenant name field left empty.");
//    }
//
//    @And("I entered {string} as the owner name")
//    public void iEnterOwnerName1(String ownerName) {
//        rentReceiptPage.getOwnerNameField().clear();
//        rentReceiptPage.getOwnerNameField().sendKeys(ownerName);
//    }
//
//    @And("I entered {string} as the rent amount")
//    public void iEnterRentAmount1(String rentAmount) {
//        rentReceiptPage.getRentAmountField().clear();
//        rentReceiptPage.getRentAmountField().sendKeys(rentAmount);
//    }
//    
//    @And("I entered {string} as the rental property address")
//    public void iEnterRentalAddress1(String rentalAddress) {
//        rentReceiptPage.getRentalAddressField().clear();
//        rentReceiptPage.getRentalAddressField().sendKeys(rentalAddress);
//    }
//
//    @And("I entered {string} as the owner address")
//    public void iEnterOwnerAddress1(String ownerAddress) {
//        rentReceiptPage.getOwnerAddressField().clear();
//        rentReceiptPage.getOwnerAddressField().sendKeys(ownerAddress);
//    }
//    
//    
//    @And("I selected start date as the start date and end date as the end date")
//    public void iSelectStartAndEndMonth1() throws InterruptedException {
//    	
//    	rentReceiptPage.getStartDateField().click();
//    	rentReceiptPage.getStartDateField();
//        rentReceiptPage.selectDate("rentrecipt-form-from_date-nbInput", 3, 3); // Example: 3rd row, 3rd column
//
//        // Pause for UI rendering
//        Thread.sleep(2000);
//
//        // Open the end date picker and select a date
//        rentReceiptPage.getEndDateField().click();
//        rentReceiptPage.selectDate("rentrecipt-form-to_date-nbInput", 4, 4); // Example: 4th row, 4th column
//
//    }
//    
//    @And("I entered {string} as the email address")
//    public void iEnterEmailAddress1(String emailAddress) {
////        rentReceiptPage.getEmailField().clear();
//        rentReceiptPage.getEmailField().sendKeys(emailAddress);
//    }
//
//    @And("I clicked on the {string} button")
//    public void iClickOnGenerateReceiptButton1(String buttonText) throws InterruptedException {
//
//        // Delegate button click logic
//        rentReceiptPage.clickGenerateReceiptButton(buttonText);
//
//        System.out.println("Generate Receipt button clicked successfully.");
//    	
//    	
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////
////        js.executeScript("arguments[0].scrollIntoView(true);", rentReceiptPage.getGenerateButton());
////        rentReceiptPage.getGenerateButton().click();
////        Thread.sleep(2000);
//    }
//
//    @Then("I should see an error message saying {string}")
//    public void iShouldSeeErrorMessage(String expectedErrorMessage) throws InterruptedException {
//        String actualErrorMessage = rentReceiptPage.fieldRequiredErrorMessage();
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, 
//            "Error message did not match the expected value.");
//        System.out.println("Test Passed: Error message displayed correctly - " + actualErrorMessage);
//        
//        driver.quit();
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//   // Scenario: Verifiy the explore now content---------------------------------------------------------
//    
//    @When("I get to Explore Now page")
//    public void iGetToExploreNowPage() throws Exception {
//        mainPageURL = rentReceiptPage.getMainURL();
//    	rentReceiptPage.getToExplorePage();
//        
//    }
//
//    @And("I verify the title of explore now")
//    public void iVerifyTheTitleOfExploreNow() {
//        String expectedTitle = "Create Rental Agreement"; // Replace with actual title of the Explore Now page
//        String actualTitle = rentReceiptPage.getExplorePageTitle();
//
//        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match for Explore Now page.");
//        System.out.println("Verified page title successfully: " + actualTitle);
//        
//        
//    }
//
////    @And("I click on the explore button")
////    public void iClickOnTheExploreButton() throws InterruptedException {
////        rentReceiptPage.clickExploreButton();
////        System.out.println("Clicked on the Explore button successfully.");
////    }
//
//    @And("I verify the explore button")
//    public void iVerifyTheExploreButton() throws InterruptedException {
//        // Validate that the Explore button is visible and enabled
//        Assert.assertTrue(rentReceiptPage.isExploreButtonDisplayed().isDisplayed(), "Explore button is not displayed.");
//        
//        rentReceiptPage.clickExploreButton();
//        
//        navigatedPageURL = rentReceiptPage.getNavigatedURL();
////        Assert.assertTrue(rentReceiptPage.isExploreButtonDisplayed().isEnabled(), "Explore button is not enabled.");
////
//        System.out.println("Verified Explore button is clicked successfully");
//    }
//    
//    @Then("I verify it successfully navigated to another page")
//    public void navigatedToPage() throws InterruptedException {
//    	
//    	Assert.assertNotEquals(mainPageURL, navigatedPageURL, "Pages URL not matched....");
//    	System.out.println("Verified the page are navigated successfully");
//    	
//    	Thread.sleep(5000);
//    	
//    	driver.quit();
//    	
//    }
//    
//    
//    
//    
//    
//    // Scenario: Check the valid phone number--------------------------------------------------------------------
//    
//    
//    @When("I fill {string} as the tenant name")
//    public void iEnterTenantName2(String tenantName) {
//        rentReceiptPage.getTenantNameField().clear();
//        rentReceiptPage.getTenantNameField().sendKeys(tenantName);
//    }
//
//    @And("I fill {string} as the owner name")
//    public void iEnterOwnerName2(String ownerName) {
//        rentReceiptPage.getOwnerNameField().clear();
//        rentReceiptPage.getOwnerNameField().sendKeys(ownerName);
//    }
//    
//    @And("I fill {string} as the tenant phone no")
//    public void iEnterTenantNumber(String tenantNumber) {
//    	
//    	rentReceiptPage.getTenantPhoneNoField().clear();
//    	rentReceiptPage.getTenantPhoneNoField().sendKeys(tenantNumber);
//    	
//    }
//    
//    @And("I fill {string} as the owner phone no")
//    public void iEnterOwnerNumber(String ownerNumber) {
//    	
//    	rentReceiptPage.getOwnerPhoneNoField().clear();
//    	rentReceiptPage.getOwnerPhoneNoField().sendKeys(ownerNumber);
//    	
//    }
//
//    @And("I fill {string} as the rent amount")
//    public void iEnterRentAmount2(String rentAmount) {
//        rentReceiptPage.getRentAmountField().clear();
//        rentReceiptPage.getRentAmountField().sendKeys(rentAmount);
//    }
//
//    @And("I fill {string} as the rental property address")
//    public void iEnterRentalAddress2(String rentalAddress) {
//        rentReceiptPage.getRentalAddressField().clear();
//        rentReceiptPage.getRentalAddressField().sendKeys(rentalAddress);
//    }
//
//    @And("I fill {string} as the owner address")
//    public void iEnterOwnerAddress2(String ownerAddress) {
//        rentReceiptPage.getOwnerAddressField().clear();
//        rentReceiptPage.getOwnerAddressField().sendKeys(ownerAddress);
//    }
//
//    @And("I fill start date as the start date and end date as the end date")
//    public void iSelectStartAndEndMonth2() throws InterruptedException {
//    	
//    	rentReceiptPage.getStartDateField().click();
//    	rentReceiptPage.getStartDateField();
//        rentReceiptPage.selectDate("rentrecipt-form-from_date-nbInput", 3, 3); // Example: 3rd row, 3rd column
//
//        // Pause for UI rendering
//        Thread.sleep(2000);
//
//        // Open the end date picker and select a date
//        rentReceiptPage.getEndDateField().click();
//        rentReceiptPage.selectDate("rentrecipt-form-to_date-nbInput", 4, 4); // Example: 4th row, 4th column
//
//        System.out.println("Start and End Dates have been selected successfully.");
//        
//    }
//
//    @And("I fill {string} as the email address")
//    public void iEnterEmailAddress2(String emailAddress) {
//        rentReceiptPage.getEmailField().clear();
//        rentReceiptPage.getEmailField().sendKeys(emailAddress);
//    }
//    
//    @Then("I verify the phone numbers filled in fields")
//    public void verifyPhoneNo() throws InterruptedException {
//    	
//    	boolean validTenantPhoneNumber = rentReceiptPage.validatePhoneNumber(rentReceiptPage.getTenantPhoneNoField());
//    	Assert.assertTrue(validTenantPhoneNumber, "Invalid Tenant's Phone Number...");
//    	
//    	boolean validOwnerPhoneNumber = rentReceiptPage.validatePhoneNumber(rentReceiptPage.getOwnerPhoneNoField());
//    	Assert.assertTrue(validOwnerPhoneNumber, "Invalid Phone Number...");
//    	
//    	
//    	rentReceiptPage.ifValidPhoneNumber(validTenantPhoneNumber && validOwnerPhoneNumber);
////    	rentReceiptPage.ifValidPhoneNumber(validTenantPhoneNumber, "Owner's Phone");
//    	
//    	Thread.sleep(5000);
//    	
//    	driver.quit();
//    	
//    }
//    
//    
//    
//    
//    
//    
//    // Scenario: Check the Frequently Asked Questions page--------------------------------------------------------------------------
//    
//    @When("I move to FAQS slide")
//    public void moveToFAQS() {
//    	
//    	rentReceiptPage.locateFaqs();
//    	
//    }
//    
//    @And("I click on the FAQ point")
//    public void clickOnTheFAQ() throws InterruptedException {
//    	
//    	rentReceiptPage.clickOnFaq();
//    	
//    }
//    
//    @Then("I check content of FAQ is display")
//    public void checkContentFaq() throws InterruptedException {
//    	
//    	rentReceiptPage.checkContent();
//    	
//    }
//    
//    
//    @And("I verify the content of FAQ is correct")
//    public void verifyTheFaqContent() throws InterruptedException {
//    	
//    	rentReceiptPage.verifyContent();
//    	Thread.sleep(5000);
//    	
//    	driver.quit();
//    	
//    }
//    
//    
//    
//    
//    @After
//    public void takeScreenShotOnFailedScenario(Scenario scenario) {
//    	
//    	setup.takeScreenShotOnError(scenario);
//    }
//    
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//// -------------------------------------------------------------------------------------------------------------------
//
//
//
//
//
//
//
//
//
//
//
////package com.stepdefinition;
////
////import java.time.Duration;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.ElementClickInterceptedException;
////import org.openqa.selenium.JavascriptExecutor;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.openqa.selenium.support.ui.WebDriverWait;
////
////import com.setup.BaseSteps;
////
////import io.cucumber.java.en.And;
////import io.cucumber.java.en.Given;
////import io.cucumber.java.en.Then;
////import io.cucumber.java.en.When;
////
////public class RentReceiptSteps {
////
////    BaseSteps setup = new BaseSteps();
////    WebDriver driver;
////    WebElement tenantField, ownerField, rentField, ReceiptStartDateField, ReceiptEndDateField, 
////    	RentedPropertyAddressField, OwnerAddressField, EmailField, ButtonField;
////    
////    // Variables to hold the input data
//////    private String actualMainTitle;
//////    private String tenantName, ownerName, rentAmount;
//////    private String startMonth;
//////    private String endMonth;
//////    private String ownerPAN;
//////    private String propertyAddress;
//////    private String emailAddress;
//////    private boolean receiptGenerated;
//////    private boolean downloadOptionAvailable;
//////    private String errorMessage;
////
////    // Background step: Navigate to the Rent Receipt Generator page
////    @Given("I navigate to the Online Rent Receipt Generator page using {string} browser")
////    public void iNavigateToRentReceiptGeneratorPage(String browser) throws Exception {
////        System.out.println("Navigating to the Rent Receipt Generator page...");
////        
////        // Set up the browser and navigate to the URL
////        driver=setup.setupBrowser(browser);
////        setup.navigateToUrl("https://www.nobroker.in/");
////        driver.manage().window().maximize();
////        
////        
//////        actualMainTitle = driver.getTitle();
//////        System.out.println(actualMainTitle);
//////        expecetedMainTitle = "No"
////        
////        
////        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[1]")).click();
////        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[2]/a[6]")).click();
////        
////    }
////
////    // Scenario: Generate rent receipt successfully with valid data
////    
////    @When("I enter {string} as the tenant name")
////    public void iEnterTenantName(String tenantName) {
////    	
////    	tenantField = driver.findElement(By.id("rentrecipt-form-tenant_name-nbInput"));
////    	tenantField.clear();
////        tenantField.sendKeys(tenantName);
////    }
////
////    @And("I enter {string} as the owner name")
////    public void iEnterOwnerName(String ownerName) {
////    	
////    	ownerField = driver.findElement(By.id("rentrecipt-form-owner_name-nbInput"));
////    	ownerField.clear();
////        ownerField.sendKeys(ownerName);
////    }
//////
////    @And("I enter {string} as the rent amount")
////    public void iEnterRentAmount(String rentAmount) {
////    	
////    	rentField = driver.findElement(By.id("rentrecipt-form-rent-nbInput"));
////    	rentField.clear();
////    	rentField.sendKeys(rentAmount);
////    }
//////
////    
////    @And("I enter {string} as the rental property address")
////    public void iEnterRentalAddress(String rentalAddress) {
////    	RentedPropertyAddressField = driver.findElement(By.id("rentrecipt-form-tenant_address-nbInput"));
////    	RentedPropertyAddressField.clear();
////    	RentedPropertyAddressField.sendKeys(rentalAddress);		
////    }
////    
////    
////    @And("I enter {string} as the owner address")
////    public void iEnterOwnerAddress(String ownerAddress) {
////    	OwnerAddressField = driver.findElement(By.id("rentrecipt-form-owner_address-nbInput"));
////    	OwnerAddressField.clear();
////    	OwnerAddressField.sendKeys(ownerAddress);		
////    }
////    
////    
////    @And("I select start date as the start date and end date as the end date")
////    public void iSelectStartAndEndMonth() {
//////    	ReceiptStartDateField.clear();
////    	ReceiptStartDateField = driver.findElement(By.xpath("//*[@id=\"rentrecipt-form-from_date-nbInput\"]/div/div[1]/div/input"));
////    	ReceiptStartDateField.click();
////    	ReceiptStartDateField = driver.findElement(By.xpath("//*[@id=\"rentrecipt-form-from_date-nbInput\"]/div/div[2]/div/div[2]/div[2]/div[2]/div[4]"));
////    	ReceiptStartDateField.click();
////    	
//////    	ReceiptEndDateField.clear();
////    	ReceiptEndDateField = driver.findElement(By.xpath("//*[@id=\"rentrecipt-form-to_date-nbInput\"]/div/div[1]/div/input"));
////    	ReceiptEndDateField.click();
////    	ReceiptEndDateField = driver.findElement(By.xpath("//*[@id=\"rentrecipt-form-to_date-nbInput\"]/div/div[2]/div/div[2]/div[2]/div[4]/div[4]"));
////    	ReceiptEndDateField.click();
////    }
//////
////    @And("I enter {string} as the email address")
////    public void iEnterEmailAddress(String emailAddress) {
////    	
////    	EmailField = driver.findElement(By.id("rentrecipt-form-email-nbInput"));
////    	EmailField.clear();
////    	EmailField.sendKeys(emailAddress);
////    	
////    }
////    
////    
////    @Then("I click on the {string} button")
////    public void iClickOnGenerateReceiptButton(String button) throws InterruptedException {
////    	
////    	if (button.equals("Generate Rent Receipt Now")) {
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////            // Wait for the button to be present
////            ButtonField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rentrecipt-form\"]/button")));
////
////            // Scroll into view using JavaScript
////            JavascriptExecutor js = (JavascriptExecutor) driver;
////            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ButtonField);
////
////            // Handle potential overlapping elements
////            try {
////                // Try clicking the button
////                ButtonField.click();
////            } catch (ElementClickInterceptedException e) {
////                System.out.println("Element click intercepted. Attempting JavaScript click...");
////
////                // Use JavaScript to click the button
////                js.executeScript("arguments[0].click();", ButtonField);
////            }
////
////            // Wait for any post-click actions to complete
////            Thread.sleep(2000);
////        } else {
////            System.out.println("Button not found or incorrect button text.");
////        }
////    }
////    
//////    @Then("I should see a rent receipt preview with the entered details")
//////    public void iShouldSeeRentReceiptPreview() {
//////        assertTrue("Receipt should be generated", receiptGenerated);
//////        assertEquals("Tenant name should be correct", "John Doe", tenantName);
//////        assertEquals("Owner name should be correct", "Jane Smith", ownerName);
//////        assertEquals("Rent amount should be correct", "15000", rentAmount);
//////        assertEquals("Start month should be correct", "January 2024", startMonth);
//////        assertEquals("End month should be correct", "December 2024", endMonth);
//////    }
//////
//////    @And("the option to download the receipt as a PDF should be available")
//////    public void theOptionToDownloadPDFShouldBeAvailable() {
//////        downloadOptionAvailable = true;
//////        assertTrue("Download option should be available", downloadOptionAvailable);
//////    }
////
////    // Other scenarios remain unchanged...
////}
package com;




