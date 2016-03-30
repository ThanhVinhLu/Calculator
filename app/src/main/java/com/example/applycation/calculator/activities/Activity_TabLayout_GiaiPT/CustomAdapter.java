package com.example.applycation.calculator.activities.Activity_TabLayout_GiaiPT;

import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * Created by Apink on 30/03/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Apink on 27/03/2016.
 */
public class CustomAdapter extends FragmentPagerAdapter {
    private String fragments[] ={"Bac 1", "Bac 2", "Bac 3"};
    public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ActivityPtBac1();
            case 1: return new ActivityPtBac2();
            case 2: return new ActivityPtBac3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}

