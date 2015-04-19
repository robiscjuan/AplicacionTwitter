package com.example.juan.aplicaciontwitter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import java.util.List;

/**
 * Created by Juan on 19/04/2015.
 */
public class TweetActivity {
    public void obtenerListadoDeTweets(final Context contexto,final ViewPager mViewPager, final MainActivity.SectionsPagerAdapter mSectionsPagerAdapter){

// Can also use Twitter directly: Twitter.getApiClient()
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        StatusesService statusesService = twitterApiClient.getStatusesService();
            statusesService.homeTimeline(10,null,null,null,null,null,false,new Callback<List<Tweet>>() {
                @Override
                public void success(Result<List<Tweet>> listResult) {
                    ListView listTweets = (ListView)  mSectionsPagerAdapter.getRegistrerFragment(mViewPager.getCurrentItem()).getView().findViewById(R.id.listTweets);
                    listTweets.setAdapter(new CustomTweetAdapter(contexto, R.layout.row_tweet, listResult.data));
                }

                @Override
                public void failure(TwitterException e) {

                }
            });
    }
}
