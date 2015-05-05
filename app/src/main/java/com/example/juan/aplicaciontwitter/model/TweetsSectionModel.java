package com.example.juan.aplicaciontwitter.model;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 19/04/2015.
 */
public class TweetsSectionModel {
    private List<Tweet> tweetList;

    public TweetsSectionModel() {
        tweetList = new ArrayList<Tweet>();
    }

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void loadTweetList(List<Tweet> tweetList) {
        this.tweetList.clear();
        this.tweetList.addAll(tweetList);
    }

    public void updateTweetList(List<Tweet> tweetList) {
        this.tweetList.addAll(0, tweetList);
    }

    public void loadMoreTweetList(List<Tweet> tweetList) {

    }
}
