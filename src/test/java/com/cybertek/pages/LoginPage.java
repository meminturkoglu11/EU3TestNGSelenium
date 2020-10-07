package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //driver.findElement(By.id("prependedInput"));
    @FindAll({//biri dogruysa bulur or  gibi/findbyse ikiside dogru olursa yapar and gibi
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })
    public WebElement usernameInput;

  /*  @FindBys({
            @FindBy(id="prerendedInput"),
            @FindBy(name="_username")
    })
    public WebElement getUsernameInput;*/

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> buttons;



    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public  void loginAsSalesManager(){
        String salesmanager_username = ConfigurationReader.get("salesmanager_username");
        String salesmanager_password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(salesmanager_username);
        passwordInput.sendKeys(salesmanager_password);
        loginBtn.click();
    }
    public void loginAsDriver(){
        String driver_username = ConfigurationReader.get("driver_username");
        String driver_password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(driver_username);
        passwordInput.sendKeys(driver_password);
        loginBtn.click();

    }



}
