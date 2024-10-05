package com.selenium.project.core.utils.genericutils;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import org.openqa.selenium.WebDriver;

public class AlertUtility {
    static WebDriver driver= DriverInitializer.getWebDriverInstance();

    public static void accept(){
        driver.switchTo().alert().accept();
    }

    public static void dismiss(){
        driver.switchTo().alert().dismiss();
    }

    public static void sendKeys(String input){
        driver.switchTo().alert().sendKeys(input);
    }

    public static String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}
