package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;

import com.example.juan.aplicaciontwitter.fragments.MainSectionFragment;
import com.example.juan.aplicaciontwitter.model.TweetsSectionModel;
import com.example.juan.aplicaciontwitter.util.retrofit.TwitterApi;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan on 22/04/2015.
 */
public class TweetsSectionPresenter extends MainSectionPresenter {
    private TweetsSectionModel model;


    public TweetsSectionPresenter(MainSectionFragment view) {
        model = new TweetsSectionModel();
        this.view = view;
        this.view.setList(model.getTweetList());
        loadData();
    }

    @Override
    public void loadData() {
        Map<String, String> options = new HashMap<>();
        options.put("count", "10");
        TwitterApi.getHomeTimeline(options, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("loadData con éxito", "");
                model.loadTweetList(listResult.data);
                view.updateView();
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Timeline con fracaso", "");
            }
        });
    }

    @Override
    public void updateData() {
        Long firstTweetId = model.getTweetList().get(0).getId();
        Map<String, String> options = new HashMap<>();
        options.put("count", "10");
        options.put("since_id", firstTweetId.toString());
        TwitterApi.getHomeTimeline(options, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("updateData con éxito", "");
                model.updateTweetList(listResult.data);
                view.updateView();
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Timeline con fracaso", "");
            }
        });
    }

    @Override
    public void loadMoreData() {
        Long lastTweetId = model.getTweetList().get(model.getTweetList().size() - 1).getId();
        Map<String, String> options = new HashMap<>();
        options.put("count", "10");
        options.put("max_id", lastTweetId.toString());
        TwitterApi.getHomeTimeline(options, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("loadMoreData con éxito", "");
                model.loadTweetList(listResult.data);
                view.updateView();
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Timeline con fracaso", "");
            }
        });

    }
}
