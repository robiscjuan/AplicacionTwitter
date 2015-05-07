package com.example.juan.aplicaciontwitter.util;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Juan on 05/05/2015.
 */
public abstract class CustomMainAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> list;

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }
}
