package com.cinecentre.cinecentrecinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;

public class PaymentFragment extends BaseFragment {

    @Override
    public int getFragmentId() {
        return ID_PAYMENT;
    }

    @Override
    protected int layout() {
        return R.layout.layout_page_payment;
    }

    protected int title() {
        return R.string.action_payment;
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
        return new PaymentFragment();
    }

}