package com.example.administrateur.intentexample;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class JosIntentService extends IntentService{

    private static final String TAG = "com.jo.intenttest";

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "the service has now started");
    }

    public JosIntentService(){
        super("JosIntentService");
    }
}
