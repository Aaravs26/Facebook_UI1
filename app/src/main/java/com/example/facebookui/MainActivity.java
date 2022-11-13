package com.example.facebookui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et,ps;
//    String user = "AaravS";
//    String pass = "1234";
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et = findViewById(R.id.email);
        ps = findViewById(R.id.password);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        if (sharedPreferenceConfig.readLoginStatus()) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void login(View view) {
        String user_name_entered = "";
        String password_entered = "";

        user_name_entered = et.getText().toString();
        password_entered = ps.getText().toString();
        if (user_name_entered.equals(getResources().getString(R.string.user_name)) && password_entered.equals(getResources().getString(R.string.user_password))){
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i);
            finish();
            sharedPreferenceConfig.writeLoginStatus(true);
            SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
            editor.putString("name", user_name_entered);
            editor.apply();
        }
        else {
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            et.setText("");
            ps.setText("");
        }

    }
}