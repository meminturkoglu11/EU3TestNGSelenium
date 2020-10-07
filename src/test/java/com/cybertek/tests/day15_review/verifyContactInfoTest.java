package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
   @Test
    public void contactDetailsTest(){
       extentLogger=report.createTest("Contact info verification");
       LoginPage loginPage=new LoginPage();
       String username= ConfigurationReader.get("salesmanager_username");
       String password=ConfigurationReader.get("salesmanager_password");
       extentLogger.info("Login as a sales manager");
       loginPage.login(username,password);
       extentLogger.info("Navigate to---> Customers--->Contacts");
       new DashboardPage().navigateToModule("Customers","Contacts");
       ContactsPage contactsPage=new ContactsPage();
       contactsPage.waitUntilLoaderScreenDisappear();
       extentLogger.info("Click on mbrackstone9@example.com");
       contactsPage.getContactEmail("mbrackstone9@example.com").click();

       ContactInfoPage contactInfoPage=new ContactInfoPage();
       String expectedfullname="Mariam Brackstone";
       String actualfullname=contactInfoPage.fullname.getText();
       extentLogger.info("verify fullname is"+expectedfullname);
       Assert.assertEquals(actualfullname,expectedfullname);
       extentLogger.info("verify email is mbrackstone9@example.com");
       Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com");
       extentLogger.info("verify phone number is +18982323434");
       Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434");
       extentLogger.pass("PASSED");


   }
}
