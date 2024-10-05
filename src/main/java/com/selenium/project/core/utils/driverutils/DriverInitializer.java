package com.selenium.project.core.utils.driverutils;

import com.selenium.project.core.testconfiguration.TestConfig;
import org.openqa.selenium.WebDriver;

public class DriverInitializer {
    public static WebDriver driver= null;

    public static WebDriver getWebDriverInstance(){
        if(driver!=null){
            return driver;
        }
        driver=DriverFactory.valueOf(TestConfig.browser.toUpperCase()).createDriver();
        return driver;
    }

}
