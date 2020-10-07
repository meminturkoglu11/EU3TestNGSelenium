package com.cybertek.tests.day13_pom;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class PositiveLoginTest extends TestBase {
    @Test
    public void loginAsDriver(){
        LoginPage loginPage=new LoginPage();
      /*  String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();*/
        loginPage.loginAsDriver();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();
    }
    @Test
    public void loginAsSalesManager(){
        LoginPage loginPage=new LoginPage();
        loginPage.login("user1","UserUser123");
    }
   @Test
    public void asLoginStoreManager(){
       String storemanager_username = ConfigurationReader.get("storemanager_username");
       String storemanager_password = ConfigurationReader.get("storemanager_password");
       LoginPage loginPage=new LoginPage();
       loginPage.login(storemanager_username,storemanager_password);
       Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

   }
   @Test
    public void loginAsStoreManager2(){
     LoginPage loginPage=new LoginPage();
     loginPage.loginAsStoreManager();
     Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

   }
   @Test
    public void testExercise(){
       LoginPage loginPage=new LoginPage();
       loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));
   }
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
   @Test
    public void testExercise2() throws InterruptedException {
LoginPage loginPage=new LoginPage();
loginPage.loginAsStoreManager();
DashboardPage dashboardPage=new DashboardPage();
dashboardPage.navigateToModule("Customer","Contacts");
WebElement mail = driver.findElement(By.xpath("(//a[@href='/contact/view/14'])[2]"));
Thread.sleep(5000);
       //WebElement mail = driver.findElement(By.xpath("//tbody/tr[5]/td[@data-column-label='Email']"));
       mail.click();
   }
  /* @Test
    public void testExercise3(){
       extentLogger=report.createTest("Name,phone number, email compare ");
       LoginPage loginPage=new LoginPage();
       loginPage.loginAsSalesManager();
       DashBoardPage dashBoardPage=new DashBoardPage();
       extentLogger.info("Click Customers tab and Contacts Module");
       dashBoardPage.navigateToModule("Customers","Contacts");
       extentLogger.info("Locate    'mbrackstone9@example.com'   e mail ");
       Thread.sleep(4000);
       Driver.get().findElement(By.xpath("//tbody/tr[5]/td[@data-column-label='Email']")).click();
       String expectedName="Mariam Brackstone";
       extentLogger.info("Get text contatct name");
       String actualName =Driver.get().findElement(By.xpath("//h1[@class='user-name']")).getText();
       extentLogger.info("verify the name");
       Assert.assertEquals(actualName,expectedName);
       String expectedEmail="mbrackstone9@example.com";
       String actualEmail = Driver.get().findElement(By.xpath("//a[@class='email']")).getText();
       extentLogger.info("verify the email");
       Assert.assertEquals(actualEmail,expectedEmail);
       String expectedphoneNumber="+18982323434";
       extentLogger.info("Get phne number");
       String actualPhoneNumber = Driver.get().findElement(By.xpath("//a[@class='phone']")).getText();
       extentLogger.info("Compare phone number");
       Assert.assertEquals(actualPhoneNumber,expectedphoneNumber);
       extentLogger.pass("name, email,phone compare passed");
   }*/
}
