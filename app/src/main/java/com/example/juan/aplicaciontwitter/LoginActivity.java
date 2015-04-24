package com.example.juan.aplicaciontwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import io.fabric.sdk.android.Fabric;


/**
 * Created by Juan on 19/04/2015.
 */
public class LoginActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "YkSUSp1BiT8Bk7MydRsoKhtdT";
    private static final String TWITTER_SECRET = "zhHUz6LbS09dXIXPBGkRi659uErRIUnfpBJvQggqbV9OQPs0uk";
    private TwitterLoginButton loginButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        final Intent intent = new Intent(this, MainActivity.class);
        setContentView(R.layout.login);
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);

        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                startActivity(intent);


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
