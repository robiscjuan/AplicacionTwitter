package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;

import com.example.juan.aplicaciontwitter.fragments.MainSectionFragment;
import com.example.juan.aplicaciontwitter.model.UnfollowSectionModel;
import com.example.juan.aplicaciontwitter.util.retrofit.Ids;
import com.example.juan.aplicaciontwitter.util.retrofit.TwitterApi;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan on 22/04/2015.
 */
public class UnfollowSectionPresenter extends MainSectionPresenter {
    private UnfollowSectionModel model;

    public UnfollowSectionPresenter(MainSectionFragment view) {
        model = new UnfollowSectionModel();
        this.view = view;
        this.view.setList(model.getUserList());
        loadData();
    }

    @Override
    public void loadData() {
        final Map<String, String> options = new HashMap<>();
        final Map<String, String> optionsU = new HashMap<>();
        options.put("count", "50");
        options.put("stringify_ids", "false");
        TwitterApi.getFollowing(options, new Callback<Ids>() {
            @Override
            public void success(final Result<Ids> Result) {
                Log.e("updateData con éxito", "");
                model.loadFollowingIdsObject(Result.data);
                model.loadFilteredFollowingIdsObject(Result.data);
                TwitterApi.getFollowers(options, new Callback<Ids>() {
                    @Override
                    public void success(Result<Ids> idsResult) {
                        model.loadFollowersIdsObject(idsResult.data);
                        model.getFilteredFollowingIdsObject().getIds().removeAll(model.getFollowersIdsObject().getIds());
                        Iterator usersI = model.getFilteredFollowingIdsObject().getIds().iterator();
                        String user_id = "";
                        for (int i = 0; i < 50; i++) {
                            if (usersI.hasNext()) {
                                user_id = user_id + usersI.next() + ",";
                            } else {
                                break;
                            }
                        }
                        if (usersI.hasNext())
                            user_id = user_id + usersI.next();          //TODO Se permite MAX 100 ids según la API
                        optionsU.put("user_id", user_id);
                        TwitterApi.getUsers(optionsU, new Callback<List<User>>() {
                            @Override
                            public void success(Result<List<User>> listResult) {
                                model.loadUserList(listResult.data);
                                view.updateView();
                            }

                            @Override
                            public void failure(TwitterException e) {
                                Log.e("Fallo update users", "");
                            }
                        });
                    }

                    @Override
                    public void failure(TwitterException e) {
                        Log.e("Fallo update followers", "");
                    }
                });
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Fallo Unfollowfollowing", "");
            }
        });

        Log.e("s", "");
    }

    @Override
    public void updateData() {

    }

    @Override
    public void loadMoreData() {

    }
}
