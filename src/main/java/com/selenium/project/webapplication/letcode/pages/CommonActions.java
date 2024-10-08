package com.selenium.project.webapplication.letcode.pages;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import com.selenium.project.core.utils.genericutils.ActionsUtils;
import com.selenium.project.core.utils.genericutils.DriverWait;
import com.selenium.project.core.utils.genericutils.ElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonActions {
    static WebDriver driver=DriverInitializer.getWebDriverInstance();


    public static void navigateToCardLink(String cardName){
        DriverWait.getInstance().waitForPageToLoad(5);
        WebElement element=driver.findElement(By.xpath(String.format("//div[./header/p[text()=' %s ']]/child::footer/a",cardName)));
        ElementOperations.scrollToElement(element);
        ElementOperations.clickOnWebElement(element);
    }
}
