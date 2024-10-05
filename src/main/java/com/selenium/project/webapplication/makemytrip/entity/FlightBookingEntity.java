package com.selenium.project.webapplication.makemytrip.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FlightBookingEntity {

    private String tripType;
    private String from;
    private String to;
    private String departureDate;
    private String returnDate;
    private boolean searchButton;

}
