package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.SessionManager;
import com.cinecentre.cinecentrecinema.events.SignInUpEvent;
import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import retrofit2.Call;

/**
 * Created by victg on 05.04.2017.
 */
public class DrawerMenuPresenter extends BasePresenter<DrawerMenuView> {

    public DrawerMenuPresenter(Context context) {
        super(context);

    }

    public void getUserProfile() {
        SessionManager sessionManager = SessionManager.getInstance(getContext());
        if (!sessionManager.hasSession()) return;
        String currentSession = sessionManager.getCurrentSession();
        getClient().getUserProfile(currentSession, new RetrofitCallback<UserInfo>() {
            @Override
            public void onFinished(Call<ApiResponse<UserInfo>> call, UserInfo info) {
                if (isViewAttached()) getView().onUpdateIU(info);
            }

            @Override
            public void onError(Call<ApiResponse<UserInfo>> call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }

    public void logout() {
        SessionManager.getInstance(getContext()).eraseSession();
    }

    @Override
    public void attachView(DrawerMenuView view) {
        super.attachView(view);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onSignInUpEvent(SignInUpEvent event) {
        getUserProfile();
    }
}
