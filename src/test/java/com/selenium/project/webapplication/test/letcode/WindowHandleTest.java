package com.selenium.project.webapplication.test.letcode;


import com.selenium.project.core.annotations.ReportBasePath;
import com.selenium.project.core.annotations.Url;
import com.selenium.project.core.constants.BaseReportPaths;
import com.selenium.project.core.constants.Urls;
import com.selenium.project.core.listners.BaseListener;
import com.selenium.project.core.listners.TestListener;
import com.selenium.project.core.testconfiguration.TestConfig;
import com.selenium.project.core.utils.driverutils.DriverInitializer;
import com.selenium.project.core.utils.genericutils.ActionsUtils;
import com.selenium.project.core.utils.genericutils.DriverWait;
import com.selenium.project.webapplication.letcode.pages.CommonActions;
import com.selenium.project.webapplication.letcode.pages.WindowPageRepository;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

@Listeners({BaseListener.class, TestListener.class})
@Url(url= Urls.LETCODE)
@ReportBasePath(baseReportPath = BaseReportPaths.LETCODE)

public class WindowHandleTest {
    public WindowHandleTest(){
        TestConfig.setTestObject(this);
    }
    private WindowPageRepository windowPageRepository;
    private WebDriver driver;

    @Test(priority = 1,description = "Validate new window is opened and title of new Window is fetched.")
    public void windowHandle(){
        DriverWait.getInstance().waitForPageToLoad(5);
        CommonActions.navigateToCardLink("Window");
        windowPageRepository= new WindowPageRepository();
        driver= DriverInitializer.getWebDriverInstance();
        ActionsUtils.click(windowPageRepository.getOpenHomePageButton());
        Reporter.log("Parent window Title : "+driver.getTitle());
        List<String> windows= driver.getWindowHandles().stream().toList();
        Reporter.log("WindowId for currently opened tabs in browser \n"+windows.toString());
        driver.switchTo().window(windows.get(1));
        String title=driver.getTitle();
        Assert.assertEquals("LetCode - Testing Hub",title);
        Reporter.log("Navigated to new Window and fetched title "+title);
        driver.close();
        driver.switchTo().window(windows.get(0));
        Reporter.log("Switched back to parent window and fetched parent window title : "+driver.getTitle());
    }

}
