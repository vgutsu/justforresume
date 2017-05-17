package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.activities.BaseActivity;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;
import com.cinecentre.cinecentrecinema.presenters.DetailsPresenter;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;

import java.io.Serializable;


/**
 * Created by victg on 15.03.2017.
 */
public class DetailsCinemaFragment extends BaseFragment {
    @Override
    public int getFragmentId() {
        return ID_DETAILS;
    }

    @Override
    protected int title() {
        return NONE;
    }

    @Override
    protected int layout() {
        return R.layout.layout_cinema_details_fragment;
    }


    public static BaseFragment newInstance(Serializable cinema) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseActivity.EXTRA_SERIALIZABLE, cinema);
        DetailsCinemaFragment fragment = new DetailsCinemaFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public DetailsPresenter createPresenter() {
        return new DetailsPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Cinema cinema = (Cinema) getArguments().getSerializable(BaseActivity.EXTRA_SERIALIZABLE);

    }
}
