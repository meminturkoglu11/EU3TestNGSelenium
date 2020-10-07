package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class day5_basic_locator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.amazon.com");
       //driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //driver.findElement(By.xpath("/html/body/nav/ul/li/a")).click();
       // driver.findElement(By.xpath("/html/body/div/div/div/div/button[3]")).click();
        //driver.findElement(By.xpath("//button[@onclick='button2()']")).click();
       // driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
    }
}
