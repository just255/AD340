package com.justinsimmons.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by just_ on 4/17/2017.
 */

public class MessageActivity extends AppCompatActivity{

    public static String lifecycle = "";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        lifecycleMessage("onCreate");
    }
    @Override
    public void onStart(){
        super.onStart();
        lifecycleMessage("onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        lifecycleMessage("onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        lifecycleMessage("onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        lifecycleMessage("onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        lifecycleMessage("onDestroy");
    }

    public static void lifecycleMessage(String lifecycle){
        Log.d("ACTIVITY LIFECYCLE", lifecycle);
    }

}


