/*
------------------------------------------------------------------------------
 File: Traveler.java
 Purpose: This file contains the Traveler class, which represents traveler information in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Traveler {

    @PrimaryKey()
    @NotNull
    private String nic;
    private String Id;
    private String Role;
    private String Title;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String Password;
    private String ImageUrl;


}
