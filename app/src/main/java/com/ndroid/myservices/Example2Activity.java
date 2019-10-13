package com.ndroid.myservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Example2Activity extends AppCompatActivity {

    private final String TAG = "StopSelfActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_2);
    }

    // Method to start the service
    public void onClick_StartService(View view) {
        Log.e(TAG, "service about to start");
        Intent serviceIntent = new Intent(getApplicationContext(), Example2Service.class);
        serviceIntent.putExtra("key_01", "download_xyz");
        startService(serviceIntent);
    }
}
