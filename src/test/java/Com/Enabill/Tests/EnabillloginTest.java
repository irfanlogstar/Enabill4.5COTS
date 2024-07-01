package Com.Enabill.Tests;

import org.testng.annotations.Test;

import Com.Enabill.Pages.LoginPage;



public class EnabillloginTest extends basetest {
    
	
	
	 @Test(priority = 1)
	public void EnterUserNameandpassword() {
        String TCname ="TestCaes1";
        logger = extent.createTest(TCname);
        LP = new LoginPage(driver, logger);  
        LP.Login(data.get(TCname).get("UserName"), data.get(TCname).get("Password"));
    }
	 

	 @Test(priority = 2)
	public void ClickOnLoginButton() {
		logger = extent.createTest("TestCaes2");
	    LP = new LoginPage(driver, logger);
	    LP.loginb();
	   
	}
	 
     @Test(priority = 3)
	 public void LogOut()
	 {
		 logger = extent.createTest("TestCaes2");
		    LP = new LoginPage(driver, logger);
		    LP.Logout();
		 
	 }
	 
	 @Test(priority = 3)
		public void TestCaes3() {
	        String TCname ="TestCaes4";
	        logger = extent.createTest(TCname);
	        LP = new LoginPage(driver, logger);  
	        LP.Login(data.get(TCname).get("UserName"), data.get(TCname).get("Password"));
	    }
	 
	 
	 @Test(priority = 4)
		public void TestCaes4() {
			logger = extent.createTest("TestCaes5");
		    LP = new LoginPage(driver, logger);
		    LP.loginb();
		   
		}
	 @Test(priority = 5)
		public void TestCaes5() {
			logger = extent.createTest("TestCaes6");
		    LP = new LoginPage(driver, logger);
		    LP.invaliduser();
		   
		}
	
	 
	 

	
	

}
