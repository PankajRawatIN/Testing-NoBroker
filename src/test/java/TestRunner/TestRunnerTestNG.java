package TestRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.RentReceiptPageFactory;
import com.pages.RentReceiptPageOriginal;
import com.setup.BaseSteps;

public class TestRunnerTestNG {

	BaseSteps setup = new BaseSteps();
    WebDriver driver;
    RentReceiptPageFactory rentReceiptPage;

    String mainPageURL, navigatedPageURL;

    @BeforeMethod
    public void setupBrowser() throws Exception {
        driver = setup.setupBrowser("chrome"); // Replace "chrome" with desired browser if needed
        setup.navigateToUrl("https://www.nobroker.in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div[2]/a[6]")).click();

        rentReceiptPage = new RentReceiptPageFactory(driver);
    }

    @Test(priority = 1, dataProvider = "fullRentDetails")
    public void testGenerateReceipt(String tenantName, String ownerName, String rentAmount, String rentalAddress, String ownerAddress, String emailAddress) throws InterruptedException {
        rentReceiptPage.getTenantNameField().clear();
        rentReceiptPage.getTenantNameField().sendKeys(tenantName);

        rentReceiptPage.getOwnerNameField().clear();
        rentReceiptPage.getOwnerNameField().sendKeys(ownerName);

        rentReceiptPage.getRentAmountField().clear();
        rentReceiptPage.getRentAmountField().sendKeys(rentAmount);

        rentReceiptPage.getRentalAddressField().clear();
        rentReceiptPage.getRentalAddressField().sendKeys(rentalAddress);

        rentReceiptPage.getOwnerAddressField().clear();
        rentReceiptPage.getOwnerAddressField().sendKeys(ownerAddress);

        rentReceiptPage.getStartDateField().click();
        rentReceiptPage.selectDate("rentrecipt-form-from_date-nbInput", 3, 3);
        Thread.sleep(3000);

        rentReceiptPage.getEndDateField().click();
        rentReceiptPage.selectDate("rentrecipt-form-to_date-nbInput", 4, 4);

        rentReceiptPage.getEmailField().clear();
        rentReceiptPage.getEmailField().sendKeys(emailAddress);

        rentReceiptPage.clickGenerateReceiptButton("Generate Rent Receipt Now");

        boolean isAvailable = rentReceiptPage.isPdfDownloadOptionAvailable();
        Assert.assertTrue(isAvailable, "PDF download option is not available.");

        System.out.println("Test Passed: Receipt generated and PDF option available.");
    }

    @Test(priority = 2, dataProvider = "notFullRentDetails")
    public void testEmptyTenantName(String ownerName, String rentAmount, String rentalAddress, String ownerAddress, String emailAddress) throws InterruptedException {
//        rentReceiptPage.getTenantNameField().clear();
        
        rentReceiptPage.getOwnerNameField().sendKeys(ownerName);
        
        rentReceiptPage.getRentAmountField().sendKeys(rentAmount);
        
        rentReceiptPage.getRentalAddressField().sendKeys(rentalAddress);
        rentReceiptPage.getOwnerAddressField().sendKeys(ownerAddress);
        
        rentReceiptPage.getStartDateField().click();
        rentReceiptPage.selectDate("rentrecipt-form-from_date-nbInput", 3, 3);
        Thread.sleep(3000);

        rentReceiptPage.getEndDateField().click();
        rentReceiptPage.selectDate("rentrecipt-form-to_date-nbInput", 4, 4);

        
        rentReceiptPage.getEmailField().sendKeys(emailAddress);

        rentReceiptPage.clickGenerateReceiptButton("Generate Rent Receipt Now");

        String errorMessage = rentReceiptPage.fieldRequiredErrorMessage();
        Assert.assertEquals(errorMessage, "This is required field", "Error message does not match.....");
        System.out.println("Test Passed: Correct error message displayed for empty tenant name.");
    }
    
    
    
    

    @Test(priority = 3)
    public void testExploreNowPage() throws InterruptedException {
        mainPageURL = rentReceiptPage.getMainURL();
        rentReceiptPage.getToExplorePage();

        String expectedTitle = "Create Rental Agreement";
        String actualTitle = rentReceiptPage.getExplorePageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch.");

        Assert.assertTrue(rentReceiptPage.isExploreButtonDisplayed().isDisplayed(), "Explore button is not displayed.");
        rentReceiptPage.clickExploreButton();

        navigatedPageURL = rentReceiptPage.getNavigatedURL();
        Assert.assertNotEquals(mainPageURL, navigatedPageURL, "Navigation failed.");

        System.out.println("Test Passed: Successfully navigated to Explore Now page.");
        
    }
    
    
    
    @Test(priority = 4, dataProvider = "rentDetailWithPhoneNo")
    public void validatePhoneNumber(String tenantName, String ownerName, String tenantPhone, String ownerPhone, String rentAmount, String rentalAddress, String ownerAddress, String emailAddress) throws InterruptedException {
        
        // Fill tenant name
        rentReceiptPage.getTenantNameField().clear();
        rentReceiptPage.getTenantNameField().sendKeys(tenantName);

        // Fill owner name
        rentReceiptPage.getOwnerNameField().clear();
        rentReceiptPage.getOwnerNameField().sendKeys(ownerName);

        // Fill tenant phone number
        rentReceiptPage.getTenantPhoneNoField().clear();
        rentReceiptPage.getTenantPhoneNoField().sendKeys(tenantPhone);

        // Fill owner phone number
        rentReceiptPage.getOwnerPhoneNoField().clear();
        rentReceiptPage.getOwnerPhoneNoField().sendKeys(ownerPhone);

        // Fill rent amount
        rentReceiptPage.getRentAmountField().clear();
        rentReceiptPage.getRentAmountField().sendKeys(rentAmount);

        // Fill rental property address
        rentReceiptPage.getRentalAddressField().clear();
        rentReceiptPage.getRentalAddressField().sendKeys(rentalAddress);

        // Fill owner address
        rentReceiptPage.getOwnerAddressField().clear();
        rentReceiptPage.getOwnerAddressField().sendKeys(ownerAddress);

        // Fill email address
        rentReceiptPage.getEmailField().clear();
        rentReceiptPage.getEmailField().sendKeys(emailAddress);

        // Select start and end dates
        rentReceiptPage.getStartDateField().click();
        rentReceiptPage.selectDate("rentrecipt-form-from_date-nbInput", 3, 3);
        Thread.sleep(1000);
        rentReceiptPage.getEndDateField().click();
        rentReceiptPage.selectDate("rentrecipt-form-to_date-nbInput", 4, 4);

        System.out.println("Start and End Dates have been selected successfully.");

        // Validate phone numbers
        boolean validTenantPhoneNumber = rentReceiptPage.validatePhoneNumber(rentReceiptPage.getTenantPhoneNoField());
        Assert.assertTrue(validTenantPhoneNumber, "Invalid Tenant's Phone Number...");

        boolean validOwnerPhoneNumber = rentReceiptPage.validatePhoneNumber(rentReceiptPage.getOwnerPhoneNoField());
        Assert.assertTrue(validOwnerPhoneNumber, "Invalid Owner's Phone Number...");

        rentReceiptPage.ifValidPhoneNumber(validTenantPhoneNumber && validOwnerPhoneNumber);

        Thread.sleep(5000);
//        driver.quit();
    }

    
    
    @Test(priority = 5)
    public void testFAQsFlow() throws InterruptedException {
       
        rentReceiptPage.locateFaqs();
        System.out.println("Navigated to FAQs slide successfully.");

        rentReceiptPage.clickOnFaq();
        System.out.println("Clicked on the FAQ point successfully.");

        rentReceiptPage.checkContent();
        System.out.println("FAQ content is displayed successfully.");

        rentReceiptPage.verifyContent();
        System.out.println("FAQ content is verified successfully.");

        // Cleanup
        Thread.sleep(5000);
//        driver.quit();
    }
    
    
      

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
    @DataProvider(name = "fullRentDetails")
    public Object[][] rentDetails() {
        return new Object[][] {
            {"Mahesh Sharma", "Pankaj Shukla", "20000", "123 Main Street", "456 Main Street", "abc123@gmail.com"}
        };
    }
    
    
    @DataProvider(name = "notFullRentDetails")
    public Object[][] partialRentDetails() {
    	return new Object[][] {
    		{"Pankaj Shukla", "20000", "123 Main Street", "456 Main Street", "abc123@gmail.com"}
    	};
    }
    
    
    @DataProvider(name = "rentDetailWithPhoneNo")
    public Object[][] rentDetailWithPhoneNoProvider() {
        return new Object[][] {
            { "Mahesh Sharma", "Pankaj Shukla", "1234567890", "0987654321", "50000", "123 Main Street", "456 Elm Street", "abc123@gmail.com" }
        };
    }
	
}
