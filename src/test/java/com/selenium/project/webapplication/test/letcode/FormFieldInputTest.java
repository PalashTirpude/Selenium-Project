package com.selenium.project.webapplication.test.letcode;

import com.selenium.project.core.annotations.ReportBasePath;
import com.selenium.project.core.annotations.Url;
import com.selenium.project.core.constants.BaseReportPaths;
import com.selenium.project.core.constants.Urls;
import com.selenium.project.core.listners.BaseListener;
import com.selenium.project.core.listners.TestListener;
import com.selenium.project.core.testconfiguration.TestConfig;
import com.selenium.project.core.utils.genericutils.ActionsUtils;
import com.selenium.project.core.utils.genericutils.DriverWait;
import com.selenium.project.webapplication.letcode.pages.CommonActions;
import com.selenium.project.webapplication.letcode.pages.InputPageRepository;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({BaseListener.class, TestListener.class})
@Url(url= Urls.LETCODE)
@ReportBasePath(baseReportPath = BaseReportPaths.LETCODE)
public class FormFieldInputTest {
    public FormFieldInputTest(){
        TestConfig.setTestObject(this);
    }
    InputPageRepository inputPageRepository;

    @Test(priority =1,description = "Validate user able to fill fullName in the feild.")
    public void validateEnterYourFullNameInput(){
        DriverWait.getInstance().waitForPageToLoad(5);
        CommonActions.navigateToCardLink("Input");
        inputPageRepository= new InputPageRepository();
        ActionsUtils.senKeys(inputPageRepository.getFullNameInput(),"Selenium Testing");
        Reporter.log("Entered Full Name : Selenium Testing");
        Assert.assertEquals(inputPageRepository.getFullNameInput().getText(), "Selenium Testing");
    }

    @Test(priority =2,description = "Validate the value of input field Whats inside the text box.")
    public void validateTextInsideTheInputField(){
        String fieldValue=inputPageRepository.getWhatInsideTheTextBox().getAttribute("value");
        Assert.assertEquals("ortonikc",fieldValue);
        Reporter.log("Fetched attribute value from 'What inside the text box' input field");
    }

    @Test(priority =3,description = "Validate user is able to clear the field value.")
    public void validateFieldValueClearText(){
        inputPageRepository.getClearTheText().clear();
        Assert.assertTrue(inputPageRepository.getClearTheText().getText().isEmpty());
        Reporter.log("Cleared the field 'Clear The Text Box'");
    }

    @Test(priority =4,description = "Validate edit field is disabled.")
    public void validateEditFieldDisabled(){
        inputPageRepository.getConfirmEditFielIsDisabled().isEnabled();
        Assert.assertFalse(inputPageRepository.getConfirmEditFielIsDisabled().isEnabled());
        Reporter.log("'Confirm Edit Field Disabled' field is disabled");
    }



}
