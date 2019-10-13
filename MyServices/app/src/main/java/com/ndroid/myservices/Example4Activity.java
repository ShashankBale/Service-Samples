package com.ndroid.myservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Example4Activity extends AppCompatActivity implements ServiceConnection, View.OnClickListener {

    private ArrayList<String> alWords;
    private Example4RandomWordService randomWordService;
    private TextView tvList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_4);
        initObjects();
    }

    private void initObjects() {
        tvList = findViewById(R.id.tvList);
        findViewById(R.id.updateList).setOnClickListener(this);
        findViewById(R.id.triggerServiceUpdate).setOnClickListener(this);
        alWords = new ArrayList<String>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, Example4RandomWordService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.updateList:
                if (randomWordService != null) {
                    toast("Number of elements " + randomWordService.getWordList().size());
                    alWords.clear();
                    alWords.addAll(randomWordService.getWordList());
                    populateValueOfList();
                }
                break;
            case R.id.triggerServiceUpdate:
                Intent service = new Intent(getApplicationContext(), Example4RandomWordService.class);
                startService(service);
                break;
        }
    }

    private void populateValueOfList() {
        String strValues = "";
        for (String str : alWords) {
            strValues = strValues + "\n" + str;
        }

        tvList.setText(strValues);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        Example4RandomWordService.MyBinder b = (Example4RandomWordService.MyBinder) binder;
        randomWordService = b.getServiceInstance();
        toast("Connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        randomWordService = null;
    }

    private void toast(String msg) {
        Toast.makeText(Example4Activity.this, msg, Toast.LENGTH_SHORT).show();
    }
}