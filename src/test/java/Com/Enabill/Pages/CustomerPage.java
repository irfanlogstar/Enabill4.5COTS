package Com.Enabill.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Com.common.Methods.commonmethods;


public class CustomerPage extends HeaderPage {

	    private WebDriver driver;
	    public commonmethods cm;
	    private ExtentTest logger;

	    public CustomerPage(WebDriver driver, ExtentTest logger)
	    {
	        super(driver, logger);
	        this.cm = new commonmethods(driver, logger);
	        
	    }
	    
	    @FindBy(id = "Search")
	    WebElement Search;
	    
	    @FindBy(xpath = "//a[normalize-space()='Customer']")
	    WebElement SearchCustomer;
	    
	    @FindBy(id = "Add")
	    WebElement CustomerAddButton;
	    
	    @FindBy(xpath = "//kendo-textbox[@id='Code']//input[@class='k-input-inner']")
	    WebElement CustomerCode;
	    
	    @FindBy(xpath = " //kendo-textbox[@id='Name']//input[@class='k-input-inner']")
	    WebElement Name;
	    
	    @FindBy(xpath = " //kendo-textbox[@id='LongName']//input[@class='k-input-inner']")
	    WebElement LongName;
	  
	    
	    
	    
	    public void custometnavigation(String SerachCustomer)
	    {
	    	SearchCustomer(SerachCustomer);
	    }
	    public void custometnavigation2()
	    {
	    	SelectCustomer();
	    }
	    
	    public void EnterCustomerCode(String CustomerCode , String CustomerName, String CustomerLongName)
	    {
	    	EnterCustomercode(CustomerCode);
	    	EnterCustomerName(CustomerName);
	    	EnterCustomerLongName(CustomerLongName);
	    }
	    
	    
	  
	   public void SearchCustomer(String val)
	   {
		   cm.EnterValue(Search, val, "Text " + val + " has been entered into Search Bar");
	   }
	   
	   public void SelectCustomer()
	    {
	    	cm.ClickElement(SearchCustomer, "User has selected Customer from Search Bar");
	    	cm.ClickElement(CustomerAddButton, "User has Clicked on Add Button");
	    }
	  
	   public void EnterCustomercode(String val)
	   {
		   cm.EnterValue(CustomerCode, val, "Text " + val + " has been entered into Customer Code");
	   }
	   
	   public void EnterCustomerName(String val)
	   {
		   cm.EnterValue(Name, val, "Text " + val + " has been entered into Name");
	   }
	   
	   public void EnterCustomerLongName(String val)
	   {
		   cm.EnterValue(LongName, val, "Text " + val + " has been entered into Long Name");
	   }
	   
	   
	   
	   
	      

}

