package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cinecentre.cinecentrecinema.IntentStarter;
import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.customviews.SignUpInView;
import com.cinecentre.cinecentrecinema.presenters.DrawerMenuPresenter;
import com.cinecentre.cinecentrecinema.presenters.DrawerMenuView;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;

import butterknife.BindView;

/**
 * Created by victg on 05.04.2017.
 */


public class MenuFragment extends BaseFragment<DrawerMenuView, DrawerMenuPresenter> implements DrawerMenuView, NavigationView.OnNavigationItemSelectedListener {

    private static final int MENU_LOGOUT_ID = 321123;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    SignUpInView signInUpView;

    @Override
    public int getFragmentId() {
        return NONE;
    }

    @Override
    protected int title() {
        return NONE;
    }

    @Override
    protected int layout() {
        return R.layout.layout_drawer_menu;
    }

    @Override
    public DrawerMenuPresenter createPresenter() {
        return new DrawerMenuPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //      by default choose 1st item on app start
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.action_movies);
        navigationView.getMenu().performIdentifierAction(R.id.action_movies, 0);

        signInUpView = (SignUpInView) navigationView.getHeaderView(0).findViewById(R.id.login_sign_up_view);
        signInUpView.setOnSignInUpClickListener(new SignUpInView.OnSignInUpClickListener() {
            @Override
            public void signInUp() {
                IntentStarter.navigateSignInUpFragmentActivity(getContext());
            }

            @Override
            public void updateUserInfo() {
//                do nothing
            }
        });
        getPresenter().getUserProfile();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_movies:
                pushFragment(HomeFragment.newInstance());
                break;
            case R.id.action_movies_theater:
                pushFragment(CinemasFragment.newInstance());
                break;
            case R.id.action_mytickets:
                pushFragment(TicketsFragment.newInstance());
                break;
            case MENU_LOGOUT_ID:
                //do logout
                getPresenter().logout();
                onUpdateIU(null);
                return false;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onUpdateIU(UserInfo info) {
        if (info != null) {
            navigationView.getMenu().add(0, MENU_LOGOUT_ID, Menu.NONE, R.string.logout).setIcon(R.drawable.ic_settings_black_24px);
            signInUpView.showInfoView(info.getFirstName() + " " + info.getLastName(), info.getEmail());
        } else {
            navigationView.getMenu().removeItem(MENU_LOGOUT_ID);
            signInUpView.showSignInUpView();
        }
    }

    @Override
    public void onShowMessage(String message) {
        showMessage(message);
    }
}
