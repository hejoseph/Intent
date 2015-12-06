package com.example.administrateur.intentexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "com.jo.intenttest";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "on start method");
        Thread josThread = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i=0; i<5; i++){
                    long futureTime = System.currentTimeMillis() + 10000;
                    while(System.currentTimeMillis()<futureTime){
                        synchronized (this){
                            try{
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG, "services is doing something");
                            }catch(Exception e){}
                        }
                    }
                }
            }
        });
        josThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"on destroy method");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
