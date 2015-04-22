package com.example.juan.aplicaciontwitter.view;

/**
 * Created by Juan on 22/04/2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.Locale;

/**
 * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final int NUMEROTABS = 3;
    private PlaceholderFragment[] arrayFragment = new PlaceholderFragment[NUMEROTABS];
    private int numFragment;
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        // getItem is called to instantiate the fragment for the given page.
                     // Return a PlaceholderFragment (defined as a static inner class below).
                     arrayFragment[numFragment] = PlaceholderFragment.newInstance(position);
        Log.e("Se ha creado la poscion",""+position);
                     numFragment++;

                    return arrayFragment[numFragment-1];

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return NUMEROTABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Follow";//getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return "Tweets";//getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return "Unfollow";//getString(R.string.title_section3).toUpperCase(l);
        }
        return null;
    }

    public Fragment getRegistrerFragment(int position){
        return arrayFragment[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }
}
