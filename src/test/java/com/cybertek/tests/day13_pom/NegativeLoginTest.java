package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){


        //driver.get(ConfigurationReader.get("url"));

        //String username=ConfigurationReader.get("driver_username");
        //String password=ConfigurationReader.get("driver_password");

        //driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("user1");
       // driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("somepassword"+ Keys.TAB);
       // driver.findElement(By.id("_submit")).click();
        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");


    }
    @Test
    public void wrongUserNameTest(){
        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("someUsername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void test1Exercise() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(6000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.equals("https://qa1.vytrack.com/user/login"));

    }
}
