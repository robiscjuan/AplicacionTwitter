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

import java.util.List;

/**
 * Created by Juan on 19/04/2015.
 */
public class Tuit extends Activity {
   private  List<Tweet> listaTweets;
    public List<Tweet> getTimeline(){
        // Can also use Twitter directly: Twitter.getApiClient()
          Log.e("ses",Twitter.getSessionManager().getActiveSession().getUserName());

        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        StatusesService statusesService = Twitter.getApiClient().getStatusesService();
        Log.e("Timeline","AQUÍ ESTOY");
            statusesService.homeTimeline(10,null,null,null,null,null,false,new Callback<List<Tweet>>() {
                @Override
                public void success(Result<List<Tweet>> listResult) {
                    Log.e("Timeline con éxito","");
                    Tuit.this.listaTweets = listResult.data;
                  //  final Result<List<Tweet>> listaTweets = listResult;
                }

                @Override
                public void failure(TwitterException e) {
                    Log.e("Timeline con fracaso","");
                  //  final Result<List<Tweet>> listaTweets = null;
                   final List<Tweet> listaTweets = null;
                }
            });
        return listaTweets;
    }
}
