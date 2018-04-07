package com.example.ibrahim.testworldcup.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ibrahim.testworldcup.Fragmnets.TabFragmentComing;
import com.example.ibrahim.testworldcup.Fragmnets.TabFragmentLast;
import com.example.ibrahim.testworldcup.Fragmnets.TapFragmentTeams;

public class PagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentComing tabFragmentComing= new TabFragmentComing();
                return tabFragmentComing;
            case 1:
                TabFragmentLast tabFragmentLast = new TabFragmentLast();
                return tabFragmentLast;
            case 2:
                TapFragmentTeams tapFragmentToday = new TapFragmentTeams ();
                return tapFragmentToday;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}