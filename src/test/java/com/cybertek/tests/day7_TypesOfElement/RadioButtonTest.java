package com.cybertek.tests.day7_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public  void  test1() throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement radioButtonBlue= driver.findElement(By.cssSelector("#blue"));
        WebElement radioButtonRed= driver.findElement(By.cssSelector("#red"));
        System.out.println("radioButtonBlue.isSelected() = " + radioButtonBlue.isSelected());
        System.out.println("radioButtonRed.isSelected() = " + radioButtonRed.isSelected());
        Thread.sleep(3000);
        Assert.assertTrue(radioButtonBlue.isSelected(),"verify blue button selected");
        Assert.assertFalse(radioButtonRed.isSelected(),"verify red button not selected");
        radioButtonRed.click();
        Thread.sleep(3000);
        Assert.assertTrue(radioButtonBlue.isSelected(),"verify blue button selected");
        Assert.assertFalse(radioButtonRed.isSelected(),"verify red button not selected");
        driver.quit();
    }@Test
    public void example(){
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blue= driver.findElement(By.cssSelector("#blue"));
        WebElement red= driver.findElement(By.cssSelector("#red"));
        System.out.println("blue.isSelected() = " + blue.isSelected());
        System.out.println("red.isSelected() = " + red.isSelected());
        red.click();
        Assert.assertTrue(red.isSelected(),"red is selected");
        Assert.assertFalse(blue.isSelected(),"blue is not selected");

    }

}
