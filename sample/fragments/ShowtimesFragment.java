package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.activities.BaseActivity;
import com.cinecentre.cinecentrecinema.activities.MovieDetailActivity;
import com.cinecentre.cinecentrecinema.adapters.CalendarAdapter;
import com.cinecentre.cinecentrecinema.adapters.CustomViewPagerAdapter;
import com.cinecentre.cinecentrecinema.presenters.ShowTimesPresenter;
import com.cinecentre.cinecentrecinema.presenters.ShowTimesView;
import com.cinecentre.cinecentrecinema.rest.model.MovieDate;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by victg on 07.02.2017.
 */

public class ShowtimesFragment extends BaseFragment<ShowTimesView, ShowTimesPresenter> implements ShowTimesView<Map<MovieDate, BaseFragment>> {

    @BindView(R.id.viewpager)
    public ViewPager viewPager;
    @BindView(R.id.recycler_tab_calendar_layout)
    public RecyclerTabLayout recycler_tab_calendar_layout;

    private CustomViewPagerAdapter viewPagerAdapter;
    private CalendarAdapter calendarAdapter;

    public static BaseFragment newInstance(Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseActivity.EXTRA_SERIALIZABLE, serializable);
        ShowtimesFragment fragment = new ShowtimesFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getFragmentId() {
        return ID_SHOW_TIMES;
    }

    @Override
    protected int title() {
        return NONE;
    }

    @Override
    protected int layout() {
        return R.layout.layout_showtime_fragment;
    }

    @Override
    public ShowTimesPresenter createPresenter() {
        return new ShowTimesPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPagerAdapter = new CustomViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        calendarAdapter = new CalendarAdapter(viewPager);
        calendarAdapter.setSelectedColor(ContextCompat.getColor(getContext(), R.color.color_drawer_item_icon_tint_pressed));
        recycler_tab_calendar_layout.setUpWithAdapter(calendarAdapter);

        Serializable serializable = getArguments().getSerializable(MovieDetailActivity.EXTRA_SERIALIZABLE);

        getPresenter().setSerializeble(serializable);
        getPresenter().getShowTimeFragments();
    }

    @Override
    public void onSetData(Map<MovieDate, BaseFragment> data) {
        ArrayList<BaseFragment> fragments = new ArrayList<>(data.values());
        ArrayList<MovieDate> dates = new ArrayList<>(data.keySet());
        calendarAdapter.setDateList(dates);
        viewPagerAdapter.addAllFragments(fragments);
    }

    @Override
    public void onShowMessage(String error) {
        showMessage(error);
    }


}
