package com.example.juan.aplicaciontwitter.presenter;

import com.example.juan.aplicaciontwitter.view.MainActivity;

/**
 * Created by Juan on 22/04/2015.
 */
public class MainPresenter {
    private TuitPresenter tuitPresenter;
    private FollowPresenter followPresenter;
    private UnfollowPresenter unfollowPresenter;
    public MainPresenter(MainActivity mainActivity){
        tuitPresenter = new TuitPresenter(mainActivity);
    }
    public void presenterTweetsTimeline(){
        tuitPresenter.presenterTweetsTimeline();
    }
}
