package com.example.juan.aplicaciontwitter.fragments;

import android.os.Bundle;

import com.example.juan.aplicaciontwitter.presenter.FollowSectionPresenter;
import com.example.juan.aplicaciontwitter.util.CustomFollowAdapter;

/**
 * Created by Juan on 29/04/2015.
 */
public class FollowSectionFragment extends MainSectionFragment {
    public FollowSectionFragment() {
        this.mainSectionPresenter = new FollowSectionPresenter(this);
        //TODO list es Lis<?> así que habría que comprobar que ? es usuario
        this.customMainAdapter = new CustomFollowAdapter(this.list, true);
    }

    public static FollowSectionFragment newInstance(int sectionNumber) {
        FollowSectionFragment fragment = new FollowSectionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
