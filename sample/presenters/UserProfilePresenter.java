package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.SessionManager;
import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.requestbody.UserInfo;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;

import retrofit2.Call;

/**
 * Created by victg on 04.04.2017.
 */
public class UserProfilePresenter extends BasePresenter<UserProfileView> {
    public UserProfilePresenter(Context context) {
        super(context);
    }

    public void getUserProfile() {
        String currentSession = SessionManager.getInstance(getContext()).getCurrentSession();
        getClient().getUserProfile(currentSession, new RetrofitCallback<UserInfo>() {
            @Override
            public void onFinished(Call<ApiResponse<UserInfo>> call, UserInfo info) {
                if (isViewAttached()) getView().onSetUserInfo(info);
            }

            @Override
            public void onError(Call<ApiResponse<UserInfo>> call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }
}
