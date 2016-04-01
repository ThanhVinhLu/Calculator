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
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.PopupMenu;

import com.example.applycation.calculator.R;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;


/**
 * Created by PC on 3/27/2016.
 */
public abstract class BaseActivity extends ActionBarActivity implements OnMenuItemClickListener{


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
                starColorAnimaton(v,0xFFFFFFFF);
                startActivity(new Intent(BaseActivity.this, BasicCalculator.class));
                finish();
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
        findViewById(R.id.button_binhThuong).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                starColorAnimaton(v,0xFFFFFFFF);
                startActivity(new Intent(BaseActivity.this, NormalCalculator.class));
                finish();
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
        findViewById(R.id.button_nangCao).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                starColorAnimaton(v,0xFFFFFFFF);
                startActivity(new Intent(BaseActivity.this, AdvancedCalculator.class));
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
                shouldInvalidateOptionMenu = true;
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
        switch (id){
            case R.id.action_setting:
                Toast.makeText(getBaseContext(),"Setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_help:
                Toast.makeText(getBaseContext(),"Help",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_feedBack:
                Toast.makeText(getBaseContext(),"Feed back",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_history:
                Toast.makeText(getBaseContext(),"History",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_aboutUs:
                Toast.makeText(getBaseContext(),"About us",Toast.LENGTH_SHORT).show();
                break;
            default: break;
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

}
