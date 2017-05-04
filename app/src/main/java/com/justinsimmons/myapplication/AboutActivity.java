package com.justinsimmons.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by just_ on 5/4/2017.
 */

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView lblAbout = (TextView) findViewById(R.id.lblAbout);
        lblAbout.setText("This is my application. There are many like it, but this one is mine.\n\n" +
                "My application is my best friend. It is my life. I must master it as I must master my life.\n\n" +
                "Without me, my application is useless. Without my application, I am useless. \n\n " +
                "I must code my application true. I must debug better than my enemy who is trying to one-up me. \n\n " +
                "I must code faster than him before he codes faster than me. I will...\n\n" +
                "My application and I know that what counts in development is not the code we write, the noise of our sound effects, nor the visuals we make.\n\n" +
                " We know that it is the stability that counts. We will be stable...\n\n" +
                "My application is human, even as I, because it is my life. Thus, I will learn it as a brother. \n\n" +
                "I will learn its weaknesses, its strength, its classes, its activities, its scope and its variables.\n\n" +
                " I will keep my application clean and ready, even as I am clean and ready. We will become part of each other. We will...\n\n" +
                "Before God, I swear this creed. My application and I are the innovators of my country. \n\n" +
                "We are the masters of our enemy. We are the saviors of my life.\n\n" +
                "So be it, until victory is America's and there is no enemy, but peace!");
    }
}
