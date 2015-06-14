package com.example.juan.aplicaciontwitter.model;

import com.twitter.sdk.android.core.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Juan on 19/04/2015.
 */
public class FollowSectionModel {
    private Set<Long> toFollowIdsObject;
    private List<User> userList;

    public FollowSectionModel() {
        userList = new ArrayList<User>();
    }

    public void loadMoreDataToUserList(Set<Long> toFollowIdsObject) {
        this.toFollowIdsObject.addAll(toFollowIdsObject);
    }
    public void loadMoreIdsToList(Set<Long> toFollowIdsObject) {
        this.toFollowIdsObject.addAll(toFollowIdsObject);
    }

    public Set<Long> getIds(){
        return this.toFollowIdsObject;
    }

    public void loadUserList(List<User> userList) {
        this.userList.clear();
        this.userList.addAll(userList);
    }
        public List<User> getUserList() {
        return userList;
    }

    public void updateTweetList(List<User> userList) {
        this.userList.addAll(0, userList);
    }
}
