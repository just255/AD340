package com.justinsimmons.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Button btnStartMessageActivity = (Button) findViewById(R.id.btnStartMessageActivity);
        btnStartMessageActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent message = new Intent(MainActivity.this, MessageActivity.class);
                EditText txtBox = (EditText) findViewById(R.id.editText);
                String text = txtBox.getText().toString();
                message.putExtra("job_title", text);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Continue?")
                        .setTitle("Confirm Action");
                // Add the buttons
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Log.d("DIALOG", "User selected Yes");
                        startActivity(message);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Log.d("DIALOG", "User selected No");
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about_item:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.message_item:
                intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
                break;
            case R.id.movies_item:
                intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

