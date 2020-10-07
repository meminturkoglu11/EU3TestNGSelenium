package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.concurrent.Callable;

public class PageSubTitleTest extends TestBase {
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        String actualSubTitle = dashboardPage.getPageSubTitle();
        String expectedSubTitle = "Quick Launchpad";
        Assert.assertEquals(actualSubTitle,expectedSubTitle);
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events");

    }
    @Test
    public void exercise1(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.getPageSubTitle();
        Assert.assertTrue(dashboardPage.getPageSubTitle().equals("Quick Launchpad"));
        dashboardPage.navigateToModule("Activities","Calendar Events");
        Assert.assertEquals(dashboardPage.getPageSubTitle(),"Calendar Events");


    }

}
