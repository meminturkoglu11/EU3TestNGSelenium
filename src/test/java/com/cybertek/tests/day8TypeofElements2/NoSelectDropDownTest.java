package com.cybertek.tests.day8TypeofElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDownTest {
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
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement selectButton = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        selectButton.click();
        List<WebElement> DropDownOptions = driver.findElements(By.className("dropdown-item"));
        System.out.println("DropDownOptions.size() = " + DropDownOptions.size());
        for (WebElement webElement : DropDownOptions) {
            System.out.println("webElement.getText() = " + webElement.getText());

        }
        Assert.assertEquals(DropDownOptions.size(), 5, " size must be 5");
        // DropDownOptions.get(2).click();


    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement web = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        web.click();
        List<WebElement> Webpage = driver.findElements(By.cssSelector(".dropdown-item"));
        for (WebElement webElement : Webpage) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }
    Select s=new Select(web);

    }
}