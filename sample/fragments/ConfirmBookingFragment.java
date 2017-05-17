package com.cinecentre.cinecentrecinema.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.activities.BaseActivity;
import com.cinecentre.cinecentrecinema.customviews.MovieImageView;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;
import com.cinecentre.cinecentrecinema.rest.model.Order;

import java.io.Serializable;

import butterknife.BindView;

import static com.cinecentre.cinecentrecinema.activities.BaseActivity.EXTRA_SERIALIZABLE;

/**
 * Created by victg on 29.03.2017.
 */
public class ConfirmBookingFragment extends BaseFragment {
    @BindView(R.id.movie_poster)
    MovieImageView movie_poster;

    public static void navigate(Context context, Order order) {
        Intent intent = new Intent(context, ConfirmBookingFragment.class);
        intent.putExtra(EXTRA_SERIALIZABLE, order);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeBasic();
        ActivityCompat.startActivity(context, intent, options.toBundle());
    }

    @Override
    public BasePresenter createPresenter() {
        return new BasePresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Order order = (Order) getArguments().getSerializable(EXTRA_SERIALIZABLE);
        movie_poster.setImageUrl("null", R.drawable.placeholder_movie);
    }

    public static BaseFragment newInstance(Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseActivity.EXTRA_SERIALIZABLE, serializable);
        ConfirmBookingFragment fragment = new ConfirmBookingFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public int getFragmentId() {
        return ID_BUY_SEATS_CONFIRM;
    }

    @Override
    protected int title() {
        return R.string.review_booking;
    }

    @Override
    protected int layout() {
        return R.layout.layout_review_booking;
    }
}
