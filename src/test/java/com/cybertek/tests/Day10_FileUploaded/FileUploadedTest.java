package com.cybertek.tests.Day10_FileUploaded;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileUploadedTest {
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
    public void test1(){
        driver.get("http://practice.cybertekSchool.com/upload");
        WebElement chooseFile = driver.findElement(By.xpath("//*[@name='file']"));

        String projectPath = System.getProperty("user.dir");//textile.txt dosy uzer saga tikla once copy sonra Absolute pathi tikla
        String filePath="src/test/resources/textfile.txt";//textile.txt dosy uzer saga tikla once copy sonrapath from content root
        String fullPath=projectPath+"/"+filePath;
        chooseFile.sendKeys(fullPath);

        //chooseFile.sendKeys("C:\\Users\\User\\Desktop\\futf.txt");
        driver.findElement(By.id("file-submit")).click();
        String fileUpload = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        System.out.println("fileUpload = " + fileUpload);
        Assert.assertEquals(fileUpload,"textfile.txt");

    }
    @Test
    public void test1Exercise() {
        driver.get("http://practice.cybertekSchool.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys("C:\\Users\\User\\Desktop\\futf.txt");
        WebElement upload1 = driver.findElement(By.id("file-submit"));
        upload1.click();

    }
}
