package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.SeatsData;

import retrofit2.Call;

/**
 * Created by victg on 28.03.2017.
 */
public class SeatsPresenter extends BasePresenter<SeatsView> {
    public SeatsPresenter(Context context) {
        super(context);
    }

    public void getSeats(int cinemaId, int scheduleId) {
        getClient().getSeats(cinemaId, scheduleId, getRegionId(), new RetrofitCallback<SeatsData>() {
            @Override
            public void onFinished(Call<ApiResponse<SeatsData>> call, SeatsData seatsData) {
                if (isViewAttached()) getView().onSetData(seatsData);
            }

            @Override
            public void onError(Call call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }
}
