package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;

public class SettingsFragment extends BaseFragment {

    @Override
    public int getFragmentId() {
        return ID_SETTINGS;
    }

    @Override
    protected int layout() {
        return R.layout.layout_page_settings;
    }

    protected int title() {
        return R.string.action_settings;
    }

    @Override
    public BasePresenter createPresenter() {
        return new BasePresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public static BaseFragment newInstance() {
        return new SettingsFragment();
    }

}