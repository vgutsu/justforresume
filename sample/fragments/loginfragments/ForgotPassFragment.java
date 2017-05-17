package com.cinecentre.cinecentrecinema.fragments.loginfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.fragments.BaseFragment;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;

/**
 * Created by victg on 14.02.2017.
 */
public class ForgotPassFragment extends BaseFragment {

    @Override
    public int getFragmentId() {
        return ID_FORGOT_PASS;
    }

    @Override
    public int title() {
        return R.string.forgot_pass;
    }

    @Override
    protected int layout() {
        return R.layout.layout_forgot_pass;
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
        return new ForgotPassFragment();
    }

}
