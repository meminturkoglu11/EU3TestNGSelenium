package com.cybertek.tests.Homework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JamalHomework1 extends TestBase {
    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();

        extentLogger= report.createTest("Find customer fullname and email");

        extentLogger.info("Login as a sales manager");
        loginPage.loginAsSalesManager();

        DashboardPage dashboardPage=new DashboardPage();

        extentLogger.info("Go to Customer Contacts page");
        dashboardPage.navigateToModule("Customers","Contacts");
        dashboardPage.waitUntilLoaderScreenDisappear();
        String email="'mbrackstone9'";
        String name="//td[contains(text(),'mbrackstone9')]/../td[2]";
        String Surname="//td[contains(text(),'mbrackstone9')]/../td[3]";

        extentLogger.info("Click on the customer mail");
        driver.findElement(By.xpath("//td[contains(text(),"+email+")]")).click();

        extentLogger.info("Get Fullname of the Customer");
        String fullname = driver.findElement(By.xpath("//h1[@class='user-name']")).getText();

        extentLogger.info("Confirm that full name equals Mariam Brackstone");
        Assert.assertEquals(fullname,"Mariam Brackstone");

        extentLogger.info("get the customer email address");
        String email1=driver.findElement(By.xpath("//a[@class='email']")).getText();

        extentLogger.info("Confirm that email is equal mbrackstone9@example.com");
        Assert.assertEquals(email1,"mbrackstone9@example.com");

        extentLogger.info("get the customer telf number");
        String telfnum=driver.findElement(By.xpath("//a[@class='phone']")).getText();

        extentLogger.info("Confirm custumor telf num is equal +18982323434");
        Assert.assertEquals(telfnum,"+18982323434");

        extentLogger.pass("PASSED");
    }
}