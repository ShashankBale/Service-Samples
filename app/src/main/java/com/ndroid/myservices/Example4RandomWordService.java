package com.ndroid.myservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Example4RandomWordService extends Service {
    private final IBinder mBinder = new MyBinder();
    List<String> input = Arrays.asList("Linux", "Android", "iPhone", "Windows7", "Mac OS");
    private List<String> resultList = new ArrayList<String>();
    private int counter = 1;

    private void addResultValues() {
        Random random = new Random();
        int iRandomIndex = random.nextInt(input.size() - 1);
        resultList.add(counter + ".  " + input.get(iRandomIndex));
        counter++;

        if (counter == Integer.MAX_VALUE)
            counter = 0;
    }

    public List<String> getWordList() {
        return resultList;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        addResultValues();
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        addResultValues();
        return mBinder;
    }

    public class MyBinder extends Binder {
        Example4RandomWordService getServiceInstance() {
            return Example4RandomWordService.this;
        }
    }
}