package com.selenium.project.webapplication.makemytrip.pages;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class FlightsRepository {
    WebDriver driver;

    public FlightsRepository() {
        driver= DriverInitializer.getWebDriverInstance();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[@class='commonModal__close']")
    private WebElement loginFrameCloseButton;

    @FindBy(xpath="//li[@class='menu_Flights']/descendant::a")
    private WebElement flightMenuLink;

    @FindBy(xpath ="//label[./span[text()='From']]/child::input")
    private WebElement from;

    @FindBy(xpath ="//label[./span[text()='To']]/child::input")
    private WebElement to;

    @FindBy(xpath ="//input[@placeholder='From']")
    private WebElement fromInput;

    @FindBy(xpath ="//input[@placeholder='To']")
    private WebElement toInput;

    @FindBy(xpath="//label[@for='departure']")
    private WebElement departureDateInputLink;

    @FindBy(xpath="//label[@for='return']")
    private WebElement returnDateInputLink;

    @FindBy(xpath="//a[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div/p[text()='NETWORK PROBLEM']")
    private WebElement networkProblemError;

    public WebElement getTripTypeRadioButton(String radioButtonName) {
        return driver.findElement(By.xpath(String.format("//li[text()='%s']", radioButtonName)));
    }

    public WebElement getSearchedOption(String input){
        return driver.findElement(By.xpath(String.format("//li[./descendant::div[2]/p/span/span[text()='%s']]",input)));
    }


}
