package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chromeDriver");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));//dynamic id with xpath
        driver.findElement(By.cssSelector("button[id^='button']"));//dynamic id with css
        //WebElement dontclick=driver.findElements(By.cssSelector("button#disappearing_button"));


    }
}
