package com.example.juan.aplicaciontwitter.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juan.aplicaciontwitter.R;
import com.example.juan.aplicaciontwitter.presenter.MainSectionPresenter;
import com.example.juan.aplicaciontwitter.util.CustomMainAdapter;

import java.util.List;

/**
 * Created by Juan on 22/04/2015.
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class MainSectionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    protected static final String ARG_SECTION_NUMBER = "section_number";
    protected MainSectionPresenter mainSectionPresenter;
    protected CustomMainAdapter customMainAdapter;
    protected List list;
    SwipeRefreshLayout swipeView;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        customMainAdapter.setContext(getActivity());

        swipeView = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe);
        swipeView.setOnRefreshListener(this);

        ListView listTweets = (ListView) rootView.findViewById(R.id.listTweets);
        listTweets.setAdapter(customMainAdapter);
        return rootView;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public void updateView() {
        customMainAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        swipeView.setRefreshing(true);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                swipeView.setRefreshing(false);
                mainSectionPresenter.loadData();
                Toast.makeText(customMainAdapter.getContext(), "Cargando", Toast.LENGTH_LONG).show();
            }
        });
    }
}
