package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;

import com.example.juan.aplicaciontwitter.fragments.MainSectionFragment;
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
public class TweetsSectionPresenter implements MainSectionPresenter {
    private TweetsSectionModel model;
    private MainSectionFragment view;
    private StatusesService statusesService;


    public TweetsSectionPresenter(MainSectionFragment view) {
        model = new TweetsSectionModel();
        this.view = view;
        this.view.setList(model.getTweetList());
        statusesService = Twitter.getApiClient().getStatusesService();
        loadData();
    }

    @Override
    public void loadData() {
        statusesService.homeTimeline(10, null, null, null, null, null, false, new Callback<List<Tweet>>() {
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
        statusesService.homeTimeline(10, firstTweetId, null, null, null, null, false, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("updateData con éxito", "");
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
    public void loadMoreData() {
        Long lastTweetId = model.getTweetList().get(model.getTweetList().size() - 1).getId();
        statusesService.homeTimeline(10, null, lastTweetId, null, null, null, false, new Callback<List<Tweet>>() {
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
