package com.selenium.project.core.utils.genericutils;

import com.selenium.project.core.utils.driverutils.DriverInitializer;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementOperations {

    public static boolean isElementIsExist(WebElement webElement){
        boolean status=false;
        try {
            if(webElement.isDisplayed()){
                status=true;
            }
        } catch (NoSuchElementException e) {
            System.err.println("Element Does not exist "+e.getLocalizedMessage());
        }
        return status;
    }

    public static void handleStaleElementExceptionClick(WebElement webElement){
        boolean breakLoop=false;
        int counter=0;
        while(!breakLoop && counter<=5){
            try{
                webElement.click();
                breakLoop=true;
            }catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                System.err.println(String.format("Attempting to click webElement, Attempt %d",++counter));
            }
        }
    }

    public static void clickOnWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollDownByPixels( int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();;
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }

    public static void scrollUpByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();
        js.executeScript("window.scrollBy(0,-" + pixels + ");");
    }

    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();
        js.executeScript("window.scrollTo(0, 0);");
    }

    public static void highlightElement( WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();
        // You can set the color to any value, like "yellow", "red", etc.
        js.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);
    }

    public static void createBorderAroundElement(WebElement element, String color, String width) {
        JavascriptExecutor js = (JavascriptExecutor) DriverInitializer.getWebDriverInstance();
        // You can set the color and border width (e.g., "red", "2px")
        js.executeScript("arguments[0].style.border = '" + width + " solid " + color + "';", element);
    }

    public static void selectByVisibleText(WebElement dropdownElement, String visibleText){
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }
}
