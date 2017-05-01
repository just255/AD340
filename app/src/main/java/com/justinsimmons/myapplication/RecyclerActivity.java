package com.justinsimmons.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    RecyclerView.LayoutManager recylerViewLayoutManager;

    // 2D data array
    String[][] subjects =
            {
                    { "ANDROID", "1" },
                    { "PHP", "2" },
                    { "JSON", "3" },
                    { "SWIFT", "4" },
                    { "OBJECTIVE-C", "5" },
                    { "SQL", "6" },
                    { "JAVA", "7" },
                    { "JAVASCRIPT", "8" },
                    { "REACT", "9" },
                    { "PYTHON", "10" },
                    { "ANGULAR", "11" },
                    { "JQUERY", "12" },
                    { "CANVAS", "13" },
                    { "D3", "14" },
                    { "MATPLOTLIB", "15" },
                    { "NODE", "16" },
                    { "NODE2", "17" },
                    { "NODE3", "18" },
                    { "NODE4", "19" },
                    { "NODE5", "20" }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);

        // use a linear layout manager
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

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