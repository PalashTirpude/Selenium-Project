package com.selenium.project.webapplication.letcode.pages;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AlertsPageRepository {
    public AlertsPageRepository() {
        PageFactory.initElements(DriverInitializer.getWebDriverInstance(),this);
    }

    @FindBy(xpath="//button[text()='Simple Alert']")
    private WebElement simpleAlertButton;

    @FindBy(xpath="//button[text()='Confirm Alert']")
    private WebElement confirmAlert;

    @FindBy(xpath="//button[text()='Prompt Alert']")
    private WebElement promptAlert;

    @FindBy(xpath = "//div/p[contains(text(),'Your name is: ')]")
    private WebElement yourNameMessage;

    @FindBy(xpath="//button[text()='Modern Alert']")
    private WebElement modernAlert;


}
