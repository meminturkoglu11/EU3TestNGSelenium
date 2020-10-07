package com.cybertek.tests.day7_TypesOfElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
       WebElement blueButton=driver.findElement(By.cssSelector("#blue"));
        String blueButtonAttribute = blueButton.getAttribute("value");
        System.out.println("blueButtonAttribute = " + blueButtonAttribute);
        System.out.println("blueButton.getAttribute(\"type\") = " + blueButton.getAttribute("type"));
        System.out.println("blueButton.getAttribute(\"name\") = " + blueButton.getAttribute("name"));
        System.out.println("blueButton.getAttribute(\"checked\") = " + blueButton.getAttribute("checked"));
        System.out.println("blueButton.getAttribute(\"hrf\") = " + blueButton.getAttribute("hrf"));
        System.out.println("blueButton.getAttribute(\"outerHTML\") = " + blueButton.getAttribute("outerHTML"));
       driver.get("http://practice.cybertekschool.com/multiple_buttons");
       WebElement button2= driver.findElement(By.name("button2"));
        System.out.println("button2.getAttribute(\"outerHTML\") = " + button2.getAttribute("outerHTML"));
        System.out.println("button2.getAttribute(\"innerHTML\") = " + button2.getAttribute("innerHTML"));
        String outerHtml = button2.getAttribute("outerHTML");
        System.out.println("outerHtml = " + outerHtml);
        Assert.assertTrue(outerHtml.contains("Button 2"),"outerHTml includes button2");

    }
    @Test
    public void example(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
       /* String blueButton = driver.findElement(By.xpath("//input[@id='blue']/../label")).getText();
        System.out.println("blueButton = " + blueButton);
        System.out.println(driver.findElement(By.cssSelector("#blue")).getAttribute("type"));*/
        WebElement redButton = driver.findElement(By.id("red"));
        redButton.click();
        System.out.println("redButton.getAttribute(\"checked\") = " + redButton.getAttribute("checked"));
        System.out.println("redButton.getAttribute(\"id\") = " + redButton.getAttribute("id"));
        System.out.println("redButton.getAttribute(\"rel\") = " + redButton.getAttribute("rel"));
        System.out.println("redButton.getAttribute(\"outerHTML\") = " + redButton.getAttribute("outerHTML"));
        System.out.println("redButton.getAttribute(\"innerHTML\") = " + redButton.getAttribute("innerHTML"));
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.cssSelector("[onclick='button2()']"));
        System.out.println("button2.getAttribute(\"outerHTML\") = " + button2.getAttribute("outerHTML"));
        System.out.println("button2.getAttribute(\"innerHTML\") = " + button2.getAttribute("innerHTML"));
        System.out.println("button2.getText() = " + button2.getText());
        Assert.assertTrue(button2.getText().contains("Button 2"));


    }
}
