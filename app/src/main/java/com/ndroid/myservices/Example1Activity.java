package com.ndroid.myservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_1);
    }

    public void onClick_StartService(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Example1Service.class);
        startService(intent);
    }

    public void onClick_StopService(View view) {
        Intent intent = new Intent(getApplicationContext(), Example1Service.class);
        stopService(intent);
    }
}
