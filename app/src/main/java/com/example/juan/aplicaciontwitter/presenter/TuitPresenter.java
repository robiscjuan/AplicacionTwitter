package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;
import android.widget.ListView;

import com.example.juan.aplicaciontwitter.R;
import com.example.juan.aplicaciontwitter.model.Tuit;
import com.example.juan.aplicaciontwitter.view.CustomTweetAdapter;
import com.example.juan.aplicaciontwitter.view.MainActivity;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 22/04/2015.
 */
public class TuitPresenter {
    private Tuit modelo;
    private MainActivity vista;

    public  TuitPresenter(MainActivity mainActivityVista){
        modelo = new Tuit();
        this.vista = mainActivityVista;
    }
    public void presenterTweetsTimeline(){
        StatusesService statusesService = Twitter.getApiClient().getStatusesService();
        statusesService.homeTimeline(10,null,null,null,null,null,false,new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                Log.e("Timeline con éxito","");
                //modelo.setTimeline(listResult.data);
                //vista.mostrarTimeline(modelo.getTimeline());
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

    }
}
