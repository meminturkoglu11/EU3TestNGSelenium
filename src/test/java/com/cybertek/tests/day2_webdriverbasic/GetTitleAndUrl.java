package com.cybertek.tests.day2_webdriverbasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
