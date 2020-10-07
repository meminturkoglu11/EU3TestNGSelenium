package com.cybertek.tests.Homework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ExerciseTable extends TestBase {
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Customers","Contacts");
        dashboardPage.waitUntilLoaderScreenDisappear();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[5]/td"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());

        }
    }
}
