package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;

import com.example.juan.aplicaciontwitter.PlaceholderFragment;
import com.example.juan.aplicaciontwitter.model.TweetsSectionModel;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import java.util.List;

/**
 * Created by Juan on 22/04/2015.
 */
public class TweetsSectionPresenter {
    private TweetsSectionModel model;
    private PlaceholderFragment view;

    public TweetsSectionPresenter(PlaceholderFragment view) {
        model = new TweetsSectionModel();
        this.view = view;
        this.view.setTweetList(model.getTweetList());

        loadData();
    }

    public void loadData() {
        StatusesService statusesService = Twitter.getApiClient().getStatusesService();
        statusesService.homeTimeline(10, null, null, null, null, null, false, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("Timeline con éxito", "");
                model.setTweetList(listResult.data);
                view.updateView();
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Timeline con fracaso", "");
            }
        });

        Log.e("Se va a usar la posicion", " 1");
    }
}
