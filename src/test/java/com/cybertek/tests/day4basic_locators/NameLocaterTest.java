package com.cybertek.tests.day4basic_locators;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class NameLocaterTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("mike smith");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");
        Thread.sleep(2000);
        driver.findElement(By.name("wooden_spoon")).click();
    }
}
