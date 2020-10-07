package com.cybertek.tests.day2_webdriverbasic;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {
        WebDriver driver=WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);
    }
}
