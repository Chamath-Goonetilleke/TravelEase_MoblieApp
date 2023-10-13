/*
------------------------------------------------------------------------------
 File: Reservation.java
 Purpose: This file contains the Reservation class, which represents reservation information in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
public class Reservation {
    @PrimaryKey()
    @NotNull
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

}



