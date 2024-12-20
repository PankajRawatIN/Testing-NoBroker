package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
	protected WebDriver driver;

	
	 public BlogPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}


	public void clickblog() {
		// TODO Auto-generated method stub
		
		WebElement blog=driver.findElement(By.xpath("//a[text()='Blog']"));
		blog.click();
		
	}


	public String isNavigatedBlockPage() {
		String mainwindowhandle=driver.getWindowHandle();
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String handle : windowHandles) {
            if (!handle.equals(mainwindowhandle)) {
                driver.switchTo().window(handle); // Switch to the new window
                break;
            }
	    }
		// TODO Auto-generated method stub
	   String url=driver.getCurrentUrl();
	   System.out.println(url);
	   return url;
		
	}


	public void clickOnSubcribeToBlog() {
		// TODO Auto-generated method stub
		WebElement subscribebutton=driver.findElement(By.id("open-popup"));
		subscribebutton.click();
		
	}


	public void validatePopUpForSubscribe() {
		// TODO Auto-generated method stub
		
	}


	public void senddata() {
		// TODO Auto-generated method stub
		
	}


	public void selectoptions() {
		// TODO Auto-generated method stub
		
	}


	public void gotConfirmation() {
		// TODO Auto-generated method stub
		
	}


	public void subscribeNowButton() {
		// TODO Auto-generated method stub
		
	}


//	public String getText() {
//		// TODO Auto-generated method stub
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String text=driver.findElement(By.xpath("//h2[text()='Real Estate, Services & Inspiration Unbounded']")).getText();
//		System.out.println(text);
//		return text;
//		
//	}
}
