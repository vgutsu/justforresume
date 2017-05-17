package com.cinecentre.cinecentrecinema.fragments.loginfragments;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.fragments.BaseFragment;
import com.cinecentre.cinecentrecinema.presenters.BasePresenter;

import butterknife.OnClick;

/**
 * Created by victg on 14.02.2017.
 */
public class StartLoginFragment extends BaseFragment {

    @Override
    public int getFragmentId() {
        return NONE;
    }

    @Override
    public int title() {
        return R.string.login_sign;
    }

    @Override
    protected int layout() {
        return R.layout.layout_start_login;
    }

    public static BaseFragment newInstance() {
        return new StartLoginFragment();
    }


    @Override
    public BasePresenter createPresenter() {
        return new BasePresenter(getContext());
    }

    @OnClick(R.id.button_sign_in)
    public void signIn() {
        pushFragment(SignInFragment.newInstance(), true);
    }

    @OnClick(R.id.button_sign_up)
    public void signUp() {
        pushFragment(SignUpFragment.newInstance(), true);
    }
}
