package com.cinecentre.cinecentrecinema.rest;

import android.text.TextUtils;

import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.Data;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by victor_house on 04.08.2016.
 */

public abstract class AccountCallback extends RetrofitCallback<Data> {

    @Override
    public void onResponse(Call<ApiResponse<Data>> call, Response<ApiResponse<Data>> response) {
        if (response.isSuccessful()) {
            ApiResponse<Data> body = response.body();
            if (body.getErrorcode() == 0) {
                Data data = body.getData();
                String session = data.getSession();
                if (TextUtils.isEmpty(session)) {
                    onError(call, data.getStatusMsg());
                } else {
                    onFinished(call, body.getData());
                }
            } else {
                onError(call, body.getErrorMessage());
            }
        } else {
            onError(call, response.message());
        }
    }

    @Override
    public void onFailure(Call<ApiResponse<Data>> call, Throwable throwable) {
        super.onFailure(call, throwable);
    }
}