package com.cybertek.tests.day2_webdriverbasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        driver.navigate().to("http://www.facebook.com");

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(4000);
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.navigate().refresh();
    }
}
