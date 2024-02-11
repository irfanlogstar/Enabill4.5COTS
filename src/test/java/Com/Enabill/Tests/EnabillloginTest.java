package Com.Enabill.Tests;

import org.testng.annotations.Test;

import Com.Enabill.Pages.LoginPage;



public class EnabillloginTest extends basetest {
    
	
	
	 @Test(priority = 1)
	public void TestCaes1() {
        String TCname ="TestCaes1";
        logger = extent.createTest(TCname);
        LP = new LoginPage(driver, logger);  
        LP.Login(data.get(TCname).get("UserName"), data.get(TCname).get("Password"));
    }
	 

	 @Test(priority = 2)
	public void TestCaes2() {
		logger = extent.createTest("TestCaes2");
	    LP = new LoginPage(driver, logger);
	    LP.loginb();
	   
	}
	 
	 @Test(priority = 3)
		public void TestCaes3() {
			logger = extent.createTest("TestCaes3");
		    LP = new LoginPage(driver, logger);
		    LP.Logout();
		   
		}
	 
	 @Test(priority = 4)
		public void TestCaes4() {
	        String TCname ="TestCaes4";
	        logger = extent.createTest(TCname);
	        LP = new LoginPage(driver, logger);  
	        LP.Login(data.get(TCname).get("UserName"), data.get(TCname).get("Password"));
	    }
	 
	 
	 @Test(priority = 5)
		public void TestCaes5() {
			logger = extent.createTest("TestCaes5");
		    LP = new LoginPage(driver, logger);
		    LP.loginb();
		   
		}
	 @Test(priority = 6)
		public void TestCaes6() {
			logger = extent.createTest("TestCaes6");
		    LP = new LoginPage(driver, logger);
		    LP.invaliduser();
		   
		}
	 
	 

	
	

}
