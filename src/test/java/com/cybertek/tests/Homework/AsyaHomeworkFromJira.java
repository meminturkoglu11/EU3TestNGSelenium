package com.cybertek.tests.Homework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehicleContractPage$$;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsyaHomeworkFromJira extends TestBase {
@Test
    public void test1() throws InterruptedException {
    //extentLogger=report.createTest("Name,phone number, email compare ");
    driver.get("https://qa2.vytrack.com/user/login");
    LoginPage loginPage=new LoginPage();
    loginPage.login("storemanager61","UserUser123");
    DashboardPage dashboardPage=new DashboardPage();
    dashboardPage.navigateToModule("Fleet","Vehicle Contracts");
    dashboardPage.waitUntilLoaderScreenDisappear();
    //Thread.sleep(4000);
    String actualresult = dashboardPage.getPageSubTitle();
    String expectedResult = "All Vehicle Contract";
    Assert.assertEquals(actualresult,expectedResult);
    VehicleContractPage$$ vehicleContractPage$$=new VehicleContractPage$$();
    vehicleContractPage$$.createVehicleContractPage$$.click();
    //dashboardPage.waitUntilLoaderScreenDisappear();
   Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name='custom_entity_type[Responsible]']")).sendKeys("Mike Smith");
}
}
