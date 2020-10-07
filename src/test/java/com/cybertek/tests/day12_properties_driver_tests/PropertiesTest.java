package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void test1(){
       String browserType= ConfigurationReader.get("browser");
        WebDriver driver= WebDriverFactory.getDriver(browserType);
        System.out.println("browserType = " + browserType);

        String url=ConfigurationReader.get("url");
        driver.get(url);
    }
    @Test
    public void test2(){
        WebDriver driver=WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(username);
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys(password);

        WebDriver driver1=WebDriverFactory.getDriver("chrome");
        driver1.get("http://google.com");
        WebDriver driver2=WebDriverFactory.getDriver("firefox");
    }
}
