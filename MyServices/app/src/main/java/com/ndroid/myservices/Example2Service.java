package com.ndroid.myservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Example2Service extends Service {
    private final String TAG = "StopSelfService";

    /**
     * Called when the service is being created.
     */
    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate()");
    }

    /**
     * The service is starting, due to a call to startService()
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand()");
        Toast.makeText(this, "Service STARTED", Toast.LENGTH_LONG).show();
        if (intent != null) {
            String strValue = intent.getStringExtra("key_01");

            //will do some work here
            //will do some work here
            //will do some work here
            //will do some work here
            ;
            ;
            ;
            ;
            ;
            ;
            ;
            stopSelf();
        }
        return Service.START_STICKY;
    }

    /**
     * A client is binding to the service with bindService()
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Called when all clients have unbound with unbindService()
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind()");
        return false; //allow Rebind
    }

    /**
     * Called when a client is binding to the service with bindService()
     */
    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind()");
    }

    /**
     * Called when The service is no longer used and is being destroyed
     */
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Work Done, Service self stop and destroyed", Toast.LENGTH_LONG).show();
        Log.e(TAG, "onDestroy()");
    }
}

