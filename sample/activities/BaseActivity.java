package com.cinecentre.cinecentrecinema.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.fragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by victg on 06.02.2017.
 */
public abstract class BaseActivity extends
        AppCompatActivity implements BaseFragment.OnFragmentSelectedListener {
    public static final String EXTRA_SERIALIZABLE = "EXTRA_SERIALIZABLE";

    // don't forget add toolbar in xml layout,where you need it
    @Nullable
    @BindView(R.id.custom_toolbar)
    Toolbar toolbar;
    private Unbinder bind;

    private BaseFragment currentFragment;


    protected abstract int getLayoutResourceId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } catch (Exception e) {
            Log.e("toolbar", "add toolbar on ui" + e.getMessage());
        }
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bind = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) bind.unbind();
    }

    public Context getContext() {
        return this;
    }


    protected void pushFragment(BaseFragment fragment, boolean addToBackStack) {
        int fragmentId = fragment.getFragmentId();
        if (currentFragment != null && currentFragment.getFragmentId() == fragmentId) {
            return;
        }
        currentFragment = fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(fragment.parentContainer(), fragment, "_app_frag_#" + String.valueOf(fragmentId))
                .commitAllowingStateLoss();
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
            currentFragment = null;
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPushFragment(BaseFragment fragment, boolean add) {
        pushFragment(fragment, add);
    }

    @Override
    public void onClearStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}
