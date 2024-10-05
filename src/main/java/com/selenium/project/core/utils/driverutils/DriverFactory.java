package com.selenium.project.core.utils.driverutils;

import org.openqa.selenium.WebDriver;

public enum DriverFactory {
    CHROME{
        @Override
        public WebDriver createDriver() {
            return new DriverManager().createChromeDriver();
        }
    },
    EDGE{
        @Override
        public WebDriver createDriver() {
            return new DriverManager().createEdgeDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            return new DriverManager().createFirefoxDriver();
        }
    },
    NONE{
        @Override
        public WebDriver createDriver() {
            return null;
        }
    };
    public abstract WebDriver createDriver();
}
