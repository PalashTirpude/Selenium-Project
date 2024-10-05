package com.selenium.project.core.utils.genericutils;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWait {

    public static WebDriver driver;
    private static DriverWait driverWait;

    private DriverWait() {
        driver = DriverInitializer.getWebDriverInstance();
    }

    public static DriverWait getInstance() {
        if (driverWait == null) {
            driverWait = new DriverWait();
            return driverWait;
        }
        return driverWait;
    }

    public void WaitForElementClickable(WebElement webElement, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void WaitForElementVisible(WebElement webElement, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void WaitForElementTextVisible(WebElement webElement, String textToBePresentInElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, textToBePresentInElement));
    }

    public void waitForPageToLoad(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                String readyState = (String) jsExecutor.executeScript("return document.readyState");
                return "complete".equals(readyState);
            }
        });
    }



}
