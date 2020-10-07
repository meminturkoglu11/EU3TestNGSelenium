package com.cybertek.tests.Day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @Test
    public void hoovertest() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();

        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        Thread.sleep(2000);
        actions.moveToElement(img2).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(), "verify that view link is displayed");
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

       /* List<WebElement> AcceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));

        if(AcceptAndClose.size()>0){
            AcceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }*/


        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }

    @Test
    public void hoovertestExercise() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/hovers");
        WebElement img1 = driver.findElement(By.cssSelector("[alt='User Avatar']"));
        Actions actions = new Actions(driver);
        //actions.moveToElement(img1).perform();
        List<WebElement> names = driver.findElements(By.xpath("//h5"));
        List<WebElement> imgs = driver.findElements(By.cssSelector("[alt='User Avatar']"));
        for (int i = 0; i < names.size(); i++) {
            actions.moveToElement(imgs.get(i)).perform();
            Thread.sleep(2000);

            Assert.assertTrue(names.get(i).isDisplayed());

        }


    }

    @Test
    public void hoovertestExercise1() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/hovers");
        List<WebElement> elements = driver.findElements(By.cssSelector("[alt='User Avatar']"));
        List<WebElement> elements1 = driver.findElements(By.xpath("//h5"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < elements1.size(); i++) {
            actions.moveToElement(elements.get(i)).perform();
            System.out.println(elements1.get(i).getText());
            Assert.assertTrue(elements1.get(i).isDisplayed());
        }

    }

    @Test
    public void multipleButtonsExercise() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/multiple_buttons");
        List<WebElement> elements = driver.findElements(By.xpath("//button"));
        List<WebElement> elements1 = driver.findElements(By.cssSelector(".col-4.col-md-4>h4~p"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            //System.out.println(elements1.get(i).getText());

        }
    }
    @Test
    public void testExerciseOmer() {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-primary"));
        ArrayList<String> a = new ArrayList<>();
        a.add("one!");
        a.add("two!");
        a.add("three!");
        a.add("four!");
        a.add("five!");

        for (int j = 0; j < elements.size(); j++) {
            elements.get(j).click();
            WebElement result = driver.findElement(By.id("result"));
            System.out.println(result.getText());
            if (j == 5) {
                Assert.assertEquals(result.getText(), "Now it's gone!");
                break;
            }
            Assert.assertEquals(result.getText(), "Clicked on button " + a.get(j));
        }
    }
}