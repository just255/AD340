package com.justinsimmons.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by just_ on 4/17/2017.
 */

public class MessageActivity extends AppCompatActivity{


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        lifecycleMessage("onCreate");

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
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


