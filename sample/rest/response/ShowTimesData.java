package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.MovieDate;
import com.cinecentre.cinecentrecinema.rest.model.Schedule;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by victg on 27.03.2017.
 */
public abstract class ShowTimesData implements Serializable {
    @SerializedName("SelectedDate")
    @Expose
    private MovieDate selectedDate;

    @SerializedName("MovieDate")
    @Expose
    private List<MovieDate> movieDate = null;
    @SerializedName("Schedules")
    @Expose
    private Map<Integer, List<Schedule>> schedulesMap;

    public MovieDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(MovieDate selectedDate) {
        this.selectedDate = selectedDate;
    }

    public List<MovieDate> getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(List<MovieDate> movieDate) {
        this.movieDate = movieDate;
    }

    public Map<Integer, List<Schedule>> getSchedulesMap() {
        return schedulesMap;
    }

    public void setSchedulesMap(Map<Integer, List<Schedule>> schedulesMap) {
        this.schedulesMap = schedulesMap;
    }

    public abstract List getList();
}
