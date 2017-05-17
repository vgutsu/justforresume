package com.cinecentre.cinecentrecinema.presenters;

import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by victg on 05.04.2017.
 */
public interface DrawerMenuView extends MvpView {
    void onUpdateIU(UserInfo info);

    void onShowMessage(String message);
}
