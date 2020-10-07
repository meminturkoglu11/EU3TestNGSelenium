package com.cybertek.tests.day4basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
       // WebElement dontclickButton= driver.findElement(By.id("disappearing_button"));
      //dontclickButton.click();
        Thread.sleep(2000);
      driver.findElement(By.id("disappearing_button")).click();
    }

}