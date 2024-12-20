package Pages;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        public String isnavigated() {
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
		    
		    try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return currentURL;
		 }

		
		

	public void gettext()	{
		
		String text = driver.findElement(By.className("nb__3TPU1")).getText();  // Example XPath
        System.out.println(text);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertTrue("'Carrier' is not found on career page", text.contains("Careers"));
		
	}
	public void clickjoblist()
	{
		WebElement Joblist=driver.findElement(By.xpath("//button[text()='Jobs Listing']"));
		try {
			Thread.sleep(5000);
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
	

	
	public String navigatedToLinkedInPage() {
		String mainwindowhandle=driver.getWindowHandle();
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String handle : windowHandles) {
            if (!handle.equals(mainwindowhandle)) {
                driver.switchTo().window(handle); // Switch to the new window
                break;
            }
	    }
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String currentURL=driver.getCurrentUrl();
	    System.out.println(currentURL);
	    return currentURL;
	    
	    //assertTrue("URL did not navigate to the career page", currentURL.contains("jobs"));
	    
	}





	public void clickSeeAllOpertunities() {
		// TODO Auto-generated method stub
		
		WebElement seeallOpertunities=driver.findElement(By.xpath("//button[text()='See all opportunities']"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		seeallOpertunities.click();
		
	}





	public void clickForwardButton() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1400)");
		//WebElement imageElement=driver.findElement(By.xpath("//img[@alt='expert']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", imageElement);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement forwardButton=driver.findElement(By.xpath("//img[contains(@class, 'navigation-arrow')]"));
		forwardButton.click();
	}





	public String isNextImageDisplayed() {
		// TODO Auto-generated method stub
		String text=driver.findElement(By.xpath("//p[text()='Saurabh Garg is the Founder and Chief Business officer at NoBroker']")).getText();
		System.out.println(text);
		return text;
	}





	public void clickBackwardButton() {
		// TODO Auto-generated method stub
		WebElement BackwardButton=driver.findElement(By.xpath("//img[@src='https://assets.nobroker.in/nb-new/public/MaterialIcons/ArrowBack.svg']"));
		BackwardButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}





	public String isPreviousImageDisplayed() {
		// TODO Auto-generated method stub
		String text=driver.findElement(By.xpath("//p[text()='Amit Agrawal is the Founder and Chief Executive officer at NoBroker']")).getText();
		System.out.println(text);
		return text;
	}





	public void clickNavigationNoBroker() {
		// TODO Auto-generated method stub
		WebElement NOBROKERBUTTON=driver.findElement(By.className("nb__2_dgM"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NOBROKERBUTTON.click();
		
	}





	public String isNavigatedToHomePage() {
		// TODO Auto-generated method stub
		String mainwindowhandle=driver.getWindowHandle();
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String handle : windowHandles) {
            if (!handle.equals(mainwindowhandle)) {
                driver.switchTo().window(handle); // Switch to the new window
                break;
            }
	    }
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(driver.getCurrentUrl());
	   String text= driver.findElement(By.xpath("//div[text()=\"World's Largest NoBrokerage Property Site\"]")).getText();
	   System.out.println(text);
	   return text;
		
		
	}





	public String isHomePageUrl() {
		// TODO Auto-generated method stub
		String url=driver.getCurrentUrl();
		return url;
		
	}





//	public void navigatedToLinkedInPagebySeeAllOpertunities() {
//		// TODO Auto-generated method stub
//		String mainwindowhandle=driver.getWindowHandle();
//		System.out.println(mainwindowhandle);
//	    Set<String> windowHandles = driver.getWindowHandles();
//	    for (String handle : windowHandles) {
//            if (!handle.equals(mainwindowhandle)) {
//                driver.switchTo().window(handle); // Switch to the new window
//                break;
//            }
//	    }
//	    String currentURL=driver.getCurrentUrl();
//	    System.out.println(currentURL);
//	    
//	    assertTrue("URL did not navigate to the career page", currentURL.contains("jobs"));
//		
//	}
	
}



