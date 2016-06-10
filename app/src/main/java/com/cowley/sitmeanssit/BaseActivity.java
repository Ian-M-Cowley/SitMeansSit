package com.cowley.sitmeanssit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Ian Cowley on 6/6/16 at 11:37 PM.
 * <p>
 * Base Activity to provide functionality to all other Activities.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    public abstract int getLayoutResourceId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setupToolbarAndNavDrawer();
    }

    private void setupToolbarAndNavDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawerLayout == null) return;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar == null) return;

        mNavigationView = (NavigationView) findViewById(R.id.nav_drawer);
        if (mNavigationView == null) return;

        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, 0, 0);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(mNavigationItemSelectedListener);
        setSupportActionBar(mToolbar);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private NavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {

        }
        return true;
    };


}
