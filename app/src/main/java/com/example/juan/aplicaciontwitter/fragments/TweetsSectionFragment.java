package com.example.juan.aplicaciontwitter.fragments;

import android.os.Bundle;

import com.example.juan.aplicaciontwitter.presenter.TweetsSectionPresenter;
import com.example.juan.aplicaciontwitter.util.CustomTweetAdapter;

/**
 * Created by Juan on 29/04/2015.
 */
public class TweetsSectionFragment extends MainSectionFragment {
    public TweetsSectionFragment() {
        this.mainSectionPresenter = new TweetsSectionPresenter(this);
        //TODO list es Lis<?> así que habría que comprobar que ? es tweet
        this.customMainAdapter = new CustomTweetAdapter(this.list);
    }

    public static TweetsSectionFragment newInstance(int sectionNumber) {
        TweetsSectionFragment fragment = new TweetsSectionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
