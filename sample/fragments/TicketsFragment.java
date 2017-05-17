package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.adapters.TicketPageAdapter;
import com.cinecentre.cinecentrecinema.customviews.CustomViewPager;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;

import butterknife.BindView;

public class TicketsFragment extends BaseFragment {

    @BindView(R.id.viewpager)
    CustomViewPager viewPager;

    public static BaseFragment newInstance() {
        return new TicketsFragment();
    }

    @Override
    public int getFragmentId() {
        return ID_TICKETS;
    }

    @Override
    protected int layout() {
        return R.layout.layout_page_tickets;
    }

    protected int title() {
        return R.string.action_my_tickets;
    }

    @Override
    public BasePresenter createPresenter() {
        return new BasePresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TicketPageAdapter mAdapter = new TicketPageAdapter(getContext(), 5);
        viewPager.setAdapter(mAdapter);
    }
}