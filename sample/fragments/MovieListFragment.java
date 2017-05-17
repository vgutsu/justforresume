package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.adapters.MovieAdapter;
import com.cinecentre.cinecentrecinema.customviews.decorators.GridSpacingItemDecoration;
import com.cinecentre.cinecentrecinema.presenters.MovieListPresenter;
import com.cinecentre.cinecentrecinema.presenters.MoviesView;
import com.cinecentre.cinecentrecinema.rest.response.MoviesData;

import butterknife.BindView;

public class MovieListFragment extends SwipeableFragment<MoviesView, MovieListPresenter> implements MoviesView {

    @BindView(R.id.recycleview)
    public RecyclerView recyclerView;

    private MovieAdapter movieAdapter;

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
        return R.layout.layout_recycleview_page;
    }

    public static MovieListFragment newInstance() {
        Bundle args = new Bundle();
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public MovieListPresenter createPresenter() {
        return new MovieListPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movieAdapter = new MovieAdapter(getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.margin_standart);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        onRefresh();
    }


    @Override
    public void onSetData(MoviesData data) {
        onRefreshDone();
        if (movieAdapter != null) movieAdapter.update(data);
    }

    @Override
    public void onShowMessage(String error) {
        onRefreshDone();
        showMessage(error);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        getPresenter().getTodayList();
    }
}