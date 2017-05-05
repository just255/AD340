package com.justinsimmons.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
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
    String[] dialogItems = {
            "Yes",
            "No",
            "I Like This Popup"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Prevents keyboard from auto popping up
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        Button btnStartMessageActivity = (Button) findViewById(R.id.btnStartMessageActivity);
        btnStartMessageActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent message = new Intent(MainActivity.this, MessageActivity.class);
                EditText txtBox = (EditText) findViewById(R.id.editText);
                String text = txtBox.getText().toString();
                message.putExtra("job_title", text);
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Continue to Message Activity?")
                        .setItems(dialogItems, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle item selection
                                switch (which) {
                                    case 0:
                                        startActivity(message);
                                        Log.d("DIALOG", "User selected Yes");
                                        break;
                                    case 1:
                                        Log.d("DIALOG", "User selected No");
                                        break;
                                    case 2:
                                        Log.d("DIALOG", "User really likes the dialog screen");
                                        AlertDialog dialog1 = builder.create();
                                        dialog1.show();
                                }
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

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
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

