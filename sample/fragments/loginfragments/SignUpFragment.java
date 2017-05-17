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
public class SignUpFragment extends BaseFragment<SignInUpView, SignInUpPresenter> implements SignInUpView {
    @BindView(R.id.email_edit_text)
    EditText emailEditTextView;
    @BindView(R.id.password_edit_text)
    EditText passwordEditTextView;
    @BindView(R.id.city_edit_text)
    EditText cityEditTextView;
    @BindView(R.id.last_name_edit_text)
    EditText lastNameEditTextView;
    @BindView(R.id.first_name_edit_text)
    EditText firstNameEditTextView;
    @BindView(R.id.mobile_edit_text)
    EditText mobileEditTextView;

    @Override
    public int getFragmentId() {
        return ID_SIGN_UP;
    }

    @Override
    protected int title() {
        return R.string.sign_up;
    }

    @Override
    protected int layout() {
        return R.layout.layout_sign_up;
    }


    public static BaseFragment newInstance() {
        return new SignUpFragment();
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
            cityEditTextView.setText("city");
            firstNameEditTextView.setText("first");
            lastNameEditTextView.setText("last");
            mobileEditTextView.setText("1234567890");
            emailEditTextView.setText("v@mail.ru");
        }
    }

    @OnClick(R.id.button_sign_up)
    public void signUp() {
        boolean cancel = false;
        View focusView = null;
        String email = emailEditTextView.getText().toString();
        String passw = passwordEditTextView.getText().toString();
        String city = cityEditTextView.getText().toString();
        String firstName = firstNameEditTextView.getText().toString();
        String lastName = lastNameEditTextView.getText().toString();
        String mobile = mobileEditTextView.getText().toString();
        passwordEditTextView.setError(null);
        cityEditTextView.setError(null);
        firstNameEditTextView.setError(null);
        lastNameEditTextView.setError(null);
        mobileEditTextView.setError(null);
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

        if (TextUtils.isEmpty(city)) {
            cityEditTextView.setError(getString(R.string.error_invalid_city));
            focusView = cityEditTextView;
            cancel = true;
        }

        if (TextUtils.isEmpty(firstName)) {
            firstNameEditTextView.setError(getString(R.string.error_invalid_first_name));
            focusView = firstNameEditTextView;
            cancel = true;
        }

        if (TextUtils.isEmpty(lastName)) {
            lastNameEditTextView.setError(getString(R.string.error_invalid_last_name));
            focusView = lastNameEditTextView;
            cancel = true;
        }

        if (TextUtils.isEmpty(mobile)) {
            mobileEditTextView.setError(getString(R.string.error_invalid_mobile));
            focusView = mobileEditTextView;
            cancel = true;
        }

        if (cancel) {
//             There was an error; don't attempt login and focus the first
//             form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            UserInfo userInfo = new UserInfo();
            userInfo.setCity(cityEditTextView.getText().toString());
            userInfo.setFirstName(firstNameEditTextView.getText().toString());
            userInfo.setLastName(lastNameEditTextView.getText().toString());
            userInfo.setMobile(mobileEditTextView.getText().toString());
            userInfo.setEmail(emailEditTextView.getText().toString());
            userInfo.setPassword(passwordEditTextView.getText().toString());
            getPresenter().register(userInfo);
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
