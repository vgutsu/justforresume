package com.cinecentre.cinecentrecinema.presenters;

import android.content.Context;

import com.cinecentre.cinecentrecinema.rest.RetrofitCallback;
import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.model.MovieDate;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;
import com.cinecentre.cinecentrecinema.rest.response.ShowTimesData;
import com.cinecentre.cinecentrecinema.rest.model.TicketType;
import com.cinecentre.cinecentrecinema.rest.response.ApiResponse;
import com.cinecentre.cinecentrecinema.rest.response.TickettypesData;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;

/**
 * Created by victg on 27.03.2017.
 */
public class TimeTablePresenter extends BasePresenter<TimeTableTicketView> {

    private Serializable serializeble;

    public TimeTablePresenter(Context context) {
        super(context);
    }

    public void setSerializeble(Serializable serializeble) {
        this.serializeble = serializeble;
    }

    private TickettypesData ticketTypeData;

    public void setTicketTypeData(TicketType type) {
        this.ticketTypeData.setCurrentTicketType(type);
        if (isViewAttached()) getView().onContinue(ticketTypeData);
    }

    public void updateShowTimes(MovieDate date) {
        if (serializeble == null || date == null) return;
        long timeStamp = date.getTimeStamp();

        if (serializeble instanceof Film) {
            Film film = (Film) this.serializeble;
            getClient().getShowtime(getRegionId(), film.getMovieId(), timeStamp, updateCallback);
        }
        if (serializeble instanceof Cinema) {
            Cinema cinema = (Cinema) this.serializeble;
            getClient().getShowtimes(getRegionId(), cinema.getCinemaId(), timeStamp, updateCallback);
        }
    }


    RetrofitCallback updateCallback = new RetrofitCallback<ShowTimesData>() {
        @Override
        public void onFinished(Call<ApiResponse<ShowTimesData>> call, ShowTimesData data) {
            if (isViewAttached()) getView().onSetData(data);
        }

        @Override
        public void onError(Call<ApiResponse<ShowTimesData>> call, String error) {
            if (isViewAttached()) getView().onShowMessage(error);
        }
    };

    public void getTicketTypeData(Cinema cinema, Schedule schedule) {
        getClient().getTickettypes(cinema.getCinemaId(), schedule.getScheduleId(), new RetrofitCallback<TickettypesData>() {
            @Override
            public void onFinished(Call<ApiResponse<TickettypesData>> call, TickettypesData data) {
                ticketTypeData = data;
                if (isViewAttached()) {
                    List<TicketType> ticketTypeList = data.getTicketTypes();
                    if (ticketTypeList != null && ticketTypeList.size() == 1) {
                        setTicketTypeData(ticketTypeList.get(0));
                    } else {
                        getView().onShowTicketList(ticketTypeList);
                    }
                }
            }

            @Override
            public void onError(Call<ApiResponse<TickettypesData>> call, String error) {
                if (isViewAttached()) getView().onShowMessage(error);
            }
        });
    }
}
