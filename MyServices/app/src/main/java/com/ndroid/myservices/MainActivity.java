package com.ndroid.myservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_btnExample1(View view) {
        startActivity(new Intent(this, Example1Activity.class));
    }
    public void onClick_btnExample2(View view) {
        startActivity(new Intent(this, Example2Activity.class));
    }
    public void onClick_btnExample3(View view) {
        startActivity(new Intent(this, Example3Activity.class));
    }

    public void onClick_btnExample4(View view) {
        startActivity(new Intent(this, Example4Activity.class));
    }

    public void onClick_btnExample5(View view) {
        startActivity(new Intent(this, Example5Activity.class));
    }
}
