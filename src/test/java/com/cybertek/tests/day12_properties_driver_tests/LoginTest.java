package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{


@Test
    public void OpenBrowserWithConf(){


        driver.get(ConfigurationReader.get("url"));

        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");

        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(username);
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys(password);


    }
}
