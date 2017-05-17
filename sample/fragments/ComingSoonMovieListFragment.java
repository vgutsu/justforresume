package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;

public class ComingSoonMovieListFragment extends MovieListFragment {


    public static ComingSoonMovieListFragment newInstance() {
        Bundle args = new Bundle();
        ComingSoonMovieListFragment fragment = new ComingSoonMovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onRefresh() {
        getPresenter().getComingSoonList();
    }
}
