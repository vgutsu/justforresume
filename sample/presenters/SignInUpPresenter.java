package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.SessionManager;
import com.cinecentre.cinecentrecinema.events.SignInUpEvent;
import com.cinecentre.cinecentrecinema.rest.AccountCallback;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.Data;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;

/**
 * Created by victg on 04.04.2017.
 */
public class SignInUpPresenter extends BasePresenter<SignInUpView> {

    public SignInUpPresenter(Context context) {
        super(context);
    }

    public void register(UserInfo info) {
        getClient().register(info, new AccountCallback() {
            @Override
            public void onFinished(Call<ApiResponse<Data>> call, Data data) {
                onFinish(data);
            }

            @Override
            public void onError(Call<ApiResponse<Data>> call, String error) {
                showMessage(error);
            }
        });
    }


    public void login(UserInfo info) {
        getClient().login(info, new AccountCallback() {
            @Override
            public void onFinished(Call<ApiResponse<Data>> call, Data data) {
                onFinish(data);
            }

            @Override
            public void onError(Call<ApiResponse<Data>> call, String error) {
                showMessage(error);
            }
        });
    }

    void showMessage(String message) {
        if (isViewAttached()) getView().onShowMessage(message);
    }

    void onFinish(Data data) {
        SessionManager.getInstance(getContext()).saveSession(data.getSession());
        EventBus.getDefault().post(new SignInUpEvent(data));
        if (isViewAttached()) getView().onFinished();
    }
}
