package com.example.travelease_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travelease_mobile.databinding.ActivityLoginBinding;
import com.example.travelease_mobile.managers.ContextManager;
import com.example.travelease_mobile.managers.TravelerManager;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    TravelerManager travelerManager;
    EditText email;
    EditText password;
    MaterialButton loginBtn;
    MaterialButton registerBtn;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ContextManager.getInstance().setApplicationContext(getApplicationContext());
        travelerManager = TravelerManager.getInstance();

        email = binding.email;
        password = binding.password;
        loginBtn = binding.loginBtn;
        registerBtn = binding.registerBtn;

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void login(){
        if(!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();

            travelerManager.login(email.getText().toString(),password.getText().toString(), this::handleLoginSuccess, this::handleLoginFailed);
        }
    }

    private void handleLoginSuccess(){
        //logInManager.setLoggedInState(true);
        progressDialog.dismiss();
        Toast.makeText(this, "SUCCESS", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    //Called if login failed
    private void handleLoginFailed(String error){
        progressDialog.dismiss();
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}