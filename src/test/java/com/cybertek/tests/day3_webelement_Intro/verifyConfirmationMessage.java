package com.cybertek.tests.day3_webelement_Intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("ChromeDriver");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox=driver.findElement(By.name("email"));
        String expectedemail="abc@gmail.com";
        emailInputBox.sendKeys(expectedemail);
        String actualemail = emailInputBox.getAttribute("value");
        System.out.println("actualemail = " + actualemail);
        if(expectedemail.equals(actualemail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        WebElement actualConfirmationMessage=driver.findElement(By.name("confirmation_message"));
        String actualMessage = actualConfirmationMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage="Your e-mail's been sent!";
        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);

        }
        Thread.sleep(3000);
        driver.quit();
    }

}
