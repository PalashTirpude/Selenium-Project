package com.selenium.project.core.utils.reporertutils.extentreportutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.project.core.annotations.ReportBasePath;
import com.selenium.project.core.testconfiguration.TestConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExtentReporterManager {

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;

    public ExtentReports getExtentReport(){
        if(extentReports!=null){
            return extentReports;
        }
        if(extentSparkReporter==null){
            extentSparkReporter= new ExtentSparkReporter(createReportPath());
        }
        extentSparkReporter.config().setReportName("Functional Testing");
        extentSparkReporter.config().setDocumentTitle(TestConfig.testName);
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Host name", "localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("user", "Selenium");
        return extentReports;
    }

    public String createReportPath(){
        return new StringBuilder().append(TestConfig.testObject.getClass().getAnnotation(ReportBasePath.class).baseReportPath().getBaseReportPath())
                .append(TestConfig.testName)
                .append(".html").toString();
    }


}
