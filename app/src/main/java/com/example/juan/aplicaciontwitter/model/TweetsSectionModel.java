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

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList.clear();
        this.tweetList.addAll(tweetList);
    }
}
