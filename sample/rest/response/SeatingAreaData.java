package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.SeatingAreaInfo;
import com.cinecentre.cinecentrecinema.rest.model.MovieInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 14.02.2017.
 */
public class SeatingAreaData {

    @SerializedName("MovieInfo")
    @Expose
    private MovieInfo movieInfo;
    @SerializedName("ScheduleId")
    @Expose
    private long scheduleId;
    @SerializedName("ScheduleDatetime")
    @Expose
    private long scheduleDatetime;
    @SerializedName("CinemaId")
    @Expose
    private String cinemaId;
    @SerializedName("CinemaName")
    @Expose
    private String cinemaName;
    @SerializedName("ScreenName")
    @Expose
    private String screenName;
    @SerializedName("SeatingAreas")
    @Expose
    private List<SeatingAreaInfo> seatingAreas = null;

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getScheduleDatetime() {
        return scheduleDatetime;
    }

    public void setScheduleDatetime(long scheduleDatetime) {
        this.scheduleDatetime = scheduleDatetime;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<SeatingAreaInfo> getSeatingAreas() {
        return seatingAreas;
    }

    public void setSeatingAreas(List<SeatingAreaInfo> seatingAreas) {
        this.seatingAreas = seatingAreas;
    }


}
