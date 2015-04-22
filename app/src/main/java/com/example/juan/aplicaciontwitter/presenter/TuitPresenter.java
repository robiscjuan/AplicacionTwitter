package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;
import android.widget.ListView;

import com.example.juan.aplicaciontwitter.R;
import com.example.juan.aplicaciontwitter.model.Tuit;
import com.example.juan.aplicaciontwitter.view.CustomTweetAdapter;
import com.example.juan.aplicaciontwitter.view.MainActivity;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;

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
        Log.e("Se va a usar la posicion"," 1");
        ListView listTweets = (ListView)  vista.getmSectionsPagerAdapter().getRegistrerFragment(1).getView().findViewById(R.id.listTweets);
        listTweets.setAdapter(new CustomTweetAdapter(vista.getApplicationContext(), R.layout.row_tweet,FALLO.getTimeline()));
    }
}
