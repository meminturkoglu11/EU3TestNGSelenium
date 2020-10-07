package com.cybertek.tests.Homework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTableColumnName extends TestBase {
    @Test
    public void test(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Customers","Contacts");
        dashboardPage.waitUntilLoaderScreenDisappear();

        List<String> name=new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[2]"));
        for (int i = 1; i <= elements.size(); i++) {
            String text = driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
        name.add(text);

        }
        System.out.println(name.size());
    }
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Customers","Contacts");
        dashboardPage.waitUntilLoaderScreenDisappear();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[10]/td"));
        List<String> rowElements=new ArrayList<>();
        for (int i = 1; i <= elements.size(); i++) {
            String text = driver.findElement(By.xpath("//tr[10]/td["+i+"]")).getText();
            System.out.println(text);
            rowElements.add(text);

        }
        System.out.println(rowElements.size());
    }
    @Test
    public void test2(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Customers","Contacts");
        dashboardPage.waitUntilLoaderScreenDisappear();
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr"));
        List<WebElement> elements1 = driver.findElements(By.xpath("//tbody/tr/td"));

        for (int i = 1; i <= elements.size(); i++) {
            for (int j = 1; j <= elements1.size(); j++) {

                System.out.println(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[" + j + "]")).getText());
            }

        }
    }

}
