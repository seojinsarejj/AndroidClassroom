package com.example.ex01_service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    // 서비스가 시작되면 호출되는 메소드

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("test","인텐트서비스 시작");
        return super.onStartCommand(intent, flags, startId);
    }


    // 서비스가 종료되면 호출되는 메소드


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test","인텐트서비스 종료");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i = 0; i<10; i++){
            SystemClock.sleep(1000); // 1초 기다림
            long time = System.currentTimeMillis(); // 현재 시간(밀리세컨드)
            Log.d("test","Service Running..." + time);
        }
    }


}
