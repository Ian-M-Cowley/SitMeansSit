package com.cowley.sitmeanssit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.cowley.sitmeanssit.contact.ContactUsActivity;
import com.cowley.sitmeanssit.home.HomeActivity;

/**
 * Created by Ian Cowley on 6/6/16 at 11:37 PM.
 * <p>
 * Base Activity to provide functionality to all other Activities.
 */

public abstract class BaseActivity extends AppCompatActivity {



    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;

    public abstract int getLayoutResourceId();
    public abstract int getNavigationId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setupToolbarAndNavDrawer();
    }

    private void setupToolbarAndNavDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout == null) return;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar == null) return;

        navigationView = (NavigationView) findViewById(R.id.nav_drawer);
        if (navigationView == null) return;

        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(mNavigationItemSelectedListener);
        navigationView.setCheckedItem(getNavigationId());
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private NavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.home:
                if (!(this instanceof HomeActivity)) {
                    HomeActivity.start(this);
                    finish();
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                break;
            case R.id.contact_us:
                if (!(this instanceof ContactUsActivity)) {
                    ContactUsActivity.start(this);
                    finish();
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                break;
        }
        return true;
    };


}
