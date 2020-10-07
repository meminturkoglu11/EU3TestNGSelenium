package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest(){

        //name of the test
        extentLogger=report.createTest("Wrong Password Test");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter Username:user1");
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter password:somepassword");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        //Assert.assertTrue(driver.getCurrentUrl().equals("https://qa1.vytrack.com/user/login"));
        extentLogger.pass("Wrong password Test is PASSED");


    }
    @Test
    public void wrongUserNameTest(){
        //name of the test
        extentLogger=report.createTest("Wrong Username Test");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter Username:someUsername");
        loginPage.usernameInput.sendKeys("someUsername");
        extentLogger.info("Enter password:UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("PASSED");
    }
}
