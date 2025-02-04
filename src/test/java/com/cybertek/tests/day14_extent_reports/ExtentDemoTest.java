package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {
    //this class is used for starting and building reports
    ExtentReports report;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test,enables adding logs,outhors,test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
        //initialize the class
        report=new ExtentReports();

        //create report path
        String projectpath=System.getProperty("user.dir");
        System.out.println("projectpath = " + projectpath);
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
    @Test
    public void test1(){
        //give name to current test
        extentLogger=report.createTest("TC123 Login as driver Test");

        //test steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to this URL");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click login");

        extentLogger.info("Verify logged in");

        //pass()---->marks the test case as passed
        extentLogger.pass("TC123 is passed");

    }
    @AfterMethod
    public  void teardown(){
        //this is when the report is actually created
        report.flush();
    }
}
