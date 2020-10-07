package com.cybertek.tests.day7_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {
    @Test
    public  void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkBox1= driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(1)"));
        WebElement checkBox2=driver.findElement(By.xpath("//input[2]"));
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());
        Assert.assertFalse(checkBox1.isSelected(),"box 1 is not selected");
        Assert.assertTrue(checkBox2.isSelected(),"box 2 is selected");
        Thread.sleep(2000);
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected(),"box1 is selected");
        Assert.assertTrue(checkBox2.isSelected(),"box2 is not selected");
        Thread.sleep(2000);
      //  driver.quit();
    }@Test
    public void example(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement box1 = driver.findElement(By.xpath("//form/input[1]"));
        WebElement box2 = driver.findElement(By.xpath("//form/input[2]"));
        System.out.println("box1.isSelected() = " + box1.isSelected());
        System.out.println("box2.isSelected() = " + box2.isSelected());
        Assert.assertFalse(box1.isSelected());
        Assert.assertTrue(box2.isSelected());
        box1.click();
        Assert.assertTrue(box1.isSelected());
        Assert.assertTrue(box2.isSelected());

       /* WebElement check1= driver.findElement(By.xpath("//input[1]"));
        WebElement check2= driver.findElement(By.xpath("//input[2]"));
        System.out.println("check1.isSelected() = " + check1.isSelected());
        System.out.println("check2.isSelected() = " + check2.isSelected());
        Assert.assertFalse(check1.isSelected(),"check1 is not selected");
        Assert.assertTrue(check2.isSelected(),"ceck 2 is selected");
        check1.click();
        Assert.assertTrue(check1.isSelected(),"check1 is not selected");
        Assert.assertTrue(check2.isSelected(),"ceck 2 is selected");*/


    }

}
