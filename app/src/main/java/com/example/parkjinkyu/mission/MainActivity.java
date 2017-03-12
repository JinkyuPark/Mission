package com.example.parkjinkyu.mission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Mission01Activity.class);
        startActivity(intent);
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Mission02Activity.class);
        startActivity(intent);
    }

    public void onButton3Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), Mission03LoginActivity.class);
        startActivity(intent);
    }
}
