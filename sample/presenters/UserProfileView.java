package com.cinecentre.cinecentrecinema.presenters;

import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by victg on 04.04.2017.
 */
public interface UserProfileView extends MvpView {
    void onSetUserInfo(UserInfo info);

    void onShowMessage(String error);
}
