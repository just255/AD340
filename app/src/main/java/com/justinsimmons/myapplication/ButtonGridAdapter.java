package com.justinsimmons.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by just_ on 4/26/2017.
 */

public class ButtonGridAdapter extends BaseAdapter {

    private Context mContext;

    private final String[] web;

    public ButtonGridAdapter(Context c,String[] web) {
        mContext = c;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setText(web[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
