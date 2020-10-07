package com.cybertek.tests.day2_webdriverbasic;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebDriverFactory1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory1 {
    public static void main(String[] args) {
       WebDriver driver=WebDriverFactory1.getDriver1("ChromeDriver");
       driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);

         driver=WebDriverFactory1.getDriver1("FireFoxDriver");
        driver.get("http://www.facebook.com.tr");
        String title1 = driver.getTitle();
        System.out.println("title1 = " + title1);
    }
}
