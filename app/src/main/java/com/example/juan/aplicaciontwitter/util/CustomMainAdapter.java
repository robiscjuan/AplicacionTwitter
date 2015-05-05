package com.example.juan.aplicaciontwitter.util;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Juan on 05/05/2015.
 */
public abstract class CustomMainAdapter extends BaseAdapter {
    protected Context context;
    protected List<?> list;

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

    //TODO Revisar
    @Override
    public long getItemId(int position) {
        return position;
    }
}
