package com.selenium.project.core.listners;

import com.selenium.project.core.annotations.Url;
import com.selenium.project.core.testconfiguration.TestConfig;
import com.selenium.project.core.utils.driverutils.DriverInitializer;
import com.selenium.project.core.utils.reporertutils.extentreportutils.ExtentReporterManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class BaseListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        TestConfig.browser=suite.getXmlSuite().getParameter("browser");
        TestConfig.testName=suite.getXmlSuite().getParameter("testName");
        DriverInitializer.getWebDriverInstance().get(TestConfig.testObject.getClass().getAnnotation(Url.class).url().getUrl());
    }

    @Override
    public void onFinish(ISuite suite) {
        DriverInitializer.getWebDriverInstance().quit();
        ExtentReporterManager.getExtentReport().flush();
    }
}
