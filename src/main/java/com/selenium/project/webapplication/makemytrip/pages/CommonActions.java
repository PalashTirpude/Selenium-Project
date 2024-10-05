package com.selenium.project.webapplication.makemytrip.pages;


import com.selenium.project.core.utils.driverutils.DriverInitializer;
import com.selenium.project.core.utils.genericutils.ActionsUtils;
import com.selenium.project.core.utils.genericutils.DateUtils;
import com.selenium.project.core.utils.genericutils.DriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.util.List;

public class CommonActions {

    WebDriver driver;

    public CommonActions() {
        driver= DriverInitializer.getWebDriverInstance();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@aria-label='Next Month']")
    private WebElement nextMonthButton;

    private WebElement getMonthAndYear(String dateInMonthAndYearFormat){
        return driver.findElement(By.xpath(String.format("//div[@class='DayPicker-Month']/descendant::div[text()='%s']",dateInMonthAndYearFormat)));
    }

    private WebElement selectDay(String dateInMonthAndYearFormat, int day){
       return driver.findElement(By.xpath(String.format("//div[./div[text()='%s']]/following-sibling::div[2]/div/div/div/p[text()='%s']",dateInMonthAndYearFormat,day)));
    }

    private List<WebElement> getMontAndYearWebElementList(){
        List<WebElement> listOfElements;
        int counter=0;
        do {
            listOfElements=driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
            counter++;
        }while (listOfElements.isEmpty() && counter<5);
        return listOfElements;
    }

    public void monthAndYearIterator(String inputDateInMonthAndYearDateFormat){
        boolean breakLoop=false;
        while(!breakLoop){
            WebElement element =(getMontAndYearWebElementList().isEmpty())?null:getMontAndYearWebElementList().stream().filter(a->a.getText().equals(inputDateInMonthAndYearDateFormat.replace(" ",""))).findFirst().orElse(null);
            if(element==null){
                DriverWait.getInstance().WaitForElementClickable(nextMonthButton,5);
                nextMonthButton.click();
            }else{
                breakLoop=true;
            }
        }

    }


    public void SelectDateFromCalender(String inputDate, String inputDateFormat) throws ParseException {
        String dateInMonthAndYearFormat= DateUtils.changeDateFormat((DateUtils.getDate(inputDate,inputDateFormat)),"MMMM yyyy");
        int getDay=Integer.parseInt(DateUtils.changeDateFormat((DateUtils.getDate(inputDate,inputDateFormat)),"dd-MM-yyyy").substring(0,2));
        monthAndYearIterator(dateInMonthAndYearFormat);
        ActionsUtils.click(selectDay(dateInMonthAndYearFormat.split(" ")[0],getDay));
    }


}
