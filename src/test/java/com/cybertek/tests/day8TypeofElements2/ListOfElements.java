package com.cybertek.tests.day8TypeofElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekSchool.com/multiple_buttons");
        List<WebElement> button = driver.findElements(By.tagName("button"));
        System.out.println("button.size() = " + button.size());
        Assert.assertEquals(button.size(), 6, "button size expected equal 6");
        for (WebElement buttonnumber : button) {
            System.out.println(buttonnumber.getText());
            System.out.println(buttonnumber.isDisplayed());
            Assert.assertTrue(buttonnumber.isDisplayed());
        }
        button.get(1).click();

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekSchool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("dklmn"));
        System.out.println("buttons.size() = " + buttons.size());
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        System.out.println("buttons.size() = " + buttons.size());
        Assert.assertEquals(buttons.size(),6);
        for (WebElement button : buttons) {
            System.out.println("button.getText() = " + button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed());
        }
        System.out.println("buttons.get(1).getText() = " + buttons.get(1).getText());
        Thread.sleep(3000);
        buttons.get(0).click();
    }
}