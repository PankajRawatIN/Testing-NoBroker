package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RentReceiptPage {
    WebDriver driver;
    WebDriverWait wait;

    public RentReceiptPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    
//    private By pageTitleName = By.xpath("(//span[contains(@class,\"'pt-0.4p'\")])[1]");
    private By tenantNameField = By.id("rentrecipt-form-tenant_name-nbInput");
    private By ownerNameField = By.id("rentrecipt-form-owner_name-nbInput");
    private By rentAmountField = By.id("rentrecipt-form-rent-nbInput");
    private By rentalAddressField = By.id("rentrecipt-form-tenant_address-nbInput");
    private By ownerAddressField = By.id("rentrecipt-form-owner_address-nbInput");
    private By emailField = By.id("rentrecipt-form-email-nbInput");
    private By startDateField = By.xpath("//*[@id='rentrecipt-form-from_date-nbInput']/div/div[1]/div/input");
    private By endDateField = By.xpath("//*[@id='rentrecipt-form-to_date-nbInput']/div/div[1]/div/input");
//    private By generateButton = By.xpath("//*[@id='rentrecipt-form']/button");
    private String datePickerXpathTemplate = "//*[@id='%s']/div/div[2]/div/div[2]/div[2]/div[%d]/div[%d]";
    private By generateButtonLocator = By.xpath("//*[@id='rentrecipt-form']/button");
    private By pdfDownloadLocator = By.xpath("//*[@id=\"app\"]/div/div/div[1]/button");
    private By nameFieldErrorMessageLocator = By.xpath("//*[@id=\"rentrecipt-form-tenant_name-nbInput-container\"]/div/div");
//    private By dateFieldErrorMessageLocator = By.xpath("//*[@id=\"rentrecipt-form-tenant_name-nbInput-container\"]/div/div");
    private By explorePage = By.xpath("(//div[@class='flex gap-2 mt-4'])[1]"); // Adjust tag as per actual HTML structure
    private By exploreTitle = By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[3]/div[1]/div[1]/div/div[1]"); // Replace with actual locator (id, class, etc.)
    
    private By exploreButton  = By.xpath("(//button[@type='button'][normalize-space()='Explore Now'])[1]");
    private By getExploreButton = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > button:nth-child(3)");
    
    private By tenantPhoneNoField = By.xpath("//*[@placeholder=\"Tenant's Phone\"]");
    private By ownerPhoneNoField = By.xpath("//*[@placeholder=\"Owner's Phone\"]");
    
    private By faqsPageLocate = By.xpath("(//div[@class='heading-4 font-semi-bold text-left nb__3zTIc'])[1]");
    private By locateOneOfFaq = By.className("nb__1aa1A");
    private By locateFaqContent = By.className("nb__3U-Ey");
    
    // Variables
    String mainPageURL, navigatedPageURL;
    String phoneRegex = "^[+]?\\d{10,13}$";
    String actualContent;
    String expectedContent = "Not having a rent receipt can jeopardise your ability "
    		+ "to prove timely rent payments, potentially leading to wrongful eviction"
    		+ " claims. Additionally, in India, lacking such receipts can hinder"
    		+ " your eligibility to claim HRA deductions, subsequently increasing your "
    		+ "tax liability.";
    
    
    // Actions
    public String getMainURL() {
    	mainPageURL = driver.getCurrentUrl();
    	return mainPageURL;
    }
    
    public WebElement getTenantNameField() {
        return driver.findElement(tenantNameField);
    }

    public WebElement getOwnerNameField() {
        return driver.findElement(ownerNameField);
    }

    public WebElement getRentAmountField() {
        return driver.findElement(rentAmountField);
    }

    public WebElement getRentalAddressField() {
        return driver.findElement(rentalAddressField);
    }

    public WebElement getOwnerAddressField() {
        return driver.findElement(ownerAddressField);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getStartDateField() {
        return wait.until(ExpectedConditions.elementToBeClickable(startDateField));
    }

    public WebElement getEndDateField() {
        return wait.until(ExpectedConditions.elementToBeClickable(endDateField));
    }

    public void selectDate(String datePickerId, int row, int column) {
        String dynamicXpath = String.format(datePickerXpathTemplate, datePickerId, row, column);
        WebElement dateToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
        dateToSelect.click();
    }
    
    public void clickGenerateReceiptButton(String buttonText) throws InterruptedException {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(generateButtonLocator));

        // Verify button text
        if (button.getText().equals(buttonText)) {
            // Scroll into view
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

            try {
                // Try to click the button
//            	Thread.sleep(6000);
                button.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted. Attempting JavaScript click...");

                // Click using JavaScript
//                Thread.sleep(5000);
                js.executeScript("arguments[0].click();", button);
            }

            // Wait for post-click actions
            Thread.sleep(5000);
        } else {
            System.out.println("Button not found or incorrect button text.");
        }
    }
    
    
    public boolean isPdfDownloadOptionAvailable() {
        try {
            WebElement downloadButton = wait.until(ExpectedConditions.presenceOfElementLocated(pdfDownloadLocator));
            return downloadButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("PDF download option is not available.");
            return false;
        }
    }
    
    public String fieldRequiredErrorMessage() throws InterruptedException {
    	Thread.sleep(5000);
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(nameFieldErrorMessageLocator));
        return errorMessage.getText();
    }
    
    

    public void getToExplorePage() {
        
    	WebElement explorePageElement = wait.until(ExpectedConditions.presenceOfElementLocated(explorePage));
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", explorePageElement);
    	
    }

    public String getExplorePageTitle() {
        
    	return driver.findElement(exploreTitle).getText();
    	
    }
    
    public WebElement isExploreButtonDisplayed() {
    	
    	return driver.findElement(exploreButton);
    			
    }

    public void clickExploreButton() throws InterruptedException {
       
    	Thread.sleep(5000);
    	
    	driver.findElement(getExploreButton).click();
    	
    	// bug in website --- can not refresh when click on the button so we need to refresh it in automation
    	driver.navigate().refresh();
    	
    }
    
    public String getNavigatedURL() {
    	
    	navigatedPageURL = driver.getCurrentUrl();
    	return navigatedPageURL;
    	
    }
    
    public WebElement getTenantPhoneNoField() {
        return driver.findElement(tenantPhoneNoField);
    } 
    
    
    public WebElement getOwnerPhoneNoField() {
    	return driver.findElement(ownerPhoneNoField);
    } 
    
    
    public boolean validatePhoneNumber(WebElement phoneFieldAddress) {

        // Retrieve the entered phone number
        String phoneNumber = phoneFieldAddress.getAttribute("value");

        // Validate the phone number using the method
        return isValidPhoneNumber(phoneNumber);
    }
    
    
    public boolean isValidPhoneNumber(String phoneNumber) {
        
        return phoneNumber.matches(phoneRegex);
    }

    
    public void ifValidPhoneNumber(boolean phoneNumber) throws InterruptedException {
    	
    	if(phoneNumber == true) {
    		Thread.sleep(5000);
    		clickGenerateReceiptButton("Generate Rent Receipt Now");
    	}
    	
    	else {
    		System.out.println("Enter vaild phone number.....");
    	}
    	
    }
    
    
    public void locateFaqs() {
    	
    	WebElement faqsPage = driver.findElement(faqsPageLocate);
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", faqsPage);
    	
    }
    
    public void clickOnFaq() throws InterruptedException {
    	
    	Thread.sleep(6000);
    	WebElement FaqElement = driver.findElement(locateOneOfFaq);
    	FaqElement.click();
    	Thread.sleep(5000);
    	
    	Assert.assertTrue(FaqElement.isDisplayed(), "FAQ is not display...");
    	
//    	Assert.assertTrue(FaqElement.isEnabled(), "FAQ is not display...");
    	
    	
//    	FaqElement.isEnabled();
    }
    
    
    public void checkContent() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	WebElement FaqElement = driver.findElement(locateOneOfFaq);
    	FaqElement.click();
    	Thread.sleep(5000);
    	WebElement FaqContent = driver.findElement(locateFaqContent);
    	
    	Assert.assertTrue(FaqContent.isDisplayed(), "content is not display...");
    	
    }
    
    
    
    public void verifyContent() {
    	
    	actualContent = driver.findElement(locateFaqContent).getText();
    	Assert.assertEquals(actualContent, expectedContent);
    	
    }
    
    
}


































































// ------------------------------------------------------------------------------------------------------------------











//package com.pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class RentReceiptPage extends BasePage {
//	
//	
//	// Locators for the Rent Receipt Page
//	
//	@FindBy(id = "rentrecipt-form-tenant_name-nbInput")
//	private WebElement tenantNameField;
//	
//	@FindBy(id = "rentrecipt-form-owner_name-nbInput")
//	private WebElement ownerNameField;
//	
//	@FindBy(id = "rentrecipt-form-rent-nbInput")
//	private WebElement rentAmountField;
//
//	@FindBy(id = "rentrecipt-form-tenant_address-nbInput")
//	private WebElement RentedPropertyAddressField;
//	
//	@FindBy(id = "rentrecipt-form-owner_address-nbInput")
//	private WebElement OwnerAddressField;
//	
//	@FindBy(xpath = "//*[@id=\\\"rentrecipt-form-from_date-nbInput\\\"]/div/div[1]/div/input")
//	private WebElement ReceiptStartDateField;
//	
//	@FindBy(xpath = "//*[@id=\\\"rentrecipt-form-from_date-nbInput\\\"]/div/div[2]/div/div[2]/div[2]/div[2]/div[4]")
//	private WebElement ReceiptStartDate;
//	
//	@FindBy(xpath = "//*[@id=\\\"rentrecipt-form-to_date-nbInput\\\"]/div/div[1]/div/input")
//	private WebElement ReceiptEndDateField;
//	
//	@FindBy(xpath = "rentrecipt-form-email-nbInput")
//	private WebElement EmailField;
//	
//	@FindBy(xpath = "//*[@id=\\\"rentrecipt-form\\\"]/button")
//	private WebElement ButtonField;
//	
//	
//	
//	// Constructor to initialize WebDriver
//	public RentReceiptPage(WebDriver driver) {
//		super(driver);
//		PageFactory.initElements(driver, this);
//	}
//	
//	
//	// Actions
//    public WebElement getTenantNameField() {
//        return driver.findElement(tenantNameField);
//    }
//
//    public WebElement getOwnerNameField() {
//        return driver.findElement(ownerNameField);
//    }
//
//    public WebElement getRentAmountField() {
//        return driver.findElement(rentAmountField);
//    }
//
//    public WebElement getRentalAddressField() {
//        return driver.findElement(rentalAddressField);
//    }
//
//    public WebElement getOwnerAddressField() {
//        return driver.findElement(ownerAddressField);
//    }
//
//    public WebElement getEmailField() {
//        return driver.findElement(emailField);
//    }
//
//    public WebElement getStartDateField() {
//        return driver.findElement(startDateField);
//    }
//
//    public WebElement getEndDateField() {
//        return driver.findElement(endDateField);
//    }
//
//    public WebElement getGenerateButton() {
//        return driver.findElement(generateButton);
//    }
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
////    BaseSteps setup = new BaseSteps();
////    WebDriver driver;
////    WebElement tenantField, ownerField, rentField, ReceiptStartDateField, ReceiptEndDateField, 
////    	RentedPropertyAddressField, OwnerAddressField, EmailField, ButtonField;
////    
////    // Variables to hold the input data
////    private String actualMainTitle;
////    private String tenantName, ownerName, rentAmount;
////    private String startMonth;
////    private String endMonth;
////    private String ownerPAN;
////    private String propertyAddress;
////    private String emailAddress;
////    private boolean receiptGenerated;
////    private boolean downloadOptionAvailable;
////    private String errorMessage;
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
////        actualMainTitle = driver.getTitle();
////        System.out.println(actualMainTitle);
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
////    	ownerField = driver.findElement(By.id("rentrecipt-form-owner_name-nbInput"));
////    	ownerField.clear();
////        ownerField.sendKeys(ownerName);
////    }
//////
////    @And("I enter {string} as the rent amount")
////    public void iEnterRentAmount(String rentAmount) {
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
//
//    // Other scenarios remain unchanged...
//}
