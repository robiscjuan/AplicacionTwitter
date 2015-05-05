package com.example.juan.aplicaciontwitter.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.juan.aplicaciontwitter.R;
import com.example.juan.aplicaciontwitter.fragments.FollowSectionFragment;
import com.example.juan.aplicaciontwitter.fragments.TweetsSectionFragment;
import com.example.juan.aplicaciontwitter.fragments.UnfollowSectionFragment;

import java.util.Locale;

/**
 * Created by Juan on 22/04/2015.
 */

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a MainSectionFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return FollowSectionFragment.newInstance(position + 1);
       
            case 1:
                return TweetsSectionFragment.newInstance(position + 1);

            case 2:
                return UnfollowSectionFragment.newInstance(position + 1);

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return context.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return context.getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return context.getString(R.string.title_section3).toUpperCase(l);
        }
        return null;
    }
}