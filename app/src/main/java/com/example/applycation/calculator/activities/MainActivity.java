package com.example.applycation.calculator.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.applycation.calculator.R;
public class MainActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
