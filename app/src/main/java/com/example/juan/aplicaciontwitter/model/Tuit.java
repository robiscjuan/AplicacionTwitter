package com.example.juan.aplicaciontwitter.model;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ListView;

import com.example.juan.aplicaciontwitter.view.CustomTweetAdapter;
import com.example.juan.aplicaciontwitter.view.MainActivity;
import com.example.juan.aplicaciontwitter.R;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.example.juan.aplicaciontwitter.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by Juan on 19/04/2015.
 */
public class Tuit  {
   private  List<Tweet> listaTweets;
    public Tuit(){
        listaTweets = new ArrayList<Tweet>();
    }

    public List<Tweet> getTimeline()  {
        return listaTweets;
    }
}
