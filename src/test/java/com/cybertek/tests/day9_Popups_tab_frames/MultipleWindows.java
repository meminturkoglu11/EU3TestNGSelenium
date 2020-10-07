package com.cybertek.tests.day9_Popups_tab_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void SwitchWindowTest() {
        driver.get("http://practice.cybertekSchool.com/windows");
        String beforeNewWindow = driver.getTitle();
        System.out.println("beforeNewWindow = " + beforeNewWindow);
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("afterNewWindow = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());
        String CurrentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String Handle : windowHandles) {
            if (!Handle.equalsIgnoreCase(CurrentWindowHandle)) {
                System.out.println("driver.switchTo().window(Handle).getTitle() = " + driver.switchTo().window(Handle).getTitle());
            }
        }
        System.out.println("driverCurrentTitle = " + driver.getTitle());
    }

    @Test
    public void moreThanTwoWindow() {
        driver.get("http://practice.cybertekSchool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("beforeSwitch = " + driver.getTitle());
        Set<String> windowHandle = driver.getWindowHandles();
        for (String handle : windowHandle) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("New Window")) {
                break;
            }

        }
        System.out.println("driver.getTitle() After Switch= " + driver.getTitle());
    }

    @Test
    public void SwitchWindowTestExercise() {
        driver.get("http://practice.cybertekSchool.com/windows");
        System.out.println("firstWebTitle = " + driver.getTitle());
        driver.findElement(By.cssSelector("[target='_blank']")).click();
        String newWebtitle = driver.getTitle();
        System.out.println("newWebtitle = " + newWebtitle);
        String windowHandle1 = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(windowHandle1)) {
                driver.switchTo().window(windowHandle);
            }

        }
        System.out.println("SecondWindowTitle = " + driver.getTitle());
    }

    @Test
    public void moreThanTwoWindowExercises() {
        driver.get("http://practice.cybertekSchool.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.findElement(By.partialLinkText("Click Here")).click();
        String current=driver.getWindowHandle();
        System.out.println("current = " + current);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(!windowHandle.equals(current)){
                break;
            }
        }
       /*driver.findElement(By.cssSelector("#content>div>h3~a")).click();
        Set<String> windows = driver.getWindowHandles();
       for (String window : windows) {
            driver.switchTo().window(window);
           if(driver.getTitle().equals("New Window")){

               break;
           }

        }

       */ System.out.println("newTitle() = " + driver.getTitle());
    }
}