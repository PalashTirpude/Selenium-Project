package com.selenium.project.webapplication.test.makemytrip;


import com.selenium.project.core.annotations.ReportBasePath;
import com.selenium.project.core.annotations.Url;
import com.selenium.project.core.constants.BaseReportPaths;
import com.selenium.project.core.constants.Urls;
import com.selenium.project.core.listners.BaseListener;
import com.selenium.project.core.listners.TestListener;
import com.selenium.project.core.testconfiguration.TestConfig;
import com.selenium.project.webapplication.makemytrip.entity.FlightBookingEntity;
import com.selenium.project.webapplication.makemytrip.workflows.FlightBooking;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.text.ParseException;

@Listeners({BaseListener.class, TestListener.class})
@Url(url= Urls.MAKEMYTRIP)
@ReportBasePath(baseReportPath = BaseReportPaths.MAKEMYTRIP)
public class FlightBookingTest {
    private FlightBooking flightBooking;

    public FlightBookingTest(){
        TestConfig.setTestObject(this);
    }

    @Test(priority = 1,description = "Check User is able to search flights")
    public void flightSearchTest() throws ParseException, InterruptedException {
        flightBooking= new FlightBooking(FlightBookingEntity.builder()
                .tripType("Round Trip")
                .from("Nagpur")
                .to("Pune")
                .departureDate("15.Mar.2025")
                .returnDate("10.Jul.2025")
                .searchButton(true)
                .build());
        flightBooking.searchFlights();
        Assert.assertEquals("NETWORK PROBLEM",flightBooking.getNetworkProblem());
    }
}
