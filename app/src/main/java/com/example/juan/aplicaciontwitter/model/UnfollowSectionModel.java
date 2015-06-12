package com.example.juan.aplicaciontwitter.model;

import com.example.juan.aplicaciontwitter.util.retrofit.Ids;
import com.twitter.sdk.android.core.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 19/04/2015.
 */
public class UnfollowSectionModel {
    private final Ids followingIdsObject, followersIdsObject, filteredFollowingIdsObject;
    private final List<User> userList;

    public UnfollowSectionModel() {
        followingIdsObject = new Ids();
        followersIdsObject = new Ids();
        filteredFollowingIdsObject = new Ids();
        userList = new ArrayList<User>();
    }

    public void loadFollowingIdsObject(Ids followingIdsObject) {
        this.followingIdsObject.getIds().clear();
        this.followersIdsObject.getIds().addAll(followingIdsObject.getIds());
    }

    public Ids getFollowingIdsObject() {
        return followingIdsObject;
    }

    public void loadFollowersIdsObject(Ids followersIdsObject) {
        this.followersIdsObject.getIds().clear();
        this.followersIdsObject.getIds().addAll(followersIdsObject.getIds());
    }

    public Ids getFollowersIdsObject() {
        return followersIdsObject;
    }

    public void loadFilteredFollowingIdsObject(Ids filteredFollowingIdsObject) {
        this.filteredFollowingIdsObject.getIds().clear();
        this.filteredFollowingIdsObject.getIds().addAll(filteredFollowingIdsObject.getIds());
    }

    public Ids getFilteredFollowingIdsObject() {
        return filteredFollowingIdsObject;
    }

    public void loadUserList(List<User> userList) {
        this.userList.clear();
        this.userList.addAll(userList);
    }
    public List<User> getUserList() {
        return userList;
    }

}

