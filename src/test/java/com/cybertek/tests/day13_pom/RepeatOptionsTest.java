package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.day12_properties_driver_tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class RepeatOptionsTest extends TestBase {
    LoginPage loginPage=new LoginPage();
    @Test
    public void test1() throws InterruptedException {

        loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        //BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,50);
        Thread.sleep(5000);
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());


    }
    @Test
    public void test2() throws InterruptedException {
        loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Thread.sleep(6000);
        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();
       /* List<String> expectedList=new ArrayList<>();
        expectedList.add(0,"Daily");
        expectedList.add(1,"Weekly");
        expectedList.add(2,"Monthly");
        expectedList.add(3,"Yearly");*/
        List<String> expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualoptions = repeatDropdown.getOptions();
        List<String> actualList=new ArrayList<>();
        for (int i = 0; i < actualoptions.size(); i++) {
            actualList.add(actualoptions.get(i).getText());
            expectedList.get(i);
           // Assert.assertEquals(actualoptions.get(i).getText(),expectedList.get(i));

        }
        List<String> elementsText = BrowserUtils.getElementsText(actualoptions);
        Assert.assertEquals(actualList,expectedList);
        Assert.assertEquals(elementsText,expectedList);


    }
    /*VERIFY RADIO BUTTONS
Open browser
Login as driver
Go to Activities->Calendar Events
Click on create calendar events
Click on repeat
Verify that repeat every days is checked
verify that repeat weekday is not checked
* */
    @Test
    public void testExercise(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());
    }
    @Test
    public void testExercises(){
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        System.out.println("createCalendarEventsPage.repeatOptions.getText() = " + createCalendarEventsPage.repeatOptions.getText());
        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

    }
    @Test
    public void testExercise2() throws InterruptedException {
        loginPage.loginAsDriver();
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        Thread.sleep(5000);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        WebElement repeatOptions = createCalendarEventsPage.repeatOptions;
        Select select=new Select(repeatOptions);

        List<String> mylist=new ArrayList<>();
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            mylist.add(options.get(i).getText());
            System.out.println(mylist.get(i));
            Assert.assertEquals(options.get(i).getText(),mylist.get(i));

        }

    }
}
