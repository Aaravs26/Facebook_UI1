package com.example.facebookui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView text;
    Button logout;
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        text = findViewById(R.id.text);
        logout = findViewById(R.id.logout);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        SharedPreferences s = getSharedPreferences("name", MODE_PRIVATE);
        String n = s.getString("name", "No name defined");
        text.setText("Welcome, " + n);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                sharedPreferenceConfig.writeLoginStatus(false);
            }
        });
    }
}