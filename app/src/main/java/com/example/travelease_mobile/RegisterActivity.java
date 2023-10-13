/**
 * ----------------------------------------------------------------------------
 * File: RegisterActivity.java
 * Purpose: This activity allows users to register a new traveler account in the TravelEase_Mobile project.
 * Author: IT20122096
 * Date: 2023-10-13
 * ----------------------------------------------------------------------------
 */
package com.example.travelease_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travelease_mobile.databinding.ActivityRegisterBinding;
import com.example.travelease_mobile.managers.ContextManager;
import com.example.travelease_mobile.managers.TravelerManager;
import com.example.travelease_mobile.services.request.RegisterRequest;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    TravelerManager travelerManager;
    ProgressDialog progressDialog;
    EditText firstName;
    EditText lastName;
    EditText nic;
    EditText phoneNumber;
    EditText email;
    EditText password;
    EditText conPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ContextManager.getInstance().setApplicationContext(getApplicationContext());
        travelerManager = TravelerManager.getInstance();

        firstName = binding.firstName;
        lastName = binding.lastName;
        nic = binding.nic;
        phoneNumber = binding.phoneNumber;
        email = binding.email;
        password = binding.password;
        conPassword = binding.cpassword;



        binding.registerBtn.setOnClickListener(view -> {
            RegisterRequest request = new RegisterRequest(
                    nic.getText().toString(),
                    "Mr",
                    firstName.getText().toString(), lastName.getText().toString(),
                    email.getText().toString(),
                    phoneNumber.getText().toString(),
                    "Gampaha", password.getText().toString()
            );
            register(request);
        });

        binding.loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    public void register(RegisterRequest request) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();

        travelerManager.register(request, this::handleLoginSuccess, this::handleLoginFailed);
    }

    private void handleLoginSuccess() {
        progressDialog.dismiss();
        Toast.makeText(this, "SUCCESS", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    //Called if login failed
    private void handleLoginFailed(String error) {
        progressDialog.dismiss();
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}