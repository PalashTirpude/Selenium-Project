package com.selenium.project.core.listners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.selenium.project.core.utils.reporertutils.extentreportutils.ExtentReporterManager;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {
        extentTest= ExtentReporterManager.getExtentReport().createTest(String.format("TC%s %s",result.getMethod().getPriority(),result.getMethod().getDescription())
                ,result.getMethod().getDescription()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        for(String str:Reporter.getOutput(result)){
            extentTest.info(str);
        }
        extentTest.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
        if (result.getThrowable() != null) {
            extentTest.fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.ORANGE));
        if (result.getThrowable() != null) {
            extentTest.skip(result.getThrowable());
        }
    }
}
