package com.example.applycation.calculator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.applycation.calculator.R;

public class AdvancedCalculator extends BaseActivity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_advanced);
    }
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
