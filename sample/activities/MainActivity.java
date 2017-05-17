package com.cinecentre.cinecentrecinema.activities;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.fragments.BaseFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.layout_mainfragment_activity;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.setDrawerListener(toggle);
    }


    @Override
    public void onBackPressed() {
        if (closeDrawer()) return;
        super.onBackPressed();
    }

    @Override
    protected void pushFragment(BaseFragment fragment, boolean add) {
        super.pushFragment(fragment, add);
        closeDrawer();
    }

    boolean closeDrawer() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}

