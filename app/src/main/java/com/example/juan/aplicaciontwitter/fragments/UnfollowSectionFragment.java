package com.example.juan.aplicaciontwitter.fragments;

import android.os.Bundle;

import com.example.juan.aplicaciontwitter.presenter.UnfollowSectionPresenter;
import com.example.juan.aplicaciontwitter.util.CustomFollowAdapter;

/**
 * Created by Juan on 29/04/2015.
 */
public class UnfollowSectionFragment extends MainSectionFragment {
    public UnfollowSectionFragment() {
        this.mainSectionPresenter = new UnfollowSectionPresenter(this);
        //TODO list es Lis<?> así que habría que comprobar que ? es usuario
        this.customMainAdapter = new CustomFollowAdapter(this.list, false);
    }

    public static UnfollowSectionFragment newInstance(int sectionNumber) {
        UnfollowSectionFragment fragment = new UnfollowSectionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
