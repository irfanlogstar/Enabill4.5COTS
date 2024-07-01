package Com.Enabill.Tests;

import org.testng.annotations.Test;

import Com.Enabill.Pages.CustomerPage;
import Com.Enabill.Pages.LoginPage;

public class customertest extends basetest {
    
    @Test(priority = 1)
    public void TestCaes1() {
        String TCname = "TestCaes1";
        logger = extent.createTest(TCname);
        LP = new LoginPage(driver,logger);
        CP = new CustomerPage(driver, logger);
        LP.Login(data.get(TCname).get("UserName"), data.get(TCname).get("Password"));
        LP.loginb();
       // CP.logout();
    }
    
    @Test(priority = 2)
    public void TestCaes2()
    {
    	logger = extent.createTest("TestCaes2");
    	CP = new CustomerPage(driver, logger);
	    CP.custometnavigation("Customer");
	    CP.custometnavigation2();
    }
    
    @Test(priority = 3)
    public void TestCaes3() {
        String TCname = "CTestCase001";
        logger = extent.createTest(TCname);
        CP = new CustomerPage(driver, logger);
        CP.EnterCustomerCode(CustData.get(TCname).get("Customercode"),CustData.get(TCname).get("Name"),CustData.get(TCname).get("LongName"));
        //CP.logout();
    }
    
    
    
    
}
