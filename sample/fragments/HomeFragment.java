package com.cinecentre.cinecentrecinema.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.adapters.CustomViewPagerAdapter;
import com.cinecentre.cinecentrecinema.adapters.ListAdapter;
import com.cinecentre.cinecentrecinema.presenters.RegionPresenter;
import com.cinecentre.cinecentrecinema.presenters.RegionView;
import com.cinecentre.cinecentrecinema.rest.model.Region;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<RegionView, RegionPresenter> implements RegionView, DialogInterface.OnClickListener {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;
    private CustomViewPagerAdapter<BaseFragment> pagerAdapter;
    private ListAdapter<Region> regionAdapter;
    private AlertDialog alertDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    protected int layout() {
        return R.layout.layout_home;
    }

    @Override
    public int getFragmentId() {
        return ID_HOME;
    }

    public static BaseFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int title() {
        return R.string.action_movies;
    }

    @Override
    public RegionPresenter createPresenter() {
        return new RegionPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pagerAdapter = new CustomViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(MovieListFragment.newInstance(), getString(R.string.filter_today));
        pagerAdapter.addFragment(ComingSoonMovieListFragment.newInstance(), getString(R.string.filter_soon));
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        getPresenter().getListRegion();
        regionAdapter = new ListAdapter<>(getContext());

        TextView dialogTitle = (TextView) View.inflate(getContext(), R.layout.custom_dialog_title, null);
        dialogTitle.setText(R.string.select_city);
        alertDialog = new AlertDialog.Builder(getContext())
                .setCustomTitle(dialogTitle)
                .setAdapter(regionAdapter, HomeFragment.this).create();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        // Associate searchable configuration with the SearchView
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_location:
                alertDialog.show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSetData(List<Region> data) {
        regionAdapter.clear();
        regionAdapter.addAll(data);
        regionAdapter.notifyDataSetChanged();
    }

    @Override
    public void onShowMessage(String error) {
        showMessage(error);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        getPresenter().saveRegion(regionAdapter.getItem(i));
    }

}

