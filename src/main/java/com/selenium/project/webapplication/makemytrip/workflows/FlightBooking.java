package com.selenium.project.webapplication.makemytrip.workflows;

import com.selenium.project.core.utils.genericutils.ActionsUtils;
import com.selenium.project.core.utils.genericutils.DriverWait;
import com.selenium.project.core.utils.genericutils.ElementOperations;
import com.selenium.project.webapplication.makemytrip.entity.FlightBookingEntity;
import com.selenium.project.webapplication.makemytrip.pages.CommonActions;
import com.selenium.project.webapplication.makemytrip.pages.FlightsRepository;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import java.text.ParseException;

public class FlightBooking {
    private final FlightBookingEntity flightBookingEntity;
    private @Getter String networkProblem;
    public FlightBooking(FlightBookingEntity flightBookingEntity) {
        this.flightBookingEntity=flightBookingEntity;
    }

    public FlightBooking searchFlights() throws ParseException, InterruptedException {
        FlightsRepository flightRepo= new FlightsRepository();

        DriverWait.getInstance().waitForPageToLoad(30);
        DriverWait.getInstance().WaitForElementVisible(flightRepo.getLoginFrameCloseButton(),5);
        ActionsUtils.click(flightRepo.getLoginFrameCloseButton());
        ActionsUtils.click(flightRepo.getFlightMenuLink());
        Reporter.log("Clicked on Flight menu link");
        DriverWait.getInstance().WaitForElementVisible(flightRepo.getFrom(),5);

        if(flightBookingEntity.getTripType()!= null){
            flightRepo.getTripTypeRadioButton(flightBookingEntity.getTripType()).click();
            Reporter.log("Selected Trip Type : "+flightBookingEntity.getTripType());
        }
        if(flightBookingEntity.getFrom()!= null){
            flightRepo.getFrom().click();
            DriverWait.getInstance().WaitForElementVisible(flightRepo.getFromInput(),2);
            flightRepo.getFromInput().sendKeys(flightBookingEntity.getFrom());
            ActionsUtils.pause(1).sendKeys(Keys.ENTER).build().perform();
            DriverWait.getInstance().WaitForElementClickable(flightRepo.getSearchedOption(flightBookingEntity.getFrom()),5);
            ElementOperations.clickOnWebElement(flightRepo.getSearchedOption(flightBookingEntity.getFrom()));
            Reporter.log("From Destination Entered : "+flightBookingEntity.getFrom());
        }
        if(flightBookingEntity.getTo()!= null){
            flightRepo.getTo().sendKeys(Keys.ENTER);
            DriverWait.getInstance().WaitForElementVisible(flightRepo.getTo(),2);
            flightRepo.getTo().sendKeys(flightBookingEntity.getTo());
            ActionsUtils.pause(1).sendKeys(Keys.ENTER).build().perform();
            DriverWait.getInstance().WaitForElementClickable(flightRepo.getSearchedOption(flightBookingEntity.getTo()),5);
            ElementOperations.clickOnWebElement(flightRepo.getSearchedOption(flightBookingEntity.getTo()));
            Reporter.log("To Destination Entered : "+flightBookingEntity.getTo());
        }
        if(flightBookingEntity.getDepartureDate()!=null){
//            flightRepo.getDepartureDateInputLink().click();
            new CommonActions().SelectDateFromCalender(flightBookingEntity.getDepartureDate(),"dd.MMM.yyyy");
            Reporter.log("Departure Date Selected : "+flightBookingEntity.getDepartureDate());
        }
        if(flightBookingEntity.getReturnDate()!=null){
//            flightRepo.getReturnDateInputLink().click();
            new CommonActions().SelectDateFromCalender(flightBookingEntity.getReturnDate(),"dd.MMM.yyyy");
            Reporter.log("Return Date Selected : "+flightBookingEntity.getReturnDate());
        }
        if(flightBookingEntity.isSearchButton()){
            flightRepo.getSearchButton().click();
            Reporter.log("Clicked on Search Button");
            networkProblem =flightRepo.getNetworkProblemError().getText();
        }
        return this;
    }
}
