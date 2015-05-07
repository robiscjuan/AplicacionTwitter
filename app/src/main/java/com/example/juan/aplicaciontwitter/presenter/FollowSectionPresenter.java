package com.example.juan.aplicaciontwitter.presenter;

import com.example.juan.aplicaciontwitter.fragments.MainSectionFragment;
import com.example.juan.aplicaciontwitter.model.FollowSectionModel;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.services.StatusesService;

/**
 * Created by Juan on 22/04/2015.
 */
public class FollowSectionPresenter extends MainSectionPresenter {
    private FollowSectionModel model;
    private StatusesService statusesService;

    public FollowSectionPresenter(MainSectionFragment view) {
        model = new FollowSectionModel();
        this.view = view;
        this.view.setList(model.getUserList());
        statusesService = Twitter.getApiClient().getStatusesService();
        loadData();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void updateData() {

    }

    @Override
    public void loadMoreData() {

    }
}
