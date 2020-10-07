package com.cybertek.tests.day9_Popups_tab_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p")).sendKeys("MikeSmith with ID");
        //driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with ID");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//p")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p")).sendKeys("MikeSmith with INDEX");
        driver.findElement(By.id("tinymce")).clear();
        driver.switchTo().parentFrame();
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with WEBELEMENT");

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekSchool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.id(\"content\")).getText() = " + driver.findElement(By.id("content")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.name("frame-left")));
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());


    }

    @Test
    public void test1Exercises() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/iframe");
        driver.switchTo().frame("mce_0_ifr");//iframi 3 yolla kullniyoruz.1.si switchTo.frame(by id or by name)
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).clear();//Text your content here daha sonra silindigi icin xpath-text olmaz
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith ");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();//her defasinda yeni bir mesaj icin parenta gidip oyle mesaji gonderebiliyoruz
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        // driver.findElement(By.cssSelector("#tinymce>p")).sendKeys("hello");
        driver.switchTo().parentFrame();
        WebElement iframeElemnt = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElemnt);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Hello Word");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.cssSelector("#tinymce")).clear();

    }

    @Test
    public void test2Exercise() {
        driver.get("http://practice.cybertekSchool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        WebElement left = driver.findElement(By.cssSelector("[src='/frame_left']"));
        driver.switchTo().frame(left);
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
       driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
    @Test
    public void Exercise3(){
        driver.get("http://practice.cybertekschool.com/frames");

    }
    @Test
    public void Exercise4() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/frames");
        driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p")).clear();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//p")).sendKeys("Hello");


    }
}