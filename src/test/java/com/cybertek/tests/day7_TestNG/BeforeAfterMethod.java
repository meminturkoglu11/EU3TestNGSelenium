package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("Executed one times before class");
    }
    @Test
    public  void test1(){
        System.out.println("First test case");
    }

    @Test
    public  void test2(){
        System.out.println("Second test case");
    }
    @BeforeMethod
    public void setup(){
        System.out.println("WebDriver opening Browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser,Quit");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("Sam reporting code here");
    }
}
