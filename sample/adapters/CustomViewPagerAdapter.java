package com.cinecentre.cinecentrecinema.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class CustomViewPagerAdapter<T extends Fragment> extends SmartFragmentStatePagerAdapter {
    private final List<T> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public CustomViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public T getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(T fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public void addFragment(T fragment) {
        mFragmentList.add(fragment);
        notifyDataSetChanged();
    }

    public void addAllFragments(List<T> fragments) {
        mFragmentList.addAll(fragments);
        notifyDataSetChanged();
    }

    public T getFragment(int posititon) {
        return mFragmentList.get(posititon);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mFragmentTitleList == null || mFragmentTitleList.isEmpty()) return null;
        return mFragmentTitleList.get(position);
    }
}
