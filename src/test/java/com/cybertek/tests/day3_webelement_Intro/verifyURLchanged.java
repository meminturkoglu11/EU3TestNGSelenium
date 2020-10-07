package com.cybertek.tests.day3_webelement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {



    public static void main(String[] args) throws InterruptedException {
    /* Verify URL changed
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
    */
    WebDriver driver=WebDriverFactory.getDriver("ChromeDriver");
    driver.get("http://practice.cybertekschool.com/forgot_password");
    WebElement emailInputBox=driver.findElement(By.name("email"));
    emailInputBox.sendKeys("abc@gmail.com");

    WebElement retrievePasswordButton= driver.findElement(By.id("form_submit"));
    retrievePasswordButton.click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        String actualUrl=driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("currentUrl = " + currentUrl);
        }
        driver.quit();

    }
}