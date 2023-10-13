/*
------------------------------------------------------------------------------
 File: ReservationDTO.java
 Purpose: This file contains the ReservationDTO class, which represents reservation data in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.dto;

import com.example.travelease_mobile.entities.Passenger;

import java.util.List;

public class ReservationDTO {
    private String id;
    private String from;
    private String to;
    private String time;
    private String date;
    private String scheduleId;
    private String trainN0;
    private String trainName;
    private String trainClass;
    private String classPrice;
    private String travelerNIC;
    private Boolean isTravelerCreated;
    private String travelAgentId;
    private Boolean isCancelled;
    private List<Passenger> passengers;

    public ReservationDTO(){}

    public ReservationDTO(String from, String to, String time, String date) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getTrainN0() {
        return trainN0;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainClass() {
        return trainClass;
    }

    public String getClassPrice() {
        return classPrice;
    }

    public String getTravelerNIC() {
        return travelerNIC;
    }

    public Boolean getTravelerCreated() {
        return isTravelerCreated;
    }

    public String getTravelAgentId() {
        return travelAgentId;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
