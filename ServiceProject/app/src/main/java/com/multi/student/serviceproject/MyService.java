package com.multi.student.serviceproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer player;
    public MyService() {}

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this,R.raw.battle);
    }

    //service 시작 후에 Intent 도착시 호출되는 메소드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand()", Toast.LENGTH_SHORT).show();
        player.start();

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestory", Toast.LENGTH_SHORT).show();
        player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
