/*
------------------------------------------------------------------------------
 File: ProfileFragment.java
 Purpose: This file contains the ProfileFragment class, which is responsible for
 displaying the user's profile information in the TravelEase_Mobile project.
 Author: IT20122096
 Date: 2023-10-13
------------------------------------------------------------------------------
*/
package com.example.travelease_mobile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.travelease_mobile.R;
import com.example.travelease_mobile.entities.CurrentUser;


public class ProfileFragment extends Fragment {

    View view;
    CurrentUser currentUser;

    TextView name_Text;
    TextView email_text;
    TextView nic_text;
    TextView status_text;

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText city;

ImageView profile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentUser = CurrentUser.getInstance();
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        name_Text = view.findViewById(R.id.name_text);
        name_Text.setText(currentUser.getTitle() + " " + currentUser.getFirstName() + " " + currentUser.getLastName());

        email_text = view.findViewById(R.id.email_text);
        email_text.setText(currentUser.getEmail());

        nic_text = view.findViewById(R.id.nic_text);
        nic_text.setText(currentUser.getNic());

        profile = view.findViewById(R.id.profile);


        status_text = view.findViewById(R.id.status_text);
        if (currentUser.getState() == 0) {
            status_text.setText("ACTIVE");
        } else {
            status_text.setText("IN-ACTIVE");
        }

        //Update Fields
        firstName = view.findViewById(R.id.firstName);
        firstName.setText(currentUser.getFirstName());

        lastName= view.findViewById(R.id.lastName);
        lastName.setText(currentUser.getLastName());

        phoneNumber = view.findViewById(R.id.phoneNumber);
        phoneNumber.setText(currentUser.getPhoneNumber());

        city = view.findViewById(R.id.city);
        city.setText(currentUser.getCity());



        return view;
    }
}