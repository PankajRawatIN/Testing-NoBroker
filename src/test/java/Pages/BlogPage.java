package Pages;

import java.util.Set;

import org.openqa.selenium.Alert;
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
		driver.findElement(By.xpath("//button[@class='nb_blog_subscribe_button' and @id='open-popup' and contains(text(), 'Subscribe to our blogs')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("button clicked");
		//subscribebutton.click();
		
		
	}


	public String validatePopUpForSubscribe() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text=driver.findElement(By.xpath("//p[text()='Get latest news delivered straight to you inbox']")).getText();
		System.out.println(text);
		return text;
		
	}


	public void senddata() {
		// TODO Auto-generated method stub
		WebElement Email=driver.findElement(By.id("blog_input_email"));
		Email.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Email.sendKeys("amit@gmail.com");
	}


	public void selectoptions() {
		// TODO Auto-generated method stub
		WebElement selectoption1=driver.findElement(By.xpath("//div[@class='categ_options' and contains(text(), 'Real Estate')]"));
		WebElement selectoption2=driver.findElement(By.xpath("//div[@class='categ_options' and contains(text(), 'Home Services')]"));
		WebElement selectoption3=driver.findElement(By.xpath("//div[@class='categ_options' and contains(text(), 'Finance')]"));
		
		selectoption1.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectoption2.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectoption3.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void subscribeNowButton() {
		// TODO Auto-generated method stub
		WebElement subcribeNow=driver.findElement(By.id("submit-btn"));
		subcribeNow.click();
		
		
	}


	public String gotConfirmation() {
		// TODO Auto-generated method stub
		//System.out.println("i will verify it");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text=driver.findElement(By.xpath("//div[@class='submitMsg']//p[@class='submitMsg_heading' and text()=\"You're all set!\"]")).getText();
		//String text=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='submitMsg']//p[@class='submitMsg_heading' and text()=\"You're all set!\"]"))).getText();
		System.out.println(text);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
		
		
	}


	public void selectlessoptions() {
		// TODO Auto-generated method stub
		WebElement selectoption1=driver.findElement(By.xpath("//div[@class='categ_options' and contains(text(), 'Real Estate')]"));
		WebElement selectoption2=driver.findElement(By.xpath("//div[@class='categ_options' and contains(text(), 'Home Services')]"));
		
		selectoption1.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectoption2.click();
		
	}


	public String gotalertmsg() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert;
		alert=driver.switchTo().alert();
		
		 String text=alert.getText();
		 System.out.println(text);
		return text;
		
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
