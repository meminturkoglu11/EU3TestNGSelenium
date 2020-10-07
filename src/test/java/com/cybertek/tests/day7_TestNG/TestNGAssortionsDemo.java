package com.cybertek.tests.day7_TestNG;

import com.google.gson.internal.$Gson$Preconditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssortionsDemo {
    @BeforeMethod
    public void setup(){
        System.out.println("Open the browser");
    }
    @Test
    public void test1(){

        System.out.println("First assertion");
        Assert.assertEquals("title","title ");
        System.out.println("Second assertion");
        Assert.assertEquals("url","url");


    }
    @Test
    public void test2(){
       Assert.assertEquals("test2","test2");
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        String expectedTitle="cyp";
        String actualTitle="cybertek";
       Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify titles start with");
    }
    @Test
    public void test4(){
        String email="mike@smith.com";
        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }
    @Test
    public  void test5(){
        Assert.assertFalse(2>1,"verify that 0 is not greater than 1");
    }
    @Test
    public  void test6(){
        Assert.assertNotEquals("one","one");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close the browser");
    }
}
