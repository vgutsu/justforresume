package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.BindView;


/**
 * Created by victg on 24.02.2017.
 */
public abstract class SwipeableFragment<V extends MvpView, P extends MvpPresenter<V>> extends BaseFragment<V,P> implements SwipeRefreshLayout.OnRefreshListener {

    @Nullable
    @BindView(R.id.swipe_container)
    public SwipeRefreshLayout swipe_container;


    @Override
    public void onRefresh() {
        showProgress(true);
    }

    // load data that you u need
    public void onRefreshDone() {
        showProgress(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setOnRefreshListener(this);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener l) {
        if (swipe_container != null) swipe_container.setOnRefreshListener(l);
        else Log.i("SwipeableFragment", "add swipe layout to ui");

    }

    private void showProgress(boolean show) {
        if (swipe_container != null) swipe_container.setRefreshing(show);
        else Log.i("SwipeableFragment", "add swipe layout to ui");
    }
}
