package com.example.juan.aplicaciontwitter.util.retrofit;

import com.example.juan.aplicaciontwitter.util.signpost.retrofit.RetrofitHttpOAuthConsumer;
import com.example.juan.aplicaciontwitter.util.signpost.retrofit.SigningOkClient;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Alan Mark on 5/22/2015.
 */
public class TwitterApi {

    private static TwitterApiService service = null;

    private TwitterApi() {
    }

    public static void init(String key, String secret, String token, String tokenSecret) {
        RetrofitHttpOAuthConsumer oAuthConsumer = new RetrofitHttpOAuthConsumer(key, secret);
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

    public static void postStatus(Map<String, String> options, Callback<Tweet> cb) {
        service.postStatus(options, cb);
    }

    public static void postUnfollow(Map<String, String> options, Callback<User> cb) {
        service.postUnfollow(options, cb);
    }

    public static void postFollow(Map<String, String> options, Callback<User> cb) {
        service.postFollow(options, cb);
    }

    public static void postRetweet(long id, Map<String, String> options, Callback<Tweet> cb) {
        service.postRetweet(id, options, cb);
    }

    public static void postFavorite(Map<String, String> options, Callback<Tweet> cb) {
        service.postFavorite(options, cb);
    }

    public static void getStatuses(Map<String, String> options, Callback cb){
        service.getStatuses(options, cb);
    }

    public static void getStatusRetweeters(Map<String, String> options, Callback<Ids> cb){
        service.getStatusRetweeters(options, cb);
    }
}
