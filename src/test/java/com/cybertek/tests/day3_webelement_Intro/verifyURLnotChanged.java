package com.cybertek.tests.day3_webelement_Intro;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.PasswordView;

public class verifyURLnotChanged {
    public static void main(String[] args) throws InterruptedException {
        /*Verify URL not changed
        open browser
        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        click on Retrieve password
        verify that url did not change
        Verify URL changed
        open browser
        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
        Verify confirmation message
        open browser
        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says ‘Your e-mail’s been sent!’   */
        WebDriver driver= WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://practice.cybertekschool.com/forgot_password ");
        String expectedurl= driver.getCurrentUrl();
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();


        String actualUrl= driver.getCurrentUrl();
        if(expectedurl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
