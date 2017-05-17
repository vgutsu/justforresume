package com.cinecentre.cinecentrecinema.rest;

import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by victor_house on 04.08.2016.
 */
public abstract class RetrofitCallback<T> implements Callback<ApiResponse<T>> {
    public RetrofitCallback() {
    }

    @Override
    public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
        if (response.isSuccessful()) {
            ApiResponse<T> body = response.body();
            if (body.getErrorcode() == 0) {
                onFinished(call, body.getData());
            } else {
                onError(call, body.getErrorMessage());
            }
        } else {
            onError(call, response.message());
        }
    }

    @Override
    public void onFailure(Call<ApiResponse<T>> call, Throwable throwable) {
        onError(call, throwable.getMessage());
    }

    public abstract void onFinished(Call<ApiResponse<T>> call, T t);

    public abstract void onError(Call<ApiResponse<T>> call, String error);

}