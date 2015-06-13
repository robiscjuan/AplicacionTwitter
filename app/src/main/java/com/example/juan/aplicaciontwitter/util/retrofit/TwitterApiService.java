package com.example.juan.aplicaciontwitter.util.retrofit;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.QueryMap;

/**
 * Created by Alan Mark on 5/22/2015.
 */
public interface TwitterApiService {

    @GET("/statuses/home_timeline.json")
    void getHomeTimeline(@QueryMap Map<String, String> options, Callback<List<Tweet>> cb);

    @GET("/friends/ids.json")
    void getFollowing(@QueryMap Map<String, String> options, Callback<Ids> cb);

    @GET("/followers/ids.json")
    void getFollowers(@QueryMap Map<String, String> options, Callback<Ids> cb);

    @GET("/users/lookup.json")
    void getUsers(@QueryMap Map<String, String> options, Callback<List<User>> cb);

    @FormUrlEncoded
    @POST("/statuses/update.json")
    void postStatus(@FieldMap Map<String, String> options, Callback<Tweet> cb);

    @FormUrlEncoded
    @POST("/friendships/destroy.json")
    void postUnfollow(@FieldMap Map<String, String> options, Callback<User> cb);

    @FormUrlEncoded
    @POST("/friendships/create.json")
    void postFollow(@FieldMap Map<String, String> options, Callback<User> cb);

}
