package com.cybertek.tests.day2_webdriverbasic;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        Thread.sleep(4000);
        driver.close();

        driver=new ChromeDriver();
        driver.navigate().to("http://www.facebook.com");
        Thread.sleep(3000);
        driver.quit();

    }
}
