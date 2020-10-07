package com.cybertek.tests.day11;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekSchool.com/tables");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }
    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println( table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }
    @Test
    public void getAllHeaders(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("elements.size() = " + elements.size());
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
        List<WebElement> elements1 = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("elements1.size() = " + elements1.size());

        List<WebElement> elements2 = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println("elements2.size() = " + elements2.size());
    }
    @Test
    public void getRow(){
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[2]")).getText());
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        for (int i = 1; i <= elements.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]")).getText());

        }
    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[1]/td"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void getASingleCell(){
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[3]/td[5]")).getText());
    }
    @Test
    public void printAllCellByIndex(){
        int rowNumber=getNumberOfRows();
        int colNumber=getNumberOfColums();
        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= colNumber; j++) {

        String cellXPath="//table[@id='table1']//tbody/tr["+i+"]/td["+j+"]";
                System.out.println("cellXPath = " + cellXPath);
                WebElement cell = driver.findElement(By.xpath(cellXPath));
                System.out.println(cell.getText());
            }
        }

    }
    private int getNumberOfColums(){
        List<WebElement> column = driver.findElements(By.xpath("//table[@id='table1']//th"));
        int ColumnSize = column.size();
        return ColumnSize;
    }
    private int getNumberOfRows(){
        List<WebElement> rowWithoutHead = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        int Rowsize = rowWithoutHead.size();
        return Rowsize;
    }
    @Test
    public void getCellInRelationToAnotherCellInRow(){
        String  firstname="Jason";
        String xpath="//table[@id='table1']//td[.=''"+firstname+"'']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println("email.getText() = " + email.getText());



    }
    @Test
    public void table1Exercise(){
        String table1 = driver.findElement(By.id("table1")).getText();
        Assert.assertTrue(table1.contains("John"));
        List<WebElement> column = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("column.size() = " + column.size());
        for (WebElement webElement : column) {
            System.out.println(webElement.getText());
        }
        List<WebElement> headrows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        for (WebElement headrow : headrows) {
            System.out.println(headrow.getText());
        }
        System.out.println("========================================");
        List<WebElement> bodyrow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 0; i < bodyrow.size(); i++) {
            System.out.println(bodyrow.get(i).getText());

        }
        List<WebElement> firstnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        for (WebElement firstname : firstnames) {
            System.out.println(firstname.getText());
        }
        for (int i = 1; i <= firstnames.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]")).getText());

        }
        System.out.println("====================================");
        List<WebElement> secondrowCells = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[2]/td"));
        for (WebElement secondrowCell : secondrowCells) {
            System.out.println(secondrowCell.getText());
        }
    }

}