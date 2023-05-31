package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private Button help;
    private Button BTDtest;
    private Button info;
    private Button logout;
    private TextView userName;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // display the username to the dashboard
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        userName = findViewById(R.id.user_name);
        userName.setText(sharedPreferences.getString(KEY_NAME, null));

        // logout from the app
        logout = findViewById(R.id.log_out_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogIn.class));
                Toast.makeText(Home.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
            }
        });

        // home buttons
        help = findViewById(R.id.help);
        BTDtest = findViewById(R.id.BTDtest);
        info = findViewById(R.id.info);

        // open help page
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),help.class));
            }
        });

        // open BT detection page
        BTDtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BTdetection.class));
            }
        });

        //open Info page
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Info.class));
            }
        });
    }
}