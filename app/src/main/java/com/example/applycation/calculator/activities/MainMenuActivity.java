package com.example.applycation.calculator.activities;

/**
 * Created by PC on 3/28/2016.
 */
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.example.applycation.calculator.R;

public abstract class MainMenuActivity extends AppCompatActivity{


    private DrawerLayout drawerLayout;
    @Override
    protected void onPostCreate(Bundle saveState){
        super.onPostCreate(saveState);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar=(Toolbar) findViewById(R.id.include_toolbar);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_drawer);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.START))
                    drawerLayout.closeDrawer(Gravity.START);
                else drawerLayout.openDrawer(Gravity.START);
            }
        });

        findViewById(R.id.button_coBan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runtime(v);

                startActivity(new Intent(MainMenuActivity.this, ActivityBasCalculator.class));
                finish();
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
        findViewById(R.id.button_binhThuong).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainMenuActivity.this, ActivityNorCalculator.class));
                finish();
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
        findViewById(R.id.button_nangCao).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainMenuActivity.this, ActivityAdvCalculator.class));
                finish();
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
        findViewById(R.id.button_ptMotAn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainMenuActivity.this, ActivityGiaiPT.class));
                finish();
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {

            private boolean shouldInvalidateOptionMenu;

            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {
                shouldInvalidateOptionMenu = true;
            }

            @Override
            public void onDrawerClosed(View view) {
                shouldInvalidateOptionMenu=true;
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                if (newState == DrawerLayout.STATE_IDLE && shouldInvalidateOptionMenu) {
                    invalidateOptionsMenu();
                    shouldInvalidateOptionMenu = false;
                }
            }
        });
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(R.id.drawer_layout, !drawerLayout.isDrawerOpen(Gravity.START));
        return super.onPrepareOptionsMenu(menu);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void starColorAnimaton(View v,int color){
        int colorStar = Color.WHITE;
        int colorEnd = color;
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(
                v, "backgroundColor", colorStar, colorEnd
        );
        valueAnimator.setDuration(100);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();

    }
    public void runtime(View v){
        starColorAnimaton(v,Color.WHITE);
        long futureTime= System.currentTimeMillis()+300;
        while(System.currentTimeMillis()<futureTime){
            synchronized (this){
                try{
                    wait(futureTime-System.currentTimeMillis());
                }

                catch (Exception e) {

                } ;
            }

        }
    }
}
