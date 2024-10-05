package com.selenium.project.webapplication.letcode.pages;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class InputPageRepository {
    WebDriver driver= null;
    public InputPageRepository() {
       driver= DriverInitializer.getWebDriverInstance();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[./label[text()='Enter your full Name']]/child::div/input")
    private WebElement fullNameInput;

    @FindBy(xpath = "//div[./label[text()='Append a text and press keyboard tab']]/child::div/input")
    private WebElement appendTextPressKeyboardTab;

    @FindBy(xpath = "//div[./label[text()='What is inside the text box']]/child::div/input")
    private WebElement whatInsideTheTextBox;

    @FindBy(xpath = "//div[./label[text()='Clear the text']]/child::div/input")
    private WebElement clearTheText;

    @FindBy(xpath = "//div[./label[text()='Confirm edit field is disabled']]/child::div/input")
    private WebElement confirmEditFielIsDisabled;

    @FindBy(xpath = "//div[./label[text()='Confirm text is readonly']]/child::div/input")
    private WebElement confirmTextIsRandomly;

}
