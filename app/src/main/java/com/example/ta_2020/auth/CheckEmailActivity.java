package com.example.ta_2020.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ta_2020.R;

public class CheckEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_email);
    }

    public void login(View view) {
        Intent login = new Intent(CheckEmailActivity.this, LoginActivity.class);
        startActivity(login);
    }
}
