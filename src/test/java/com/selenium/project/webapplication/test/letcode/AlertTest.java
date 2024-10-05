package com.selenium.project.webapplication.test.letcode;

import com.aventstack.extentreports.ExtentTest;
import com.selenium.project.core.annotations.ReportBasePath;
import com.selenium.project.core.annotations.Url;
import com.selenium.project.core.constants.BaseReportPaths;
import com.selenium.project.core.constants.Urls;
import com.selenium.project.core.listners.BaseListener;
import com.selenium.project.core.listners.TestListener;
import com.selenium.project.core.testconfiguration.TestConfig;
import com.selenium.project.core.utils.genericutils.ActionsUtils;
import com.selenium.project.core.utils.genericutils.AlertUtility;
import com.selenium.project.core.utils.genericutils.DriverWait;
import com.selenium.project.webapplication.letcode.pages.AlertsPageRepository;
import com.selenium.project.webapplication.letcode.pages.CommonActions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({BaseListener.class, TestListener.class})
@Url(url= Urls.LETCODE)
@ReportBasePath(baseReportPath = BaseReportPaths.LETCODE)
public class AlertTest {
    public AlertTest(){
        TestConfig.setTestObject(this);
    }
    AlertsPageRepository alertsPageRepository;

    @Test(priority =1,description = "Validate user able to accept Simple Alert popup")
    public void validateSimpleAlert(){
        DriverWait.getInstance().waitForPageToLoad(5);
        CommonActions.navigateToCardLink("Alert");
        alertsPageRepository=new AlertsPageRepository();
        ActionsUtils.click(alertsPageRepository.getSimpleAlertButton());
        Reporter.log("Clicked on Simple Alert button.");
        Assert.assertEquals("Hey! Welcome to LetCode",AlertUtility.getAlertText());
        Reporter.log("Fetched Alert message : Hey! Welcome to LetCode");
        AlertUtility.accept();
        Reporter.log("Accepted Alert Message");
    }

    @Test(priority =2,description = "Validate user able to dismiss or accept the alert popup")
    public void validateConfirmAlert(){
        ActionsUtils.click(alertsPageRepository.getConfirmAlert());
        ActionsUtils.pause(2);
        AlertUtility.dismiss();
        Reporter.log("Dismissed Alert Message");
        ActionsUtils.click(alertsPageRepository.getConfirmAlert());
        ActionsUtils.pause(2);
        AlertUtility.accept();
        Reporter.log("Accepted Alert Message");
    }

    @Test(priority =3,description = "Validate user able to name in alert popup and get Name details ouput")
    public void validatePromptAlert(){
        ActionsUtils.click(alertsPageRepository.getPromptAlert());
        ActionsUtils.pause(2).sendKeys("Selenium Tester");
        Reporter.log("Inserted Name : Selenium Tester in alert input field");
        AlertUtility.sendKeys("Selenium Tester");
        ActionsUtils.pause(2);
        AlertUtility.accept();
        Assert.assertEquals("Your name is: Selenium Tester",alertsPageRepository.getYourNameMessage().getText());
        Reporter.log("Fetched Your name is: Selenium Tester message after successfully entered name and accepted alert popup.");
    }

}
