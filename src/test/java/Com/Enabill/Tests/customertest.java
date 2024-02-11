package Com.Enabill.Tests;

import org.testng.annotations.Test;

import Com.Enabill.Pages.CustomerPage;
import Com.Enabill.Pages.LoginPage;

public class customertest extends basetest {
    
    @Test(priority = 1)
    public void TestCaes1() {
        String TCname = "TestCaes1";
        logger = extent.createTest(TCname);
        CP = new CustomerPage(driver, logger);
        CP.Login1(data.get(TCname).get("UserName"), data.get(TCname).get("Password"));
    }

    @Test(priority = 2)
    public void TestCaes2() {
        logger = extent.createTest("TestCaes2");
        CP = new CustomerPage(driver, logger);
        CP.Login2();
    }

    @Test(priority = 3)
    public void TestCases3() {
        logger = extent.createTest("TestCases3");
        CP = new CustomerPage(driver, logger);
        CP.customernavigate();
    }

    @Test(priority = 4)
    public void TestCaes4() {
        String TCname = "TestCaes4";
        logger = extent.createTest(TCname);
        CP = new CustomerPage(driver, logger);
        CP.customerdata(data.get(TCname).get("Customer code"));
    }
}
