package com.selenium.project.core.utils.genericutils;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsUtils {

    public static Actions pause(int waitTime){
        Actions action = new Actions(DriverInitializer.getWebDriverInstance());
        action.pause(Duration.ofSeconds(waitTime));
        return action;
    }

    public static void moveToElement(WebElement webElement){
        Actions action = new Actions(DriverInitializer.getWebDriverInstance());
        action.pause(Duration.ofMillis(500)).moveToElement(webElement).build().perform();
    }

    public static void click(WebElement webElement){
        Actions action = new Actions(DriverInitializer.getWebDriverInstance());
        action.pause(Duration.ofMillis(500)).click(webElement).build().perform();
    }

    public static void senKeys(WebElement webElement, String inputText){
        Actions action = new Actions(DriverInitializer.getWebDriverInstance());
        action.pause(Duration.ofMillis(500)).sendKeys(webElement).build().perform();
    }
}
