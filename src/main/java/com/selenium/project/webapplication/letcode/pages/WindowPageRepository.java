package com.selenium.project.webapplication.letcode.pages;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class WindowPageRepository {
    WebDriver driver=null;
    public WindowPageRepository() {
        driver= DriverInitializer.getWebDriverInstance();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[text()='Open Home Page']")
    private WebElement openHomePageButton;

    @FindBy(xpath="//button[text()='Muiltiple windows']")
    private WebElement multipleWindowsButton;

}
