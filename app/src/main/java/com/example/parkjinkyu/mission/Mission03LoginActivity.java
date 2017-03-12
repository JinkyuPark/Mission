package com.example.parkjinkyu.mission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mission03LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission03login);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Mission03MenuActivity.class);
        startActivity(intent);
    }
}
