package com.ex.droidlist;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Jitesh on 13/4/16.
 */
public class MyService extends Service {

    MediaPlayer myPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    @Override
//    public void onCreate() {
//        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
//
//
//    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        myPlayer = MediaPlayer.create(this, R.raw.crazy);
        myPlayer.setLooping(false); // Set looping
        myPlayer.start();
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }
}
