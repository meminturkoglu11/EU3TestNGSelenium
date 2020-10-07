package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleContractPage$$ extends BasePage{


        public VehicleContractPage$$() {
            PageFactory.initElements(Driver.get(), this);
        }

        @FindBy(css = "[title='Create Vehicle Contract']")
        public WebElement createVehicleContractPage$$;

    }

