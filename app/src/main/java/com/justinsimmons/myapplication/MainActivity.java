package com.justinsimmons.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    String[] web = {
            "Recycler View",
            "Button 2",
            "Button 3",
            "Button 4"

    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartMessageActivity = (Button) findViewById(R.id.btnStartMessageActivity);
        btnStartMessageActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent message = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(message);
            }
        });

        ButtonGridAdapter adapter = new ButtonGridAdapter(MainActivity.this, web);
        grid=(GridView)findViewById(R.id.buttonGrid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked " +web[+ position], Toast.LENGTH_SHORT).show();

                if (web[position].equals("Recycler View")){
                    Intent recycler = new Intent(MainActivity.this, RecyclerActivity.class);
                    startActivity(recycler);
                }

            }
        });

    }

/*    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartMessageActivity:
                Intent message = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(message);
                break;
            case R.id.btnRecycler:
                Intent recycler = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(recycler);
                break;
            case R.id.btn2:
                Toast.makeText(this, "You pressed button #2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:
                Toast.makeText(this, "You pressed button #3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn4:
                Toast.makeText(this, "You pressed button #4", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    */
}

