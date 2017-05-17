package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.CinemaData;

import retrofit2.Call;

public class CinemaListPresenter extends BasePresenter<CinemaView> {

    public CinemaListPresenter(Context context) {
        super(context);
    }

    public void getCinemaList() {
        getClient().getCinemas(getRegionId(), new RetrofitCallback<CinemaData>() {
            @Override
            public void onFinished(Call<ApiResponse<CinemaData>> call, CinemaData data) {
                if (isViewAttached()) getView().onSetData(data);

            }

            @Override
            public void onError(Call<ApiResponse<CinemaData>> call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }
}
