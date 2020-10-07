package com.cybertek.tests.Day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
    @Test
    public void clickWithJS(){
      driver.get("http://practice.cybertekSchool.com/");
        WebElement  dropdownButton= driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", dropdownButton);
    }
    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekSchool.com/dynamic_controls");
        WebElement inputbox = driver.findElement(By.cssSelector("[type='text']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
       String sendkeys="Hello Disabled Input";
        jse.executeScript("arguments[0].setAttribute('value', '" + sendkeys +"')", inputbox);


    }
    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,250)");
            Thread.sleep(2000);
        }
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,-250)");
            Thread.sleep(2000);


        }

    }
    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement element = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);

    }
}
