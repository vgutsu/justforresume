package com.cinecentre.cinecentrecinema.fragments.loginfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.cinecentre.cinecentrecinema.BuildConfig;
import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.cinecentrecinema.fragments.BaseFragment;
import com.cinecentre.cinecentrecinema.presenters.SignInUpPresenter;
import com.cinecentre.cinecentrecinema.presenters.SignInUpView;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by victg on 14.02.2017.
 */
public class SignInFragment extends BaseFragment<SignInUpView, SignInUpPresenter> implements SignInUpView {

    @BindView(R.id.email_edit_text)
    EditText emailEditTextView;
    @BindView(R.id.password_edit_text)
    EditText passwordEditTextView;

    @Override
    public int getFragmentId() {
        return ID_SIGN_IN;
    }

    @Override
    public int title() {
        return R.string.sign_in;
    }

    @Override
    protected int layout() {
        return R.layout.layout_sign_in;
    }

    @Override
    public SignInUpPresenter createPresenter() {
        return new SignInUpPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (BuildConfig.DEBUG) {
            passwordEditTextView.setText("111111");
            emailEditTextView.setText("v@mail.ru");
        }
    }

    public static BaseFragment newInstance() {
        return new SignInFragment();
    }

    @OnClick(R.id.textview_forgot_pass)
    public void forgotpass() {
        pushFragment(ForgotPassFragment.newInstance(), true);
    }

    @OnClick(R.id.button_sign_in)
    public void signIn() {
        boolean cancel = false;
        View focusView = null;
        String email = emailEditTextView.getText().toString();
        String passw = passwordEditTextView.getText().toString();
        passwordEditTextView.setError(null);
        emailEditTextView.setError(null);

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(passw)) {
            passwordEditTextView.setError(getString(R.string.error_invalid_password));
            focusView = passwordEditTextView;
            cancel = true;
        }
        if (TextUtils.isEmpty(email)) {
            emailEditTextView.setError(getString(R.string.error_invalid_email));
            focusView = emailEditTextView;
            cancel = true;
        }

        if (cancel) {
//             There was an error; don't attempt login and focus the first
//             form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            UserInfo body = new UserInfo();
            body.setEmail(emailEditTextView.getText().toString());
            body.setPassword(passwordEditTextView.getText().toString());
            getPresenter().login(body);
        }
    }


    @Override
    public void onFinished() {
        finish();
    }

    @Override
    public void onShowMessage(String error) {
        showMessage(error);
    }
}
