package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType){
        WebDriver driver=null;
        if(browserType.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        return driver;
    }
}
