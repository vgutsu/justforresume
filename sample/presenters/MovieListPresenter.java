package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.MoviesData;

import retrofit2.Call;

/**
 * Created by victg on 27.03.2017.
 */

public class MovieListPresenter extends BasePresenter<MoviesView> {

    public MovieListPresenter(Context context) {
        super(context);
    }

    public void getTodayList() {
        getClient().getMovies(getRegionId(), new RetrofitCallback<MoviesData>() {
            @Override
            public void onFinished(Call<ApiResponse<MoviesData>> call, MoviesData data) {
                if (isViewAttached()) getView().onSetData(data);
            }

            @Override
            public void onError(Call<ApiResponse<MoviesData>> call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }

    public void getComingSoonList() {
        getClient().getComingSoon(getRegionId(), new RetrofitCallback<MoviesData>() {
            @Override
            public void onFinished(Call<ApiResponse<MoviesData>> call, MoviesData data) {
                if (isViewAttached()) getView().onSetData(data);
            }

            @Override
            public void onError(Call<ApiResponse<MoviesData>> call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }


}
