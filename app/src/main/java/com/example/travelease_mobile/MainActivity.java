/**
 * ----------------------------------------------------------------------------
 * File: MainActivity.java
 * Purpose: This is the main activity of the TravelEase_Mobile project, which allows users to navigate
 * through different sections of the application.
 * Author: IT20122096
 * Date: 2023-10-13
 * ----------------------------------------------------------------------------
 */
package com.example.travelease_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.example.travelease_mobile.databinding.ActivityMainBinding;
import com.example.travelease_mobile.dto.ReservationDTO;
import com.example.travelease_mobile.fragments.HistoryFragment;
import com.example.travelease_mobile.fragments.HomeFragment;
import com.example.travelease_mobile.fragments.ProfileFragment;
import com.example.travelease_mobile.fragments.ReservationFragment;
import com.example.travelease_mobile.managers.ContextManager;
import com.example.travelease_mobile.managers.ReservationManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.reservations:
                    replaceFragment(new ReservationFragment());
                    break;
                case R.id.history:
                    replaceFragment(new HistoryFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });


    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}