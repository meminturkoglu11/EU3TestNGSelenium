package com.cybertek.tests.day12_properties_driver_tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
   protected WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;
   protected ExtentReports report;
   protected ExtentHtmlReporter htmlReporter;
   protected ExtentTest extentLogger;

   @BeforeTest
   public void setupTest(){
       //initialize the class
       report=new ExtentReports();

       //create report path
       String projectpath=System.getProperty("user.dir");
       String path=projectpath+"/test-output/report.html";

       //initialize the html reporter with the report path
       htmlReporter=new ExtentHtmlReporter(path);

       //attach the html report to report object
       report.attachReporter(htmlReporter);

       //title in report
       htmlReporter.config().setReportName("Vytrack Smoke Test");

       //set enviroment information
       report.setSystemInfo("Enviroment","QA");
       report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
       report.setSystemInfo("OS",System.getProperty("os.name"));
   }

    @BeforeMethod
     public void setup() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));


    }

    @AfterMethod
    public void teardown(ITestResult result) throws InterruptedException, IOException {
       //if test fails
        if(result.getStatus()== ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }
        Thread.sleep(5000);
        //Driver.closeDriver();
    }
    @AfterTest
    public  void teardownTest(){
        //this is when the report is actually created
        report.flush();
    }
}
