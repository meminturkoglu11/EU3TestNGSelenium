package com.cybertek.tests.day7_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElement {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        WebElement greenBuutton = driver.findElement(By.cssSelector("#green"));
        System.out.println("greenBuutton.isEnabled() = " + greenBuutton.isEnabled());
        Assert.assertFalse(greenBuutton.isEnabled());
        Assert.assertTrue(greenBuutton.isEnabled());
        greenBuutton.click();
    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement enableBox = driver.findElement(By.xpath("//input[@type='text']"));
        enableBox.sendKeys("some message");


    }

    @Test
    public void testExercise1() {
        //WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement green = driver.findElement(By.id("green"));
        System.out.println("green.isEnabled() = " + green.isEnabled());
        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(green.isDisplayed());
        green.click();
    }

    @Test
    public void testExercise2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement EnableBox = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("EnableBox.isEnabled() = " + EnableBox.isEnabled());

        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        Thread.sleep(5000);
        EnableBox.sendKeys("send message");
    }
}