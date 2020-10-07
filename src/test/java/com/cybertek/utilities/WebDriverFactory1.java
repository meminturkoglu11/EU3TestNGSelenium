package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory1 {
    public static WebDriver getDriver1(String browserType){
        WebDriver driver=null;
        switch(browserType.toLowerCase()){
            case "chrome":
            WebDriverManager.chromedriver().setup();
           driver=new ChromeDriver();
           break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }return driver;
    }
}
