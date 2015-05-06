package com.example.juan.aplicaciontwitter.model;

import com.twitter.sdk.android.core.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 19/04/2015.
 */
public class FollowSectionModel {
    private List<User> userList;

    public FollowSectionModel() {
        userList = new ArrayList<User>();
    }

    public List<User> getUserList() {
        return userList;
    }
}
