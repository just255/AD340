package com.justinsimmons.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by just_ on 4/26/2017.
 */

public class RecyclerActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    // 2D data array
    String[][] subjects =
            {
                    { "The Dark Knight", "2008" },
                    { "Raiders of the Lost Ark", "1981" },
                    { "Casino Royale", "2006" },
                    { "Terminator 2: Judgement Day", "1991" },
                    { "The Bourne Ultimatum", "2007" },
                    { "Mad Max: Fury Road", "2015" },
                    { "The Matrix", "1999" },
                    { "Aliens", "1986" },
                    { "Mad Max 2", "1981" },
                    { "Die Hard", "1988" },
                    { "The Avengers", "2012" },
                    { "The Raid: Redemption", "2011" },
                    { "Star Wars", "1977" },
                    { "Predator", "1987" },
                    { "Gladiator", "2000" },
                    { "Taken", "2008" },
                    { "Skyfall", "2012" },
                    { "Seven Samurai", "1954" },
                    { "Rambo: First Blood", "1982" },
                    { "True Lies", "1994" }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);

        // use a linear layout manager
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));

        recyclerViewAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTitle;
            public TextView mDetail;
            public ViewHolder(View v) {
                super(v);
                mTitle = (TextView) v.findViewById(R.id.subject_1);
                mDetail = (TextView) v.findViewById(R.id.subject_2);
            }
        }

        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

            // Inflate the view for this view holder
            View item = getLayoutInflater().inflate(R.layout.list_item2, parent,
                    false);

            // Call the view holder's constructor, and pass the view to it;
            // return that new view holder
            ViewHolder vh = new ViewHolder(item);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            Log.d("PLACES", "subjects equals " + subjects[position][0]);
            Log.d("PLACES", "subjects equals " + subjects[position][1]);
            holder.mTitle.setText(subjects[position][0]);
            holder.mDetail.setText(subjects[position][1]);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return subjects.length;
        }
    }
}