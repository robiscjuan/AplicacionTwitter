package com.example.juan.aplicaciontwitter;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.TweetView;


/**
 * Created by Juan on 19/04/2015.
 */
public class LoginActivity  extends Activity {
    private TwitterLoginButton loginButton;


    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);



    setContentView(R.layout.login);
    loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
    loginButton.setCallback(new Callback<TwitterSession>() {
        @Override
        public void success(Result<TwitterSession> result) {
            //Después de la creación de tabs




            finish();

        }

        @Override
        public void failure(TwitterException exception) {
            // Do something on failure
        }
    });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
