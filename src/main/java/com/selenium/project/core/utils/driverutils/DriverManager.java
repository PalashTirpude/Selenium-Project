package com.selenium.project.core.utils.driverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    WebDriver driver= null;

    public WebDriver createChromeDriver(){
        System.setProperty("webdriver.chrome.driver","driver-resources/chromedriver.exe");
        return new ChromeDriver(chromeOptions());
    }
    public WebDriver createEdgeDriver(){
        System.setProperty("webdriver.edge.driver","driver-resources/msedgedriver.exe");
        return new EdgeDriver(edgeOptions());
    }
    public WebDriver createFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver","driver-resources/chromedriver.exe");
        return new FirefoxDriver(firefoxOptions());
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(getArguments());
        chromeOptions.setExperimentalOption("prefs", getPreferences());
        return chromeOptions;
    }
    
    private EdgeOptions edgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(getArguments());
        edgeOptions.setExperimentalOption("prefs", getPreferences());
        return edgeOptions;
    }
    
    public FirefoxOptions firefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(getArguments());
        FirefoxProfile profile= new FirefoxProfile();
        getPreferences().forEach(profile::setPreference);
        firefoxOptions.setProfile(profile);
        return firefoxOptions;
    }
    
    private String[] getArguments(){
//        String tempProfilePath = System.getProperty("java.io.tmpdir") + "seleniumProfile";
        return new String[]{"enable-automation-testing",
                "--ignore-certificate-errors",
                "--start-maximized",
                "--disable-application-cache",
                "--disable-restore-session-state",
                "--disable-infobars",
                "--disable-extensions",
//                "--disable-web-security",
//                "--user-data-dir=" + tempProfilePath,
                "--disable-gpu"};
    }
    
    private Map<String,Object> getPreferences() {
        Map<String, Object> prefs = new HashMap<>();
        File downloadPath = new File("downloads");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.default_directory", downloadPath.getAbsolutePath());
        return prefs;
    }

}
