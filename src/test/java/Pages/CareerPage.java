package Pages;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerPage  {
	
	private WebDriver driver;

	
	 public CareerPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}




	
	    // Constructor to initialize WebDriver
//	    public CareerPage(WebDriver driver) {
//	        this.driver = driver;// Assign the passed WebDriver to this instance
//	    }
//	
        public void isnavigated() {
		    //String currentURL = driver.getCurrentUrl();
		    //System.out.println(currentURL);
		    String mainwindowhandle=driver.getWindowHandle();
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String handle : windowHandles) {
	            if (!handle.equals(mainwindowhandle)) {
	                driver.switchTo().window(handle); // Switch to the new window
	                break;
	            }
		    }
		    try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String currentURL=driver.getCurrentUrl();
		    System.out.println(currentURL);
		    
		    assertTrue("URL did not navigate to the career page", currentURL.contains("careers"));
		 }

		
		

	public void gettext()	{
		
		String text = driver.findElement(By.className("nb__3TPU1")).getText();  // Example XPath
        System.out.println(text);
        assertTrue("'Carrier' is not found on career page", text.contains("Careers"));
		
	}
	public void clickjoblist()
	{
		WebElement Joblist=driver.findElement(By.xpath("//button[text()='Jobs Listing']"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Joblist.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void navigatedToLinkedInPage() {
		String mainwindowhandle=driver.getWindowHandle();
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String handle : windowHandles) {
            if (!handle.equals(mainwindowhandle)) {
                driver.switchTo().window(handle); // Switch to the new window
                break;
            }
	    }
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String currentURL=driver.getCurrentUrl();
	    System.out.println(currentURL);
	    
	    assertTrue("URL did not navigate to the career page", currentURL.contains("jobs"));
	}
	
}



