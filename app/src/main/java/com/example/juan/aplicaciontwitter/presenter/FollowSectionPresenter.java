package com.example.juan.aplicaciontwitter.presenter;

import android.util.Log;

import com.example.juan.aplicaciontwitter.fragments.MainSectionFragment;
import com.example.juan.aplicaciontwitter.model.FollowSectionModel;
import com.example.juan.aplicaciontwitter.util.retrofit.Ids;
import com.example.juan.aplicaciontwitter.util.retrofit.TwitterApi;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan on 22/04/2015.
 */
public class FollowSectionPresenter extends MainSectionPresenter {
    private final static String[] cuentas  = {"MejoresTwits", /*"Sr_AmadorRivas", /*"TuFraseDisney",*/ "escupotwits",/*"EresKurioso,"*/ "PostureoTwits", "UnAIumno", "DijoMarley", "LocoOtro", "TopMejoresTwits"};
    private FollowSectionModel model;

    public FollowSectionPresenter(MainSectionFragment view) {
        model = new FollowSectionModel();
        this.view = view;
        this.view.setList(model.getUserList());
        loadData();
    }

    @Override
    public void loadData() {
        final Map<String, String> options = new HashMap<>();
        final Map<String, String> optionsF = new HashMap<>();
        final Map<String, String> optionsU = new HashMap<>();
        options.put("count", "1");
        options.put("include_rts","false");
        optionsF.put("stringify_ids","false");
        //for (int i=0;i<cuentas.length;i++) {
            options.put("screen_name",cuentas[0]);
            TwitterApi.getStatuses(options,new Callback<List<Tweet>>() {
                @Override
                public void success(Result<List<Tweet>> listResult) {
                    if(listResult.data.iterator().hasNext()){
                        optionsF.put("id",String.valueOf(listResult.data.iterator().next().getId()));
                        TwitterApi.getStatusRetweeters(optionsF, new Callback<Ids>() {
                            @Override
                            public void success(Result<Ids> idsResult) {
                                Iterator usersI = idsResult.data.getIds().iterator();
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

                            }
                        });
                    }
                }

                @Override
                public void failure(TwitterException e) {
                    Log.e("Timeline con fracaso", "");
                }
            });
        //}

    }

    @Override
    public void updateData() {
        final Map<String, String> options = new HashMap<>();
        final Map<String, String> optionsF = new HashMap<>();
        final Map<String, String> optionsU = new HashMap<>();
        options.put("count", "1");
        options.put("include_rts", "false");
        optionsF.put("stringify_ids", "false");
        //for (int i=0;i<cuentas.length;i++) {
        options.put("screen_name", cuentas[0]);
        TwitterApi.getStatuses(options, new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> listResult) {
                if (listResult.data.iterator().hasNext()) {
                    optionsF.put("id", String.valueOf(listResult.data.iterator().next().getId()));
                    TwitterApi.getStatusRetweeters(optionsF, new Callback<Ids>() {
                        @Override
                        public void success(Result<Ids> idsResult) {
                            Iterator usersI = idsResult.data.getIds().iterator();
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
                                    model.updateTweetList(listResult.data);
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

                        }
                    });
                }
            }

            @Override
            public void failure(TwitterException e) {
                Log.e("Timeline con fracaso", "");
            }
        });
        //}
    }

    @Override
    public void loadMoreData() {

    }
}
