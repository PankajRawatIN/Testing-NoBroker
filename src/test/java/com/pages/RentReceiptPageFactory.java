package com.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.google.common.io.Files;

public class RentReceiptPageFactory extends BasePage {

//    WebDriver driver;
//    WebDriverWait wait;
	
	public RentReceiptPageFactory(WebDriver driver) {
        super(driver);  // This initializes the WebDriver and WebDriverWait from BasePage
        PageFactory.initElements(driver, this);  // Initializes the WebElement fields
    }
//
//    public RentReceiptPageChecking(WebDriver driver) {
//        super(driver);
////        this.driver = driver;
////        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        PageFactory.initElements(driver, this);
//        
//    }

    // Locators using Page Factory
    @FindBy(id = "rentrecipt-form-tenant_name-nbInput")
    private WebElement tenantNameField;

    @FindBy(id = "rentrecipt-form-owner_name-nbInput")
    private WebElement ownerNameField;

    @FindBy(id = "rentrecipt-form-rent-nbInput")
    private WebElement rentAmountField;

    @FindBy(id = "rentrecipt-form-tenant_address-nbInput")
    private WebElement rentalAddressField;

    @FindBy(id = "rentrecipt-form-owner_address-nbInput")
    private WebElement ownerAddressField;

    @FindBy(id = "rentrecipt-form-email-nbInput")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='rentrecipt-form-from_date-nbInput']/div/div[1]/div/input")
    private WebElement startDateField;

    @FindBy(xpath = "//*[@id='rentrecipt-form-to_date-nbInput']/div/div[1]/div/input")
    private WebElement endDateField;

    @FindBy(xpath = "//*[@id='rentrecipt-form']/button")
    private WebElement generateButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/button")
    private WebElement pdfDownloadButton;

    @FindBy(xpath = "//*[@id=\"rentrecipt-form-tenant_name-nbInput-container\"]/div/div")
    private WebElement nameFieldErrorMessage;

    @FindBy(xpath = "(//div[@class='flex gap-2 mt-4'])[1]")
    private WebElement explorePage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/div[3]/div[1]/div[1]/div/div[1]")
    private WebElement exploreTitle;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Explore Now'])[1]")
    private WebElement exploreButton;

    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > button:nth-child(3)")
    private WebElement exploreActionButton;

    @FindBy(xpath = "//*[@placeholder=\"Tenant's Phone\"]")
    private WebElement tenantPhoneNoField;

    @FindBy(xpath = "//*[@placeholder=\"Owner's Phone\"]")
    private WebElement ownerPhoneNoField;

    @FindBy(xpath = "(//div[@class='heading-4 font-semi-bold text-left nb__3zTIc'])[1]")
    private WebElement faqsPage;

    @FindBy(className = "nb__1aa1A")
    private WebElement faqItem;

    @FindBy(className = "nb__3U-Ey")
    private WebElement faqContent;

    
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
        return tenantNameField;
    }

    public WebElement getOwnerNameField() {
        return ownerNameField;
    }

    public WebElement getRentAmountField() {
        return rentAmountField;
    }

    public WebElement getRentalAddressField() {
        return rentalAddressField;
    }

    public WebElement getOwnerAddressField() {
        return ownerAddressField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getStartDateField() {
        return wait.until(ExpectedConditions.elementToBeClickable(startDateField));
    }

    public WebElement getEndDateField() {
        return wait.until(ExpectedConditions.elementToBeClickable(endDateField));
    }

    public void selectDate(String datePickerId, int row, int column) throws InterruptedException {
        String datePickerXpath = String.format("//*[@id='%s']/div/div[2]/div/div[2]/div[2]/div[%d]/div[%d]", datePickerId, row, column);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(datePickerXpath)));
        
        Thread.sleep(3000);
        dateElement.click();
    }

    public void clickGenerateReceiptButton(String buttonText) throws InterruptedException {
        if (generateButton.getText().equals(buttonText)) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", generateButton);
            try {
                Thread.sleep(5000);
                generateButton.click();
            } catch (ElementClickInterceptedException e) {
                js.executeScript("arguments[0].click();", generateButton);
            }
            Thread.sleep(5000);
        } else {
            System.out.println("Incorrect button text.");
        }
    }

    public boolean isPdfDownloadOptionAvailable() {
        return pdfDownloadButton.isDisplayed();
    }

    public String fieldRequiredErrorMessage() throws InterruptedException {
        Thread.sleep(5000);
        return nameFieldErrorMessage.getText();
    }
    
    public void getToExplorePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", explorePage);
    }
    
    public String getExplorePageTitle() {
        return exploreTitle.getText();
    }
    
    public WebElement isExploreButtonDisplayed() {
    	
    	return exploreButton;
    			
    }
    
    public void clickExploreButton() throws InterruptedException {
        Thread.sleep(5000);
       
        exploreButton.click();
        
        driver.navigate().refresh();
    }
    
    public String getNavigatedURL() {
    	
    	navigatedPageURL = driver.getCurrentUrl();
    	return navigatedPageURL;
    	
    }
    
    public WebElement getTenantPhoneNoField() {
        return tenantPhoneNoField;
    } 
    
    
    public WebElement getOwnerPhoneNoField() {
    	return ownerPhoneNoField;
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", faqsPage);
    }

    public void clickOnFaq() throws InterruptedException {
        Thread.sleep(5000);
        faqItem.click();
        Assert.assertTrue(faqItem.isDisplayed(), "FAQ item is not displayed.");
    }

    public void checkContent() throws InterruptedException {
        Thread.sleep(5000);
        faqItem.click();
        Assert.assertTrue(faqContent.isDisplayed(), "FAQ content is not displayed.");
    }

    public void verifyContent() {
        String actualContent = faqContent.getText();
        String expectedContent = "Not having a rent receipt can jeopardise your ability to prove timely rent payments, potentially leading to wrongful eviction claims. Additionally, in India, lacking such receipts can hinder your eligibility to claim HRA deductions, subsequently increasing your tax liability.";
        Assert.assertEquals(actualContent, expectedContent, "FAQ content mismatch.");
    }
    
 // To capture a screenshot and save it to the specified file path
 	public void screenShot(WebDriver driver, String filePath) {
 		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		try 
 		{
 			Files.copy(f, new File(filePath));
 		} 
 		catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
}
