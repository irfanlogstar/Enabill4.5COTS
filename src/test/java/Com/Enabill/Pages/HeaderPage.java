package Com.Enabill.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;


import Com.common.Methods.commonmethods;

public class HeaderPage {
	
	public WebDriver driver;
	public commonmethods cm;
	private ExtentTest logger;
	
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		cm = new commonmethods(driver,logger);
	}
	
	 @FindBy(xpath = "//button[normalize-space()='Login']")
	    WebElement loginbu;

	    @FindBy(xpath = "//div[@class='flex-grow-1']")
	    WebElement Profile;
	    
	    @FindBy(xpath = "//i[@class='ti ti-logout txt-w']")
	    WebElement logout;
	
	 public void Logout() {     
         Profile1();
         switchTo();
         logout();
  }
	 
	 public void Profile1() { 
	       cm.ClickElementToBeClickable(Profile, "Profile  button has been clicked");
	        }
	    
	     public void switchTo() { 
	    	 
	    	 JavascriptExecutor executor = (JavascriptExecutor) driver;
	    	 executor.executeScript("arguments[0].click();", Profile);
	         cm.ClickElementToBeClickable(Profile, "Profile");
	    }
	   

	     public void logout() { 
	    	    if (cm.ClickElementToBeClickable(logout, "logout Button has been clicked")) {
	    	        System.out.println("Pass");
	    	    } else {
	    	        System.out.println("Fail");
	    	    }
	    	}
	
	

}
