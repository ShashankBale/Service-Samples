package com.ndroid.myservices;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Example5Activity extends AppCompatActivity {

    private TextView textView;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    String string = bundle.getString(Example5DownloadService.FILEPATH);
                    int resultCode = bundle.getInt(Example5DownloadService.RESULT);
                    if (resultCode == RESULT_OK) {
                        Toast.makeText(getApplicationContext(), "Download complete. Download URI: " + string, Toast.LENGTH_LONG).show();
                        textView.setText("Download done");
                    } else {
                        Toast.makeText(getApplicationContext(), "Download failed", Toast.LENGTH_LONG).show();
                        textView.setText("Download failed");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_5);
        textView = (TextView) findViewById(R.id.status);

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(Example5DownloadService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, Example5DownloadService.class);
        // add infos for the service which file to download and where to store
        intent.putExtra(Example5DownloadService.FILENAME, "asterix_index.html");
        intent.putExtra(Example5DownloadService.URL, "https://www.asterixsolution.com/index.html");
        startService(intent);
        textView.setText("Service started");
    }
}