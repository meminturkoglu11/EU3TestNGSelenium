package com.cybertek.tests.day9_Popups_tab_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PopupAndAlerts {
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
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
        driver.findElement(By.xpath("//button[.='No']")).click();
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekSchool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        //Alert alert1=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        alert.sendKeys("Malatya");
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

    }

    @Test
    public void test2Exercises() throws InterruptedException {

        driver.get("http://practice.cybertekSchool.com/javascript_alerts");
        List<WebElement> alertsButtons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        alertsButtons.get(0).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        alertsButtons.get(1).click();
        Thread.sleep(2000);
        alert.dismiss();
        alertsButtons.get(2).click();
        Thread.sleep(2000);
        alert.sendKeys("I like UK");
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

    }

    @Test
    public void test2Exercises2() throws InterruptedException {

        driver.get("http://practice.cybertekSchool.com/javascript_alerts");
        List<WebElement> alertButton = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for (int i = 0; i < alertButton.size(); i++) {
            alertButton.get(i).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(2000);


        }
    }
    @Test
    public void test2Exercises3() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/javascript_alerts");
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        Alert alert1=driver.switchTo().alert();
        alert1.dismiss();
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        Alert alert2=driver.switchTo().alert();
        alert2.sendKeys("Mike Smith");
        alert2.accept();

}}