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
