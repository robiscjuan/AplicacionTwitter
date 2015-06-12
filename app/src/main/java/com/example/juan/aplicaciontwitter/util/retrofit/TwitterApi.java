package com.example.juan.aplicaciontwitter.util.retrofit;

import com.example.juan.aplicaciontwitter.util.signpost.retrofit.RetrofitHttpOAuthConsumer;
import com.example.juan.aplicaciontwitter.util.signpost.retrofit.SigningOkClient;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

import java.util.List;
import java.util.Map;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Alan Mark on 5/22/2015.
 */
public class TwitterApi {

    private static final String TWITTER_KEY = "YkSUSp1BiT8Bk7MydRsoKhtdT";
    private static final String TWITTER_SECRET = "zhHUz6LbS09dXIXPBGkRi659uErRIUnfpBJvQggqbV9OQPs0uk";
    private static TwitterApiService service = null;

    private TwitterApi() {
    }

    public static void init(String token, String tokenSecret) {
        RetrofitHttpOAuthConsumer oAuthConsumer = new RetrofitHttpOAuthConsumer(TWITTER_KEY, TWITTER_SECRET);
        oAuthConsumer.setTokenWithSecret(token, tokenSecret);
        OkClient client = new SigningOkClient(oAuthConsumer);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.twitter.com/1.1")
                .setClient(client)
                .build();
        service = adapter.create(TwitterApiService.class);
    }

    public static void getHomeTimeline(Map<String, String> options, Callback<List<Tweet>> cb) {
        service.getHomeTimeline(options, cb);
    }

    public static void getFollowing(Map<String, String> options, Callback<Ids> cb) {
        service.getFollowing(options, cb);
    }

    public static void getFollowers(Map<String, String> options, Callback<Ids> cb) {
        service.getFollowers(options, cb);
    }

    public static void getUsers(Map<String, String> options, Callback<List<User>> cb) {
        service.getUsers(options, cb);
    }
}
