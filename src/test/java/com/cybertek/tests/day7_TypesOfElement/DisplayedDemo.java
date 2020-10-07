package com.cybertek.tests.day7_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
            public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement usernameInput=driver.findElement(By.cssSelector("#username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        //Assert.assertTrue(usernameInput.isDisplayed(),"username input is displayed");
        // usernameInput.sendKeys("some keys");
        WebElement startButton= driver.findElement(By.cssSelector("#start>button"));
        Thread.sleep(2000);
        startButton.click();
        Thread.sleep(5000);
        Assert.assertTrue( usernameInput.isDisplayed(),"username is displayed");
        //Assert.assertFalse(usernameInput.isDisplayed(),"username button is not displayed");
    }@Test
    public void example() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username= driver.findElement(By.cssSelector("#username"));
        Assert.assertFalse(username.isDisplayed(),"username is not display");
       // driver.findElement(By.xpath("//div[@id='start']/button")).click();
      WebElement user=  driver.findElement(By.cssSelector(".btn.btn-primary"));
      user.click();
        Thread.sleep(7000);
      username.sendKeys("Mike Smith");
       String actual = username.getAttribute("value");
        String excpected="Mike Smith";
       Assert.assertEquals(actual,excpected);
        Assert.assertTrue(actual.contains(excpected));
    }
}
