package com.justinsimmons.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by just_ on 4/17/2017.
 */

public class MessageActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lifecycleMessage("onCreate");

        Intent intent = getIntent();
        String message = intent.getStringExtra("job_title");
        Log.d("MESSAGE : ", message);
        TextView lblJobTitle = (TextView) findViewById(R.id.lblMessageFromMain);
        lblJobTitle.setText(message);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        // Hide menu item
        invalidateOptionsMenu();
        MenuItem about = menu.findItem(R.id.message_item);
        about.setVisible(false);

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
                intent = new Intent(MessageActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.message_item:
                intent = new Intent(MessageActivity.this, MessageActivity.class);
                startActivity(intent);
                break;
            case R.id.movies_item:
                intent = new Intent(MessageActivity.this, RecyclerActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}


