package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.fragments.BaseFragment;
import com.cinecentre.cinecentrecinema.fragments.TimeTableFragment;
import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.model.MovieDate;
import com.cinecentre.cinecentrecinema.rest.response.ShowTimesData;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import retrofit2.Call;

/**
 * Created by victg on 27.03.2017.
 */
public class ShowTimesPresenter extends BasePresenter<ShowTimesView> {

    private Serializable serializeble;

    public ShowTimesPresenter(Context context) {
        super(context);
    }

    public void setSerializeble(Serializable serializeble) {
        this.serializeble = serializeble;
    }

    public void getShowTimeFragments() {
        if (serializeble instanceof Cinema) {
            Cinema cinema = (Cinema) this.serializeble;
            getClient().getShowtimes(getRegionId(), cinema.getCinemaId(), 0, showFragmentsCallBack);
        }
        if (serializeble instanceof Film) {
            Film film = (Film) serializeble;
            getClient().getShowtime(getRegionId(), film.getMovieId(), 0, showFragmentsCallBack);
        }
    }


    RetrofitCallback showFragmentsCallBack = new RetrofitCallback<ShowTimesData>() {
        @Override
        public void onFinished(Call<ApiResponse<ShowTimesData>> call, ShowTimesData data) {
            HashMap<MovieDate, BaseFragment> dateFragmentMap = new LinkedHashMap<>();
            List<MovieDate> movieDateList = data.getMovieDate();
            for (MovieDate date : movieDateList) {
                dateFragmentMap.put(date, TimeTableFragment.newInstance(serializeble, date));
            }
            if (isViewAttached()) getView().onSetData(dateFragmentMap);
        }

        @Override
        public void onError(Call<ApiResponse<ShowTimesData>> call, String error) {
            getView().onShowMessage(error);
        }
    };
}
