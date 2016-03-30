package com.example.applycation.calculator.activities;

/**
 * Created by Apink on 30/03/2016.
 */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.applycation.calculator.R;
import com.example.applycation.calculator.activities.Activity_TabLayout_GiaiPT.CustomAdapter;


public class ActivityGiaiPT extends AppCompatActivity {

    TabLayout tab_layout;
    ViewPager view_pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_phuong_trinh);

        attachID();
        attachView();
        attachListener();

    }
    public void attachID(){
        view_pager = (ViewPager)findViewById(R.id.view_pager);
        tab_layout = (TabLayout)findViewById(R.id.tab_layout);
    }

    public void attachView(){
        view_pager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));
        tab_layout.setupWithViewPager(view_pager);
    }
    public void attachListener(){
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());

            }
        });
    }
}