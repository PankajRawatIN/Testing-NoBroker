package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterPropertyPage {

	WebDriver driver;
	WebDriverWait wait;

	public FilterPropertyPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void selectCity(String city) {

		WebElement cityDropdown = driver.findElement(By.xpath("(//*[@id=\"searchCity\"]/div/div[1]/div)[1]")); // Adjust
																												// locator
		cityDropdown.click();

	}

	public void enterLocality(String locality) {
		WebElement localitySearchBar = driver.findElement(By.xpath("//*[@id=\"listPageSearchLocality\"]")); // Adjust
																											// locator
		localitySearchBar.click();
		localitySearchBar.clear();
		localitySearchBar.sendKeys(locality);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"autocomplete-dropdown-container\"]/div[1]"));
		dropdown.click();
	}

	public void selectPropertyType(String propertyType) {

		WebElement radioButton = driver
				.findElement(By.xpath("//label[contains(text(), '" + propertyType + "')]/input"));
		radioButton.click();
	}

	public void selectAvailability(String availability) {
		// Click the dropdown to expand options
		WebElement dropdown = driver.findElement(By.xpath("(//*[@id='searchCity']/div/div[2]/div)[3]"));
		dropdown.click();

		// Wait for the availability option and select it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement availabilityOption = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + availability + "']")));
		availabilityOption.click();
	}

	public void selectBHKType(String bhkType) {
		// WebElement bhkOption = driver.findElement(By.xpath("//label[text()='" +
		// bhkType + "']/preceding-sibling::input")); // Adjust locator
		// bhkOption.click();

		// *[@id="react-select-3-option-2"]/div/label/input
		WebElement dropdown = driver.findElement(By.xpath("(//*[@id=\"searchCity\"]/div[1]/div[1])[2]"));
		dropdown.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement availabilityOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='react-select-3-option-2']/div/label/input")));
		availabilityOption.click();

	}

	public boolean verifyImmediateAvailability() {
		return driver.findElements(By.xpath("//div[@class='property-list-item']")).size() > 0;
	}

	public void clickSearchButton() {
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[4]/button")); // Adjust
																													// locator
		searchButton.click();
	}

	public boolean verifyPropertiesDisplayed(String locality) {
		return driver.findElements(By.xpath("//div[contains(text(),'" + locality + "')]")).size() > 0;
	}

	public boolean verifyBHKPropertiesDisplayed(String bhkType, String locality) {
		return driver
				.findElements(
						By.xpath("//div[contains(text(),'" + bhkType + "') and contains(text(),'" + locality + "')]"))
				.size() > 0;
	}
	public boolean verifyPageTitleContains(String partialTitle) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout
	    return wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	public boolean verifySpecificBHKCount(String bhkCount) {
	
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout
		WebElement properties = driver.findElement(By.xpath("//*[@id=\"listPageContainer\"]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div[3]"));
  
		String count = properties.getText();
		
		return count.equals(bhkCount);
		
		
	}

	public boolean verifyErrorMessage(String expectedMessage) {
		WebElement errorMessage = driver.findElement(By.id("errorMessage")); // Adjust locator
		return errorMessage.getText().equals(expectedMessage);
	}
}
