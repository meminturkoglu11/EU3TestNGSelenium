package com.cybertek.tests.day8TypeofElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {
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
    public void test1() {
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("state"));
        Select StateDrop = new Select(dropdown);
        List<WebElement> options = StateDrop.getOptions();
        System.out.println("options.size() = " + options.size());
        for (WebElement option : options) {
            System.out.println("option = " + option.getText());
        }


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement StateSelectionButton = driver.findElement(By.id("state"));
        Select StateSelectionDrop = new Select(StateSelectionButton);
        String expectedOption = "Select a State";
        String ActualOption = StateSelectionDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(ActualOption, expectedOption, "if expected option equal actual option");
        StateSelectionDrop.selectByVisibleText("Virginia");
        expectedOption = "Virginia";
        ActualOption = StateSelectionDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(ActualOption, expectedOption, "expected option is equal actual option Virginia");
        Thread.sleep(3000);
        StateSelectionDrop.selectByIndex(51);
        System.out.println("StateSelectionDrop.getFirstSelectedOption().getText() = " + StateSelectionDrop.getFirstSelectedOption().getText());
        expectedOption = "Wyoming";
        ActualOption = StateSelectionDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(ActualOption, expectedOption, "expected option must equal Actual options Wyoming");
        StateSelectionDrop.selectByValue("TX");
        expectedOption = "Texas";
        ActualOption = StateSelectionDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(ActualOption, expectedOption, "if is is equal Texas");

    }

    @Test
    public void testExample() {
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement stateBox = driver.findElement(By.cssSelector("#state"));
        Select stateSelect=new Select(stateBox);
        List<WebElement> stateoptions = stateSelect.getOptions();
        for (WebElement state : stateoptions) {
            System.out.println("state.getText() = " + state.getText());
        }
        System.out.println("stateoptions.size() = " + stateoptions.size());
        String actualResult = stateSelect.getFirstSelectedOption().getText();
        String expectedResult = "Select a State";
        Assert.assertEquals(actualResult,expectedResult);
        stateSelect.selectByVisibleText("New York");
        stateSelect.selectByIndex(19);
        stateSelect.selectByValue("WA");
        String ActualResult1 = stateSelect.getFirstSelectedOption().getText();
        String expectedResult1 = "Washington";
        Assert.assertEquals(ActualResult1,expectedResult1);
    }
    @Test
    public void testExample1() {
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select select=new Select(year);
        select.selectByValue("1974");
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select select1=new Select(month);
        List<WebElement> monthOptions = select1.getOptions();
        for (WebElement monthOption : monthOptions) {
            System.out.println("monthOption.getText() = " + monthOption.getText());
        }
        System.out.println("monthOptions.get(2) = " + monthOptions.get(2).getText());
        select1.selectByIndex(2);
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select select2=new Select(day);
        select2.selectByVisibleText("8");
        WebElement state = driver.findElement(By.cssSelector("#state"));
        Select select3=new Select(state);
        select3.selectByIndex(5);
        driver.findElement(By.cssSelector("[value='java']")).click();
        driver.findElement(By.cssSelector("[id='dropdownMenuLink']")).click();

        driver.findElement(By.xpath("//a[text()='Amazon']")).click();

    }
    @Test
    public void testExercise3() {
        driver.get("http://practice.cybertekSchool.com/dropdown");
        WebElement option = driver.findElement(By.id("dropdown"));
        Select select=new Select(option);
        select.selectByVisibleText("Option 1");
        WebElement year = driver.findElement(By.id("year"));
       Select select1=new Select(year);
       select1.selectByValue("1974");
        WebElement month = driver.findElement(By.id("month"));
        Select select2=new Select(month);
       // select2.selectByVisibleText("March");
        List<WebElement> monthOptions = select2.getOptions();
        for (int i = 0; i < monthOptions.size(); i++) {
            System.out.println("monthOptions.get(i).getText() = " + monthOptions.get(i).getText());
        }
        System.out.println("monthOptions.get(2).getText() = " + monthOptions.get(2).getText());
        select2.selectByVisibleText(monthOptions.get(2).getText());
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select select3=new Select(day);
        select3.selectByVisibleText("8");
        List<WebElement> dayOptions = select3.getOptions();
        for (WebElement dayOption : dayOptions) {
            System.out.println("dayOption.getText() = " + dayOption.getText());
        }
        System.out.println(dayOptions.get(7).getText());
        WebElement state = driver.findElement(By.id("state"));
        Select select4=new Select(state);
        select4.selectByVisibleText("Washington");
        List<WebElement> stateOptions = select4.getOptions();
        for (WebElement stateOption : stateOptions) {
            System.out.println(stateOption.getText());
        }
        stateOptions.get(1).click();
        WebElement language = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select5=new Select(language);
        select5.selectByVisibleText("Java");
        List<WebElement> languages = select5.getOptions();
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(languages.get(i).getText());

        }
        languages.get(1).click();
        WebElement drpdownLink = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        drpdownLink.click();
        List<WebElement> webPage = driver.findElements(By.cssSelector(".dropdown-item"));
        for (int i = 0; i < webPage.size(); i++) {
            System.out.println(webPage.get(i).getText());

        }
        webPage.get(2).click();
    }
}