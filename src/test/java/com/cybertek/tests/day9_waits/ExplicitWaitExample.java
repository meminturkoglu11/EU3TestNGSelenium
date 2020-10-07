package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
         wait=new WebDriverWait(driver,10);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekSchool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));

        wait.until(ExpectedConditions.visibilityOf(usernameInput));
       usernameInput.sendKeys("MikeSmith");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekSchool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
        WebElement enableBox= driver.findElement(By.cssSelector("#input-example>input"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(enableBox));
        enableBox.sendKeys("MikeSmith");
    }
}
