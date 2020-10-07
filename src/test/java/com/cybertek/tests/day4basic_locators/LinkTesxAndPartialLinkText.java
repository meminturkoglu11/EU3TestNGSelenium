package com.cybertek.tests.day4basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTesxAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("ChromeDriver");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
       // WebElement link1Click=driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));

       // link1Click.click();
        //WebElement Link4Click=driver.findElement(By.partialLinkText("Example 4:"));
        //Thread.sleep(2000);
       // Link4Click.click();
        WebElement DynamicText= driver.findElement(By.partialLinkText("Dynamically Loaded Page Elements"));
        System.out.println("DynamicText = " + DynamicText);


    }
}
