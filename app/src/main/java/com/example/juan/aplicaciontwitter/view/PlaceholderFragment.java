package com.example.juan.aplicaciontwitter.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Juan on 22/04/2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juan.aplicaciontwitter.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

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

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final List<Tweet> l = new ArrayList<Tweet>();
        final CustomTweetAdapter a = new CustomTweetAdapter(getActivity(), R.layout.row_tweet, l);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listTweets = (ListView)  rootView.findViewById(R.id.listTweets);
        listTweets.setAdapter(a);

        StatusesService statusesService = Twitter.getApiClient().getStatusesService();
        statusesService.homeTimeline(10,null,null,null,null,null,false,new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("Timeline con éxito", "");
                l.clear();
                l.addAll(listResult.data);
                a.notifyDataSetChanged();
                //  final Result<List<Tweet>> listaTweets = listResult;
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Timeline con fracaso","");
                //  final Result<List<Tweet>> listaTweets = null;
                final List<Tweet> listaTweets = null;
            }
        });

        Log.e("Se va a usar la posicion"," 1");

        return rootView;
    }
}
