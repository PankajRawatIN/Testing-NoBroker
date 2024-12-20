package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	 protected WebDriver driver;
	// BaseSteps base1;
	    // Constructor to initialize WebDriver (receive it from the test)
	    public BasePage(WebDriver driver) {
	    	
	        this.driver = driver;
    }

	//WebDriver driver=BaseSteps.dr();
	
	public void clickmenu()
	{
		WebElement menu=driver.findElement(By.id("main-menu"));
		menu.click();
		
	}
	
	public void clickcareer()
	{
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////		}
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement career=driver.findElement(By.xpath("//a[@href='/careers' and text()='Careers']"));
		wait.until(ExpectedConditions.elementToBeClickable(career));
		 try {
	            // Attempt to click the link
	            career.click();
	        } catch (ElementClickInterceptedException e) {
	            // If the element click is intercepted, use JavaScript to click
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", career);
	        }
	}
	


}
