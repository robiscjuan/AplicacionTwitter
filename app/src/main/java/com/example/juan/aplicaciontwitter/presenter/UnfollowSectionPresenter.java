package com.example.juan.aplicaciontwitter.presenter;

import com.example.juan.aplicaciontwitter.fragments.MainSectionFragment;
import com.example.juan.aplicaciontwitter.model.UnfollowSectionModel;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.services.StatusesService;

/**
 * Created by Juan on 22/04/2015.
 */
public class UnfollowSectionPresenter extends MainSectionPresenter {
    private UnfollowSectionModel model;
    private StatusesService statusesService;

    public UnfollowSectionPresenter(MainSectionFragment view) {
        model = new UnfollowSectionModel();
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
