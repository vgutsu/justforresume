package com.cinecentre.cinecentrecinema.activities;

import android.os.Bundle;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.fragments.loginfragments.StartLoginFragment;

/**
 * Created by victg on 14.02.2017.
 */
public class SignInUpFragmentActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pushFragment(StartLoginFragment.newInstance(), false);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.layout_sign_activity;
    }
}
