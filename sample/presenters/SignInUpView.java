package com.cinecentre.cinecentrecinema.presenters;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by victg on 04.04.2017.
 */
public interface SignInUpView extends MvpView {
    void onFinished();

    void onShowMessage(String message);
}
