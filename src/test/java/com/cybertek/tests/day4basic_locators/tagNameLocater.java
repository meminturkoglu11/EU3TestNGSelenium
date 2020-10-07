package com.cybertek.tests.day4basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocater {
    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().maximize();
        driver.findElement(By.tagName("input")).sendKeys("mike smith");
        //driver.findElement(By.tagName("input")).sendKeys("mike@smith.com");
        driver.findElement(By.tagName("button")).click();
        driver.quit();
    }
}
