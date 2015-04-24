package com.example.juan.aplicaciontwitter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.juan.aplicaciontwitter.presenter.TweetsSectionPresenter;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Juan on 22/04/2015.
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private TweetsSectionPresenter tweetsSectionPresenter;

    private CustomTweetAdapter customTweetAdapter;

    private List<Tweet> tweetList;

    public PlaceholderFragment() {
        tweetsSectionPresenter = new TweetsSectionPresenter(this);
        customTweetAdapter = new CustomTweetAdapter(tweetList);
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        customTweetAdapter.setContext(getActivity());

        ListView listTweets = (ListView) rootView.findViewById(R.id.listTweets);
        listTweets.setAdapter(customTweetAdapter);

        return rootView;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    public void updateView() {
        customTweetAdapter.notifyDataSetChanged();
    }
}
