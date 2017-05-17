package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 14.02.2017.
 */
public class CinemaShowTimesData extends ShowTimesData {
    @SerializedName("Cinema")
    @Expose
    private Cinema cinema;

    @SerializedName("MovieList")
    @Expose
    private List<Film> movieList = null;

    @Override
    public List<Film> getList() {
        return movieList;
    }

    public Cinema getCinema() {
        return cinema;
    }
}
